package arabulkazan.albatros.com.arabulkazan;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import arabulkazan.albatros.com.arabulkazan.Fragments.Main;
import arabulkazan.albatros.com.arabulkazan.Fragments.Register;
import arabulkazan.albatros.com.arabulkazan.R;

public class Anasayfa_Giris_Kaydol  extends android.support.v4.app.Fragment{
Button loginbtn,registerbtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.anasayfa_giris_kaydol, container, false);
        loginbtn=root.findViewById(R.id.loginbtn);
        registerbtn=root.findViewById(R.id.registerbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Main nextFrag= new Main();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();



            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Register nextFrag= new Register();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();


            }
        });



        return root;
    }
}
