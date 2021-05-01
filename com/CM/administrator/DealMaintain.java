package com.CM.administrator;

import com.CM.db.DBman;

import javax.swing.*;

public class DealMaintain extends JFrame {

    JLabel currentMaintain;
    JLabel workerType;
    JLabel workerName;

    JComboBox<String> Type;
    JComboBox<String> Name;

    JButton confirm;

    JComboBox<String> maintain;

    Object[][] workerList;

    DealMaintain(Object[][] reqList, Object[][] workerList){
        this.workerList=workerList;
        setLayout(null);

        setBounds(300,300,250,300);

        currentMaintain=new JLabel("当前处理：");
        add(currentMaintain);
        currentMaintain.setBounds(10,50,100,20);

        workerType =new JLabel("工人种类：");
        add(workerType);
        workerType.setBounds(10,100,100,20);

        workerName =new JLabel("工人名字：");
        add(workerName);
        workerName.setBounds(10,150,100,20);

        maintain= new JComboBox<String>();
        add(maintain);
        maintain.setBounds(80,50,150,20);

        for(int i=0;i<reqList.length;i++){
            maintain.addItem(String.format("%s->%s",reqList[i][0],reqList[i][1]));
        }

        Type=new JComboBox<>();
        Type.addItem("水电工");
        Type.addItem("家具工");
        Type.addItem("淋浴工");
        Type.addItem("其他工");
        add(Type);
        Type.setBounds(80,100,150,20);
        //TODO 添加监听事件，如果选择的种类改动，则调用 WhoCan(type,nameBox)  将可用工人加载入选择栏


        Name=new JComboBox<String>();
        //TODO 添加监听事件，如果选中某个工人，则可以点击按钮，否则按钮不可点击


        confirm=new JButton("确认处理");
        add(confirm);
        confirm.setBounds(65,220,100,20);



        confirm.addActionListener(e->{

            String name = (String) Name.getSelectedItem();
            try {
                String sql=String.format("UPDATE worker SET time=date_add(now(), interval 30 minute) WHERE name='%s'",name);
                DBman.update(sql);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        setVisible(true);
    }

    void WhoCan(String type,JComboBox nameBox){
        nameBox.removeAllItems();
        for(int i=0;i<workerList.length;i++){
            if(workerList[i][1]==type)nameBox.addItem(workerList[i][0]);
        }
    }
}
