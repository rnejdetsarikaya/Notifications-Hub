package com.kodluyoruz;

import com.kodluyoruz.exceptions.PackageException;
import com.kodluyoruz.languages.Turkish;
import com.kodluyoruz.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Company company = new Company();
        company.setName("Trendyol");
        company.setLang(new Turkish());
        List<User> users = company.createUserGroup(5);
        Email_Constant pack = new Email_Constant();
        Sms_Constant pack2 = new Sms_Constant();
        Email_In_Constant pack3 = new Email_In_Constant();
        Sms_In_Constant pack4 = new Sms_In_Constant();
        company.register(pack);
        company.register(pack2);
        //company.register(pack3);
        //company.register(pack4);
        for (int i = 0; i < 5000; i++) {
            try {
                company.send(users);
            } catch (PackageException e) {
                e.printStackTrace();
                break;
            }
        }


    }
}
