package arabulkazan.albatros.com.arabulkazan.Pojos;

import java.util.Date;

/**
 * Created by PC on 30.03.2018.
 */


public class Result {

    private String error;
    private String mesaj;
    private int lastID;
    private String myReferans;
    private String tarih;
    private String sifre_kod;
    private String data;
    private String tc;
    private String pass;


    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMesssage() {
        return mesaj;
    }

    public void setMesssage(String mesaj) {
        this.mesaj = mesaj;
    }


    public int getLastID() {
        return lastID;
    }

    public void setLastID(int lastID) {
        this.lastID = lastID;
    }

    public String getMyReferans() {
        return myReferans;
    }

    public void setMyReferans(String myReferans) {
        this.myReferans = myReferans;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }


    public String getSifre_kod() {
        return sifre_kod;
    }

    public void setSifre_kod(String sifre_kod) {
        this.sifre_kod = sifre_kod;
    }
}
