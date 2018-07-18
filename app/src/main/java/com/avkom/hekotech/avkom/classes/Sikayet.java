package com.avkom.hekotech.avkom.classes;

/**
 * Created by hekotech on 16.07.2018.
 */

public class Sikayet {
    String isim,mail,mesaj,numara;

    public Sikayet(String isim, String mail, String mesaj, String numara) {
        this.isim = isim;
        this.mail = mail;
        this.mesaj = mesaj;
        this.numara = numara;
    }
    public Sikayet(){

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

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }
}
