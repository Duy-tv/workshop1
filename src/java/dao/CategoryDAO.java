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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyLib;

/**
 *
 * @author Duy.Tran
 */
public class CategoryDAO implements Accessible<Category>{

    @Override
    public int insertRec(Category obj) {
        int rs = 0;
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "insert into [dbo].[categories]([categoryName],[memo]) values(?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, obj.getCategoryName());
                pst.setString(2, obj.getMemo());
                rs = pst.executeUpdate();
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
        return rs;
    }

    @Override
    public int updatetRec(Category obj) {
       int rs = 0;
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "update [dbo].[categories] set [categoryName] = ?, [memo] = ? where [typeId] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, obj.getCategoryName());
                pst.setString(2, obj.getMemo());
                pst.setInt(3, obj.getTypeId());
                rs = pst.executeUpdate();
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
        return rs;
    }

    @Override
    public int deleteRec(Category obj) {
      int rs = 0;
        Connection cn = null;
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "delete from [dbo].[categories] where [typeId] = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, obj.getTypeId());
                rs = pst.executeUpdate();
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
        return rs;
    }

    @Override
    public Category getObjectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Category> listAll() {
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = null;
        
        try {
            cn = MyLib.makeConnection();
            if (cn != null) {
                String sql = "select [typeId],[categoryName],[memo] from categories";
                Statement st = cn.createStatement();
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

   
    
}
