/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerDAL;

import java.sql.*;

/**
 *
 * @author s7995
 */
public class DeleteDAL {
    
    public int access(String[] ID, String author) throws Exception {  //删除

        Class.forName("com.mysql.cj.jdbc.Driver");
        int count = 0;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            if (ID == null && author.equals("")) {
                return stmt.executeUpdate("delete from data");   //删除全部
            }
            if (author.equals("")) {
                for (String id : ID) {
                    count += stmt.executeUpdate("delete from data where ID = '" + id + "'");  //删除所有匹配ID的记录
                }
                return count;
            }
            if (ID == null) {
                return stmt.executeUpdate("delete from data where Author = '" + author + "'"); //删除该添加者添加的所有记录
            }
            for (String id : ID) {
                count += stmt.executeUpdate("delete from data where ID = '" + id + "' and Author = '" + author + "'");  //删除该添加者添加的匹配ID记录
            }
            return count;
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
