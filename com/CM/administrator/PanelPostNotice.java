package com.CM.administrator;

import javax.swing.*;

public class PanelPostNotice extends JPanel {

    JLabel titleNotice;
    JLabel detailNotice;

    JTextField titleText;

    JTextArea detailText;

    JButton confirm;
    JButton quit;

    PanelPostNotice(){
        setLayout(null);

        titleNotice=new JLabel("公告标题:");
        add(titleNotice);
        titleNotice.setBounds(100,50,100,20);

        detailNotice=new JLabel("公告内容:");
        add(detailNotice);
        detailNotice.setBounds(100,100,100,20);

        titleText=new JTextField();
        add(titleText);
        titleText.setBounds(210,50,400,20);

        detailText=new JTextArea();
        add(detailText);
        detailText.setBounds(210,100,400,200);

        confirm=new JButton("确认发布");
        add(confirm);
        confirm.setBounds(210,320,100,20);
        //TODO
        confirm.addActionListener(e->{

            JOptionPane.showMessageDialog(this,"发布成功！",
                    "提示对话框",JOptionPane.WARNING_MESSAGE);
        });

        quit=new JButton("重置");
        add(quit);
        quit.setBounds(420,320,100,20);
        quit.addActionListener(e->{
            titleText.setText("");
            detailText.setText("");
        });
    }
}
