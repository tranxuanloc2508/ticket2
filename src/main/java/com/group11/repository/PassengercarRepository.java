/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository;

import com.group11.pojos.Passengercar;
import java.util.List;
/**
 *
 * @author pminh
 */

public interface PassengercarRepository {
    Passengercar getCarById(int id);
    boolean updatePass(Passengercar p);
    boolean addPass(Passengercar p);
    
}
