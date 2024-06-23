/*
 * Navigation.java
 * 
 * Interface defining constants for URL paths used in the web application.
 */

package controller;

/**
 * Interface defining constants for URL paths used in the web application.
 * Each constant represents a specific JSP page or resource URL.
 */
public interface Navigation {
    /** Home page URL */
    public final String HOME_URL = "index.jsp";
    
    /** Account page URL */
    public final String ACCOUNT_URL = "account.jsp";
    
    /** Product page URL */
    public final String PRODUCT_URL = "product.jsp";
    
    /** Category page URL */
    public final String CATEGORY_URL = "category.jsp";
    
    /** Contact page URL */
    public final String CONTACT_URL = "contact.jsp";
    
    /** Login page URL */
    public final String LOGIN_URL = "login.jsp";
    
    /** Register page URL */
    public final String REGISTER_URL = "register.jsp";
    
    /** Update Account page URL */
    public final String UPDATE_ACCOUNT_URL = "updateAcc.jsp";
    
    /** Error 404 page URL */
    public final String ERROR_URL = "error404.html";
    
    /** Add Category page URL */
    public final String ADD_CATEGORY_URL = "addCategory.jsp";
    
    /** Update Category page URL */
    public final String UPDATE_CATEGORY_URL = "updateCategory.jsp";
    
    /** Show Info page URL */
    public final String SHOW_INFO_URL = "showInfo.jsp";
    
    /** Add Product page URL */
    public final String ADD_PRODUCT_URL = "addProduct.jsp";
    
    /** Update Product page URL */
    public final String UPDATE_PRODUCT_URL = "updateProduct.jsp";
}
