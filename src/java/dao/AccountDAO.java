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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyLib;

/**
 *
 * @author Duy.Tran
 */
public class AccountDAO implements Accessible<Account> {

    @Override
    public int insertRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updatetRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteRec(Account obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "select account, pass, lastName, firstName, \n"
                        + "birthday, gender, phone, isUse, roleInSystem \n"
                        + "from accounts";
                Statement st = cn.createStatement();
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public Account getUserLogin(String account, String password) {
        Account acc = null;
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "select [account],[pass],[lastName],[firstName],[birthday],[gender],[phone],[isUse],[roleInSystem] from [dbo].[accounts] where account = ? and pass = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
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
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return acc;
    }
}
