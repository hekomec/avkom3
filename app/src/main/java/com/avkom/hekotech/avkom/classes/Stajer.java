package com.avkom.hekotech.avkom.classes;

/**
 * Created by hekotech on 16.07.2018.
 */

public class Stajer {
    String isim,mail,medeni,numara,stajTarih,stajSure,uni,dogum,adres,id;

    public Stajer(String isim, String mail, String medeni, String numara, String stajtarih, String stajsure, String uni, String dogum, String adres,String id) {
        this.isim = isim;
        this.mail = mail;
        this.medeni = medeni;
        this.numara = numara;
        this.stajTarih = stajtarih;
        this.stajSure = stajsure;
        this.uni = uni;
        this.dogum = dogum;
        this.adres = adres;
        this.id =id;
    }
public Stajer(){

}
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
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

    public String getStajTarih() {
        return stajTarih;
    }

    public void setStajTarih(String stajtarih) {
        this.stajTarih = stajtarih;
    }

    public String getStajSure() {
        return stajSure;
    }

    public void setStajSure(String stajsure) {
        this.stajSure = stajsure;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
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
}
