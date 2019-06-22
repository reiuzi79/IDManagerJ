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
public class LoginDAL {
    
    public String access(String account, String password, String IP) throws Exception{   //访问数据库验证用户名和密码，返回昵称
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where Account = '" + account + "' and Password = '" + password + "'");
            if(rs.next()){
                String online = rs.getString("IPAddress");
                if(!online.equals("0")){
                    stmt.executeUpdate("update user set IPAddress = '0' where Account = '" + account + "'");
                    throw new Exception("当前用户在线！由" + online + "登录");
                }
                String name = rs.getString("Name");
                stmt.executeUpdate("update user set IPAddress = '" + IP + "' where Account = '" + account + "'");
                return name;
            }else{
                throw new Exception("用户名或密码错误！");
            }
        }
        
    }
    
}
