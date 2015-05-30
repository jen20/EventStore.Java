package com.jen20.client;

public class Credentials {

    private String username;
    
    private char[] password;
    
    public Credentials(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

}
