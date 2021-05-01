package com.CM.resident;

import com.CM.db.DBman;
import com.CM.resident.listener.NoticeListListener;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PanelNotice extends JPanel {
    JLabel notice;


    JList<String> noticeItem=new JList<>();
    DefaultListModel<String> listModel;

    NoticeListListener mouseListener;

    public PanelNotice() {

        setLayout(null);

        notice = new JLabel("公告栏：");
        add(notice);
        notice.setBounds(10, 10, 80, 20);


        listModel=new DefaultListModel<>();
        mouseListener=new NoticeListListener();
        mouseListener.listModel=listModel;
        noticeItem.setModel(listModel);

        add(noticeItem);
        noticeItem.setBounds(10,40,630,400);

        getNotice();

    }

    public void getNotice(){
        ResultSet rs= DBman.execute("SELECT * FROM notice");
        if(rs==null)return;
        try {
            while(rs.next()){
                String text=rs.getString("text");
                if(text.length()>30)text=text.substring(0,30)+"...";
                String line=String.format("%s        \t%s               \t%s",
                        rs.getString("title"),text,rs.getString("time")
                        );
                listModel.addElement(line);
                mouseListener.noticeList.add(line);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
