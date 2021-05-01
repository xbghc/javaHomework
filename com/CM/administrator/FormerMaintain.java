package com.CM.administrator;

import com.CM.db.DBman;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormerMaintain extends JFrame {

    JLabel note;

    JTable information;

    JScrollPane scroll;

    JButton query;
    JButton quit;

    Object[][] dealLog;
    Object[] name ={"报修描述","处理时间","报修时间","报修状态"};

    FormerMaintain(){
        setLayout(null);
        setBounds(300,300,310,220);

        note=new JLabel("历史报修信息如下:");
        add(note);
        note.setBounds(0,10,150,20);

        try{
            ResultSet rs= DBman.execute("SELECT * FROM req WHERE status=1");
            int count=0;
            if (rs != null) {
                while(rs.next()){
                    count++;
                }
            }
            else return;
            rs= DBman.execute("SELECT * FROM req WHERE status=1");

            dealLog=new Object[count][4];
            for(int i=0;i<count;i++){
                assert rs != null;
                dealLog[i][0]=rs.getString("type");
                dealLog[i][1]=rs.getString("dealTime");
                dealLog[i][2]=rs.getString("time");
                dealLog[i][3]=rs.getString("已处理");
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return;
        }


        information=new JTable(dealLog,name);

        scroll=new JScrollPane(information);
        add(scroll);
        scroll.setBounds(10,40,280,100);

        query=new JButton("立即查询");
        add(query);
        query.setBounds(30,160,100,20);

        quit=new JButton("取消");
        add(quit);
        quit.setBounds(140,160,100,20);
        quit.addActionListener(e-> dispose());

        setVisible(true);
    }

}
