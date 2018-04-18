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
    public OnPostExecuteListener mPostExecuteListener = null;

    public static void register(Activity act, String tc, String adi, String soyadi, String telefon, String pass,String ref,String sehir, final OnPostExecuteListener postExecuteListener) {

        ArrayList<NameValuePair> nm = new ArrayList<>();
        nm.add(new BasicNameValuePair("act", "newMember"));
        nm.add(new BasicNameValuePair("adi", adi));
        nm.add(new BasicNameValuePair("soyadi", soyadi));
        nm.add(new BasicNameValuePair("tc", tc));
        nm.add(new BasicNameValuePair("pass", pass));
        nm.add(new BasicNameValuePair("telefonNum", telefon));
        nm.add(new BasicNameValuePair("referans", ref));
        nm.add(new BasicNameValuePair("sehir", sehir));

        new HttpGonderim(act, Constants.REST_URL, nm, false, new HttpGonderim.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {

                if (postExecuteListener != null) {
                    postExecuteListener.onPostExecute(result);

                }
            }
        }).execute();


    }






}
