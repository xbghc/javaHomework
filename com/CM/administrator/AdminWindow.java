package com.CM.administrator;

import com.CM.resident.PanelNotice;

import javax.swing.*;

public class AdminWindow extends JFrame {

    //声明需要的面板
    PanelAddPerson panelAddPerson;         //增加户主信息
    PanelSelectPerson panelSelectPerson;   //删除户主信息
    PanelDealMaintain panelDealMaintain;   //处理报修信息
    PanelPostNotice panelPostNotice;       //发布公告
    PanelNotice panelNotice;    //公告信息面板

    //声明需要的信息
    JLabel name;
    JLabel id;
    JLabel position;


    //声明选择子窗口的选项卡窗格
    JTabbedPane choice;          //面板选择栏

    Individual individual;

    public AdminWindow(String username){
        individual=new Individual(username);
        setLayout(null);
        setBounds(150, 150, 700, 540);//设置主窗口的大小
        panelAddPerson =new PanelAddPerson();
        panelSelectPerson =new PanelSelectPerson();
        panelDealMaintain =new PanelDealMaintain();
        panelPostNotice =new PanelPostNotice();
        panelNotice = new PanelNotice();


        choice=new JTabbedPane();
        choice.add("社区公告", panelNotice);
        choice.add("增加户主", panelAddPerson);
        choice.add("删除账户", panelSelectPerson);
        choice.add("处理保修", panelDealMaintain);
        choice.add("发布公告", panelPostNotice);

        add(choice);
        choice.setBounds(0,100,700,440);

        name=new JLabel("姓名:"+individual.name);
        add(name);
        name.setBounds(500,10,80,20);

        id=new JLabel("工号:"+individual.NO);
        add(id);
        id.setBounds(500,40,80,20);

        position=new JLabel("职位:管理员");
        add(position);
        position.setBounds(500,70,80,20);

        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }
}
