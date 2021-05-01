package com.CM.login;

import com.CM.administrator.AdminWindow;
import com.CM.db.DBman;
import com.CM.resident.ResidentWindow;

import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;

public class UserLogin extends JFrame implements ActionListener {
    
    // 文本信息、图标 显示
    JLabel text1,text2,title;
    JLabel image;

    // 文本框变量
    JTextField username;
    JPasswordField password;

    // 按钮变量
    JButton login, findBackPwd;


    // 构造函数
    UserLogin(){
        init();
        setBounds(600,300,300,400);
        setTitle("登录");
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 窗体实现
    void init(){
        // 初始化
        text1=new JLabel("账号:");
        text2=new JLabel("密码:");
        title=new JLabel("社区登录界面");
        image=new JLabel();
        username=new JTextField();
        password=new JPasswordField();
        password.setEchoChar('*');
        login=new JButton("登录");
        findBackPwd =new JButton("找回密码");

        // 图片设置
        title.setIcon(new ImageIcon("com/CM/login/img/housePic.jpeg"));
        title.setHorizontalTextPosition(SwingConstants.RIGHT);
        title.setVerticalTextPosition(SwingConstants.CENTER);

        // 空布局 设置控件位置
        setLayout(null);
        text1.setBounds(60,140,60,20);
        text2.setBounds(60,170,60,20);
        title.setBounds(45,35,200,80);

        image.setIcon(new ImageIcon("com/CM/login/img/1.png"));
        image.setBounds(50,260,200,50);

        username.setBounds(110,140,140,20);
        password.setBounds(110,170,140,20);

        login.setBounds(70,220,60,30);
        findBackPwd.setBounds(150,220,90,30);

        // 改变title字体参数
        title.setFont(new Font("楷体",Font.BOLD,25));

        // 登录按钮设置监视器及响应事件
        login.addActionListener(e -> {
            while(DBman.con==null) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            int flag=DBman.SignIn(username.getText(), String.valueOf(password.getPassword()));
            if(flag==0){
                //  登录成功 打开新窗口
                new ResidentWindow(username.getText());
                dispose();
            }
            else if(flag==1){
                new AdminWindow(username.getText());
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "登陆失败",
                        "消息对话框",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
        // 找回密码按钮添加监视器
        findBackPwd.addActionListener(this);

        // 窗体上添加控件
        add(text1);
        add(text2);
        add(title);
        add(image);

        add(username);
        add(password);

        add(login);
        add(findBackPwd);
    }

    // 监视器响应函数:找回密码
    public void actionPerformed(ActionEvent e) {
        FindBackPwd win=new FindBackPwd();
        win.setBounds(600,300,350,400);
        win.setTitle("找回密码界面");
    }
}