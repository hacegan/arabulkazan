package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arabulkazan.albatros.com.arabulkazan.Adapters.Exp_Main_Fragment_List_Adapter;

import arabulkazan.albatros.com.arabulkazan.R;


/**
 * Created by PC on 29.03.2018.
 */

public class Main extends android.support.v4.app.Fragment {
  private  static SliderLayout sliderShow;
  private Button sizeozelbtn;

private ExpandableListView exp_gunfirsat,exp_on_egitim,exp_on_ar_kir,exp_on_sig,exp_on_fa;

    public static List<String> groupList = null;
    public  static Map<String, List<String>> childListMap = null;


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



exp_gunfirsat=root.findViewById(R.id.exp_gunun_firsatlari);
exp_on_egitim=root.findViewById(R.id.exp_online_egitim);
exp_on_ar_kir=root.findViewById(R.id.exp_online_arac_kiralama);
exp_on_sig=root.findViewById(R.id.exp_online_sigorta);
exp_on_fa=root.findViewById(R.id.exp_online_fatura);

Exp_Main_Fragment_List_Adapter exp_main_fragment_list_adapter=new Exp_Main_Fragment_List_Adapter(Main.this.getActivity());

exp_on_egitim.setAdapter(exp_main_fragment_list_adapter);
exp_on_ar_kir.setAdapter(exp_main_fragment_list_adapter);
exp_on_sig.setAdapter(exp_main_fragment_list_adapter);
exp_on_fa.setAdapter(exp_main_fragment_list_adapter);

exp_on_egitim.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
    @Override
    public void onGroupExpand(int groupIndex) {

        // Get total group size.
        int groupListSize = groupList.size();

        // Close other expanded group.
        for(int i=0;i < groupListSize; i++) {
            if(i!=groupIndex) {
                exp_on_egitim.collapseGroup(i);
            }
        }


    }
});

exp_on_ar_kir.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
    @Override
    public void onGroupExpand(int groupIndex) {


        // Get total group size.
        int groupListSize = groupList.size();

        // Close other expanded group.
        for(int i=0;i < groupListSize; i++) {
            if(i!=groupIndex) {
                exp_on_ar_kir.collapseGroup(i);
            }
        }



    }
});


        exp_on_sig.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupIndex) {


                // Get total group size.
                int groupListSize = groupList.size();

                // Close other expanded group.
                for(int i=0;i < groupListSize; i++) {
                    if(i!=groupIndex) {
                        exp_on_sig.collapseGroup(i);
                    }
                }



            }
        });


        exp_on_fa.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupIndex) {


                // Get total group size.
                int groupListSize = groupList.size();

                // Close other expanded group.
                for(int i=0;i < groupListSize; i++) {
                    if(i!=groupIndex) {
                        exp_on_fa.collapseGroup(i);
                    }
                }



            }
        });




    sizeozelbtn=root.findViewById(R.id.sizeozelbtn);
    sizeozelbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            System.out.println("Click olayı oldu");
SizeOzel sizeOzel=new SizeOzel();

            //getFragmentManager().beginTransaction().replace(R.id.frameLayout,sizeOzel).commit();
           /* getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, sizeOzel,"findThisFragment")
                    .addToBackStack(null)
                    .commit();*/

            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
fragmentTransaction.addToBackStack(null);
fragmentTransaction.remove(Main.this);
            fragmentTransaction.replace(R.id.container,sizeOzel);
            fragmentTransaction.commit();



        }
    });




        return root;

    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }



    // online_egitim
    private void online_egitim()
    {
        if(this.groupList == null)
        {
            this.groupList = new ArrayList<String>();
        }

        if(this.childListMap == null)
        {
            this.childListMap = new HashMap<String, List<String>>();
        }

        if(!this.groupList.contains("ONLİNE EĞİTİM")) {
            this.groupList.add("ONLİNE EĞİTİM");
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add(""+R.drawable.online_egitim_anasayfa_exp);

        // Add child data list in the map, key is group name.
        this.childListMap.put("ONLİNE EĞİTİM", childList);
    }


    // online_arac_kiralama
    private void online_arac_kiralama()
    {
        if(this.groupList == null)
        {
            this.groupList = new ArrayList<String>();
        }

        if(this.childListMap == null)
        {
            this.childListMap = new HashMap<String, List<String>>();
        }

        if(!this.groupList.contains("ONLİNE ARAÇ KİRALAMA")) {
            this.groupList.add("ONLİNE ARAÇ KİRALAMA");
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add(""+R.drawable.online_arac_kiralama_anasayfa_exp);

        // Add child data list in the map, key is group name.
        this.childListMap.put("ONLİNE ARAÇ KİRALAMA", childList);
    }

    // online_sigorta
    private void online_sigorta()
    {
        if(this.groupList == null)
        {
            this.groupList = new ArrayList<String>();
        }

        if(this.childListMap == null)
        {
            this.childListMap = new HashMap<String, List<String>>();
        }

        if(!this.groupList.contains("ONLİNE SİGORTA")) {
            this.groupList.add("ONLİNE SİGORTA");
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add(""+R.drawable.online_sigorta_anasayfa_exp);

        // Add child data list in the map, key is group name.
        this.childListMap.put("ONLİNE SİGORTA", childList);
    }


    // online_fatura
    private void online_fatura()
    {
        if(this.groupList == null)
        {
            this.groupList = new ArrayList<String>();
        }

        if(this.childListMap == null)
        {
            this.childListMap = new HashMap<String, List<String>>();
        }

        if(!this.groupList.contains("ONLİNE FATURA")) {
            this.groupList.add("ONLİNE FATURA");
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add(""+R.drawable.online_fatura_anasayfa_exp);

        // Add child data list in the map, key is group name.
        this.childListMap.put("ONLİNE FATURA", childList);
    }




}