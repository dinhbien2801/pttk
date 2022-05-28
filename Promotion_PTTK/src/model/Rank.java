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
public class Rank implements Serializable{
    private int id;
    private String name;
    private int min_point;
    private int max_Point;

    public Rank() {
    }

    public Rank(String name, int min_point, int max_Point) {
        this.name = name;
        this.min_point = min_point;
        this.max_Point = max_Point;
    }

    public Rank(int id, String name, int min_point, int max_Point) {
        this.id = id;
        this.name = name;
        this.min_point = min_point;
        this.max_Point = max_Point;
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

    public int getMin_point() {
        return min_point;
    }

    public void setMin_point(int min_point) {
        this.min_point = min_point;
    }

    public int getMax_Point() {
        return max_Point;
    }

    public void setMax_Point(int max_Point) {
        this.max_Point = max_Point;
    }

    @Override
    public String toString() {
        return "id= " + id + ", name= " + name + ", min_point= " + min_point + ", max_Point="  + max_Point ;
    }
     
}
