package com.kodluyoruz.languages;

import com.kodluyoruz.interfaces.Language;

public class English implements Language {
    @Override
    public String package_not_found() {
        return "Registered package not found";
    }

    @Override
    public String added_blacklist() {
        return "Company added BlackList!!!! Please give us money :p";
    }

    @Override
    public String sms_limit_exceeded() {
        return "Sms limit exceeded";
    }

    @Override
    public String email_limit_exceeded() {
        return "Email limit exceeded";
    }
}
