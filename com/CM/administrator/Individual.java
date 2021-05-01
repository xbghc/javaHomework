package com.CM.administrator;

import com.CM.db.DBman;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Individual {
    String username;
    String name;
    String ID;

    public Individual(String username){
        this.username=username;
        ResultSet rs= DBman.execute(String.format( "SELECT * FROM user WHERE username='%s'",username));
        if(rs==null)return;
        try {
            rs.next();
            this.name=rs.getString("name");
            this.ID=rs.getString("ID");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
