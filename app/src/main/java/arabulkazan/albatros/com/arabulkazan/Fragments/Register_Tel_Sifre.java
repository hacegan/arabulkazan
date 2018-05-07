package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import arabulkazan.albatros.com.arabulkazan.Anasayfa_Giris_Kaydol;
import arabulkazan.albatros.com.arabulkazan.Helpers.Constants;
import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.MainActivity;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

public class Register_Tel_Sifre extends  android.support.v4.app.Fragment {
      EditText tel_sifre;
    static Button btn;
    static String durum="";
    static Register_Tel_Sifre register=new Register_Tel_Sifre();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_onay, container, false);//anıldaki tasarım eklenecek

        tel_sifre=root.findViewById(R.id.kayit_tamam_sifre_et);
        btn=root.findViewById(R.id.kayit_tamam_btn);



        if( UI.getString(Register_Tel_Sifre.this.getActivity(),"sifre_kod")==null){//bundan dolayı direk uygulamayı aşağı alınca runtime hatası alıyorum.kontrol edilmeli

            Data.send_new_sms_kod(Register_Tel_Sifre.this.getActivity(),UI.getString(Register_Tel_Sifre.this.getActivity(),"tc"), new Data.OnPostExecuteListener() {
                @Override
                public void onPostExecute(String result) {
                    final Result sonuc=new Gson().fromJson(result,Result.class);
                    try {

                        if(!sonuc.getSifre_kod().isEmpty()){
                            Toast.makeText(getContext(),"Hesabınızı etkinleştirmek için yeni şifre hesabınıza gönderildi!", Toast.LENGTH_SHORT).show();
                            UI.setString(Register_Tel_Sifre.this.getActivity(),"sifre_kod",sonuc.getSifre_kod());
                            System.out.println(sonuc.getSifre_kod());

//                           Register_Tel_Sifre register=new Register_Tel_Sifre();
//                           android.support.v4.app.FragmentTransaction  transaction = Register_Tel_Sifre.this.getActivity().getSupportFragmentManager().beginTransaction();
//                           transaction.replace(R.id.frameLayout,register);
//                           transaction.commit();


                            durum="yenisifregeldi";
//                           if (register != null && register.isAdded()) {
//                               getFragmentManager().beginTransaction().detach(register).attach(register).commit();
//                           }
                            if(register!=null){
                                System.out.println("Değişdi");
                                android.support.v4.app.FragmentTransaction  transaction = Register_Tel_Sifre.this.getActivity().getSupportFragmentManager().beginTransaction();
                                //transaction.addToBackStack(null);
                                //transaction.detach(register).attach(register).commit();
                                transaction.replace(getView().getId(),register,"Register_Tel_Sifre").commitAllowingStateLoss();
                            }
                            else{
                                System.out.println("Değişmedi");
                            }





//                           Intent i =Register_Tel_Sifre.this.getActivity().getPackageManager()
//                                                .getLaunchIntentForPackage(Register_Tel_Sifre.this.getActivity().getPackageName() );
//                                          i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                          startActivity(i);

                            //Eğer activity resetlenirse yeniden şifre gelicek iş karışıcak o yüzden fragment resetlenmeli

                        }
                        else if(sonuc.getMesaj().equals("Bu kadar sıklıkla yeni şifre talebinde bulunamazsınız!")){
                            UI.showErrorDialog(Register_Tel_Sifre.this.getActivity(),"Bu kadar sıklıkla yeni şifre talebinde bulunamazsınız!",sonuc.getMesssage(),null);
                        }

                        else{
                            Toast.makeText(getContext(),"Bir hata oluştu.Lütfen tekrar deneyin ! ", Toast.LENGTH_SHORT);
                        }



                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            });



        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Click geldi");

                if( UI.getString(Register_Tel_Sifre.this.getActivity(),"sifre_kod")!=null){
                    System.out.println("sifre var");
                    System.out.println("Benim yazdım="+tel_sifre.getText().toString()+"Gelen="+UI.getString(Register_Tel_Sifre.this.getActivity(),"sifre_kod"));

                    if(tel_sifre.getText().toString().equals(UI.getString(Register_Tel_Sifre.this.getActivity(),"sifre_kod")) ){
                        Data.activate_member(Register_Tel_Sifre.this.getActivity(),UI.getString(Register_Tel_Sifre.this.getActivity(),"tc"), new Data.OnPostExecuteListener() {
                            @Override
                            public void onPostExecute(String result) {
                                final Result sonuc=new Gson().fromJson(result,Result.class);
                                try {
                                    if(sonuc.getMesaj().equals("Başarılı")){
                                        Toast.makeText(getContext(),"Tebrikler başarıyla üyeliğinizi aktifleştirdiniz!", Toast.LENGTH_SHORT).show();

//                            Register_Tel_Sifre main=new Register_Tel_Sifre();
//                            android.support.v4.app.FragmentTransaction  transaction =Register_Tel_Sifre.this.getActivity().getSupportFragmentManager().beginTransaction();
//                            transaction.remove(main);
//                            transaction.commit();

//                                        Intent i = Register_Tel_Sifre.this.getActivity().getPackageManager()
//                                                .getLaunchIntentForPackage( Register_Tel_Sifre.this.getActivity().getPackageName() );
//                                       // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                        startActivity(i);

//                                        android.support.v4.app.FragmentTransaction  transaction =Register_Tel_Sifre.this.getActivity().getSupportFragmentManager().beginTransaction();
//                                        transaction.remove(new Anasayfa_Giris_Kaydol());


                                        UI.setString(getContext(),"pass",sonuc.getPass());
                                        UI.setString(getContext(),"tc",sonuc.getTc());
                                        UI.setString(getContext(),"myReferans",sonuc.getMyReferans());

                                        Intent i = new Intent(Register_Tel_Sifre.this.getActivity(),MainActivity.class);
                                        Register_Tel_Sifre.this.getActivity().startActivity(i);




                                    }
                                    else{
                                        Toast.makeText(getContext(),"Bir hata oluştu.", Toast.LENGTH_SHORT).show();
                                    }



                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            }
                        });



                    }

                    else{
                        Toast.makeText(Register_Tel_Sifre.this.getContext(),"Yanlış Şifre Girdiniz.Lütfen Tekrar Deneyiniz!",Toast.LENGTH_SHORT).show();
                    }




                }



            }
        });



        return root;
    }



}
