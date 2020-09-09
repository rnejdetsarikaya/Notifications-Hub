package com.kodluyoruz.models;

import com.kodluyoruz.exceptions.ConstantEmailException;
import com.kodluyoruz.exceptions.InConstantEmailException;
import com.kodluyoruz.interfaces.Package;

public class Email_In_Constant implements Package {
    private int amount = 2000;
    private int renewal=100;//kayıt tarihini aşmak gibi yenileme miktarı hakkı

    @Override
    public double getPrice() {
        return 30.0;
    }

    @Override
    public void send(Company company, User user) {
        if (this.amount == 0) throw new InConstantEmailException(company.getLang().email_limit_exceeded());
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
        System.out.println("Fazladan ücretli email kullanıldı.");
        this.renewal--;
        return 0.1;
    }

    @Override
    public int getRenewal() {
        return this.renewal;
    }
}
