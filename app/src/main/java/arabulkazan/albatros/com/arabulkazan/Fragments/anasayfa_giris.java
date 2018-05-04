package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.MainActivity;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

public class anasayfa_giris extends android.support.v4.app.Fragment {

    Button btn;
    EditText tc, pass;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.anasayfa_giris, container, false);

        btn = root.findViewById(R.id.button3);
        tc = root.findViewById(R.id.editText2);
        pass = root.findViewById(R.id.editText3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Data.login(anasayfa_giris.this.getActivity(), tc.getText().toString(), pass.getText().toString(), new Data.OnPostExecuteListener() {
                    @Override
                    public void onPostExecute(String result) {
                        final Result sonuc = new Gson().fromJson(result, Result.class);
                        try {

                            if (sonuc.getError().equals("0")) {//Buralar degisicek
                                Toast.makeText(getContext(), "Tebrikler başarıyla giriş yapıyorsunuz!", Toast.LENGTH_LONG);


                                UI.setString(getContext(),"pass",pass.getText().toString());
                                UI.setString(getContext(),"tc",tc.getText().toString());

                                Intent i = new Intent(anasayfa_giris.this.getContext(),MainActivity.class);
                                startActivity(i);


//                                Intent i = anasayfa_giris.this.getActivity().getPackageManager()
//                                                  .getLaunchIntentForPackage( anasayfa_giris.this.getActivity().getPackageName() );
//                                          i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                           startActivity(i);


                            } else if (sonuc.getMesaj().equals("Aktifleştirilmemiş Hesap!")) {
                                 Toast.makeText(getContext(),"Hesabınızı aktifleştirmeniz gerekiyor!", Toast.LENGTH_SHORT);

                                Register_Tel_Sifre register_tel_sifre=new Register_Tel_Sifre();
                                android.support.v4.app.FragmentTransaction  transaction =anasayfa_giris.this.getActivity().getSupportFragmentManager().beginTransaction();
                                transaction.add(R.id.frameLayout,register_tel_sifre);
                                transaction.commit();


                            }
                            else if(sonuc.getMesaj().equals("T.C Kimlik No ve/veya Şifre Yanlış Lütfen Tekrar Deneyin!")){
                                Toast.makeText(getContext(),"T.C Kimlik No ve/veya Şifre Yanlış Lütfen Tekrar Deneyin!", Toast.LENGTH_SHORT);
                            }


                            else {
                                Toast.makeText(getContext(),"T.C. Kimlik Numarası ve/veya Şifre Boş Olamaz!", Toast.LENGTH_SHORT);
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
