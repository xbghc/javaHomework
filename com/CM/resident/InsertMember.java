package com.CM.resident;

import com.CM.db.DBman;

import javax.swing.*;

public class InsertMember extends JFrame {
    JLabel name;
    JLabel relationship;

    JTextField textName;
    JTextField textRelationship;

    JButton confirm;
    JButton back;

    InsertMember(String username){

        setLayout(null);

        setBounds(300,300,250,300);

        name=new JLabel("姓名：");
        add(name);
        name.setBounds(10,40,80,20);

        relationship=new JLabel("关系：");
        add(relationship);
        relationship.setBounds(10,80,80,20);

        textName=new JTextField();
        add(textName);
        textName.setBounds(100,40,80,20);

        textRelationship=new JTextField();
        add(textRelationship);
        textRelationship.setBounds(100,80,80,20);

        confirm=new JButton("确认提交");
        add(confirm);
        confirm.setBounds(50,140,100,20);
        confirm.addActionListener(e->{
            String sql=String.format("INSERT INTO member VALUES('%s','%s','%s')",
                    username,textName.getText(),textRelationship.getText());
            DBman.update(sql);
            dispose();
        });

        back=new JButton("取消");
        add(back);
        back.setBounds(50,180,100,20);
        back.addActionListener(e->{
            dispose();
        });

        setVisible(true);
    }
}
