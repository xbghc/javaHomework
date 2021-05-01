package com.CM.administrator;

import com.CM.db.DBman;

public class test {
    public static void main(String[] args) {
        DBman.init();
        new AdminWindow("admin");
    }
}
