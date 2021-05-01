package com.CM.administrator;

import javax.swing.*;

public class DealMaintain extends JFrame {

    JLabel currentMaintain;
    JLabel workertype;
    JLabel workername;

    JComboBox<String> Type;
    JComboBox<String> Name;

    JButton confirm;

    JTextField maintain;

    DealMaintain(){
        setLayout(null);

        setBounds(300,300,250,300);

        currentMaintain=new JLabel("当前处理：");
        add(currentMaintain);
        currentMaintain.setBounds(10,50,100,20);

        workertype=new JLabel("工人种类：");
        add(workertype);
        workertype.setBounds(10,100,100,20);

        workername=new JLabel("工人名字：");
        add(workername);
        workername.setBounds(10,150,100,20);

        maintain=new JTextField();
        add(maintain);
        maintain.setBounds(80,50,150,20);
        maintain.setEditable(false);
        //TODO 显示需要展示的信息
        maintain.setText("");

        Type=new JComboBox<String>();
        Type.addItem("水电工");
        Type.addItem("家具工");
        Type.addItem("淋浴工");
        Type.addItem("其他工");
        add(Type);
        Type.setBounds(80,100,150,20);

        Name=new JComboBox<String>();
        //TODO 动态加载工人

        confirm=new JButton("确认处理");
        add(confirm);
        confirm.setBounds(65,220,100,20);
        //TODO
        confirm.addActionListener(e->{

        });

        setVisible(true);
    }
}
