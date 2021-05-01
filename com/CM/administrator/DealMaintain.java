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
        Type.setSelectedIndex(-1);
        add(Type);
        Type.setBounds(80,100,150,20);
        Type.addActionListener(e->{
            add(Name);
            Name.setBounds(80,150,150,20);
            WhoCan((String) Type.getSelectedItem(),Name);

        });

        Name=new JComboBox<String>();



        confirm=new JButton("确认处理");
        add(confirm);
        confirm.setBounds(65,220,100,20);

        confirm.addActionListener(e->{
            if(Type.getSelectedIndex()==-1){
                JOptionPane.showMessageDialog(this,"您还未选择工人种类！",
                        "tips",JOptionPane.WARNING_MESSAGE);

            }
            else {
                String name = (String) Name.getSelectedItem();
                try {
                    String sql=String.format("UPDATE worker SET freeTime=date_add(now(), interval 30 minute) WHERE name='%s'",name);
                    DBman.update(sql);
                    sql=String.format("UPDATE req SET status=1,dealTime=now() WHERE time='%s'",((String)maintain.getSelectedItem()).substring(0,19));
                    DBman.update(sql);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });



        setVisible(true);
    }

    void WhoCan(String type,JComboBox nameBox){
        nameBox.removeAllItems();
        for(int i=0;i<workerList.length;i++){
            if(workerList[i][1].equals(type))nameBox.addItem(workerList[i][0]);
        }
    }

    void updateStatus(String time){
        //TODO 更新处理状态
    }
}
