package com.CM.resident;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pays {
    ArrayList<Payment> pays = new ArrayList<>();

    Pays(ResultSet rs){
        if(rs==null)return;
        try {
            while(rs.next()) {
                Payment pay=new Payment();
                pay.type = rs.getString("type");
                pay.amount = rs.getString("amount");
                pay.time = rs.getDate("time");
                pays.add(pay);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }
}
