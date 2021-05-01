package com.CM.resident;

import com.CM.db.DBman;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Account {
    String name;
    String username;
    public HashMap<String, Integer> amounts = new HashMap<>();
    Pays pays;

    Account(String name1, String username1) {
        name = name1;
        username = username1;

        GetBalance();
        GetPays();
    }

    // 获取余额
    public void GetBalance(){
        String sql = String.format("SELECT * FROM account WHERE username='%s'", username);
        ResultSet rs = DBman.execute(sql);

        try {
            if (rs != null) {
                while (rs.next()) {
                    amounts.put(rs.getString("type"), rs.getInt("amount"));
                }
            }
        }
        catch (SQLException e){
            System.out.println("获取余额失败");
        }
    }

    // 获取缴费记录
    public void GetPays() {
        String sql = String.format("SELECT * FROM payment WHERE username='%s'", username);
        ResultSet rs = DBman.execute(sql);
        pays = new Pays(rs);
    }

    // 用户缴费
    public void Pay(String type, int amount) {
        // 1.记录
        String sql = String.format("INSERT INTO payment VALUES('%s','%s',%d,'%s')",
                type, username, amount, (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date().getTime()));
        DBman.update(sql);

        // 2.更改余额
        sql = String.format("UPDATE account SET amount=%d WHERE type='%s' and username='%s'",
                Integer.parseInt(amounts.get(type).toString()) + amount, type, username
        );
        DBman.update(sql);

        // 3.更新本地余额
        GetBalance();
    }

    // 生成逐行显示支付记录的字符串
    public String LogString() {
        GetPays();
        StringBuilder bf = new StringBuilder();
        for (Payment p : pays.pays) {
            bf.append(String.format("%s\t%s\t%s\n",
                    p.type, p.amount, p.time.toString()));
        }
        if(bf.isEmpty())return "暂无缴费记录!";
        return bf.toString();
    }
}
