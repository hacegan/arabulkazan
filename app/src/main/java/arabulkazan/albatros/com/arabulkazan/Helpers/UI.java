package arabulkazan.albatros.com.arabulkazan.Helpers;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class UI {

    public static void logout(Context cn){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
        SharedPreferences.Editor edit=preferences.edit();
        edit.clear();
        edit.apply();

    }

    public static void changeFont(Context cn, TextView tx)
    {
        Typeface face = Typeface.createFromAsset(cn.getAssets(),
                "Trirong/font-Bold.ttf");
        tx.setTypeface(face);

    }
    public static void changeFont(Context cn, EditText tx)
    {
        Typeface face = Typeface.createFromAsset(cn.getAssets(),
                "Phenomena/font-Regular.ttf");
        tx.setTypeface(face);

    }

    private static final String ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm";
    private static final String ALLOWED = "0123456789";

    public static String getRandomString(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(ALLOWED_CHARACTERS.length())));
        return sb.toString();
    }

    public static String getRandomInt(final int sizeOfRandomString) {
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(sizeOfRandomString);
        for (int i = 0; i < sizeOfRandomString; ++i)
            sb.append(ALLOWED.charAt(random.nextInt(ALLOWED.length())));
        return sb.toString();
    }

    private static String getNoFromWatsApp(Context cn) {
        AccountManager am = AccountManager.get(cn);
        Account[] accounts = am.getAccounts();
        String phoneNumber = "";

        for (Account ac : accounts) {
            String acname = ac.name;
            String actype = ac.type;
            // Take your time to look at all available accounts
            if (actype.equals("com.whatsapp")) {
                phoneNumber = ac.name;
            }
        }
        return phoneNumber;
    }
    public static interface onClick
    {
        public void onFinishedDialog();

    }
    public static void showConfirmation(Context cn, String title, String message, final onClick setPositive, final onClick setNegative)
    {
        new AlertDialog.Builder(cn)
                .setTitle(title)
                .setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (setPositive!=null)
                        setPositive.onFinishedDialog();
                    }})
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (setNegative!=null)
                            setNegative.onFinishedDialog();
                    }
                }).show();



    }
    public static void showErrorDialog(Context cn, String title, String message, final onClick onClick)
    {
        new AlertDialog.Builder(cn)
                .setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_error_black_24dp)
                .setNeutralButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (onClick!=null)
                            onClick.onFinishedDialog();
                    }
                })
                .show();



    }
    public static void showSuccesDialog(Context cn, String title, String message, final onClick onClick)
    {
        new AlertDialog.Builder(cn)
                .setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_check_circle_black_24dp)
                .setNeutralButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (onClick!=null)
                            onClick.onFinishedDialog();
                    }
                })
                .show();
   }

   public static String getString(Context cn,String key)
   {
       SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
       return preferences.getString(key,null);
   }
    public static int getInt(Context cn,String key)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
        return preferences.getInt(key,-1);
    }

    public static Boolean getBoolDefFalse(Context cn,String key)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
        return preferences.getBoolean(key,false);
    }
    public static Boolean getBoolDefTrue(Context cn,String key)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
        return preferences.getBoolean(key,true);
    }

    public static void setString(Context cn,String key,String value)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putString(key,value);
        edit.commit();
    }

    public static void setInt(Context cn,String key,int value)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(cn);
        SharedPreferences.Editor edit=preferences.edit();
        edit.putInt(key,value);
        edit.commit();
    }

    public static void loadSehirlerSpinner(Activity act, Spinner spIller)
    {
        List<String> list = new ArrayList<String>();

        list.add("Adana");
        list.add("Adıyaman");
        list.add("Afyon");
        list.add("Ağrı");
        list.add("Amasya");
        list.add("Ankara");
        list.add("Antalya");
        list.add("Artvin");
        list.add("Aydın");
        list.add("Balıkesir");
        list.add("Bilecik");
        list.add("Bingöl");
        list.add("Bitlis");
        list.add("Bolu");
        list.add("Burdur");
        list.add("Bursa");
        list.add("Çanakkale");
        list.add("Çankırı");
        list.add("Çorum");
        list.add("Denizli");
        list.add("Diyarbakır");
        list.add("Edirne");
        list.add("Elazığ");
        list.add("Erzincan");
        list.add("Erzurum");
        list.add("Eskişehir");
        list.add("Gaziantep");
        list.add("Giresun");
        list.add("Gümüşhane");
        list.add("Hakkari");
        list.add("Hatay");
        list.add("Isparta");
        list.add("Içel");
        list.add("Istanbul");
        list.add("Izmir");
        list.add("Kars");
        list.add("Kastamonu");
        list.add("Kayseri");
        list.add("Kırklareli");
        list.add("Kırşehir");
        list.add("Kocaeli");
        list.add("Konya");
        list.add("Kütahya");
        list.add("Malatya");
        list.add("Manisa");
        list.add("Kahramanmaraş");
        list.add("Mardin");
        list.add("Muğla");
        list.add("Muş");
        list.add("Nevşehir");
        list.add("Niğde");
        list.add("Ordu");
        list.add("Rize");
        list.add("Sakarya");
        list.add("Samsun");
        list.add("Siirt");
        list.add("Sinop");
        list.add("Sivas");
        list.add("Tekirdağ");
        list.add("Tokat");
        list.add("Trabzon");
        list.add("Tunceli");
        list.add("Şanlıurfa");
        list.add("Uşak");
        list.add("Van");
        list.add("Yozgat");
        list.add("Zonguldak");
        list.add("Aksaray");
        list.add("Bayburt");
        list.add("Karaman");
        list.add("Kırıkkale");
        list.add("Batman");
        list.add("Şırnak");
        list.add("Bartın");
        list.add("Ardahan");
        list.add("Iğdır");
        list.add("Yalova");
        list.add("Karabük");
        list.add("Kilis");
        list.add("Osmaniye");
        list.add("Düzce");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (act, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spIller.setAdapter(dataAdapter);


    }

}
