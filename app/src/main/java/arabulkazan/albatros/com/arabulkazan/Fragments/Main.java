package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.w3c.dom.Text;

import arabulkazan.albatros.com.arabulkazan.Anasayfa_Giris_Kaydol;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class Main extends android.support.v4.app.Fragment {
  private  static SliderLayout sliderShow;
  private Button logoutbtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_main_page, container, false);

     /*   final BottomNavigationView navigation = (BottomNavigationView) root.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setVisibility(View.GONE);*/

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

        logoutbtn=root.findViewById(R.id.logoutbtn);

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UI.showConfirmation(Main.this.getActivity(),"Çıkış","Çıkış Yapmak İstediğinize emin misiniz?",
                        new UI.onClick() {
                            @Override
                            public void onFinishedDialog() {
                                UI.logout(Main.this.getActivity());

                            /*    Register register=new Register();
                                android.support.v4.app.FragmentTransaction  transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                transaction.replace(R.id.frameLayout,register);
                              //  transaction.add(R.id.frameLayout,register);
                                transaction.commit();*/



                             /*   Intent i = Main.this.getActivity().getPackageManager()
                                        .getLaunchIntentForPackage(Main.this.getActivity().getPackageName());
                               i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                               Main.this.startActivity(i);*/

                                Anasayfa_Giris_Kaydol nextFrag= new Anasayfa_Giris_Kaydol();
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
                                        .addToBackStack(null)
                                        .commit();


                            }
                        }, new UI.onClick() {
                            @Override
                            public void onFinishedDialog() {

                            }
                        }





                        );






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