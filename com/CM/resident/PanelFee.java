package com.CM.resident;

import javax.swing.*;

public class PanelFee extends JPanel{

    //声明需要显示的标签
    JLabel waterFee;        //水费
    JLabel electricFee;     //电费
    JLabel gasFee;          //燃气费
    JLabel propertyFee;     //物业费

    JLabel result;

    //声明需要用到的‘元’字标签
    JLabel[] charFee=new JLabel[4];

    //声明需要的文本框
    JTextField Output_WF;   //水费的显示
    JTextField Output_EF;   //电费的显示
    JTextField Output_GF;   //燃气费的显示
    JTextField Output_PF;   //物业费的显示

    //显示反馈信息的区域
    JTextArea textNotice;

    //声明需要的按钮
    JButton payFee;         //缴费按钮
    JButton queryFee;       //查询按钮


    PanelFee(Individual individual){
        setLayout(null);

        //初始化‘元’标签
        for(int i=0;i<charFee.length;i++){
            charFee[i]=new JLabel("元");
        }

        //初始化Notice区域
        textNotice=new JTextArea(15,20);
        add(textNotice);
        textNotice.setBounds(300,50,300,200);
        textNotice.setEditable(false);


        //初始化标签以及布局

        result=new JLabel("反馈信息:");
        add(result);
        result.setBounds(300,10,100,40);

        waterFee=new JLabel("水费：");
        add(waterFee);
        waterFee.setBounds(50,50,100,40);
        Output_WF=new JTextField();
        add(Output_WF);
        Output_WF.setBounds(160,50,100,40);
        Output_WF.setEditable(false);
        Output_WF.setText(individual.account.amounts.get("水费").toString());
        add(charFee[0]);
        charFee[0].setBounds(260,50,40,40);

        electricFee=new JLabel("电费：");
        add(electricFee);
        electricFee.setBounds(50,100,100,40);
        Output_EF=new JTextField();
        add(Output_EF);
        Output_EF.setBounds(160,100,100,40);
        Output_EF.setEditable(false);
        Output_EF.setText(individual.account.amounts.get("电费").toString());
        add(charFee[1]);
        charFee[1].setBounds(260,100,40,40);

        gasFee=new JLabel("燃气费：");
        add(gasFee);
        gasFee.setBounds(50,150,100,40);
        Output_GF=new JTextField();
        add(Output_GF);
        Output_GF.setBounds(160,150,100,40);
        Output_GF.setEditable(false);
        Output_GF.setText(individual.account.amounts.get("燃气费").toString());
        add(charFee[2]);
        charFee[2].setBounds(260,150,40,40);

        propertyFee=new JLabel("物业费：");
        add(propertyFee);
        propertyFee.setBounds(50,200,100,40);
        Output_PF=new JTextField();
        add(Output_PF);
        Output_PF.setBounds(160,200,100,40);
        Output_PF.setEditable(false);
        Output_PF.setText(individual.account.amounts.get("物业费").toString());
        add(charFee[3]);
        charFee[3].setBounds(260,200,40,40);

        //初始化按钮以及布局
        payFee=new JButton("立即缴费");
        add(payFee);
        payFee.setBounds(100,270,150,40);
        //TODO
        payFee.addActionListener(e->{
            int[] flag=new int[1];
            new PayFee(individual.account,this);
        });

        queryFee=new JButton("查询历史缴费");
        add(queryFee);
        queryFee.setBounds(300,270,150,40);
        queryFee.addActionListener(e->{
            textNotice.setText(individual.account.LogString());
        });
    }



}
