/*
 * Action.java
 * 
 * Interface defining constants for actions or commands used in the web application.
 */

package controller;

/**
 * Interface defining constants for actions or commands used in the web application.
 * Each constant represents a specific action that can be performed.
 */
public interface Action {
    /** Home action */
    public final String HOME = "home";
    
    /** Register action */
    public final String REGISTER = "register";
    
    /** Login action */
    public final String LOGIN = "login";
    
    /** Logout action */
    public final String LOGOUT = "logout";
    
    /** Add to cart action */
    public final String ADD_TO_CART = "cart";
    
    /** Account action */
    public final String ACCOUNT = "account";
    
    /** Product action */
    public final String PRODUCT = "product";
    
    /** Category action */
    public final String CATEGORY = "category";
    
    /** Contact action */
    public final String CONTACT = "contact";
    
    /** Add new action */
    public final String ADD_NEW = "add";
    
    /** Update action */
    public final String UPDATE = "update";
    
    /** Update account action */
    public final String UPDATE_ACC = "updateAcc";
    
    /** Delete action */
    public final String DELETE = "delete";
    
    /** Activate action */
    public final String ACTIVE = "active";
    
    /** Update category action */
    public final String UPDATE_CATEGORY = "updateCat";
    
    /** Delete category action */
    public final String DELETE_CATEGORY = "deleteCat";
    
    /** Add category action */
    public final String ADD_CATEGORY = "addCat";
    
    /** Add new category action */
    public final String ADD_NEW_CATEGORY = "addNewCat";
    
    /** Edit category action */
    public final String EDIT_CATEGORY = "editCategory";
    
    /** Show action */
    public final String SHOW = "show";
    
    /** Add product action */
    public final String ADD_PRODUCT = "newProduct";
    
    /** Delete product action */
    public final String DELETE_PRODUCT = "deletePro";
    
    /** Update product action */
    public final String UPDATE_PRODUCT = "updatePro";
    
    /** Add new product action */
    public final String ADD_NEW_PRODUCT = "addNewProduct";
    
    /** Edit product action */
    public final String EDIT_PRODUCT = "editProduct";
}
