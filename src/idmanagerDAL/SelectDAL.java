/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author s7995
 */
public class SelectDAL {
    
    public Object[][] access(String type, String value, String author, String account) throws Exception{   //查找，根据之前选择的单选项拼接不同的sql语句

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Object[][] list = null;
            Statement stmt = conn.createStatement();
            String command;
            if(type == null){
                command = "select * from data where Author = '" + author + "'";
            } else {
                switch (type) {
                    case "Age":
                        if (value.contains("-")) {
                            String[] age = value.split("-");
                            command = "select * from data where cast(Age as unsigned int)>= " + age[0] + " and cast(Age as unsigned int)<=" + age[1];
                        } else {
                            command = "select * from data where Age = '" + value + "'";
                        }
                        break;
                    default:
                        command = "select * from data where " + type + " like '" + value + "%'";
                        break;
                }
                if (!author.equals("")) {
                    command += String.format(" and Author = '" + author + "'");
                }
            }
            ResultSet rs = stmt.executeQuery(command);
            if (rs.next()) {
                rs.last();
                list = new Object[rs.getRow()][];
                rs.first();
                int i = 0;
                if (account.equals("admin")) {
                    do {
                        Object[] o = new Object[]{rs.getString("Name"), rs.getString("Phone"), rs.getString("Address"), rs.getString("ID"),
                            rs.getString("Region"), rs.getString("Birthday"), rs.getString("Age"), rs.getString("Gender"), rs.getString("Remark"), rs.getString("Author")};
                        list[i++] = o;
                    } while (rs.next());
                } else {
                    do {
                        Object[] o = new Object[]{rs.getString("Name"), rs.getString("Phone"), rs.getString("Address"), rs.getString("ID"),
                            rs.getString("Region"), rs.getString("Birthday"), rs.getString("Age"), rs.getString("Gender"), rs.getString("Remark")};
                        list[i++] = o;
                    } while (rs.next());
                }
            }
            return list;
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
