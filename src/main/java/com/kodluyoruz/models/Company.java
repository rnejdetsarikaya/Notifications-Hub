package com.kodluyoruz.models;

import com.kodluyoruz.exceptions.*;
import com.kodluyoruz.interfaces.Language;
import com.kodluyoruz.interfaces.Package;
import com.kodluyoruz.validation.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {
    private String name;
    private double cost = 0;
    private Language lang;
    public List<Package> packs;


    public Company(){
        packs = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public Language getLang() {
        return this.lang;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }

    public void register(Package pack){
        this.cost += pack.getPrice();
        this.packs.add(pack);
    }

    public void send(List<User> users) {
        Random rand = new Random();
        if (!Validations.isCanUsePackage(this)) throw new PackageException(lang.package_not_found());
        Package pack = this.packs.get(rand.nextInt(packs.size()));
        if (!Validations.isCanUseService(pack,this)) throw new PackageException(lang.added_blacklist());
        try {
            for (User user : users) {
                pack.send(this, user);
            }
        } catch (ConstantEmailException e) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------");
            this.cost += pack.update();
        } catch (Exception e) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println(e.getMessage());
            System.out.println("--------------------------------------------------------------------------");
            this.cost += pack.update();
        }
        System.out.println("Current cost: "+this.cost);

    }

    public List<User> createUserGroup(int size){
        List<User> list = new ArrayList<>();
        for(int i=0;i<size;i++)
            list.add(new User(i+". user",i+".user@user.com"));
        return list;
    }
}
