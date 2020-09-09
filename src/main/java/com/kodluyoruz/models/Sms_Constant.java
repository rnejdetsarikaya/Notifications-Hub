package com.kodluyoruz.models;

import com.kodluyoruz.exceptions.ConstantSmsException;
import com.kodluyoruz.interfaces.Package;

public class Sms_Constant implements Package {

    private int amount=1000;
    private int renewal=5;//kayıt tarihini aşmak gibi yenileme miktarı hakkı

    public Sms_Constant(){

    }
    @Override
    public double getPrice() {
        return 20.0;
    }

    @Override
    public void send(Company company, User user) {
        if(this.amount==0) throw new ConstantSmsException(company.getLang().sms_limit_exceeded());
        Sms sms = new Sms();
        sms.setSender(company);
        sms.setReceiver(user);
        sms.setMessage("Hello this is a constant sms");
        sms.send(sms.getMessage());
        this.amount--;
    }

    @Override
    public double update() {
        System.out.println("Yeni Sms paketi alındı.");
        this.amount=1000;
        this.renewal--;
        return 20;
    }

    @Override
    public int getRenewal() {
        return this.renewal;
    }
}
