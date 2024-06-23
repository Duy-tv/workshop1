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
 * Utility class to manage database connections using JDBC. Supports
 * initialization from hardcoded values or ServletContext parameters
 *
 * @author Duy.Tran
 */
public class MyLib {

    private String IP;
    private String instanceName;
    private String port;
    private String db;
    private String uid;
    private String pwd;

    /**
     * Default constructor initializes connection parameters with hardcoded
     * values.
     */
    public MyLib() {
        this.IP = "localhost";
        this.instanceName = "DESKTOP-1EAPPVM\\SQLEXPRESS";
        this.port = "1433";
        this.uid = "sa";
        this.pwd = "12345";
        this.db = "ProductIntro";
    }

    /**
     * Constructor initializes connection parameters from ServletContext
     * parameters.
     *
     * @param sc ServletContext containing database connection parameters.
     */
    public MyLib(ServletContext sc) {
        this.IP = sc.getInitParameter("hostName");
        this.instanceName = sc.getInitParameter("instance");
        this.port = sc.getInitParameter("port");
        this.db = sc.getInitParameter("dbName");
        this.uid = sc.getInitParameter("userName");
        this.pwd = sc.getInitParameter("passWord");
    }

    /**
     * Constructs JDBC connection URL based on stored connection parameters.
     *
     * @return JDBC connection URL as a formatted String.
     */
    private String urlString() {
        return String.format("jdbc:sqlserver://" + this.IP + "\\" + this.instanceName + ":" + this.port
                + ";databasename=" + this.db + ";user=" + this.uid + ";password=" + this.pwd);

    }

    /**
     * Establishes a database connection using JDBC.
     *
     * @return Connection object representing the established database
     * connection.
     * @throws Exception if connection cannot be established.
     */
    public Connection makeConnection() throws Exception {
        Connection cn = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        cn = DriverManager.getConnection(urlString());
        return cn;
    }

}
