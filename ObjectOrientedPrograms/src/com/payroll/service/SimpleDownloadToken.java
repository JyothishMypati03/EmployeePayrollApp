package com.payroll.service;

public class SimpleDownloadToken {
    private final long createdTime;
    private final long expiryMillis;

    public SimpleDownloadToken() {
        this.createdTime = System.currentTimeMillis();
        this.expiryMillis = 60 * 1000; // 1 minute
    }

    public boolean isExpired() {
        return (System.currentTimeMillis() - createdTime) > expiryMillis;
    }
}

