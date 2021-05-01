package com.CM.resident;

import com.CM.db.DBman;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Individual {
    public String username;        // 用户名
    public String ID;              // 身份证
    public String name;            // 姓名
    public String workAddr;        // 工作地址
    public String companyTel;      // 公司电话
    public String personalPhone;   // 个人电话
    public String QQ;              // QQ
    public String email;           // 邮箱
    public String community;       // 小区名
    public String buildingNo;      // 楼栋号
    public String unitNo;          // 单元号
    public String doorNo;          // 门牌号

    Account account;        // 账户

    public Individual() {

    }

    public void init(String username) {

        //
        String sql = String.format("SELECT * FROM user,people WHERE user.username=people.username and user.username='%s'", username);
        ResultSet rs = DBman.execute(sql);
        try {
            if (rs != null) {
                rs.next();
            } else {
                return;
            }
            this.ID = rs.getString("ID");
            this.name = rs.getString("name");
            this.username = username;
            this.QQ = rs.getString("QQ");
            this.buildingNo = rs.getString("buildingNo");
            this.community = rs.getString("community");
            this.companyTel = rs.getString("companyTel");
            this.doorNo = rs.getString("doorNo");
            this.email = rs.getString("email");
            this.personalPhone = rs.getString("personalPhone");
            this.unitNo = rs.getString("unitNo");
            this.workAddr = rs.getString("workAddr");

            // 初始化账户
            account = new Account(name, username);
        } catch (SQLException e) {
            System.out.println("异常");
        } catch (NullPointerException e) {
            System.out.println("未查找到");
        }
    }


    public void update(String newWorkAddr, String newCompanyTel,
                       String newPersonalPhone, String newQQ,
                       String newEmail, String newCommunity,
                       String newBuildingNo, String newUnitNo, String newDoorNo) {
        String sql = String.format("UPDATE people " +
                        "SET workAddr='%s',companyTel='%s',personalPhone='%s',QQ='%s',email='%s'," +
                        "community='%s',buildingNo='%s',unitNo='%s',doorNo='%s' " +
                        "WHERE username='%s'",
                newWorkAddr, newCompanyTel, newPersonalPhone, newQQ, newEmail,
                newCommunity, newBuildingNo, newUnitNo, newDoorNo, username);
        DBman.update(sql);
        init(username);
    }
}
