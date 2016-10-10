/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearingsstore.domain;



/**
 *
 * @author Никита
 */
public interface Dao{
    Object getById(int id);
    int save(Object o);
    void update(Object o);
    void delete(Object o);
}
