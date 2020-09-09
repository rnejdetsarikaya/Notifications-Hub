package com.kodluyoruz.interfaces;

import com.kodluyoruz.models.Company;
import com.kodluyoruz.models.User;

public interface Package {
    public double getPrice();
    public void send(Company company, User user);
    public double update();
    public int getRenewal();
}
