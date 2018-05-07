package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import arabulkazan.albatros.com.arabulkazan.CuzdanimAdapter;
import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

public class Reset_Pass extends android.support.v4.app.Fragment {

EditText tc,telno;
Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_sifremiunuttum,container,false);

        tc=root.findViewById(R.id.resetpasstc);
        telno=root.findViewById(R.id.resetpasstelno);

        btn=root.findViewById(R.id.sifre_sifirla_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Data.resetpw(Reset_Pass.this.getActivity(), tc.getText().toString(),telno.getText().toString(), new Data.OnPostExecuteListener() {
                    @Override
                    public void onPostExecute(String result) {
                        final Result sonuc=new Gson().fromJson(result,Result.class);
                        try {

                            if(sonuc.getMesaj().equals("Şifre başarıyla yenilendi!")){//Buralar degisicek
                                Toast.makeText(getContext(),"Tebrikler başarıyla şifrenizi sıfırladınız", Toast.LENGTH_SHORT).show();

                                //Burada tekrar giriş sayfasına yöneltilebilir.
                                anasayfa_giris anasayfa_giris=new anasayfa_giris();

                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.frameLayout,anasayfa_giris,"anasayfagiris")
                                        .addToBackStack(null)
                                        .commit();

                            }
                            else if(sonuc.getMesaj().equals("Bu kadar sıklıkla şifrenizi değiştiremezsiniz!")){
                                Toast.makeText(getContext(),"Bu kadar sıklıkla şifrenizi değiştiremezsiniz!", Toast.LENGTH_SHORT).show();
                            }
                            else if(sonuc.getMesaj().equals("TC VE/VEYA TELEFON Yanlış!")){
                                Toast.makeText(getContext(),"Girmiş Olduğunuz T.C ve/veya telefon numarası yanlış.Tekrar Deneyin!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(getContext(),"Bilinmeyen Bir Hata Oluştu!", Toast.LENGTH_SHORT).show();
                            }



                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });





            }
        });






        return root;
    }




}
