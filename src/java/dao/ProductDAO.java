/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Account;
import dto.Category;
import dto.Product;
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
public class ProductDAO implements Accessible<Product> {

    private Connection connection;
    private ServletContext sc;

    public ProductDAO() {
    }

    public ProductDAO(ServletContext sc) {
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
    public int insertRec(Product obj) {
        int rs = 0;
        try {
            getConnect();
            String sql = "insert into [dbo].[products]([productId],[productName],[productImage],[brief],[postedDate],[typeId],[account],[unit],[price],[discount]) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, obj.getProductId());
            pst.setString(2, obj.getProductName());
            pst.setString(3, obj.getProductImage());
            pst.setString(4, obj.getBrief());
            pst.setDate(5, obj.getPostedDate());
            pst.setInt(6, obj.getType().getTypeId());
            pst.setString(7, obj.getAccount().getAccount());
            pst.setString(8, obj.getUnit());
            pst.setInt(9, obj.getPrice());
            pst.setInt(10, obj.getDiscount());
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
    public int updatetRec(Product obj) {
       int rs = 0;
        try {
            getConnect();
            String sql = "update [dbo].[products] set [productName] = ?,[productImage] = ?,[brief] = ?,[postedDate] = ?,[typeId] = ?,[account] = ?,[unit] = ?,[price] = ?,[discount] = ? where [productId] = ?";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, obj.getProductName());
            pst.setString(2, obj.getProductImage());
            pst.setString(3, obj.getBrief());
            pst.setDate(4, obj.getPostedDate());
            pst.setInt(5, obj.getType().getTypeId());
            pst.setString(6, obj.getAccount().getAccount());
            pst.setString(7, obj.getUnit());
            pst.setInt(8, obj.getPrice());
            pst.setInt(9, obj.getDiscount());
            pst.setString(10, obj.getProductId());
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
    public int deleteRec(Product obj) {
        int rs = 0;
        try {
            getConnect();
            String sql = "delete from [dbo].[products] where [productId] = ?";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, obj.getProductId());
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
    public Product getObjectById(String id) {
        Product pro = null;
        try {
            getConnect();
            String sql = "SELECT [productId], [productName], [productImage],\n"
                    + "[brief], [postedDate], [typeId], [account], [unit],\n"
                    + "[price], [discount]\n"
                    + "FROM [dbo].[products] WHERE productId = ?";
            PreparedStatement pst = getConnect().prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs != null && rs.next()) {
                String productName = rs.getString("productName");
                String productImage = rs.getString("productImage");
                String brief = rs.getString("brief");
                Date postedDate = rs.getDate("postedDate");
                int typeId = rs.getInt("typeId");
                CategoryDAO cd = new CategoryDAO();
                Category c = cd.getObjectById(String.valueOf(typeId));
                String acc = rs.getString("account");
                AccountDAO ad = new AccountDAO();
                Account account = ad.getObjectById(acc);
                String unit = rs.getString("unit");
                int price = rs.getInt("price");
                int discount = rs.getInt("discount");
                pro = new Product(id, productName, productImage, brief, postedDate, c, account, unit, price, discount);

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
        return pro;
    }

    @Override
    public List<Product> listAll() {
        ArrayList<Product> list = new ArrayList<>();

        try {
            getConnect();
            String sql = "select [productId],[productName],[productImage],[brief],[postedDate],[typeId],[account],[unit],[price],[discount] from [dbo].[products]";
            Statement st = getConnect().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    String productImage = rs.getString("productImage");
                    String brief = rs.getString("brief");
                    Date postedDate = rs.getDate("postedDate");
                    int typeId = rs.getInt("typeId");
                    CategoryDAO cd = new CategoryDAO();
                    Category c = cd.getObjectById(String.valueOf(typeId));
                    String acc = rs.getString("account");
                    AccountDAO ad = new AccountDAO();
                    Account account = ad.getObjectById(acc);
                    String unit = rs.getString("unit");
                    int price = rs.getInt("price");
                    int discount = rs.getInt("discount");
                    Product pro = new Product(productId, productName, productImage, brief, postedDate, c, account, unit, price, discount);
                    list.add(pro);
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
