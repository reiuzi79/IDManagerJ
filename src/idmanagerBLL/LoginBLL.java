/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;
import EntityAndMethod.Method;
import idmanagerDAL.LoginDAL;
/**
 *
 * @author s7995
 */
public class LoginBLL {
    
    public String validate(String account, String password, String IP) throws Exception{
        
        password = Method.encrypt(password);   //encrypt with md5
        LoginDAL dal = new LoginDAL();
        return dal.access(account, password, IP);
        
    }
    
}
