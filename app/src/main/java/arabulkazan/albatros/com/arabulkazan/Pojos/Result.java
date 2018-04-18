package arabulkazan.albatros.com.arabulkazan.Pojos;

/**
 * Created by PC on 30.03.2018.
 */


public class Result {

    private String error;
    private String mesaj;
    private int lastID;
    private String myReferans;
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
}
