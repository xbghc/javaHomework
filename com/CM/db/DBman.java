package com.CM.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBman {
    public static Connection con;

    static Connection conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }

        String url = "jdbc:mysql://39.105.84.99:3306/community";
        String user = "window";
        String password = "window123";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    static public void init(){
        con = conn();
    }

    // 查询
    // 返回查询结果
    static public ResultSet execute(String s) {
        // 执行语句
        try {
            Statement sql = con.createStatement();

            return sql.executeQuery(s);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    // update and insert
    // return: n of lines that have been changed
    static public int update(String s) {
        // 执行语句
        try {
            Statement sql = con.createStatement();
            return sql.executeUpdate(s);
        } catch (SQLException e) {
            System.out.println(e);
            return -1;
        }
    }

    // 登录
    // 管理员返回1
    // 住户返回0
    // 失败返回-1
    public static int SignIn(String username,String password){
        String sql=String.format("SELECT * FROM user WHERE username='%s' and password='%s'", username,password);
        try{
            ResultSet rs = DBman.execute(sql);
            if(!rs.next())return -1;
            if(rs.getString("priority").equals("管理员"))return 1;
            if(rs.getString("priority").equals("住户"))return 0;
            return -1;
        }
        catch(NullPointerException e){
            return -1;
        }
        catch (java.sql.SQLException e){
            System.out.println(e);
        }
        return -1;
    }

    // 重置密码
    // 成功返回true
    // 失败返回false
    public static boolean ResetPwd(String username,String ID,String newPwd){
        String sql=String.format("UPDATE user SET password='%s' WHERE username='%s' and ID='%s'", newPwd,username,ID);
        try{
            if(DBman.update(sql)==1)return true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }




}

