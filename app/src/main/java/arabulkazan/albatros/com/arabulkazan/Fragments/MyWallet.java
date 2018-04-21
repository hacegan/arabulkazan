package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import arabulkazan.albatros.com.arabulkazan.CuzdanimAdapter;
import arabulkazan.albatros.com.arabulkazan.Cuzdanim_RecyclerTouchListener;
import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.Sha1;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Mywallet_Pojo;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class MyWallet extends android.support.v4.app.Fragment   {

    private  TextView tur,tutar,tarih,tarih1,tarih2;;
private Button btn;
    private List<Mywallet_Pojo> czdnList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CuzdanimAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View rootView= inflater.inflate(R.layout.fragment_mywallet, container, false);

        tarih1=rootView.findViewById(R.id.cuzdanimtarih1);
        tarih2=rootView.findViewById(R.id.cuzdanimtarih2);
        recyclerView=rootView.findViewById(R.id.cuzdanrecview);
        btn=rootView.findViewById(R.id.cuzdanlistele);

        mAdapter = new CuzdanimAdapter(czdnList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(rootView.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(rootView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        recyclerView.setAdapter(mAdapter);


        // row click listener
        recyclerView.addOnItemTouchListener(new Cuzdanim_RecyclerTouchListener(rootView.getContext(), recyclerView, new Cuzdanim_RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Mywallet_Pojo pojo = czdnList.get(position);
                Toast.makeText(rootView.getContext(), pojo.getTur() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        tarih1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar takvim = Calendar.getInstance();
                int yil = takvim.get(Calendar.YEAR);
                int ay = takvim.get(Calendar.MONTH);
                int gun = takvim.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // ay değeri 0 dan başladığı için (Ocak=0, Şubat=1,..,Aralık=11)
                                // değeri 1 artırarak gösteriyoruz.
                                month += 1;
                                // year, month ve dayOfMonth değerleri seçilen tarihin değerleridir.
                                // Edittextte bu değerleri gösteriyoruz.
                                tarih1.setText(dayOfMonth + "-" + month + "-" + year);
                            }
                        }, yil, ay, gun);
                // datepicker açıldığında set edilecek değerleri buraya yazıyoruz.
                // şimdiki zamanı göstermesi için yukarda tanmladığımz değşkenleri kullanyoruz.

                // dialog penceresinin button bilgilerini ayarlıyoruz ve ekranda gösteriyoruz.
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();

            }
        });


        tarih2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar takvim = Calendar.getInstance();
                int yil = takvim.get(Calendar.YEAR);
                int ay = takvim.get(Calendar.MONTH);
                int gun = takvim.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // ay değeri 0 dan başladığı için (Ocak=0, Şubat=1,..,Aralık=11)
                                // değeri 1 artırarak gösteriyoruz.
                                month += 1;
                                // year, month ve dayOfMonth değerleri seçilen tarihin değerleridir.
                                // Edittextte bu değerleri gösteriyoruz.
                                tarih2.setText(dayOfMonth + "-" + month + "-" + year);
                            }
                        }, yil, ay, gun);
                // datepicker açıldığında set edilecek değerleri buraya yazıyoruz.
                // şimdiki zamanı göstermesi için yukarda tanmladığımz değşkenleri kullanyoruz.

                // dialog penceresinin button bilgilerini ayarlıyoruz ve ekranda gösteriyoruz.
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Seç", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!tarih1.getText().toString().contains("seciniz") && !tarih2.getText().toString().contains("seciniz")){

                    Data.cuzdanim(MyWallet.this.getActivity(), "15287263802", "43270ea45b9c4800f084badd5c610f19c81cb865", "2018-01-18", "2018-04-18", new Data.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(String result) {
                            final Mywallet_Pojo[] sonuc=new Gson().fromJson(result,Mywallet_Pojo[].class);



                            try {
                             /*   tur=(TextView) rootView.findViewById(R.id.mywallettur);
                                tutar=(TextView)rootView.findViewById(R.id.mywallettutar);
                                tarih=(TextView)rootView.findViewById(R.id.mywallettarih);

                                tur.setText(sonuc[0].getTur());
                                tutar.setText(sonuc[0].getTutar());
                                tarih.setText(sonuc[0].getTarih());  */


czdnList.clear();
for(int i=0;i<sonuc.length;i++){

    Mywallet_Pojo pojo=new Mywallet_Pojo(sonuc[i].getTur(),sonuc[i].getTarih(),sonuc[i].getTutar());
    czdnList.add(pojo);
    mAdapter.notifyDataSetChanged();


}

                            } catch (Exception e) {
                                e.printStackTrace();
                            }



                        }
                    });


                }

                else{
                    UI.showErrorDialog(MyWallet.this.getActivity(),"Hata","Lütfen iki tarih aralığını seçiniz",null);
                }



            }
        });




        return rootView;



    }

    public void onDestroyView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView= inflater.inflate(R.layout.fragment_mywallet, container, false);
        super.onDestroyView();
    }


}