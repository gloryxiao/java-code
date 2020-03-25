package com.sean.base.threadlocal;

public class SessionTest {
    private static ThreadLocal<SessionTest> session =  ThreadLocal.withInitial(SessionTest::new);
    private String name;
    private int time;

    public int getTime() {
        return session.get().time;
    }

    public String getName() {
        return session.get().name;
    }

    public void setName(String name) {
        session.get().name= name;
    }

    public void setTime(int time) {
        session.get().time = time;
    }

    public void echoName() {
        System.out.println(getName());
    }

    // 内存地址
    public void echo() {
        System.out.println(System.identityHashCode(session));
    }
}
