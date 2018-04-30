package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arabulkazan.albatros.com.arabulkazan.R;
import arabulkazan.albatros.com.arabulkazan.Adapters.*;

public class SizeOzel  extends android.support.v4.app.Fragment {

    public static List<String> ref_groupList = null;
    public  static Map<String, List<String>> ref_childListMap = null;

    public static List<String> satis_groupList = null;
    public static Map<String, List<String>> satis_childListMap = null;

    public static List<String> bilgi_groupList = null;
    public static Map<String, List<String>> bilgi_childListMap = null;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_size_ozel, container, false);


this.referans_linkim("Referans Linkim","12345678","kobi45678");
this.satislarim();
this.bilgilerim();

Exp_Ref_List_Adapter exp_ref_list_adapter=new Exp_Ref_List_Adapter(SizeOzel.this.getActivity());

        final ExpandableListView exp_ref = (ExpandableListView)root.findViewById(R.id.exp_referans_linkim);

        DisplayMetrics metrics = new DisplayMetrics();
       SizeOzel.this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

        final float scale = getResources().getDisplayMetrics().density;
    int elli=    (int) (50 * scale + 0.5f);
    int on= (int) (10 * scale + 0.5f);

        exp_ref.setIndicatorBounds(width-elli,width-on);

        exp_ref.setAdapter(exp_ref_list_adapter);

        // Add on group expand listener.
        exp_ref.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupIndex) {
                // Get total group size.
                int groupListSize = ref_groupList.size();

                // Close other expanded group.
                for(int i=0;i < groupListSize; i++) {
                    if(i!=groupIndex) {
                        exp_ref.collapseGroup(i);
                    }
                }
            }
        });


        Exp_Satis_List_Adapter exp_satis_list_adapter=new Exp_Satis_List_Adapter(SizeOzel.this.getActivity());

        final ExpandableListView satis_ref = (ExpandableListView)root.findViewById(R.id.exp_satislarim);

        satis_ref.setIndicatorBounds(width-elli,width-on);

        satis_ref.setAdapter(exp_satis_list_adapter);

        // Add on group expand listener.
        satis_ref.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupIndex) {
                // Get total group size.
                int groupListSize = satis_groupList.size();

                // Close other expanded group.
                for(int i=0;i < groupListSize; i++) {
                    if(i!=groupIndex) {
                        satis_ref.collapseGroup(i);
                    }
                }
            }
        });


        Exp_Bilgi_List_Adapter exp_bilgi_list_adapter=new Exp_Bilgi_List_Adapter(SizeOzel.this.getActivity());

        final ExpandableListView bilgi_ref = (ExpandableListView)root.findViewById(R.id.exp_bilgilerim);

        bilgi_ref.setIndicatorBounds(width-elli,width-on);

        bilgi_ref.setAdapter(exp_bilgi_list_adapter);

        // Add on group expand listener.
        bilgi_ref.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupIndex) {
                // Get total group size.
                int groupListSize = bilgi_groupList.size();

                // Close other expanded group.
                for(int i=0;i < groupListSize; i++) {
                    if(i!=groupIndex) {
                        bilgi_ref.collapseGroup(i);
                    }
                }
            }
        });







        return  root;
    }





    // Referansım linkim data assign
    private void referans_linkim(String name,String temsil_kod,String kobi_kod)
    {
        if(this.ref_groupList == null)
        {
            this.ref_groupList = new ArrayList<String>();
        }

        if(this.ref_childListMap == null)
        {
            this.ref_childListMap = new HashMap<String, List<String>>();
        }

        if(!this.ref_groupList.contains(name)) {
            this.ref_groupList.add(name);
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add("Temsilci Kodu:  " + temsil_kod);
        childList.add("Kobi Kodu:  " + kobi_kod);

        // Add child data list in the map, key is group name.
        this.ref_childListMap.put(name, childList);
    }


    // Satışlarım
    private void satislarim()
    {
        if(this.satis_groupList == null)
        {
            this.satis_groupList = new ArrayList<String>();
        }

        if(this.satis_childListMap == null)
        {
            this.satis_childListMap = new HashMap<String, List<String>>();
        }

        if(!this.satis_groupList.contains("Satışlarım")) {
            this.satis_groupList.add("Satışlarım");
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add("Satış Yap");
        childList.add("Satılan Ürünler");
        childList.add("Devam eden satışlar");
        childList.add("Satılamayanlar");
        // Add child data list in the map, key is group name.
        this.satis_childListMap.put("Satışlarım", childList);
    }



    // Bilgilerim
    private void bilgilerim()
    {
        if(this.bilgi_groupList == null)
        {
            this.bilgi_groupList = new ArrayList<String>();
        }

        if(this.bilgi_childListMap == null)
        {
            this.bilgi_childListMap = new HashMap<String, List<String>>();
        }

        if(!this.bilgi_groupList.contains("Bilgilerim")) {
            this.bilgi_groupList.add("Bilgilerim");
        }

        // Create child list.
        List<String> childList = new ArrayList<String>();
        childList.add("Kişisel Bilgilerim");
        childList.add("Şifre Güncelle");
        childList.add("Adres Bilgilerim");
        childList.add("Banka Bilgilerim");
        childList.add("Fatura Bilgilerim");
        // Add child data list in the map, key is group name.
        this.bilgi_childListMap.put("Bilgilerim", childList);
    }




}
