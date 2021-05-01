package com.CM.administrator;

import com.CM.db.DBman;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PanelDealMaintain extends JPanel {

    //声明需要显示信息的标签
    JLabel note1;
    JLabel note2;

    //声明一个表格，以显示工人信息
    JTable workers;
    JTable maintains;

    //声明table需要的信息
    Object[][] workerList;
    Object[] nameW ={"姓名","工种","状态"};

    Object[][] reqList;
    Object[] nameM ={"发布时间","报修描述","报修状态"};

    //声明一个list，显示待处理的保修
    public JList InformationMaintain;

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



        // 工人
        try {
            ResultSet rs= DBman.execute("SELECT * FROM worker WHERE NOW()>freeTime");
            int rowCount;
            if(rs==null)return;
            rowCount=0;
            while(rs.next()) {
                rowCount++;
            }
            rs= DBman.execute("SELECT * FROM worker WHERE NOW()>freeTime");

            workerList =new Object[rowCount][3];

            int i=0;
            while(true){
                assert rs != null;
                if (!rs.next()) break;
                workerList[i][0]=rs.getString("name");
                workerList[i][1]=rs.getString("type");
                workerList[i][2]="空闲";
                i++;
            }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return;
        }

        // 报修

        try {
            ResultSet rs= DBman.execute("SELECT * FROM req WHERE status=0;");
            int rowCount;
            if(rs==null)return;

            rowCount=0;
            while(rs.next()) {
                rowCount++;
            }
            rs= DBman.execute("SELECT * FROM req WHERE status=0;");

            reqList =new Object[rowCount][3];

            int i=0;
            while(true){
                assert rs != null;
                if (!rs.next()) break;
                reqList[i][0]=rs.getString("time");
                reqList[i][1]=rs.getString("type");
                reqList[i][2]="未处理";
                i++;
            }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return;
        }

        workers=new JTable(workerList,nameW);
        maintains=new JTable(reqList,nameM);

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
            new DealMaintain(reqList,workerList);
        });


        query=new JButton("查询历史报修");
        add(query);
        query.setBounds(520,300,150,20);
        query.addActionListener(e->{
            new FormerMaintain();
        });
    }
}


