package com.adrond.finalproject.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadHibernateConfig {
    private  String baseName;
    private String ipAddress;
    private String ipPort;
    public String url;
    public String baseLogin;
    public String basePass;

    public ReadHibernateConfig(String fileName) throws IOException {
        class StrParams {
            String StrName;
            String StrVal;

            public StrParams(String str) {
                int index = str.indexOf("=");
                this.StrName = str.substring(0, index).toLowerCase().trim();
                String s = str.substring(index++, str.length()).trim();
                s = s.substring(s.indexOf("\"") + 1);
                this.StrVal = s.substring(0, s.indexOf("\""));

            }
        }
        // Read the file cfg
        this.baseName = "FinalProject";
        this.ipAddress = "localhost";
        this.ipPort = "5432";
        this.baseLogin = "FinalProject";
        this.basePass = "FinalProject";
        this.url = "jdbc:postgresql://" + this.ipAddress + ":" + this.ipPort + "/" + this.baseName;
        // Check existing file
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File config " + fileName + " doesn't exist. Use default settings.");
            return;
        }

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str;

        while ((str = reader.readLine()) != null) {
            if (!str.isEmpty()) {
                StrParams strParams = new StrParams(str);
                switch (strParams.StrName) {
                    case "basename":
                        this.baseName = strParams.StrVal;
                        break;
                    case "ipaddress":
                        this.ipAddress = strParams.StrVal;
                        break;
                    case "ipport":
                        this.ipPort = strParams.StrVal;
                        break;
                    case "baselogin":
                        this.baseLogin = strParams.StrVal;
                        break;
                    case "basepass":
                        this.basePass = strParams.StrVal;
                        break;
                }
            }
        }
        this.url = "jdbc:postgresql://" + this.ipAddress + ":" + this.ipPort + "/" + this.baseName;
    }
    }
