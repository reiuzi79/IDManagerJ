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
public class RegistDAL {
    
    public void access(String account, String password, String name) throws Exception{    //注册，访问数据库，先查找是否存在用户，不存在就插入
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where Account = '" + account + "'");
            if(rs.next()) {
                throw new Exception("用户名已存在");
            }   stmt.execute("insert into user values('" + account + "','" + password + "','" + name +"','0')");
        }
        
    }
    
}
