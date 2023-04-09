package com.sean.code.newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sean
 * 问题描述：
 * https://www.nowcoder.com/practice/de538edd6f7e4bc3a5689723a7435682?tpId=37&tqId=21241&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
 */
public class Code18 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countP = 0, countI = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] lineSplit = line.split("~");
            if (lineSplit.length != 2) {
                countI ++;
                continue;
            }

            String[] ipItems = lineSplit[0].split("\\.");
            if (ipItems.length != 4) {
                countI ++;
                continue;
            }

            boolean ipFormat = true;
            for (String item: ipItems) {
                if (item.length() != 0 && !item.matches("\\d+")) {
                    ipFormat = false;
                    break;
                }
            }

            if (!ipFormat) {
                countI ++;
                continue;
            }

            NetBase ip = new NetBase(
                    ipItems[0].length() ==0 ? 0: Integer.valueOf(ipItems[0]),
                    ipItems[1].length() ==0 ? 0:Integer.valueOf(ipItems[1]),
                    ipItems[2].length() ==0 ? 0:Integer.valueOf(ipItems[2]),
                    ipItems[3].length() ==0 ? 0:Integer.valueOf(ipItems[3]));

            if (!ip.isValidIp()) {
                countI ++;
                continue;
            }

            String[] mkItems = lineSplit[1].split("\\.");
            if (mkItems.length != 4) {
                countI ++;
                continue;
            }

            boolean mkFormat = true;
            for (String item: ipItems) {
                if (!item.matches("\\d+")) {
                    mkFormat = false;
                    break;
                }
            }

            if (!mkFormat) {
                countI ++;
                continue;
            }

            NetBase mask = new NetBase(
                    mkItems[0].length() ==0 ? 0: Integer.valueOf(mkItems[0]),
                    mkItems[1].length() ==0 ? 0: Integer.valueOf(mkItems[1]),
                    mkItems[2].length() ==0 ? 0: Integer.valueOf(mkItems[2]),
                    mkItems[3].length() ==0 ? 0: Integer.valueOf(mkItems[3]));

            if (!mask.isValidMask()) {
                countI ++;
                continue;
            }

            AddrRegion addrA = new AddrRegion();
            addrA.setStart(new NetBase(1, 0, 0, 0));
            addrA.setEnd(new NetBase(126, 255, 255, 255));

            AddrRegion addrB = new AddrRegion();
            addrB.setStart(new NetBase(128, 0 ,0 ,0));
            addrB.setEnd(new NetBase(191, 255, 255, 255));

            AddrRegion addrC = new AddrRegion();
            addrC.setStart(new NetBase(192, 0, 0, 0));
            addrC.setEnd(new NetBase(223, 255, 255, 255));

            AddrRegion addrD = new AddrRegion();
            addrD.setStart(new NetBase(224, 0, 0, 0));
            addrD.setEnd(new NetBase(239, 255, 255, 255));

            AddrRegion addrE = new AddrRegion();
            addrE.setStart(new NetBase(240, 0, 0, 0));
            addrE.setEnd(new NetBase(255, 255, 255, 255));

            AddrRegion addrP1 = new AddrRegion();
            addrP1.setStart(new NetBase(10, 0, 0, 0));
            addrP1.setEnd(new NetBase(10, 255, 255, 255));

            AddrRegion addrP2 = new AddrRegion();
            addrP2.setStart(new NetBase(172, 16, 0, 0));
            addrP2.setEnd(new NetBase(172, 31, 255, 255));

            AddrRegion addrP3 = new AddrRegion();
            addrP3.setStart(new NetBase(192, 168, 0, 0));
            addrP3.setEnd(new NetBase(192, 168, 255, 255));

            if (addrA.contains(ip)) {
                countA ++;
            }

            if (addrB.contains(ip)) {
                countB ++;
            }

            if (addrC.contains(ip)) {
                countC ++;
            }

            if (addrD.contains(ip)) {
                countD ++;
            }

            if (addrE.contains(ip)) {
                countE ++;
            }

            if (addrP1.contains(ip)) {
                countP ++;
            }

            if (addrP2.contains(ip)) {
                countP ++;
            }

            if (addrP3.contains(ip)) {
                countP ++;
            }
        }

        System.out.println(countA + " " + countB + " " + countC + " " + countD + " " + countE + " " +
                countI + " " + countP);

    }

    public static class NetBase {
        private int var1;

        private int var2;

        private int var3;

        private int var4;

        public NetBase(int var1, int var2, int var3, int var4) {
            this.var1 = var1;
            this.var2 = var2;
            this.var3 = var3;
            this.var4 = var4;
        }

        public int getVar1() {
            return var1;
        }

        public void setVar1(int var1) {
            this.var1 = var1;
        }

        public int getVar2() {
            return var2;
        }

        public void setVar2(int var2) {
            this.var2 = var2;
        }

        public int getVar3() {
            return var3;
        }

        public void setVar3(int var3) {
            this.var3 = var3;
        }

        public int getVar4() {
            return var4;
        }

        public void setVar4(int var4) {
            this.var4 = var4;
        }

        public boolean isValidIp() {
            if (var1 <= 0 || var1 > 255) {
                return false;
            }

            if (var2 < 0 || var2 > 255) {
                return false;
            }

            if (var3 < 0 || var3 > 255) {
                return false;
            }
            if (var4 < 0 || var4 > 255) {
                return false;
            }

            return true;
        }

        public boolean isValidMask() {
            if (!isValidIp()) {
                return false;
            }

            List<Integer> maskList = new ArrayList<>();
            maskList.add(var4);
            maskList.add(var3);
            maskList.add(var2);
            maskList.add(var1);
            int noneZeroIdx = -1;
            int index = 0;
            for (int item : maskList) {
                if (item != 0) {
                    if ( -1 == noneZeroIdx) {
                        noneZeroIdx = index;

                        if (item != 255) {
                            boolean zeroOne = false;
                            while (item > 0) {
                                int modR = item % 2;
                                if ( 1 == modR) {
                                    zeroOne = true;
                                }

                                if (zeroOne && 0 == modR) {
                                    return false;
                                }

                                item = item >>> 1;
                            }
                        }
                    }
                }

                if (-1 != noneZeroIdx && index > noneZeroIdx) {
                    if (item != 255) {
                        return false;
                    }
                }

                index ++;
            }

            return true;
        }
    }

    public static class AddrRegion{
        public NetBase getStart() {
            return start;
        }

        public void setStart(NetBase start) {
            this.start = start;
        }

        public NetBase getEnd() {
            return end;
        }

        public void setEnd(NetBase end) {
            this.end = end;
        }

        private NetBase start;

        private NetBase end;

        public boolean contains(NetBase netBase) {
            if (netBase.getVar1() < start.getVar1()) {
                return false;
            }

            if (netBase.getVar1() == start.getVar1()) {
                if (netBase.getVar2() < start.getVar2()) {
                    return false;
                }

                if (netBase.getVar2() == start.getVar2()) {
                    if (netBase.getVar3() < start.getVar3()) {
                        return false;
                    }

                    if (netBase.getVar3() == start.getVar3()) {
                        if (netBase.getVar4() < start.getVar4()) {
                            return false;
                        }
                    }
                }
            }

            if (netBase.getVar1() > end.getVar1()) {
                return false;
            }

            if (netBase.getVar1() == end.getVar1()) {
                if (netBase.getVar2() > end.getVar2()) {
                    return false;
                }

                if (netBase.getVar2() == end.getVar2()) {
                    if (netBase.getVar3() > end.getVar3()) {
                        return false;
                    }

                    if (netBase.getVar3() == end.getVar3()) {
                        if (netBase.getVar4() > end.getVar4()) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }


    }



}
