package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import arabulkazan.albatros.com.arabulkazan.MainActivity;
import arabulkazan.albatros.com.arabulkazan.R;


/**
 * Created by PC on 29.03.2018.
 */

public class Main extends android.support.v4.app.Fragment {
  private  static SliderLayout sliderShow;
  private Button sizeozelbtn,aramabtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_main_page, container, false);



       /*final BottomNavigationView navigation = (BottomNavigationView) root.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setVisibility(View.VISIBLE);*/


     //   TextView txtMyReferans=(TextView)root.findViewById(R.id.main_txtReferansNum);
      //  TextView txtWellcomeMessage=(TextView)root.findViewById(R.id.main_text_header);

    //    txtMyReferans.setText("Referans Numaranız:"+ UI.getString(Main.this.getActivity(),"myReferans"));
     //   txtWellcomeMessage.setText("Hoşgeldin:"+ UI.getString(Main.this.getActivity(),"adi")+" "+UI.getString(Main.this.getActivity(),"soyadi")+"!");

        sliderShow = (SliderLayout)root.findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(getActivity());
        textSliderView
                .description("Tıkla Kazan")
                .image("https://www.automzen.com/upload/banner2.jpg");

        sliderShow.addSlider(textSliderView);

      //  logoutbtn=root.findViewById(R.id.logoutbtn);

    /*    logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UI.showConfirmation(Main.this.getActivity(),"Çıkış","Çıkış Yapmak İstediğinize emin misiniz?",
                        new UI.onClick() {
                            @Override
                            public void onFinishedDialog() {
                                UI.logout(Main.this.getActivity());


                                Anasayfa_Giris_Kaydol nextFrag= new Anasayfa_Giris_Kaydol();
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
                                        .addToBackStack(null)
                                        .commit();

                                Intent i = Main.this.getActivity().getPackageManager()
                                        .getLaunchIntentForPackage(Main.this.getActivity().getPackageName() );

                                startActivity(i);



                            }
                        }, new UI.onClick() {
                            @Override
                            public void onFinishedDialog() {

                            }
                        }



                        );


            }
        });*/

aramabtn=root.findViewById(R.id.anasayfa_arama_btn);

aramabtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Toast.makeText(Main.this.getActivity(),"Yakında...",Toast.LENGTH_SHORT).show();



    }
});






    sizeozelbtn=root.findViewById(R.id.sizeozelbtn);
    sizeozelbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("Click olayı oldu");

            //getFragmentManager().beginTransaction().replace(R.id.frameLayout,sizeOzel).commit();
           /* getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, sizeOzel,"findThisFragment")
                    .addToBackStack(null)
                    .commit();*/

//            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//fragmentTransaction.addToBackStack(null);
//fragmentTransaction.remove(Main.this);
//            fragmentTransaction.replace(R.id.container,sizeOzel);
//            fragmentTransaction.commit();

            MainActivity.viewPager.setCurrentItem(MainActivity.viewPager.getAdapter().getCount()-2);



        }
    });







        final LinearLayout innerLayout1=(LinearLayout)root.findViewById(R.id.innerlayout1);
        LinearLayout txtHeader=(LinearLayout)root.findViewById(R.id.online_egitim);


        txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (innerLayout1.getVisibility()==View.GONE)
                    innerLayout1.setVisibility(View.VISIBLE);
                else
                    innerLayout1.setVisibility(View.GONE);

            }
        });


        final LinearLayout innerLayout2=(LinearLayout)root.findViewById(R.id.innerlayout2);
        LinearLayout txtHeader2=(LinearLayout)root.findViewById(R.id.online_arac_kiralama);
        txtHeader2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (innerLayout2.getVisibility()==View.GONE)
                    innerLayout2.setVisibility(View.VISIBLE);
                else
                    innerLayout2.setVisibility(View.GONE);

            }
        });



        final LinearLayout innerLayout3=(LinearLayout)root.findViewById(R.id.innerlayout3);
        LinearLayout txtHeader3=(LinearLayout)root.findViewById(R.id.online_sigorta);
        txtHeader3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (innerLayout3.getVisibility()==View.GONE)
                    innerLayout3.setVisibility(View.VISIBLE);
                else
                    innerLayout3.setVisibility(View.GONE);

            }
        });


        final LinearLayout innerLayout4=(LinearLayout)root.findViewById(R.id.innerlayout4);
        LinearLayout txtHeader4=(LinearLayout)root.findViewById(R.id.online_fatura);
        txtHeader4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (innerLayout4.getVisibility()==View.GONE)
                    innerLayout4.setVisibility(View.VISIBLE);
                else
                    innerLayout4.setVisibility(View.GONE);

            }
        });


        final LinearLayout innerLayoutgun=(LinearLayout)root.findViewById(R.id.innerlayoutgun);
        LinearLayout txtHeader5=(LinearLayout)root.findViewById(R.id.gunun_firsatlari);
        txtHeader5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (innerLayoutgun.getVisibility()==View.GONE)
                    innerLayoutgun.setVisibility(View.VISIBLE);
                else
                    innerLayoutgun.setVisibility(View.GONE);

            }
        });


        return root;

    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }







}