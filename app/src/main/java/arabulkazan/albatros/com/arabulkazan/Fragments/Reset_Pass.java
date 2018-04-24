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
import arabulkazan.albatros.com.arabulkazan.R;

public class Reset_Pass extends Fragment {

EditText tc,telno;
Button btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_sifremiunuttum,container,false);

        tc=root.findViewById(R.id.resetpasstc);
        telno=root.findViewById(R.id.resetpasstelno);

        btn=root.findViewById(R.id.resetpassbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Data.resetpw(Reset_Pass.this.getActivity(), tc.getText().toString(), telno.getText().toString(), new Data.OnPostExecuteListener() {
                    @Override
                    public void onPostExecute(String result) {

                        try {

                            if(result.contains("Başarılı")){
                                Toast.makeText(getContext(),"Tebrikler başarıyla şifrenizi sıfırladınız", Toast.LENGTH_SHORT);
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
        });






        return root;
    }




}
