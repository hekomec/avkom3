package com.avkom.hekotech.avkom.classes;

/**
 * Created by hekotech on 16.07.2018.
 */

public class Iletisim {
    String isim,mail,numara,id;

    public Iletisim(String isim, String mail, String numara,String id) {
        this.isim = isim;
        this.mail = mail;
        this.numara = numara;
        this.id =id;
    }
    public Iletisim(){

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

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}