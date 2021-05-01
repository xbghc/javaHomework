package com.CM.administrator;

import com.CM.db.DBman;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PanelSelectPerson extends JPanel {

    //声明需要的标签
    JLabel seekType;
    JLabel keyWord;

    //添加需要的按钮
    JButton query;

    //添加需要的文本框
    JTextField t_keyword;

    //添加单选框
    JRadioButton radioName;
    JRadioButton radioID;
    JRadioButton radioUsername;

    ButtonGroup groupRadio;


    PanelSelectPerson(){
        setLayout(null);

        seekType=new JLabel("选择筛选类别:");
        add(seekType);
        seekType.setBounds(100,80,100,40);

        keyWord=new JLabel("输入关键信息:");
        add(keyWord);
        keyWord.setBounds(100,180,100,40);

        t_keyword =new JTextField();
        add(t_keyword);
        t_keyword.setBounds(210,190,200,20);

        groupRadio=new ButtonGroup();
        radioName=new JRadioButton("户主名字");
        radioID=new JRadioButton("户主身份证号");
        radioUsername=new JRadioButton("用户名");
        groupRadio.add(radioName);
        groupRadio.add(radioID);
        groupRadio.add(radioUsername);

        add(radioName);
        radioName.setBounds(200,90,80,20);
        add(radioID);
        radioID.setBounds(300,90,140,20);
        add(radioUsername);
        radioUsername.setBounds(440,90,80,20);

        query=new JButton("查找用户");
        add(query);
        query.setBounds(250,270,100,40);
        query.addActionListener(e->{

            String keyword;
            if(radioName.isSelected()){
                keyword="name";
            }
            else if(radioID.isSelected()){
                keyword="ID";
            }
            else if(radioUsername.isSelected())keyword="username";
            else return;
            String sql=String.format("SELECT * FROM user WHERE %s='%s'",keyword,t_keyword.getText());
            ResultSet rs= DBman.execute(sql);
            if(rs==null) {
                JOptionPane.showMessageDialog(this, "无此人信息", "结果为空", JOptionPane.WARNING_MESSAGE);
                return;
            }
            try{
                rs.next();
                new DetailPerson(rs.getString("username"));
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(this, "无此人信息", "结果为空", JOptionPane.WARNING_MESSAGE);
                throwables.printStackTrace();
            }
        });
    }
}
