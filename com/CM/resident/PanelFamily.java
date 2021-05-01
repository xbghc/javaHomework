package com.CM.resident;

import com.CM.db.DBman;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PanelFamily extends JPanel {

    JLabel title;

    JTextArea information;//显示成员信息的窗口

    JButton query;        //查询信息
    JButton insert;       //插入成员

    PanelFamily(String username){
        setLayout(null);

        title=new JLabel("家庭成员信息如下：");
        add(title);
        title.setBounds(20,20,200,20);

        information=new JTextArea();
        add(information);
        information.setBounds(20,50,400,200);
        information.setEditable(false);




        query=new JButton("查询信息");
        add(query);
        query.setBounds(100,300,100,40);
        //TODO
        query.addActionListener(e->{
            StringBuffer bf=new StringBuffer();
            ResultSet rs= DBman.execute(String.format("SELECT * FROM member WHERE username='%s'",username));
            if(rs!=null){
                try {
                    while (rs.next()) {
                        bf.append(String.format("%s\t%s\n", rs.getString("name"), rs.getString("relation")));
                    }
                    information.setText(bf.toString());
                }
                catch (SQLException e1){
                    System.out.println("获取成员失败");
                }
        }});

        insert=new JButton("添加新成员");
        add(insert);
        insert.setBounds(250,300,100,40);
        //TODO
        insert.addActionListener(e -> {
            new InsertMember(username);
        });
    }
}
