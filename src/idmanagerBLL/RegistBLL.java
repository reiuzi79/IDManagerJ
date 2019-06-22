/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import EntityAndMethod.Method;
import idmanagerDAL.RegistDAL;

/**
 *
 * @author s7995
 */
public class RegistBLL {
    
    public void regist(String account, String password, String name) throws Exception{
        
        password = Method.encrypt(password);
        RegistDAL dal = new RegistDAL();
        dal.access(account, password, name);
        
    }
    
}
