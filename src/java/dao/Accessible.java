/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import static javafx.scene.input.KeyCode.V;

/**
 *
 * @author Duy.Tran
 */
public interface Accessible<T> {
    int insertRec(T obj);
    int updatetRec(T obj);
    int deleteRec(T obj);
    T getObjectById(String id);
    List<T> listAll();
    
}
