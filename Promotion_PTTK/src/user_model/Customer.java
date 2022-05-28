/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_model;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Customer implements Serializable {
    int id ;
    String userName ;
    String pw;
    String email;
    String tel ;
    int totalPoint;
    int rankid;

    public Customer() {
    }

    public Customer(String userName, int totalPoint, int rankid) {
        this.userName = userName;
        this.totalPoint = totalPoint;
        this.rankid = rankid;
    }

    public Customer(String userName, String pw, String email, String tel, int totalPoint, int rankid) {
        this.userName = userName;
        this.pw = pw;
        this.email = email;
        this.tel = tel;
        this.totalPoint = totalPoint;
        this.rankid = rankid;
    }

    public Customer(int id, String userName, String pw, String email, String tel, int totalPoint, int rankid) {
        this.id = id;
        this.userName = userName;
        this.pw = pw;
        this.email = email;
        this.tel = tel;
        this.totalPoint = totalPoint;
        this.rankid = rankid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }

    public int getRankid() {
        return rankid;
    }

    public void setRankid(int rankid) {
        this.rankid = rankid;
    }
}
