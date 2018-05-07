package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.MainActivity;
import arabulkazan.albatros.com.arabulkazan.R;


public class SizeOzel  extends android.support.v4.app.Fragment {

static TextView temsilci_tv,kobi_tv,sifre_guncelle,satis_yap,satilan_urunler,devam_eden_satis,satilamayanlar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_size_ozel_deneme, container, false);



        temsilci_tv=root.findViewById(R.id.temsilci_kod);
        kobi_tv=root.findViewById(R.id.kobi_kod);

        temsilci_tv.setText(temsilci_tv.getText().toString()+UI.getString(SizeOzel.this.getActivity(),"myReferans"));//null dönüyor
        kobi_tv.setText(kobi_tv.getText().toString()+"kobi"+UI.getString(SizeOzel.this.getActivity(),"myReferans"));

        satis_yap=root.findViewById(R.id.satis_yap);
        satilan_urunler=root.findViewById(R.id.satilan_urunler);
        devam_eden_satis=root.findViewById(R.id.devam_eden_satis);
        satilamayanlar=root.findViewById(R.id.satilamayanlar);

        satis_yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SizeOzel.this.getContext(),"Yakında...",Toast.LENGTH_SHORT).show();

            }
        });
        satilan_urunler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SizeOzel.this.getContext(),"Yakında...",Toast.LENGTH_SHORT).show();

            }
        });
        devam_eden_satis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SizeOzel.this.getContext(),"Yakında...",Toast.LENGTH_SHORT).show();

            }
        });
        satilamayanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SizeOzel.this.getContext(),"Yakında...",Toast.LENGTH_SHORT).show();

            }
        });


        sifre_guncelle=root.findViewById(R.id.sifre_guncelle);

        sifre_guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Sifre Guncelle Click");

                MainActivity.viewPager.setCurrentItem(MainActivity.viewPager.getAdapter().getCount()-1);




            }
        });

        final LinearLayout innerLayout1=(LinearLayout)root.findViewById(R.id.innerlayout1);
        TextView txtHeader=(TextView)root.findViewById(R.id.header1);
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
        TextView txtHeader2=(TextView)root.findViewById(R.id.header2);
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
        TextView txtHeader3=(TextView)root.findViewById(R.id.header3);
        txtHeader3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (innerLayout3.getVisibility()==View.GONE)
                    innerLayout3.setVisibility(View.VISIBLE);
                else
                    innerLayout3.setVisibility(View.GONE);

            }
        });





        return  root;
    }









}
