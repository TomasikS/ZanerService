/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.zaner.controller;

/**
 *
 * @author stefan.tomasik
 */
public class ResourceNotFoundException extends RuntimeException{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    int id;
    String name;

    public ResourceNotFoundException(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
}
