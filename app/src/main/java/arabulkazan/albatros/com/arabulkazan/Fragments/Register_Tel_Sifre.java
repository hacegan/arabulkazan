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

import arabulkazan.albatros.com.arabulkazan.Helpers.Constants;
import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

public class Register_Tel_Sifre extends  android.support.v4.app.Fragment {
  static  EditText tel_sifre;
  static Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_onay, container, false);//anıldaki tasarım eklenecek

         tel_sifre=root.findViewById(R.id.kayit_tamam_sifre_et);
 btn=root.findViewById(R.id.kayit_tamam_btn);


       if( UI.getString(this.getActivity(),"sifre_kod")!=null){



btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        if(tel_sifre.getText().toString().equals(UI.getString(Register_Tel_Sifre.this.getActivity(),"sifre_kod")) ){
            Data.activate_member(Register_Tel_Sifre.this.getActivity(),UI.getString(Register_Tel_Sifre.this.getActivity(),"telefon"), new Data.OnPostExecuteListener() {
                @Override
                public void onPostExecute(String result) {
                    final Result sonuc=new Gson().fromJson(result,Result.class);
                    try {
                        if(sonuc.getMesaj().equals("Başarılı")){
                            Toast.makeText(getContext(),"Tebrikler başarıyla üyeliğinizi aktifleştirdiniz!", Toast.LENGTH_SHORT);

//                            Main main=new Main();
//                            android.support.v4.app.FragmentTransaction  transaction =Register_Tel_Sifre.this.getActivity().getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.frameLayout,main);
//                            transaction.commit();

                            Intent i = Register_Tel_Sifre.this.getActivity().getPackageManager()
                                                    .getLaunchIntentForPackage( Register_Tel_Sifre.this.getActivity().getPackageName() );
                                           i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                           startActivity(i);

                        }
                        else{
                            Toast.makeText(getContext(),"Bir hata oluştu.", Toast.LENGTH_SHORT);
                        }



                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            });



        }

else{
           Toast.makeText(Register_Tel_Sifre.this.getContext(),"Yanlış Şifre Girdiniz.Lütfen Tekrar Deneyiniz!",Toast.LENGTH_SHORT);
        }



    }
});


        }
        else{

           Data.send_new_sms_kod(this.getActivity(),UI.getString(this.getActivity(),"adi"),UI.getString(this.getActivity(),"soyadi"),UI.getString(this.getActivity(),"telefon"), new Data.OnPostExecuteListener() {
               @Override
               public void onPostExecute(String result) {
                   final Result sonuc=new Gson().fromJson(result,Result.class);
                   try {

                       if(sonuc.getMesaj().equals("Şifre başarıyla yenilendi!")){//Burasıda degisicek
                           Toast.makeText(getContext(),"Hesabınızı etkinleştirmek için yeni şifre hesabınıza gönderildi!", Toast.LENGTH_SHORT);
                           UI.setString(Register_Tel_Sifre.this.getActivity(),"sifre_kod",sonuc.getSifre_kod());

                           Register_Tel_Sifre register=new Register_Tel_Sifre();
                           android.support.v4.app.FragmentTransaction  transaction = Register_Tel_Sifre.this.getActivity().getSupportFragmentManager().beginTransaction();
                           transaction.add(R.id.frameLayout,register);
                           transaction.commit();


//                           Intent i =Register_Tel_Sifre.this.getActivity().getPackageManager()
//                                                .getLaunchIntentForPackage(Register_Tel_Sifre.this.getActivity().getPackageName() );
//                                          i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                          startActivity(i);

                           //Eğer activity resetlenirse yeniden şifre gelicek iş karışıcak o yüzden fragment resetlenmeli

                       }
                       else if(sonuc.getMesaj().equals("Bu kadar sıklıkla şifrenizi değiştiremezsiniz!")){
                           UI.showErrorDialog(Register_Tel_Sifre.this.getActivity(),"Bu kadar sıklıkla şifrenizi değiştiremezsiniz!",sonuc.getMesssage(),null);
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








        return root;
    }


}
