package com.example.springboot.interceptor;

public class SessionValidationInterceptor {
    private static SessionValidationInterceptor ourInstance = new SessionValidationInterceptor();

    public static SessionValidationInterceptor getInstance() {
        return ourInstance;
    }

    private SessionValidationInterceptor() {
    }
}
