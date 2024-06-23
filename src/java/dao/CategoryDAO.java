/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Category;
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
public class CategoryDAO implements Accessible<Category> {
    
 private Connection connection;
    private ServletContext sc;

    public CategoryDAO() {
    }

    public CategoryDAO(ServletContext sc) {
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
    public int insertRec(Category obj) {
        int rs = 0;
        try {
            getConnect();
                String sql = "insert into [dbo].[categories]([categoryName],[memo]) values(?,?)";
                PreparedStatement pst = getConnect().prepareStatement(sql);
                pst.setString(1, obj.getCategoryName());
                pst.setString(2, obj.getMemo());
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
    public int updatetRec(Category obj) {
        int rs = 0;
        try {
            getConnect();
                String sql = "update [dbo].[categories] set [categoryName] = ?, [memo] = ? where [typeId] = ?";
                PreparedStatement pst = getConnect().prepareStatement(sql);
                pst.setString(1, obj.getCategoryName());
                pst.setString(2, obj.getMemo());
                pst.setInt(3, obj.getTypeId());
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
    public int deleteRec(Category obj) {
        int rs = 0;
        try {
            getConnect();
                String sql = "delete from [dbo].[categories] where [typeId] = ?";
                PreparedStatement pst = getConnect().prepareStatement(sql);
                pst.setInt(1, obj.getTypeId());
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
    public Category getObjectById(String id) {
        int typeId = Integer.parseInt(id);
        Category c = null;
        try {
            getConnect();
                String sql = "SELECT [typeId], [categoryName], [memo]\n"
                        + "FROM [dbo].[categories] WHERE [typeId] = ?";
                PreparedStatement pst = getConnect().prepareStatement(sql);
                pst.setInt(1, typeId);
                ResultSet rs = pst.executeQuery();
                if (rs != null & rs.next()) {
                    String name = rs.getString("categoryName");
                    String memo = rs.getString("memo");
                    c = new Category(typeId, name, memo);
                
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
        return c;
    }

    @Override
    public List<Category> listAll() {
        ArrayList<Category> list = new ArrayList<>();

        try {
            getConnect();
                String sql = "select [typeId],[categoryName],[memo] from categories";
                Statement st = getConnect().createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs != null) {
                    while (rs.next()) {
                        int typeId = rs.getInt("typeId");
                        String categoryName = rs.getString("categoryName");
                        String memo = rs.getString("memo");
                        Category cat = new Category(typeId, categoryName, memo);
                        list.add(cat);
                    
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

}
