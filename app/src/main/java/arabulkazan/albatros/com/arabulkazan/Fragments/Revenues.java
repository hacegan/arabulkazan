package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.gson.Gson;

import java.util.Date;

import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Mywallet_Pojo;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class Revenues extends android.support.v4.app.Fragment {

    AdView ad;
    public RewardedVideoAd gecis;
    Button btn;
    static String videoit="",videoft="";
    private  TextView tur,tutar,tarih,tarih1,tarih2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root =inflater.inflate(R.layout.fragment_revenues, container, false);
        TextView izleKazanButton=(TextView)root.findViewById(R.id.btn_izle_kazan);
        izleKazanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Revenues.this.getActivity(),"Test Denemeler",Toast.LENGTH_SHORT).show();
            }
        });

        MobileAds.initialize(getContext(), "ca-app-pub-6235102139907642~7410121045");


        ad=(AdView)root.findViewById(R.id.adView);
//        ad.setAdUnitId("");
//
//        ad.setAdSize(AdSize.BANNER);

        final AdRequest request = new AdRequest.Builder()
                .build();


        ad.loadAd(request);

        ad.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
            //    Toast.makeText(getContext(),"Tebrikler kazancınız hesabınıza eklendi.", Toast.LENGTH_SHORT);

/*
                Data.cuzdanim(Revenues.this.getActivity(), "15287263802", "43270ea45b9c4800f084badd5c610f19c81cb865", "2018-01-18", "2018-04-18", new Data.OnPostExecuteListener() {
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
*/


                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });

        gecis = MobileAds.getRewardedVideoAdInstance(getContext());

        btn=root.findViewById(R.id.btn_izle_kazan);

        gecis.loadAd("ca-app-pub-6235102139907642/5586081094",
                new AdRequest.Builder().build());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setEnabled(false);

                if(gecis.isLoaded()){
                    gecis.show();
                }

                gecis.setRewardedVideoAdListener(
                        new RewardedVideoAdListener() {
                            @Override
                            public void onRewardedVideoAdLoaded() {
                              //  gecis.show();
                              //  btn.setEnabled(true);
                            }

                            @Override
                            public void onRewardedVideoAdOpened() {

                            }

                            @Override
                            public void onRewardedVideoStarted() {
videoit= String.valueOf(new Date());
                            }

                            @Override
                            public void onRewardedVideoAdClosed() {

                            }

                            @Override
                            public void onRewarded(RewardItem rewardItem) {
                                videoft= String.valueOf(new Date());

Toast.makeText(getContext(),"Tebrikler kazancınız hesabınıza eklendi.", Toast.LENGTH_SHORT);

/*
                                Data.kazancim(Revenues.this.getActivity(), "36233263110", "43270ea45b9c4800f084badd5c610f19c81cb865",videoit,videoft, new Data.OnPostExecuteListener() {
                                    @Override
                                    public void onPostExecute(String result) {
                                        final Result sonuc=new Gson().fromJson(result,Result.class);
                                        if (sonuc.getError().equals("1"))
                                        {
                                            UI.showErrorDialog(Revenues.this.getActivity(),"Hata",sonuc.getMesssage(),null);
                                        }
                                        else
                                        {
                                            UI.showSuccesDialog(Revenues.this.getActivity(),"Başarılı","Kazancınız Bakiyenize Eklendi",null);
                                        }



                                    }
                                });*/



                            }

                            @Override
                            public void onRewardedVideoAdLeftApplication() {

                            }

                            @Override
                            public void onRewardedVideoAdFailedToLoad(int i) {
                                Toast.makeText(getContext(),String.valueOf(i),Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

        return root;

    }
}