/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import EntityAndMethod.Method;
import idmanagerDAL.ModifyDAL;

/**
 *
 * @author s7995
 */
public class ModifyBLL {
    
    public void modify(String account, String pwd, String newpwd) throws Exception{
        
        pwd = Method.encrypt(pwd);
        newpwd = Method.encrypt(newpwd);   //encrypt with md5
        ModifyDAL dal = new ModifyDAL();
        dal.access(account, pwd, newpwd);
        
    }
    
}
