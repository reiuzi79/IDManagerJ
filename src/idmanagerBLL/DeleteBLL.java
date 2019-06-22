/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import idmanagerDAL.DeleteDAL;

/**
 *
 * @author s7995
 */
public class DeleteBLL {
    
    DeleteDAL dal = new DeleteDAL();
    
    public int delete(String allID, String author) throws Exception{
        
        if(allID == null){
            return dal.access(null, author);
        }
        if(allID.contains(",") || allID.contains("，")){
            allID = allID.toUpperCase();
            allID = allID.replace("，", ",");
            String[] ID = allID.split(",");
            return dal.access(ID, author);
        }
        return dal.access(new String[] {allID.toUpperCase()}, author);
        
    }
    
    public Boolean detect(String account, String IP) throws Exception {

        return dal.detect(account, IP);

    }
    
}
