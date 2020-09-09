package com.kodluyoruz.models;

import com.kodluyoruz.exceptions.ConstantEmailException;
import com.kodluyoruz.interfaces.Package;

public class Email_Constant implements Package {
    private int amount=1000;
    private int renewal=3;//kayıt tarihini aşmak gibi yenileme miktarı hakkı

    public Email_Constant(){

    }
    @Override
    public double getPrice() {
        return 10.0;
    }

    @Override
    public void send(Company company, User user){
        if(this.amount==0) throw new ConstantEmailException(company.getLang().email_limit_exceeded());
        Email mail = new Email();
        mail.setReceiver(user);
        mail.setSender(company);
        mail.setTitle("Email");
        mail.setMessage("Hello this is a constant e-mail");
        mail.send(mail.getMessage());
        this.amount--;
    }

    @Override
    public double update() {
        System.out.println("Yeni E mail paketi alındı.");
        this.amount=1000;
        this.renewal--;
        return 10;
    }

    @Override
    public int getRenewal() {
        return this.renewal;
    }

}
