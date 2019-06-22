/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityAndMethod;
import java.io.Serializable;
/**
 *
 * @author s7995
 */
public class Data implements Serializable{  
    public Data(){}
    public Data(String n, String p, String a, String i, String r, String b, String age, String g, String rm){
        this.Name = n;
        this.Phone = p;
        this.Address = a;
        this.ID = i;
        this.Region = r;
        this.Birthday = b;
        this.Age = age;
        this.Gender = g;
        this.Remark = rm;
    }
    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the Region
     */
    public String getRegion() {
        return Region;
    }

    /**
     * @param Region the Region to set
     */
    public void setRegion(String Region) {
        this.Region = Region;
    }

    /**
     * @return the Birthday
     */
    public String getBirthday() {
        return Birthday;
    }

    /**
     * @param Birthday the Birthday to set
     */
    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * @return the Age
     */
    public String getAge() {
        return Age;
    }

    /**
     * @param Age the Age to set
     */
    public void setAge(String Age) {
        this.Age = Age;
    }

    /**
     * @return the Gender
     */
    public String getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Remark
     */
    public String getRemark() {
        return Remark;
    }

    /**
     * @param Remark the Remark to set
     */
    public void setRemark(String Remark) {
        this.Remark = Remark;
    }
//数据类
    private String Name = "";
    private String Phone = "";
    private String Address = "";
    private String ID = "";
    private String Region = "";
    private String Birthday = "";
    private String Age = "";
    private String Gender = "";
    private String Remark = "";
            
}
