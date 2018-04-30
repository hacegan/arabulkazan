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
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Mywallet_Pojo;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;
import arabulkazan.albatros.com.arabulkazan.Helpers.Constants;

/**
 * Created by PC on 29.03.2018.
 */

public class Revenues extends android.support.v4.app.Fragment {

    AdView ad;
    public RewardedVideoAd gecis;
    Button btn;
    static String videoit = "", videoft = "";
    private TextView tur, tutar, tarih, tarih1, tarih2,zenmiktar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_revenues, container, false);
        TextView izleKazanButton = (TextView) root.findViewById(R.id.btn_izle_kazan);

        zenmiktar=root.findViewById(R.id.zencounttxt);


        izleKazanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Revenues.this.getActivity(), "Test Denemeler", Toast.LENGTH_SHORT).show();
            }
        });


        ad = (AdView) root.findViewById(R.id.adView);
//        ad.setAdUnitId("");
//
//        ad.setAdSize(AdSize.BANNER);

        final AdRequest request = new AdRequest.Builder()
                .build();


        ad.loadAd(request);

        ad.setAdListener(new AdListener() {
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
                Toast.makeText(getContext(), "Tebrikler kazancınız hesabınıza eklendi.", Toast.LENGTH_SHORT).show();
              videoit=videoft=String.valueOf(Constants.dateFormat.format(new Date()));

                Data.kazancim(Revenues.this.getActivity(), "36233263110", "5fca1c413e0ecc5c7f6a27330394c913f3595bc8",videoit,videoft, new Data.OnPostExecuteListener() {
                    @Override
                    public void onPostExecute(String result) {
                        final Result sonuc = new Gson().fromJson(result, Result.class);
                        if (sonuc.getError().equals("1")) {
                            UI.showErrorDialog(Revenues.this.getActivity(), "Hata", sonuc.getMesssage(), null);
                        } else {
                            zenmiktar.setText(   String.valueOf(   Double.valueOf(zenmiktar.getText().toString().split(" Zen")[0] )+0.01    )+" Zen" );
                            UI.showSuccesDialog(Revenues.this.getActivity(), "Başarılı", "Kazancınız Bakiyenize Eklendi", null);
                        }


                    }
                });


                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {

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

        btn = root.findViewById(R.id.btn_izle_kazan);

        Data.reklamgecenzaman(Revenues.this.getActivity(), "36233263110", "2121ec97b2b46d6a5fb88ddda697bac676aced66", new Data.OnPostExecuteListener() {
            @Override
            public void onPostExecute(String result) {
                final Result sonuc = new Gson().fromJson(result,Result.class);
                if (sonuc.getError().equals("1")) {
                    UI.showErrorDialog(Revenues.this.getActivity(), "Hata", sonuc.getMesssage(), null);
                } else {

                    String cur_date=Constants.dateFormat.format(new Date());

             String[] db_saat=sonuc.getTarih().split(" ")[1].split(":");

                    String[] cur_saat=cur_date.split(" ")[1].split(":");

                    int diff=Integer.valueOf(cur_saat[1])-Integer.valueOf(db_saat[1]);

                    if(diff>5){
                        btn.setEnabled(false);
                    }

                }


            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn.setEnabled(false);

              /*  if(gecis.isLoaded()){
                    gecis.show();
                }*/

                gecis.setRewardedVideoAdListener(
                        new RewardedVideoAdListener() {
                            @Override
                            public void onRewardedVideoAdLoaded() {
                                gecis.show();
                                btn.setEnabled(true);
                            }

                            @Override
                            public void onRewardedVideoAdOpened() {

                            }

                            @Override
                            public void onRewardedVideoStarted() {
                                videoit=String.valueOf(Constants.dateFormat.format(new Date()));
                            }

                            @Override
                            public void onRewardedVideoAdClosed() {

                            }

                            @Override
                            public void onRewarded(RewardItem rewardItem) {
                               videoft=String.valueOf(Constants.dateFormat.format(new Date()));

                                Toast.makeText(getContext(), "Tebrikler kazancınız hesabınıza eklendi.", Toast.LENGTH_SHORT).show();


                                Data.kazancim(Revenues.this.getActivity(), "36233263110", "5fca1c413e0ecc5c7f6a27330394c913f3595bc8",videoit,videoft, new Data.OnPostExecuteListener() {
                                    @Override
                                    public void onPostExecute(String result) {
                                        final Result sonuc = new Gson().fromJson(result, Result.class);
                                        if (sonuc.getError().equals("1")) {
                                            UI.showErrorDialog(Revenues.this.getActivity(), "Hata", sonuc.getMesssage(), null);
                                        } else {
                                            zenmiktar.setText(   String.valueOf(   Double.valueOf(zenmiktar.getText().toString().split(" Zen")[0] )+0.01    )+" Zen" );
                                            UI.showSuccesDialog(Revenues.this.getActivity(), "Başarılı", "Kazancınız Bakiyenize Eklendi", null);
                                        }


                                    }
                                });


                            }

                            @Override
                            public void onRewardedVideoAdLeftApplication() {
                                UI.showErrorDialog(Revenues.this.getActivity(), "Hata","Kazanç sağlayabilmeniz için videoyu sonuna kadar izlemeniz gerekiyor!", null);
                            }

                            @Override
                            public void onRewardedVideoAdFailedToLoad(int i) {
                                UI.showErrorDialog(Revenues.this.getActivity(), "Hata","Reklam Yüklenirken Bir hata oluştu!", null);
                            }
                        });
                gecis.loadAd("ca-app-pub-3940256099942544/5224354917",
                        new AdRequest.Builder().build());
            }
        });

        MobileAds.initialize(getContext(), "ca-app-pub-3940256099942544~3347511713");


        return root;

    }
}