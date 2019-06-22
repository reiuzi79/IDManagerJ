/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityAndMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import javax.xml.crypto.dsig.TransformException;
/**
 *
 * @author s7995
 */
public class Method {

    public static String encrypt(String Password) throws Exception{  //MD5加密

        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(Password.getBytes("UTF8"));
        byte s[] = m.digest();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6);
        }
        return result;

    }
    
    public static Boolean IDCheck(String ID) throws Exception{  //身份证号校验
        
        char[] a = ID.toCharArray();
        int k = ((a[0] - '0') * 7 + (a[1] - '0') * 9 + (a[2] - '0') * 10 +  (a[3] - '0') * 5 + 
                (a[4] - '0') * 8 + (a[5] - '0') *4  + (a[6] - '0') * 2 + (a[7] - '0') * 1 + 
                (a[8] - '0') * 6 +(a[9] - '0') * 3 + (a[10] - '0') * 7 + (a[11] - '0') * 9 + 
                (a[12] - '0') * 10 + (a[13] - '0') * 5 + (a[14] - '0') * 8 + (a[15] - '0') * 4 +(a[16] - '0') * 2)%11;
        char k1;
        switch(k){
            case 0:k1 = '1';break;
            case 1:k1 = '0';break;
            case 2:k1 = 'X';break;
            case 3:k1 = '9';break;
            case 4:k1 = '8';break;
            case 5:k1 = '7';break;
            case 6:k1 = '6';break;
            case 7:k1 = '5';break;
            case 8:k1 = '4';break;
            case 9:k1 = '3';break;
            case 10:k1 = '2';break;
            default:throw new TransformException("身份证号校验出错");
        }
        return a[17] == k1;
        
    }
    
    public static IDInformation IDAnalyze(String ID) throws Exception{  //身份证号分析得出生日，地区，年龄，性别
        
        IDInformation info = new IDInformation();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://47.103.117.231:3306/idmanager?serverTimezone=GMT", "IDManager", "123456")) {
            Statement stmt = conn.createStatement();
            //获取地区
            ResultSet rs = stmt.executeQuery("select * from REGION where BM = '" + ID.substring(0,6) + "'");
            String region = "";
            while(rs.next()){
                region = rs.getString("DQ");
            }   if(region == null || region.equals("")){
                region = "未识别的地区";
            }   //计算年龄
            String date = ID.substring(6,10) + "-" + ID.substring(10,12) + "-" + ID.substring(12,14);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date bdate = simpleDateFormat.parse(date);
            java.util.Date now = simpleDateFormat.parse(simpleDateFormat.format(Calendar.getInstance().getTime()));  //获取出生日期与今天的相差天数
            long daysBetween = (now.getTime() - bdate.getTime()) / (3600*24*1000);
            String age = String.valueOf((int)(daysBetween/365.2425));
            //获取生日
            String birthday = ID.substring(6,10) + "年" + Integer.valueOf(ID.substring(10,12)).toString() + "月" + Integer.valueOf(ID.substring(12,14)).toString() + "日";
            //获取性别
            int num17 = Integer.parseInt(ID.substring(16,17));
            String gender = (num17%2) == 1 ? "男" : "女";
            info.setAge(age);
            info.setBirthday(birthday);
            info.setGender(gender);
            info.setRegion(region);
        }
        return info;
        
    }

    public static String getInternetIp() {  //本机公网IP
        URL url = null;
        URLConnection urlconn = null;
        BufferedReader br = null;
        try {
            url = new URL("http://" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + ".ip138.com/ic.asp");
            urlconn = url.openConnection();
            br = new BufferedReader(new InputStreamReader(
                    urlconn.getInputStream()));
            String buf = null;
            String get = null;
            while ((buf = br.readLine()) != null) {
                get += buf;
            }
            int where, end;
            for (where = 0; where < get.length() && get.charAt(where) != '['; where++);
            for (end = where; end < get.length() && get.charAt(end) != ']'; end++);
            get = get.substring(where + 1, end);
            return get;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
        
}
