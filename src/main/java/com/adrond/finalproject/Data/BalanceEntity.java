package com.adrond.finalproject.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "balance", schema = "public", catalog = "FinalProject")
public class BalanceEntity {
    @Basic
    @Column(name = "user_id")
    private long user_Id;
    @Basic
    @Column(name = "balance")
    private double balance;
    @Id
    @GeneratedValue


    public long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(long user_Id) {
        this.user_Id = user_Id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
