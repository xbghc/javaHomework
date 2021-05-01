package com.CM.administrator;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.*;

public class PanelDealMaintain extends JPanel {

    //声明需要显示信息的标签
    JLabel note1;
    JLabel note2;

    //声明一个表格，以显示工人信息
    JTable workers;
    JTable maintains;

    //声明table需要的信息
    Object a[][];
    Object nameW[]={"姓名","工种","状态"};

    Object b[][];
    Object nameM[]={"发布时间","报修描述","报修状态"};

    //声明一个list，显示待处理的保修
    JList InformationMaintain;

    //声明按钮
    JButton query;
    JButton deal;
    JButton add;
    JButton delete;

    //
    JScrollPane scrollW;
    JScrollPane scrollM;

    PanelDealMaintain(){
        setLayout(null);

        //TODO 从数据库中读取信息出来
        a=new Object[20][3];
        b=new Object[5][3];
        //测试用的数据
        for(int i=0;i<20;i++){
            for(int j=0;j<3;j++){
                if(j==0)
                    a[i][j]="张三";
                if(j==1)
                    a[i][j]="水电工";
                if(j==2)
                    a[i][j]="空闲";
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                if(j==0)
                    b[i][j]="2021.5.1";
                if(j==1)
                    b[i][j]="下水道堵塞";
                if(j==2)
                    b[i][j]="未处理";
            }
        }

        workers=new JTable(a,nameW);
        maintains=new JTable(b,nameM);

        scrollW=new JScrollPane(workers);
        add(scrollW);
        scrollW.setBounds(0,20,500,150);
        scrollM=new JScrollPane(maintains);
        add(scrollM);
        scrollM.setBounds(0,200,500,150);

        note1=new JLabel("当前工人信息如下:");
        add(note1);
        note1.setBounds(0,0,140,20);

        note2=new JLabel("当前待处理报修如下:");
        add(note2);
        note2.setBounds(0,180,140,20);

        add=new JButton("增加工人");
        delete=new JButton("开除工人");
        add(add);
        add(delete);
        add.setBounds(540,75,100,20);
        delete.setBounds(540,140,100,20);
        //TODO 扩展功能
        add.addActionListener(e->{

        });

        delete.addActionListener(e->{

        });

        //添加需要处理的保修
        InformationMaintain=new JList();

        deal=new JButton("处理报修");
        add(deal);
        deal.setBounds(520,260,150,20);
        deal.addActionListener(e->{
            new DealMaintain();
        });


        query=new JButton("查询历史报修");
        add(query);
        query.setBounds(520,300,150,20);
        query.addActionListener(e->{
            new FormerMaintain();
        });
    }
}


