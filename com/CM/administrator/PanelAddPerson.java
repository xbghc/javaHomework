package com.CM.administrator;

import com.CM.db.DBman;

import javax.swing.*;
import java.awt.*;

public class PanelAddPerson extends JPanel {

    //声明需要的标签
    JLabel l_username;
    JLabel l_password1;
    JLabel l_password2;
    JLabel l_name;
    JLabel l_ID;
    JLabel l_community;
    JLabel l_buildingNo;
    JLabel l_unitNo;
    JLabel l_doorNo;
    JLabel communityInformation;

    //声明下拉列表
    //JComboBox<String> communityBox; //保留以后后续开发
    JComboBox<String> buildingBox;
    JComboBox<String> unitBox;
    JComboBox<String> houseBox;


    //声明需要的文本框
    JTextField t_username;
    JPasswordField t_password1;
    JPasswordField t_password2;
    JTextField t_name;
    JTextField t_ID;
    JTextField t_community;//Extensible: 为了以后可以修改小区名字

    JTextArea information;

    //声明需要的按钮
    JButton confirmAdd;
    JButton reset;

    PanelAddPerson() {
        setLayout(null);

        //添加显示提示信息的标签
        l_username = new JLabel("用户名:");
        add(l_username);
        l_username.setBounds(10, 10, 100, 20);

        l_password1 = new JLabel("密码:");
        add(l_password1);
        l_password1.setBounds(10, 40, 100, 20);

        l_password2 = new JLabel("确认密码：");
        add(l_password2);
        l_password2.setBounds(10, 70, 100, 20);

        l_name = new JLabel("户主名字：");
        add(l_name);
        l_name.setBounds(10, 100, 100, 20);

        l_ID = new JLabel("身份证号码：");
        add(l_ID);
        l_ID.setBounds(10, 130, 100, 20);

        l_community = new JLabel("小区名字：");
        add(l_community);
        l_community.setBounds(10, 160, 100, 20);

        l_buildingNo = new JLabel("楼栋：");
        add(l_buildingNo);
        l_buildingNo.setBounds(10, 190, 100, 20);

        l_unitNo = new JLabel("单元号：");
        add(l_unitNo);
        l_unitNo.setBounds(10, 220, 100, 20);

        l_doorNo = new JLabel("门牌号：");
        add(l_doorNo);
        l_doorNo.setBounds(10, 250, 100, 20);

        //添加显示需要的文本框和下拉栏
        t_username = new JTextField();
        add(t_username);
        t_username.setBounds(130, 10, 150, 20);

        t_password1 = new JPasswordField();
        add(t_password1);
        t_password1.setBounds(130, 40, 150, 20);
        t_password1.setEchoChar('*');

        t_password2 = new JPasswordField();
        add(t_password2);
        t_password2.setBounds(130, 70, 150, 20);
        t_password2.setEchoChar('*');

        t_name = new JTextField();
        add(t_name);
        t_name.setBounds(130, 100, 150, 20);

        t_ID = new JTextField();
        add(t_ID);
        t_ID.setBounds(130, 130, 150, 20);

        t_community = new JTextField();
        add(t_community);
        t_community.setBounds(130, 160, 150, 20);
        t_community.setEditable(false);//不允许在外部修改小区名字，修改名字留给Extensible
        t_community.setText("虎溪花园");//test阶段乱编的小区名，后续可改

        //设置楼栋，单元号，门牌号的下拉栏
        buildingBox = new JComboBox<>();
        //下列的楼栋名是临时乱编的，后续将会改动
        buildingBox.addItem("A栋");
        buildingBox.addItem("B栋");
        buildingBox.addItem("C栋");
        buildingBox.addItem("D栋");
        buildingBox.addItem("E栋");
        add(buildingBox);
        buildingBox.setBounds(130, 190, 100, 20);
        buildingBox.setSelectedIndex(-1);

        unitBox = new JComboBox<>();
        //下列的单元号是临时乱编的，后续将会改动
        unitBox.addItem("一单元");
        unitBox.addItem("二单元");
        unitBox.addItem("三单元");
        unitBox.addItem("四单元");
        unitBox.addItem("五单元");
        unitBox.addItem("六单元");
        unitBox.addItem("七单元");
        unitBox.addItem("八单元");
        add(unitBox);
        unitBox.setBounds(130, 220, 100, 20);
        unitBox.setSelectedIndex(-1);

        houseBox = new JComboBox<>();
        //下列的门牌号是临时乱编的，后续将会改动
        houseBox.addItem("101");
        houseBox.addItem("102");
        houseBox.addItem("201");
        houseBox.addItem("202");
        houseBox.addItem("301");
        houseBox.addItem("302");
        houseBox.addItem("401");
        houseBox.addItem("402");
        houseBox.addItem("501");
        houseBox.addItem("502");
        houseBox.addItem("601");
        houseBox.addItem("602");
        houseBox.addItem("701");
        houseBox.addItem("702");
        add(houseBox);
        houseBox.setBounds(130, 250, 150, 20);
        houseBox.setSelectedIndex(-1);

        //添加按钮
        confirmAdd = new JButton("确认添加");
        add(confirmAdd);
        confirmAdd.setBounds(10, 280, 100, 20);
        //TODO
        confirmAdd.addActionListener(e -> {
            String password1 = String.valueOf(t_password1.getPassword());
            String password2 = String.valueOf(t_password2.getPassword());
            if (!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this, "两次输入的密码不一致！", "错误", JOptionPane.WARNING_MESSAGE);
                return;
            }
            AddResident(t_username.getText(),
                    t_name.getText(),
                    t_ID.getText(),
                    password1,
                    t_community.getText(),
                    buildingBox.getSelectedItem().toString(),
                    unitBox.getSelectedItem().toString(),
                    houseBox.getSelectedItem().toString()
                    );
            String msg=String.format("添加用户（%s:%s）成功!",t_username.getText(),t_name.getText());
            JOptionPane.showMessageDialog(this, msg, "成功", JOptionPane.WARNING_MESSAGE);
            ResetAll();
        });

