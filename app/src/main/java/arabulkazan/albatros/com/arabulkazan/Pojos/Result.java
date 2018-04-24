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
}
