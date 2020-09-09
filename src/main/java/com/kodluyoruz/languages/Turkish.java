package com.kodluyoruz.languages;

import com.kodluyoruz.interfaces.Language;

public class Turkish implements Language {
    @Override
    public String package_not_found() {
        return "Kayıtlı paket bulunamadı.";
    }

    @Override
    public String added_blacklist() {
        return "Firma kara listeye eklendi!!!! Faturanızı ödeyiniz.";
    }

    @Override
    public String sms_limit_exceeded() {
        return "Sms limiti aşıldı.";
    }

    @Override
    public String email_limit_exceeded() {
        return "Email limiti aşıldı";
    }
}
