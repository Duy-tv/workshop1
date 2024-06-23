/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 * Represents a Category entity with properties corresponding to database columns.
 * Used as a data transfer object (DTO) between database and application layers.
 * 
 * @author Duy.Tran
 */
public class Category {
    private int typeId;
    private String categoryName;
    private String memo;

    public Category() {
    }

    public Category(int typeId, String categoryName, String memo) {
        this.typeId = typeId;
        this.categoryName = categoryName;
        this.memo = memo;
    }
    
    public Category(String categoryName, String memo) {
        this.categoryName = categoryName;
        this.memo = memo;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
    
     @Override
   public String toString() {
       return String.format("%s", String.valueOf(typeId));
   }
}
