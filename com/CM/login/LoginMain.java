package com.CM.login;

import com.CM.db.DBman;

public class LoginMain {
    public static void main(String[] args) {
        new UserLogin();
        DBman.init();
    }
}