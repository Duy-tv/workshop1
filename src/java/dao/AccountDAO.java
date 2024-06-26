/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import utils.MyLib;

/**
 *
 * @author Duy.Tran
 */
public class AccountDAO implements Accessible<Account> {

    private Connection connection;
    private ServletContext sc;

    public AccountDAO() {
    }

    public AccountDAO(ServletContext sc) {
        this.sc = sc;
    }

    private Connection getConnect() throws ClassNotFoundException, SQLException, Exception {
        if (sc == null) {
            MyLib myLib = new MyLib();
            connection = myLib.makeConnection();
        } else {
            MyLib myLib = new MyLib(sc);
            connection = myLib.makeConnection();
        }
        return connection;
    }

    @Override
    public int insertRec(Account obj) {
        int rs = 0;
        try {
            getConnect();
            String sql = "insert into dbo.Accounts(account,pass,lastName,firstName,birthday,gender,phone,isUse,roleInSystem) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, obj.getAccount());
            pst.setString(2, obj.getPass());
            pst.setNString(3, obj.getLastName());
            pst.setNString(4, obj.getFirstName());
            pst.setDate(5, obj.getBirthday());
            pst.setBoolean(6, obj.isGender());
            pst.setString(7, obj.getPhone());
            pst.setBoolean(8, obj.isIsUse());
            pst.setInt(9, obj.getRoleInSystem());
            rs = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    @Override
    public int updatetRec(Account obj) {
        int rs = 0;
        PreparedStatement pst = null;
        try {
            getConnect();
            String sql = "update [dbo].[accounts] set [account] = ?, [pass] = ?, [lastName] = ?, [firstName] = ?, [birthday] = ?, [gender] = ?, [phone] = ?, [isUse] = ?, [roleInSystem] = ? where [account] = ?";
            pst = getConnect().prepareStatement(sql);
            pst.setString(1, obj.getAccount());
            pst.setString(2, obj.getPass());
            pst.setNString(3, obj.getLastName());
            pst.setNString(4, obj.getFirstName());
            pst.setDate(5, obj.getBirthday());
            pst.setBoolean(6, obj.isGender());
            pst.setString(7, obj.getPhone());
            pst.setBoolean(8, obj.isIsUse());
            pst.setInt(9, obj.getRoleInSystem());
            pst.setString(10, obj.getAccount());
            rs = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public int updateStatus(String account, boolean isUse) {
        int rs = 0;
        PreparedStatement pst = null;
        try {
            getConnect();
            String sql = "update [dbo].[accounts] set [isUse] = ? where [account] = ?";
            pst = getConnect().prepareStatement(sql);
            pst.setBoolean(1, isUse);
            pst.setString(2, account);
            rs = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rs;

    }

    @Override
    public int deleteRec(Account obj) {
        int rs = 0;
        try {
            getConnect();
            String sql = "delete from [dbo].[accounts] where [account] = ?";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, obj.getAccount());
            rs = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return rs;
    }

    @Override
    public Account getObjectById(String id) {
        Account acc = null;
        try {
            getConnect();
            String sql = "SELECT [account], [pass], [lastName], [firstName],\n"
                    + "[birthday], [gender], [phone], [isUse], [roleInSystem]\n"
                    + "FROM [dbo].[accounts]\n"
                    + "WHERE [account] = ?";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String pass = rs.getString("pass");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                Date birthday = rs.getDate("birthday");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                boolean isUse = rs.getBoolean("isUse");
                int roleInSystem = rs.getInt("roleInSystem");
                acc = new Account(id, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return acc;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();
        try {
            getConnect();
            String sql = "select account, pass, lastName, firstName, \n"
                    + "birthday, gender, phone, isUse, roleInSystem \n"
                    + "from accounts";
            Statement st = getConnect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String account = rs.getString("account");
                    String pass = rs.getString("pass");
                    String lastName = rs.getString("lastName");
                    String firstName = rs.getString("firstName");
                    Date birthday = rs.getDate("birthday");
                    boolean gender = rs.getBoolean("gender");
                    String phone = rs.getString("phone");
                    boolean isUse = rs.getBoolean("isUse");
                    int roleInSystem = rs.getInt("roleInSystem");
                    Account acc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
                    list.add(acc);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public Account getUserLogin(String account, String password) {
        Account acc = null;
        try {
            getConnect();
            String sql = "select [account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem] from [dbo].[accounts] where account = ? and pass = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, account);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                Date birthday = rs.getDate("birthday");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                boolean isUse = rs.getBoolean("isUse");
                int roleInSystem = rs.getInt("roleInSystem");
                acc = new Account(account, password, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return acc;
    }

    public Account checkAcc(String account) {
        Account acc = null;
        try {
            getConnect();
            String sql = "select [account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem] from [dbo].[accounts] where account = ?";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, account);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String password = rs.getString("pass");
                String lastName = rs.getString("lastName");
                String firstName = rs.getString("firstName");
                Date birthday = rs.getDate("birthday");
                boolean gender = rs.getBoolean("gender");
                String phone = rs.getString("phone");
                boolean isUse = rs.getBoolean("isUse");
                int roleInSystem = rs.getInt("roleInSystem");
                acc = new Account(account, password, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                getConnect().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return acc;
    }
}