        reset = new JButton("重置");
        add(reset);
        reset.setBounds(130, 280, 100, 20);
        //TODO
        reset.addActionListener(e -> {
            ResetAll();
        });

        //设置小区信息区块

        communityInformation = new JLabel("小区介绍：");
        add(communityInformation);
        communityInformation.setBounds(340, 10, 100, 20);

        information = new JTextArea();
        add(information);
        information.setBounds(340, 40, 300, 300);
        information.setEditable(false);
        information.setText("""
                虎溪小区：
                建筑年代: 2008
                小区地址为沙坪坝重庆沙坪坝大学城；
                所属区域为沙坪坝 大学城；
                邮编为400030；
                物业类别为住宅；
                竣工时间为2008年。
                小区绿化面积大，树木花草众多，
                道路空间宽敞，居住安宁舒适""");
        information.setBackground(Color.gray);
        information.setSelectedTextColor(Color.red);

    }

    public void AddResident(String username, String name, String ID, String password,String community,String buildingNo,String unitNo,String doorNo) {
        // 添加到user表
        String sql = String.format("INSERT INTO user (name,ID,password,username,priority)VALUES('%s','%s','%s','%s','住户')",
                name,
                ID,
                password,
                username);
        DBman.update(sql);

        // 添加到people表
        sql=String.format("INSERT INTO people (username,community,buildingNo,unitNo,doorNo)VALUES('%s','%s','%s','%s','%s')",username,community,buildingNo,unitNo,doorNo);
        DBman.update(sql);
    }

    public void ResetAll(){
        t_username.setText("");
        t_password1.setText("");
        t_password2.setText("");
        t_name.setText("");
        t_ID.setText("");
        buildingBox.setSelectedIndex(-1);
        unitBox.setSelectedIndex(-1);
        houseBox.setSelectedIndex(-1);
    }
}
