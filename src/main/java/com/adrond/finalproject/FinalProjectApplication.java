package com.adrond.finalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.adrond.finalproject.Data.UserDAO;

@SpringBootApplication
public class FinalProjectApplication {



    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);
        System.out.println("Hello World!");

        UserDAO userBalance = new UserDAO();
        System.out.println(userBalance.GetBalance(55));
        userBalance.putMoney(55, 5000.0);
        System.out.println(userBalance.GetBalance(55));
        userBalance.takeMoney(55, 1000);
        System.out.println(userBalance.GetBalance(55));

          }
    }



