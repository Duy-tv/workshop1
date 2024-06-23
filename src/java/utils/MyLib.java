/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;

/**
 *
 * @author user
 */
public class MyLib {

    private String IP;
    private String instanceName;
    private String port;
    private String db;
    private String uid;
    private String pwd;

    public MyLib() {
        this.IP = "localhost";
        this.instanceName = "DESKTOP-1EAPPVM\\SQLEXPRESS";
        this.port = "1433";
        this.uid = "sa";
        this.pwd = "12345";
        this.db = "ProductIntro";
    }

    public MyLib(ServletContext sc) {
        this.IP = sc.getInitParameter("hostName");
        this.instanceName = sc.getInitParameter("instance");
        this.port = sc.getInitParameter("port");
        this.db = sc.getInitParameter("dbName");
        this.uid = sc.getInitParameter("userName");
        this.pwd = sc.getInitParameter("passWord");
    }
    
    private String urlString() {
        return String.format( "jdbc:sqlserver://" + this.IP + "\\" + this.instanceName + ":" + this.port
            + ";databasename=" + this.db + ";user=" + this.uid + ";password=" + this.pwd);
        
    }

    public Connection makeConnection() throws Exception {
        Connection cn = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        cn = DriverManager.getConnection(urlString());
        return cn;
    }

}
