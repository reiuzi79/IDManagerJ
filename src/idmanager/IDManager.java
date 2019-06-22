/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idmanager;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author s7995
 */
public class IDManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            URL url = new URL("http://www.baidu.com");
            InputStream in = url.openStream();
            in.close();
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "当前无网络连接！无法使用", "注意", JOptionPane.WARNING_MESSAGE);
        }
        LoginFrame lf = new LoginFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }
}
