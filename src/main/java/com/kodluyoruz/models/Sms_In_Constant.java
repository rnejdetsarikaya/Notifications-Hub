package com.kodluyoruz.models;

import com.kodluyoruz.exceptions.InConstantSmsException;
import com.kodluyoruz.interfaces.Package;

public class Sms_In_Constant implements Package {

    private int amount=2000;
    private int renewal=200;//kayıt tarihini aşmak gibi yenileme miktarı hakkı

    @Override
    public double getPrice() {
        return 7.5;
    }

    @Override
    public void send(Company company, User user) {
        if(this.amount==0) throw new InConstantSmsException(company.getLang().sms_limit_exceeded());
        Sms sms = new Sms();
        sms.setSender(company);
        sms.setReceiver(user);
        sms.setMessage("Hello this is a constant sms");
        sms.send(sms.getMessage());
        this.amount--;
    }

    @Override
    public double update() {
        System.out.println("Fazladan ücretli sms kullanıldı.");
        this.renewal--;
        return 0.03;
    }

    @Override
    public int getRenewal() {
        return renewal;
    }
}
