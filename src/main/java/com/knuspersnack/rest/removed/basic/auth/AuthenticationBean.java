package com.knuspersnack.rest.removed.basic.auth;

public class AuthenticationBean {
    private String authMessage;

    public AuthenticationBean(String authMessage) {
        this.authMessage = authMessage;
    }

    public String getAuthMessage() {
        return authMessage;
    }

    public void setAuthMessage(String authMessage) {
        this.authMessage = authMessage;
    }

}
