package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.Sha1;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Mywallet_Pojo;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class MyWallet extends android.support.v4.app.Fragment {

    private  TextView tur,tutar,tarih;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View rootView= inflater.inflate(R.layout.fragment_mywallet, container, false);

        Data.cuzdanim(MyWallet.this.getActivity(), "15287263802", "43270ea45b9c4800f084badd5c610f19c81cb865", "2018-01-18", "2018-04-18", new Data.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {
                final Mywallet_Pojo[] sonuc=new Gson().fromJson(result,Mywallet_Pojo[].class);

                System.out.println(sonuc);

                            try {
                                System.out.println("tur = "+sonuc[0].getTur());
                                tur=(TextView) rootView.findViewById(R.id.mywallettur);
                                tutar=(TextView)rootView.findViewById(R.id.mywallettutar);
                                tarih=(TextView)rootView.findViewById(R.id.mywallettarih);

                                tur.setText(sonuc[0].getTur());
                                tutar.setText(sonuc[0].getTutar());
                                tarih.setText(sonuc[0].getTarih());




                            } catch (Exception e) {
                                e.printStackTrace();
                            }









            }
        });


        return rootView;



    }
}