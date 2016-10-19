/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.bearingsstore.domain;

import java.util.List;

/**
 *
 * @author Никита
 */
public interface UsersDao extends Dao{
    List<Users> getList();
    public int deleteUser(int id);
    public Users getbyLogin(String login);
    
}
