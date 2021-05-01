package com.CM.resident;

import com.CM.db.DBman;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PanelMaintain extends JPanel{

    //声明需要的按钮
    JButton commit;

    //声明需要的声明的标签
    //声明保险类别标签
    JLabel electric;    //种类为电
    JLabel gas;         //种类为气
    JLabel door;        //种类为门
    JLabel furniture;   //种类为家具
    JLabel sanitary;    //种类为洁具
    JLabel shower;      //种类为淋浴
    JLabel window;      //种类为窗户
    JLabel other;       //其他种类

    //声明每个类的复选框
    //electric
    JCheckBox light;    //灯故障
    JCheckBox noElectric;//停电
    JCheckBox device;   //电器故障
    JCheckBox airCondition;//空调故障
    JCheckBox other_electric;//其他故障

    //gas
    JCheckBox boiler;   //热水器故障
    JCheckBox other_gas;//其他故障

    //door
    JCheckBox cylinder; //锁芯故障
    JCheckBox doorFix;  //门不能关上/转动不流畅
    JCheckBox handle;   //把手坏了
    JCheckBox other_door;//其他故障

    //furniture
    JCheckBox drawer;   //抽屉故障
    JCheckBox curtain;  //窗帘坏了
    JCheckBox clothesline;//晾衣杆坏了
    JCheckBox chair;    //椅子坏了
    JCheckBox other_furniture;//其他故障

    //sanitary
    JCheckBox besom;    //扫把坏了
    JCheckBox sewer;    //下水道坏了
    JCheckBox faucet;   //水龙头坏了
    JCheckBox other_sanitary;//其他故障

    //shower
    JCheckBox temperature;  //热水器温度不正常
    JCheckBox sprinkler;    //花洒坏了
    JCheckBox other_shower; //其他故障

    //window
    JCheckBox glass;        //窗户玻璃破碎
    JCheckBox close;        //开/关存在问题
    JCheckBox other_window; //其他故障

    //other
    JCheckBox other_other;  //其他问题

    ArrayList<JCheckBox> boxes;

    PanelMaintain(String username){
        setLayout(null);

        boxes=new ArrayList<>();

        //information of row one (electric)

        electric=new JLabel("用电故障：");
        add(electric);
        electric.setBounds(0,0,80,20);


        light=new JCheckBox("灯故障");
        add(light);
        light.setBounds(90,0,80,20);
        boxes.add(light);

        noElectric=new JCheckBox("停电");
        add(noElectric);
        noElectric.setBounds(180,0,80,20);
        boxes.add(noElectric);

        device=new JCheckBox("电器没电");
        add(device);
        device.setBounds(270,0,80,20);
        boxes.add(device);

        airCondition =new JCheckBox("空调故障");
        add(airCondition);
        airCondition.setBounds(360,0,80,20);
        boxes.add(airCondition);

        other_electric=new JCheckBox("其他用电故障");
        add(other_electric);
        other_electric.setBounds(450,0,120,20);
        boxes.add(other_electric);

        //information of row two (gas)

        gas=new JLabel("用气故障：");
        add(gas);
        gas.setBounds(0,40,80,20);

        boiler=new JCheckBox("热水器故障");
        add(boiler);
        boiler.setBounds(90,40,120,20);
        boxes.add(boiler);

        other_gas=new JCheckBox("其他用气故障");
        add(other_gas);
        other_gas.setBounds(220,40,120,20);
        boxes.add(other_gas);

        //information or row three (door)

        door=new JLabel("门：");
        add(door);
        door.setBounds(0,80,80,20);

        cylinder=new JCheckBox("锁芯损坏");
        add(cylinder);
        cylinder.setBounds(90,80,80,20);
        boxes.add(cylinder);

        doorFix =new JCheckBox("门不能关上/转动不流畅");
        add(doorFix);
        doorFix.setBounds(180,80,200,20);
        boxes.add(doorFix);

        handle=new JCheckBox("把手损坏");
        add(handle);
        handle.setBounds(390,80,80,20);
        boxes.add(handle);

        other_door=new JCheckBox("门其他损坏");
        add(other_door);
        other_door.setBounds(480,80,100,20);
        boxes.add(other_door);

        //information of row four (furniture)

        furniture=new JLabel("家具报修");
        add(furniture);
        furniture.setBounds(0,120,80,20);

        drawer=new JCheckBox("抽屉坏了");
        add(drawer);
        drawer.setBounds(90,120,80,20);
        boxes.add(drawer);

        curtain=new JCheckBox("窗帘坏了");
        add(curtain);
        curtain.setBounds(180,120,80,20);
        boxes.add(curtain);

        clothesline=new JCheckBox("晾衣杆坏了");
        add(clothesline);
        clothesline.setBounds(270,120,120,20);
        boxes.add(clothesline);

        chair=new JCheckBox("椅子坏了");
        add(chair);
        chair.setBounds(400,120,80,20);
        boxes.add(chair);

        other_furniture=new JCheckBox("其他家具");
        add(other_furniture);
        other_furniture.setBounds(490,120,80,20);
        boxes.add(other_furniture);

        //information of row five  (sanitary)

        sanitary=new JLabel("洁具：");
        add(sanitary);
        sanitary.setBounds(0,160,80,20);

        besom=new JCheckBox("扫把坏了");
        add(besom);
        besom.setBounds(90,160,80,20);
        boxes.add(besom);

        sewer=new JCheckBox("下水道");
        add(sewer);
        sewer.setBounds(180,160,80,20);
        boxes.add(sewer);

        faucet=new JCheckBox("水龙头");
        add(faucet);
        faucet.setBounds(270,160,80,20);
        boxes.add(faucet);

        other_sanitary=new JCheckBox("其他洁具");
        add(other_sanitary);
        other_sanitary.setBounds(360,160,80,20);
        boxes.add(other_sanitary);

        //information of row six (shower)

        shower=new JLabel("淋浴保修：");
        add(shower);
        shower.setBounds(0,200,80,20);

        temperature=new JCheckBox("热水器温度不正常");
        add(temperature);
        temperature.setBounds(90,200,200,20);
        boxes.add(temperature);

        sprinkler=new JCheckBox("花洒坏了");
        add(sprinkler);
        sprinkler.setBounds(300,200,80,20);
        boxes.add(sprinkler);

        other_shower=new JCheckBox("其他淋浴故障");
        add(other_shower);
        other_shower.setBounds(390,200,140,20);
        boxes.add(other_shower);

        //information of row seven (window)

        window=new JLabel("窗户保修");
        add(window);
        window.setBounds(0,240,80,20);

        glass=new JCheckBox("窗户玻璃损坏");
        add(glass);
        glass.setBounds(90,240,200,20);
        boxes.add(glass);

        close=new JCheckBox("开/关存在问题");
        add(close);
        close.setBounds(300,240,200,20);
        boxes.add(close);

        other_window=new JCheckBox("其他窗户故障");
        add(other_window);
        other_window.setBounds(510,240,150,20);
        boxes.add(other_window);

        //information of row eight (other)

        other=new JLabel("其他故障");
        add(other);
        other.setBounds(0,280,80,20);

        other_other=new JCheckBox("其他故障");
        add(other_other);
        other_other.setBounds(90,280,80,20);
        boxes.add(other_other);

        //初始化按钮
        commit=new JButton("提交保修");
        add(commit);
        commit.setBounds(300,300,100,40);
        commit.addActionListener(e->{
            for(JCheckBox chkBox:boxes){
                if(chkBox.isSelected()) {
                    String sql=String.format("INSERT INTO req VALUES('%s','%s','%s',0)",
                            chkBox.getText(),
                            username,
                            (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date().getTime()));
                    DBman.update(sql);
                }
            }
            JOptionPane.showMessageDialog(null,
                    "提交成功",
                    "消息对话框",
                    JOptionPane.WARNING_MESSAGE);
        });

    }
}
