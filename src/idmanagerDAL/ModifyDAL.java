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
public class ModifyDAL {
    
    public void access(String account, String pwd, String newpwd) throws Exception{   //访问数据库查找用户和密码，如果查找到就修改
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where Account = '" + account + "' and Password = '" + pwd + "'");
            if(!rs.next()){
                throw new Exception("用户名或密码错误！");
            }   if(!(rs.getString("IPAddress")).equals("0")){
                throw new Exception("当前用户在线！无法修改");
            }   stmt.executeUpdate("update user set Password = '" + newpwd + "' where Account = '" + account + "'");
        }
        
    }
    
}
