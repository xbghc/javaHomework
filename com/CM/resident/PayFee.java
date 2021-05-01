package com.CM.resident;

import javax.swing.*;

public class PayFee extends JFrame {
    JLabel type;
    JLabel money;

    JComboBox<String> comType;//声明下拉列表

    JButton confirm;
    JButton back;

    JTextField moneyNumber;

    PayFee(Account account, PanelFee f){
        setLayout(null);
        setBounds(300,200,250,250);

        type=new JLabel("选择缴费类型：");
        add(type);
        type.setBounds(10,10,150,20);

        comType=new JComboBox<String>();

        comType.addItem("电费");
        comType.addItem("水费");
        comType.addItem("燃气费");
        comType.addItem("物业费");

        add(comType);
        comType.setBounds(120,10,65,20);

        money=new JLabel("金额：");
        add(money);
        money.setBounds(10,40,80,20);

        moneyNumber =new JTextField();
        add(moneyNumber);
        moneyNumber.setBounds(120,40,80,20);

        confirm=new JButton("确认缴费");
        add(confirm);
        confirm.setBounds(50,100,100,20);
        confirm.addActionListener(e->{
            account.Pay(comType.getSelectedItem().toString(), Integer.parseInt(moneyNumber.getText()));
            f.Output_WF.setText(account.amounts.get("水费").toString());
            f.Output_EF.setText(account.amounts.get("电费").toString());
            f.Output_GF.setText(account.amounts.get("燃气费").toString());
            f.Output_PF.setText(account.amounts.get("物业费").toString());
            dispose();
        });

        back=new JButton("取消");
        add(back);
        back.setBounds(50,140,100,20);
        back.addActionListener(e->{

            dispose();
        });

        setVisible(true);
    }

}
