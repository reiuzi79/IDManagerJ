/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import idmanagerDAL.AddDAL;
import EntityAndMethod.*;

/**
 *
 * @author s7995
 */
public class AddBLL {
    
    AddDAL dal = new AddDAL(); 
    
    public void add(String name, String ID, String phone, String address, String remark, String author) throws Exception{
        
        ID = ID.toUpperCase();
        if(!Method.IDCheck(ID)){
            throw new Exception("身份证号校验不正确");
        }
        IDInformation infor = Method.IDAnalyze(ID);
        Data data = new Data(name, phone, address, ID, infor.getRegion(), infor.getBirthday(), infor.getAge(), infor.getGender(), remark);
        dal.access(data, author);
        
    }
    
    public Boolean detect(String account, String IP) throws Exception {

        return dal.detect(account, IP);

    }
    
}
