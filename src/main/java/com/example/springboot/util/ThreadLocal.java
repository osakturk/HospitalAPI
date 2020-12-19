package com.example.springboot.util;

public class ThreadLocal {

    public static final java.lang.ThreadLocal<RequestContext> threadLocal = new java.lang.ThreadLocal<>();

    public static void set(RequestContext context) {
        threadLocal.set(context);
    }

    public static void unset() {
        threadLocal.remove();
    }

    public static RequestContext safeGet() {
        RequestContext context = threadLocal.get();
        if (context != null) {
            return context;
        } else {
            context = new RequestContext();
            set(context);
            return context;
        }
    }

    public static RequestContext get() {
        return threadLocal.get();
    }
}
