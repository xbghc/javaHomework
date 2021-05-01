package com.CM.resident;

import com.CM.db.DBman;

public class testR {
    public static void main(String[] args) {
        DBman.init();
        new ResidentWindow("xiaokeai");
    }
}
