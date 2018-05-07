package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

public class Update_Pass extends android.support.v4.app.Fragment {
    EditText oldpass, newpass, newpassagain;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.passedit, container, false);

        oldpass = root.findViewById(R.id.old_pass_et);
        newpass = root.findViewById(R.id.new_pass_et);
        newpassagain = root.findViewById(R.id.new_pass_again_et);

        btn = root.findViewById(R.id.guncelle_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (oldpass.getText().toString().isEmpty() || newpass.getText().toString().isEmpty() || newpassagain.getText().toString().isEmpty()) {

                    UI.showErrorDialog(Update_Pass.this.getContext(), "HATA", "Lütfen Tüm Alanları Eksiksiz Bir Şekilde Doldurunuz!", null);


                } else {

                    Data.updatepw(Update_Pass.this.getActivity(),UI.getString(Update_Pass.this.getActivity(), "tc"),oldpass.getText().toString(),newpass.getText().toString(),new Data.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(String result) {

                            final Result sonuc=new Gson().fromJson(result,Result.class);

                            if(sonuc.getError().equals("0")){
                                Toast.makeText(Update_Pass.this.getContext(),"Şifreniz Başarıyla Güncellendi!",Toast.LENGTH_SHORT).show();
                            }

                            else {
                                Toast.makeText(Update_Pass.this.getContext(),"İşlem Başarısız!",Toast.LENGTH_SHORT).show();
                            }






                        }
                    });


                }


            }
        });


        return root;
    }


}
