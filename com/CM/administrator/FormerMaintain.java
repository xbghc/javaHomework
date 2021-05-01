package com.CM.administrator;

import javax.swing.*;

public class FormerMaintain extends JFrame {

    JLabel note;

    JTable information;

    JScrollPane scroll;

    JButton query;
    JButton quit;

    Object a[][];
    Object name[]={"报修描述","处理时间","报修时间","报修状态"};

    FormerMaintain(){
        setLayout(null);
        setBounds(300,300,310,220);

        note=new JLabel("历史报修信息如下:");
        add(note);
        note.setBounds(0,10,150,20);

        //TODO 初始化数组
        //瞎编的信息
        a=new Object[10][4];

        for(int i=0;i<10;i++){
            for(int j=0;j<4;j++){
                if(j==0)
                    a[i][j]="下水道故障";
                if(j==1)
                    a[i][j]="2021.5.1";
                if(j==2)
                    a[i][j]="2021.5.2";
                if(j==3)
                    a[i][j]="已处理";
            }
        }


        information=new JTable(a,name);

        scroll=new JScrollPane(information);
        add(scroll);
        scroll.setBounds(10,40,280,100);

        query=new JButton("立即查询");
        add(query);
        query.setBounds(30,160,100,20);

        quit=new JButton("取消");
        add(quit);
        quit.setBounds(140,160,100,20);
        quit.addActionListener(e->{
            dispose();
        });

        setVisible(true);
    }

}
