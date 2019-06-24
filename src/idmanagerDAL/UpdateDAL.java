/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerDAL;

import EntityAndMethod.Data;
import java.sql.*;

/**
 *
 * @author s7995
 */
public class UpdateDAL {
    
    public void access(String ID, String author, Data d) throws Exception{  //修改
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from data where ID = '" + d.getID() + "' and Author = '" + author + "' and ID != '" + ID + "'");
            if(rs.next()) throw new Exception("要更改的身份证号已存在！");
            stmt.executeUpdate("update data set Name = '" + d.getName() + 
                    "', Phone = '" + d.getPhone() +
                    "', Address = '" + d.getAddress() +
                    "', ID = '" + d.getID() +
                    "', Region = '" + d.getRegion() +
                    "', Birthday = '" + d.getBirthday() +
                    "', Age = '" + d.getAge() + 
                    "', Gender = '" + d.getGender() + 
                    "', Remark = '" + d.getRemark() +
                    "' where ID = '" + ID + "' and Author = '" + author + "'");
        }
        
    }
    
    public Boolean detect(String account, String IP) throws Exception {   //检查在线状态，参数为用户名

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select IPAddress from user where Account = '" + account + "'");
            if (rs.next()) {
                if (rs.getString("IPAddress").equals(IP)) {
                    return true;
                }
            }
            return false;
        }

    }
    
}
