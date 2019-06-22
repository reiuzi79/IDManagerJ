/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityAndMethod;

/**
 *
 * @author s7995
 */
public class IDInformation {  //存放身份证号可分析出的信息

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
    
    private String Birthday = "";
    private String Age = "";
    private String Gender = "";
    private String Region = "";
    
}
