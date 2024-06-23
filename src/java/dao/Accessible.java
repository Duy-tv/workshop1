/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 * Interface defining CRUD operations for data access.
 *
 * @param <T> Type parameter representing the entity type.
 */
public interface Accessible<T> {
    int insertRec(T obj);
    int updatetRec(T obj);
    int deleteRec(T obj);
    T getObjectById(String id);
    List<T> listAll();
    
}
