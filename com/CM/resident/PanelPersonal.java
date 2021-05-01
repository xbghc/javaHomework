package com.CM.resident;

import javax.swing.*;

public class PanelPersonal extends JPanel{
    
    PanelPersonal(Individual individual){
        setLayout(null);//设置为空布局

        //添加需要显示信息的标签
        JLabel l_name=new JLabel("姓名：");
        JLabel l_ID=new JLabel("身份证号码：");
        JLabel l_username=new JLabel("用户名：");
        JLabel l_age=new JLabel("年龄：");
        JLabel l_gender=new JLabel("性别：");
        JLabel l_workAddr=new JLabel("工作单位：");
        JLabel l_companyTel=new JLabel("公司电话");
        JLabel l_personalPhone=new JLabel("电话：");
        JLabel l_QQ=new JLabel("QQ：");
        JLabel l_email=new JLabel("邮箱：");
        JLabel l_community=new JLabel("小区：");
        JLabel l_buildingNo=new JLabel("楼栋：");
        JLabel l_unitNo=new JLabel("单元号：");
        JLabel l_doorNo=new JLabel("门牌号：");

        //添加Label后显示数据库信息的文本框
        JTextField t_name=new JTextField();
        JTextField t_ID=new JTextField();
        JTextField t_username=new JTextField();
        JTextField t_age=new JTextField();
        JTextField t_gender=new JTextField();
        JTextField t_workAddr=new JTextField();
        JTextField t_companyTel=new JTextField();
        JTextField t_personalPhone=new JTextField();
        JTextField t_QQ=new JTextField();
        JTextField t_email=new JTextField();
        JTextField t_community=new JTextField();
        JTextField t_buildingNo=new JTextField();
        JTextField t_unitNo=new JTextField();
        JTextField t_doorNo=new JTextField();



        //将需要的Label和Text添加到窗口中，并设置其位置
        add(l_name);
        l_name.setBounds(50,50,80,20);
        add(t_name);
        t_name.setBounds(130,50,80,20);
        t_name.setEditable(false);
        t_name.setText(individual.name);

        add(l_ID);
        l_ID.setBounds(390,50,80,20);
        add(t_ID);
        t_ID.setBounds(470,50,150,20);
        t_ID.setEditable(false);
        t_ID.setText(individual.ID);

        add(l_username);
        l_username.setBounds(50,130,80,20);
        add(t_username);
        t_username.setBounds(130,130,80,20);
        t_username.setEditable(false);
        t_username.setText(individual.username);

        add(l_age);
        l_age.setBounds(50,170,80,20);
        add(t_age);
        t_age.setBounds(130,170,80,20);
        t_age.setEditable(false);
        t_age.setText(String.valueOf(2021 - Integer.parseInt(individual.ID.substring(6,10)))) ;

        add(l_gender);
        l_gender.setBounds(220,50,80,20);
        add(t_gender);
        t_gender.setBounds(300,50,80,20);
        t_gender.setEditable(false);
        t_gender.setText(Integer.parseInt(individual.ID.substring(16,17))%2==1?"男":"女");

        add(l_workAddr);
        l_workAddr.setBounds(220,90,80,20);
        add(t_workAddr);
        t_workAddr.setBounds(300,90,80,20);
        t_workAddr.setEditable(false);
        t_workAddr.setText(individual.workAddr);

        add(l_companyTel);
        l_companyTel.setBounds(50,210,80,20);
        add(t_companyTel);
        t_companyTel.setBounds(130,210,80,20);
        t_companyTel.setEditable(false);
        t_companyTel.setText(individual.companyTel);

        add(l_personalPhone);
        l_personalPhone.setBounds(220,130,80,20);
        add(t_personalPhone);
        t_personalPhone.setBounds(300,130,80,20);
        t_personalPhone.setEditable(false);
        t_personalPhone.setText(individual.personalPhone);

        add(l_QQ);
        l_QQ.setBounds(220,170,80,20);
        add(t_QQ);
        t_QQ.setBounds(300,170,80,20);
        t_QQ.setEditable(false);
        t_QQ.setText(individual.QQ);


        add(l_email);
        l_email.setBounds(390, 90, 80, 20);
        add(t_email);
        t_email.setBounds(470,90,150,20);
        t_email.setEditable(false);
        t_email.setText(individual.email);

        add(l_community);
        l_community.setBounds(50,90,80,20);
        add(t_community);
        t_community.setBounds(130,90,80,20);
        t_community.setEditable(false);
        t_community.setText(individual.community);

        add(l_buildingNo);
        l_buildingNo.setBounds(390,130,80,20);
        add(t_buildingNo);
        t_buildingNo.setBounds(470,130,120,20);
        t_buildingNo.setEditable(false);
        t_buildingNo.setText(individual.buildingNo);

        add(l_unitNo);
        l_unitNo.setBounds(390,170,80,20);
        add(t_unitNo);
        t_unitNo.setBounds(470,170,120,20);
        t_unitNo.setEditable(false);
        t_unitNo.setText(individual.unitNo);

        add(l_doorNo);
        l_doorNo.setBounds(390,210,80,20);
        add(t_doorNo);
        t_doorNo.setBounds(470,210,80,20);
        t_doorNo.setEditable(false);
        t_doorNo.setText(individual.doorNo);

        //添加按钮
        JButton alter=new JButton("编辑信息");
        JButton complete=new JButton("完成修改");
        add(alter);
        add(complete);
        alter.setBounds(180,300,100,40);
        complete.setBounds(300,300,100,40);


        //将需要的文本框数组传输给鼠标响应事件
        alter.addActionListener(e -> {
            t_workAddr.setEditable(true);
            t_companyTel.setEditable(true);
            t_personalPhone.setEditable(true);
            t_QQ.setEditable(true);
            t_email.setEditable(true);
            t_community.setEditable(true);
            t_buildingNo.setEditable(true);
            t_unitNo.setEditable(true);
            t_doorNo.setEditable(true);
        });

        complete.addActionListener(e -> {

            individual.update(t_workAddr.getText(),
                    t_companyTel.getText(),
                    t_personalPhone.getText(),
                    t_QQ.getText(),
                    t_email.getText(),
                    t_community.getText(),
                    t_buildingNo.getText(),
                    t_unitNo.getText(),
                    t_doorNo.getText()
                    );


            t_workAddr.setEditable(false);
            t_companyTel.setEditable(false);
            t_personalPhone.setEditable(false);
            t_QQ.setEditable(false);
            t_email.setEditable(false);
            t_community.setEditable(false);
            t_buildingNo.setEditable(false);
            t_unitNo.setEditable(false);
            t_doorNo.setEditable(false);
        });
    }

}

