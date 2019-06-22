/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import idmanagerDAL.SelectDAL;

/**
 *
 * @author s7995
 */
public class SelectBLL {
    
    SelectDAL dal = new SelectDAL();
    
    public Object[][] select(String type, String value, String author, String account) throws Exception{
        
        return dal.access(type, value, author, account);
        
    }
    
    public Object[][] selectByAuthor(String author) throws Exception{
        
        return dal.access(null, null, author, "admin");
        
    }
    
    public Boolean detect(String account, String IP) throws Exception {

        return dal.detect(account, IP);

    }
    
}
