package com.kodluyoruz.validation;

import com.kodluyoruz.interfaces.Package;
import com.kodluyoruz.models.Company;

import java.util.ArrayList;
import java.util.List;

public class Validations {
    private static List<Company> blacklist = new ArrayList<>();


    public static boolean isCanUsePackage(Company company) {
        return company.packs.size() > 0;
    }

    public static boolean isCanUseService(Package pack, Company company) {
        if (pack.getRenewal() > 0)
            return true;
        blacklist.add(company);
        return false;
    }
}
