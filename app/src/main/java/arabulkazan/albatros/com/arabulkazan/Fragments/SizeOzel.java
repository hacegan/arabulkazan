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
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.R;
import arabulkazan.albatros.com.arabulkazan.Adapters.*;

public class SizeOzel  extends android.support.v4.app.Fragment {

    public static List<String> ref_groupList = null;
    public  static Map<String, List<String>> ref_childListMap = null;

    public static List<String> satis_groupList = null;
    public static Map<String, List<String>> satis_childListMap = null;

    public static List<String> bilgi_groupList = null;
    public static Map<String, List<String>> bilgi_childListMap = null;

static TextView temsilci_tv,kobi_tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_size_ozel_deneme, container, false);


//this.referans_linkim("Referans Linkim","12345678","kobi45678");
//this.satislarim();
//this.bilgilerim();

/*Exp_Ref_List_Adapter exp_ref_list_adapter=new Exp_Ref_List_Adapter(SizeOzel.this.getActivity());

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
        });*/


//        Expandable expandable_ref = root.findViewById(R.id.expandable_referans);
//
//        expandable_ref.setExpandingListener(new ExpandingListener() {
//            @Override
//            public void onExpanded() {
//                //some stuff on expand
//            }
//
//            @Override
//            public void onCollapsed() {
//                //some stuff on collapse
//            }
//        });
//
//        Expandable expandable_sat = root.findViewById(R.id.expandable_referans);
//
//        expandable_sat.setExpandingListener(new ExpandingListener() {
//            @Override
//            public void onExpanded() {
//                //some stuff on expand
//            }
//
//            @Override
//            public void onCollapsed() {
//                //some stuff on collapse
//            }
//        });
//
//
//        Expandable expandable_bil = root.findViewById(R.id.expandable_referans);
//
//        expandable_bil.setExpandingListener(new ExpandingListener() {
//            @Override
//            public void onExpanded() {
//                //some stuff on expand
//            }
//
//            @Override
//            public void onCollapsed() {
//                //some stuff on collapse
//            }
//        });

        temsilci_tv=root.findViewById(R.id.temsilci_kod);
        kobi_tv=root.findViewById(R.id.kobi_kod);

        temsilci_tv.setText(temsilci_tv.getText().toString()+UI.getString(SizeOzel.this.getActivity(),"myReferans"));//null dönüyor
        kobi_tv.setText(kobi_tv.getText().toString()+"kobi"+UI.getString(SizeOzel.this.getActivity(),"myReferans"));

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
