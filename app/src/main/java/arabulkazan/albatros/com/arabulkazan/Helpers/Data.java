package arabulkazan.albatros.com.arabulkazan.Helpers;

import android.app.Activity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

/**
 * Created by PC on 29.03.2018.
 */

public class Data {


    public static interface OnPostExecuteListener {
        void onPostExecute(String result);
    }

    public static void register(Activity act, String tc, String adi, String soyadi, String telefon, String pass, String ref, String sehir,String is_aktif , final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> nm = new ArrayList<>();
        nm.add(new BasicNameValuePair("act", "newMember"));
        nm.add(new BasicNameValuePair("adi", adi));
        nm.add(new BasicNameValuePair("soyadi", soyadi));
        nm.add(new BasicNameValuePair("tc", tc));
        nm.add(new BasicNameValuePair("pass", pass));
        nm.add(new BasicNameValuePair("telefonNum", telefon));
        nm.add(new BasicNameValuePair("referans", ref));
        nm.add(new BasicNameValuePair("sehir", sehir));
        nm.add(new BasicNameValuePair("is_aktif", is_aktif));

        new HttpGonderim(act, Constants.REST_URL, nm, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }

    //mPostExecuteListener = null;

    public static void cuzdanim(Activity act, String tc, String pass, String tarih1, String tarih2, final OnPostExecuteListener postExecuteListener) {
        ArrayList<NameValuePair> mw = new ArrayList<>();
        mw.add(new BasicNameValuePair("act", "getMyRevenueList"));
        mw.add(new BasicNameValuePair("tc", tc));
        mw.add(new BasicNameValuePair("pass", pass));
        mw.add(new BasicNameValuePair("tarih1", tarih1));
        mw.add(new BasicNameValuePair("tarih2", tarih2));

        new HttpGonderim(act, Constants.REST_URL, mw, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }


    public static void kazancim(Activity act, String tc, String pass, String tarih1, String tarih2, final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> mr = new ArrayList<>();
        mr.add(new BasicNameValuePair("act", "kayithar"));
        mr.add(new BasicNameValuePair("tc", tc));
        mr.add(new BasicNameValuePair("pass", pass));
        mr.add(new BasicNameValuePair("tarih1", tarih1));
        mr.add(new BasicNameValuePair("tarih2", tarih2));

        new HttpGonderim(act, Constants.REST_URL, mr, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }


    public static void reklamgecenzaman(Activity act, String tc, String pass, final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> pt = new ArrayList<>();
        pt.add(new BasicNameValuePair("act", "reklamgecenzaman"));
        pt.add(new BasicNameValuePair("tc",tc));
        pt.add(new BasicNameValuePair("pass",pass));

        new HttpGonderim(act, Constants.REST_URL, pt, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }


    public static void resetpw(Activity act, String tc, String telno, final OnPostExecuteListener postExecuteListener) {


        ArrayList<NameValuePair> pt = new ArrayList<>();
        pt.add(new BasicNameValuePair("act", "sendMessage"));
        pt.add(new BasicNameValuePair("tc",tc));
        pt.add(new BasicNameValuePair("telno",telno));

        new HttpGonderim(act, Constants.REST_URL, pt, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();

    }

    public static void activate_member(Activity act,String telno, final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> am = new ArrayList<>();
        am.add(new BasicNameValuePair("act", "activation_member"));
        am.add(new BasicNameValuePair("telno",telno));

        new HttpGonderim(act, Constants.REST_URL, am, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }


    public static void send_new_sms_kod(Activity act,String adi,String soyadi,String telno, final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> am = new ArrayList<>();
        am.add(new BasicNameValuePair("act", "send_new_sms_kod"));
        am.add(new BasicNameValuePair("adi",telno));
        am.add(new BasicNameValuePair("soyadi",telno));
        am.add(new BasicNameValuePair("telefonNum",telno));

        new HttpGonderim(act, Constants.REST_URL, am, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }



    public static void login(Activity act, String tc, String pass, final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> pt = new ArrayList<>();
        pt.add(new BasicNameValuePair("act", "login"));
        pt.add(new BasicNameValuePair("tc",tc));
        pt.add(new BasicNameValuePair("pass",pass));

        new HttpGonderim(act, Constants.REST_URL, pt, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }



}
