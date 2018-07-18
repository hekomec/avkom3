package com.avkom.hekotech.avkom.classes;

/**
 * Created by hekotech on 16.07.2018.
 */

public class Eleman {
    String isim,mail,alan,egitim,medeni,numara,askerlik,dogum,adres;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAlan() {
        return alan;
    }

    public void setAlan(String alan) {
        this.alan = alan;
    }

    public String getEgitim() {
        return egitim;
    }

    public void setEgitim(String egitim) {
        this.egitim = egitim;
    }

    public String getMedeni() {
        return medeni;
    }

    public void setMedeni(String medeni) {
        this.medeni = medeni;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getAskerlik() {
        return askerlik;
    }

    public void setAskerlik(String askerlik) {
        this.askerlik = askerlik;
    }

    public String getDogum() {
        return dogum;
    }

    public void setDogum(String dogum) {
        this.dogum = dogum;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Eleman(){
    }
    public Eleman(String isim, String mail, String alan, String egitim, String medeni, String numara, String askerlik, String dogum, String adres) {
        this.isim = isim;
        this.mail = mail;
        this.alan = alan;
        this.egitim = egitim;
        this.medeni = medeni;
        this.numara = numara;
        this.askerlik = askerlik;
        this.dogum = dogum;
        this.adres = adres;
    }
}
