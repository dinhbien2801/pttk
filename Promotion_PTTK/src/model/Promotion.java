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
public class Promotion implements Serializable{
    private int id;
    private int idRank;
    private int idVoucher;
    private String startDay;
    private String endDay;
    private String createdTime;

    public Promotion() {
    }

    public Promotion(int idRank, int idVoucher, String startDay, String endDay, String createdTime) {
        this.idRank = idRank;
        this.idVoucher = idVoucher;
        this.startDay = startDay;
        this.endDay = endDay;
        this.createdTime = createdTime;
    }

    public Promotion(int id, int idRank, int idVoucher, String startDay, String endDay, String createdTime) {
        this.id = id;
        this.idRank = idRank;
        this.idVoucher = idVoucher;
        this.startDay = startDay;
        this.endDay = endDay;
        this.createdTime = createdTime;
    }


    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdRank() {
        return idRank;
    }

    public void setIdRank(int idRank) {
        this.idRank = idRank;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
    
}
