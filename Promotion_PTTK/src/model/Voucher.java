/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Voucher implements Serializable{
    private int id;
    private String name ;
    private String description ;
    private String condition ;

    public Voucher() {
    }

    public Voucher(String name, String description, String condition) {
        this.name = name;
        this.description = description;
        this.condition = condition;
    }

    public Voucher(int id, String name, String description, String condition) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.condition = condition;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", name=" + name + ", description=" + description + ", condition=" + condition ;
    }
    public String infoVC(){
        return "name=" + name + ", description= " + description + ", condition= " + condition;
    }
}
