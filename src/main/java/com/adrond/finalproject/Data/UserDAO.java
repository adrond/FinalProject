package com.adrond.finalproject.Data;

import com.adrond.finalproject.Data.BalanceEntity;
import org.hibernate.Session;

public class UserDAO {

    public double  GetBalance (int User_id) {
        return  DataBaseoperation.getSessionFactory().openSession().get(BalanceEntity.class, User_id).getBalance();
    }

    public void putMoney (int User_id, double amount_money) {
        BalanceEntity balanceEntity = DataBaseoperation.getSessionFactory().openSession().get(BalanceEntity.class, User_id);
        balanceEntity.setBalance(balanceEntity.getBalance() + amount_money);
        Session currentsession = DataBaseoperation.getSessionFactory().openSession();
        currentsession.beginTransaction();
        currentsession.merge(balanceEntity);
        currentsession.getTransaction().commit();
        currentsession.close();
    }

    public void takeMoney (int User_id, double amount_money) {
        BalanceEntity balanceEntity = DataBaseoperation.getSessionFactory().openSession().get(BalanceEntity.class, User_id);
        double currentbalance = balanceEntity.getBalance();
        if (currentbalance>amount_money) {currentbalance -= amount_money;} else {currentbalance=0;};
        balanceEntity.setBalance(currentbalance);
        Session currentsession = DataBaseoperation.getSessionFactory().openSession();
        currentsession.beginTransaction();
        currentsession.merge(balanceEntity);
        currentsession.getTransaction().commit();
        currentsession.close();
    }

}
