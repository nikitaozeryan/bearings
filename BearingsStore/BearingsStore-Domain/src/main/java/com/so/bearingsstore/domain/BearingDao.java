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
public interface BearingDao extends Dao{
    List<Bearing> getList();
    void remove(int id);
}
