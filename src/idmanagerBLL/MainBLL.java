/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import EntityAndMethod.Data;
import idmanagerDAL.MainDAL;
import java.util.LinkedList;

/**
 *
 * @author s7995
 */
public class MainBLL {
    
    String account = "";
    MainDAL dal = null;
    
    public MainBLL(){}
    
    public MainBLL(String account){
        this.account = account;
        dal = new MainDAL();
    }
    
    public Boolean detect(String IP) throws Exception{
        
        return dal.detect(account, IP);
        
    }
    
    public void exit() throws Exception{
        
        dal.exit(account);
        
    }
    
    public Object[][] refresh(String account) throws Exception{
        
        return dal.access(account);
        
    }
    
    public Data preUpdate(String ID ,String author) throws Exception{
        
        return dal.access(ID, author);
        
    }
}
