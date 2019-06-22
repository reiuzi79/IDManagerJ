/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanagerBLL;

import EntityAndMethod.Data;
import EntityAndMethod.IDInformation;
import EntityAndMethod.Method;
import idmanagerDAL.UpdateDAL;

/**
 *
 * @author s7995
 */
public class UpdateBLL {
    
    UpdateDAL dal = new UpdateDAL();
    
    public void add(String name, String oldID, String newID, String phone, String address, String remark, String author) throws Exception {
        
        newID = newID.toUpperCase();
        if (!Method.IDCheck(newID)) {
            throw new Exception("身份证号校验不正确");
        }
        IDInformation infor = Method.IDAnalyze(newID);
        Data data = new Data(name, phone, address, newID, infor.getRegion(), infor.getBirthday(), infor.getAge(), infor.getGender(), remark);
        dal.access(oldID, author, data);

    }
    
    public Boolean detect(String account, String IP) throws Exception {

        return dal.detect(account, IP);

    }
        
}
