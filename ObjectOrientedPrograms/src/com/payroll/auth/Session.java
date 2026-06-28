package com.payroll.auth;

public class Session {
    private final String username;
    private final long loginTime;
    private final long timeoutMillis;

    public Session(String username) {
        this(username, 5 * 60 * 1000L); // default 5 minutes
    }

    public Session(String username, long timeoutMillis) {
        this.username = username;
        this.loginTime = System.currentTimeMillis();
        this.timeoutMillis = timeoutMillis;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - loginTime > timeoutMillis;
    }

    @Override
    public String toString() {
        return "Session active for user: " + username;
    }
}
