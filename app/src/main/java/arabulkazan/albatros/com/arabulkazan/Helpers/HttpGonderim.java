package arabulkazan.albatros.com.arabulkazan.Helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;




import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;


import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLSocketFactory;

public class HttpGonderim extends AsyncTask<Void, Void, String> {

    Activity act;
    String url = "";
    boolean showProgress = true;
    ArrayList<NameValuePair> params;

    public OnPostExecuteListener mPostExecuteListener = null;

    public static interface OnPostExecuteListener {
        void onPostExecute(String result);
    }

    public HttpGonderim(Activity act, String url, ArrayList<NameValuePair> params, boolean showProgress, OnPostExecuteListener postExecuteListener) {
        this.act = act;
        this.url = url;
        mPostExecuteListener = postExecuteListener;
        this.showProgress = showProgress;
        this.params = params;
    }

    String TAG = "HttpPost_ST";
    ProgressDialog pDialog;
    String veri_string = "";

    protected boolean isInternetAvailable() throws UnknownHostException {

            if (Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            InetAddress ipAddr = InetAddress.getByName("automzen.com"); //You can replace it with your name
            return !ipAddr.equals("");
    }
    protected void onPreExecute() {
        try {
            if (isInternetAvailable()  && act != null) {
                if (showProgress) {
                    pDialog = new ProgressDialog(act);
                    pDialog.setTitle("Bekleyin");
                    pDialog.setMessage("Yükleniyor...");
                    pDialog.setIndeterminate(true);
                    pDialog.setCancelable(false);
                    pDialog.show();
                }
            } else {


                final AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(act, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(act);
                }

                builder.setTitle("İnternet Mevcut Değil!")
                        .setMessage("Lütfen İnternet Bağlantınızı Kontrol Ediniz!")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
    //                            dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                this.cancel(true);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    protected String doInBackground(Void... unused) { // Arka Planda yapılacaklar. Yani Post işlemi
        veri_string = httpPost(url, "POST", params, 20000);
        //Log.d("Response:", "" + veri_string);
        return veri_string;
    }

    protected void onPostExecute(String dummyText) {
        if (showProgress && act != null) {
            pDialog.dismiss();
            //   Toast.makeText(act, veri_string, Toast.LENGTH_LONG).show();
        }
        mPostExecuteListener.onPostExecute(dummyText);
    }

    public String httpPost(String url, String method, List params, int time) {
        String veri_string = null;
        InputStream veri = null;
        try {
            if (method == "POST") {
                HttpParams httpParameters = new BasicHttpParams();
                int timeout1 = time;
                int timeout2 = time;
                HttpConnectionParams.setConnectionTimeout(httpParameters, timeout1);
                HttpConnectionParams.setSoTimeout(httpParameters, timeout2);
                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost(url);
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");
                httpPost.setEntity(formEntity);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                veri = httpResponse.getEntity().getContent();
            } else if (method == "GET") {
                HttpClient httpClient = HttpClientBuilder.create().build();
                String paramString = URLEncodedUtils.format(params, "utf8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                veri = httpEntity.getContent();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    veri, "utf8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            veri.close();
            veri_string = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Hata " + e.toString());
        }
        return veri_string;
    }
}