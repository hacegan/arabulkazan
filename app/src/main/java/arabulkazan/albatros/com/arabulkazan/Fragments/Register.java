package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import arabulkazan.albatros.com.arabulkazan.Helpers.Data;
import arabulkazan.albatros.com.arabulkazan.Helpers.Sha1;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.Pojos.Result;
import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class Register extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView= inflater.inflate(R.layout.register, container, false);
        TextView txtBaslik=(TextView)rootView.findViewById(R.id.text_header);
        UI.changeFont(getContext(),txtBaslik);

        Button btnKaydet=(Button)rootView.findViewById(R.id.btnKaydet);
        final TextView txtAdi=(TextView)rootView.findViewById(R.id.editAdi);
        final TextView txtSoyadi=(TextView)rootView.findViewById(R.id.editSoyadi);
        final TextView txtCep=(TextView)rootView.findViewById(R.id.editCepTel);
        final TextView txtTc=(TextView)rootView.findViewById(R.id.editTc);
        final TextView txtReferans=(TextView)rootView.findViewById(R.id.editRef);
        final TextView txtSifre=(TextView)rootView.findViewById(R.id.editSifre);
        final Spinner spinnerIller=(Spinner)rootView.findViewById(R.id.sp_Iller);
        UI.loadSehirlerSpinner(this.getActivity(),spinnerIller);


        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtAdi.getText().toString().isEmpty()==false && txtSoyadi.getText().toString().isEmpty()==false && txtTc.getText().length()==11 &&txtCep.getText().length()==10&&txtSifre.getText().length()>3)
                {
                    Data.register(Register.this.getActivity(), txtTc.getText().toString(), txtAdi.getText().toString(), txtSoyadi.getText().toString(), txtCep.getText().toString(),txtSifre.getText().toString(), txtReferans.getText().toString(),String.valueOf(spinnerIller.getSelectedItemPosition()+1), new Data.OnPostExecuteListener() {
                        @Override
                        public void onPostExecute(final String result) {
                            final Result sonuc=new Gson().fromJson(result,Result.class);
                            if (sonuc.getError().equals("1"))
                            {
                                UI.showErrorDialog(Register.this.getActivity(),"Hata",sonuc.getMesssage(),null);
                            }
                            else
                            {

                                UI.showSuccesDialog(Register.this.getActivity(), "Başarılı", "Tebrikler ,Başarıyla Üye Oldunuz. Uygulama Yeniden Başlatılacaktır.", new UI.onClick() {
                                    @Override
                                    public void onFinishedDialog() {

                                        try {
                                            String cheaper=Sha1.SHA1(txtSifre.getText().toString());
                                            String tc=txtTc.getText().toString();
                                            UI.setString(Register.this.getActivity(),"pass",cheaper);
                                            UI.setString(Register.this.getActivity(),"tc",tc);
                                            UI.setString(Register.this.getActivity(),"adi",txtAdi.getText().toString());
                                            UI.setString(Register.this.getActivity(),"soyadi",txtSoyadi.getText().toString());
                                            UI.setString(Register.this.getActivity(),"telefon",txtCep.getText().toString());
                                            UI.setString(Register.this.getActivity(),"myReferans",sonuc.getMyReferans().toString());

                                            UI.setString(Register.this.getActivity(),"ID",String.valueOf(sonuc.getLastID()));



                                            // Restart Application
                                                    Intent i = Register.this.getActivity().getPackageManager()
                                                    .getLaunchIntentForPackage( Register.this.getActivity().getPackageName() );
                                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(i);
                                        } catch (NoSuchAlgorithmException e) {
                                            e.printStackTrace();
                                        } catch (UnsupportedEncodingException e) {
                                            e.printStackTrace();
                                        }


                                    }
                                });
                            }

                        }
                    });
                }
                else
                    if (txtAdi.getText().toString().isEmpty() || txtAdi.getText().toString().length()<3)
                        Toast.makeText(Register.this.getActivity(), "Lütfen Adınızı Boş Bırakmayınız. En az 3 karakteri olmalıdır.", Toast.LENGTH_SHORT).show();
                    else
                    if (txtSoyadi.getText().toString().isEmpty() || txtSoyadi.getText().toString().length()<2)
                        Toast.makeText(Register.this.getActivity(), "Lütfen Soyadınızı Boş Bırakmayınız. En az 2 karakteri olmalıdır.", Toast.LENGTH_SHORT).show();
                    else
                    if (txtTc.getText().toString().isEmpty() || txtTc.getText().toString().length()!=11)
                        Toast.makeText(Register.this.getActivity(), "Lütfen Kimlik Numaranızı Alanını Boş Bırakmayınız. Kimlik Numarası 11 karakterli olmalıdır.", Toast.LENGTH_SHORT).show();
                    else
                    if (txtCep.getText().toString().isEmpty()|| txtCep.getText().toString().length()!=10)
                        Toast.makeText(Register.this.getActivity(), "Lütfen Cep Telefonunuzu Boş Bırakmayınız. Cep Telefonunuz 10 Karakterli Olmalıdır. Başına 0(SIFIR) koymadan yazınız.", Toast.LENGTH_SHORT).show();
                    else
                    if (txtSifre.getText().toString().isEmpty() || txtSifre.getText().toString().length()<4)
                        Toast.makeText(Register.this.getActivity(), "Şifrenizi Boş Bırakmayınız. En az 4 karakteri olmalıdır.", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;



    }
}
