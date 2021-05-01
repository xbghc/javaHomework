package com.CM.resident;
//导入需要的包
import javax.swing.*;

public class ResidentWindow extends JFrame{

    //声明需要的子窗口
    PanelPersonal panelPersonal;    //个人信息面板
    PanelFamily panelFamily;    //家庭信息面板
    PanelFee panelFee;          //缴费信息面板
    PanelNotice panelNotice;    //公告信息面板
    PanelMaintain panelMaintain;//维修信息面板

    //声明选择子窗口的选项卡窗格
    JTabbedPane choice;          //面板选择栏
    Individual individual;

    public ResidentWindow(String username) {
        individual =new Individual();
        individual.init(username);
        setLayout(null);
        setBounds(150, 150, 700, 540);//设置主窗口的大小
        choice=new JTabbedPane();


        panelPersonal = new PanelPersonal(individual);
        choice.add("个人信息", panelPersonal);

        panelFamily = new PanelFamily(username);
        choice.add("家庭成员", panelFamily);

        panelFee = new PanelFee(individual);
        choice.add("缴费信息", panelFee);

        panelNotice = new PanelNotice();
        choice.add("社区公告", panelNotice);

        panelMaintain = new PanelMaintain(username);
        choice.add("报修信息", panelMaintain);




        add(choice);
        choice.setBounds(0,100,700,440);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }

}
