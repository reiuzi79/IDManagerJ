/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerDAL;

import EntityAndMethod.Data;
import EntityAndMethod.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author s7995
 */
public class MainDAL {
    
    public Boolean detect(String account, String IP) throws Exception{   //检查在线状态，参数为用户名
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select IPAddress from user where Account = '" + account + "'");
            if(rs.next()){
                if(rs.getString("IPAddress").equals(IP)){
                    return true;
                }
            }return false;
        }
        
    }
    
    public void exit(String account) throws Exception{   //关闭窗体，参数为用户名
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            stmt.execute("update user set IPAddress = '0' where Account = '" + account + "'");
        }
        
    }
    
    public Object[][] access(String account) throws Exception{  //显示所有数据，返回数据集
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Object[][] list = null;
            Statement stmt = conn.createStatement();
            ResultSet rs;
            if(account.equals("admin"))
                rs = stmt.executeQuery("select * from data");
            else
                rs = stmt.executeQuery("select * from data where Author = '" + account + "'");
            if(rs.next()){
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
                }else{
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
    
    public Data access(String ID, String author) throws Exception { //查找

        Class.forName("com.mysql.cj.jdbc.Driver");
        Data data;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from data where ID = '" + ID + "' and Author = '" + author + "'");
            if (rs.next()) {
                data = new Data(rs.getString("Name"), rs.getString("Phone"), rs.getString("Address"), rs.getString("ID"),
                        rs.getString("Region"), rs.getString("Birthday"), rs.getString("Age"), rs.getString("Gender"), rs.getString("Remark"));
                return data;
            } else {
                throw new Exception("无匹配记录");
            }
        }

    }
    
}
