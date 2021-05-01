package com.CM.login;

import com.CM.db.DBman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindBackPwd extends JFrame implements ActionListener {


    // 文本信息 显示
    JLabel l_username, l_password, l_confirm, l_ID;
    JLabel l_title;
    JLabel image;

    // 文本框变量
    JTextField username, ID;
    JPasswordField edit_password1, edit_password2;
    // 按钮变量
    JButton ok, cancel;

    // 构造函数
    FindBackPwd() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    // 窗体实现
    void init() {

        l_username = new JLabel("账号:");
        l_password = new JLabel("密码:");
        l_confirm = new JLabel("再次输入密码:");
        l_ID = new JLabel("身份证号:");
        l_title = new JLabel("找回密码");

        // 图片设置
        l_title.setIcon(new ImageIcon("com/CM/login/img/2.png"));
        l_title.setHorizontalTextPosition(SwingConstants.RIGHT);
        l_title.setVerticalTextPosition(SwingConstants.CENTER);

        image = new JLabel();
        // JTextField
        username = new JTextField();
        edit_password1 = new JPasswordField();
        edit_password2 = new JPasswordField();
        edit_password1.setEchoChar('*');
        edit_password2.setEchoChar('*');
        ID = new JTextField();

        // 按钮
        ok = new JButton("确认");
        cancel = new JButton("取消");

        // 空布局
        setLayout(null);
        // JLabel
        l_username.setBounds(50, 90, 80, 20);
        l_ID.setBounds(50, 120, 80, 20);
        l_password.setBounds(50, 150, 80, 20);
        l_confirm.setBounds(50, 180, 80, 20);
        l_title.setBounds(50, 40, 200, 50);

        image.setIcon(new ImageIcon("com/CM/login/img/1.png"));
        image.setBounds(50, 260, 200, 50);
        // JTextField
        username.setBounds(130, 90, 110, 20);
        ID.setBounds(130, 120, 180, 20);
        edit_password1.setBounds(130, 150, 110, 20);
        edit_password2.setBounds(130, 180, 110, 20);
        // JButton
        ok.setBounds(70, 220, 60, 30);
        cancel.setBounds(150, 220, 60, 30);

        // 改变title字体参数
        l_title.setFont(new Font("楷体", Font.BOLD, 25));

        // 确认按钮 创建监视器
        ok.addActionListener(this);

        // 取消按钮 响应事件
        cancel.addActionListener(e -> dispose());

        // 窗体添加控件
        add(l_username);
        add(l_password);
        add(l_confirm);
        add(l_ID);

        add(l_title);
        add(image);

        add(username);
        add(edit_password1);
        add(edit_password2);
        add(ID);

        add(ok);
        add(cancel);
    }

    // "确认"按钮的响应事件
    public void actionPerformed(ActionEvent e) {
        String password1 = String.valueOf(edit_password1.getPassword());
        String password2 = String.valueOf(edit_password2.getPassword());

        // 密码不一致：提示并返回
        if (!password1.equals(password2)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一致！", "错误", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 如果信息正确，则修改成功
        // 反之修改失败
        if (DBman.ResetPwd(username.getText(), ID.getText(), password1)) {
            JOptionPane.showMessageDialog(null,
                    "修改成功",
                    "成功",
                    JOptionPane.WARNING_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "身份证或用户名错误,修改失败!",
                    "失败",
                    JOptionPane.WARNING_MESSAGE);
        }

    }
}