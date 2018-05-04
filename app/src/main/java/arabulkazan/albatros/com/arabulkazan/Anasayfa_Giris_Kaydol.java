package arabulkazan.albatros.com.arabulkazan;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import arabulkazan.albatros.com.arabulkazan.Fragments.Main;
import arabulkazan.albatros.com.arabulkazan.Fragments.NotificationRemember;
import arabulkazan.albatros.com.arabulkazan.Fragments.Register;
import arabulkazan.albatros.com.arabulkazan.Fragments.anasayfa_giris;
import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
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

                anasayfa_giris nextFrag= new anasayfa_giris();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();



//                Main nextFrag= new Main();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
//
//                UI.setString(getActivity(),"pass","012345");
//
//                Intent i = Anasayfa_Giris_Kaydol.this.getActivity().getPackageManager()
//                        .getLaunchIntentForPackage(Anasayfa_Giris_Kaydol.this.getActivity().getPackageName() );
//             //   i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);




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

//                NotificationRemember nextFrag= new NotificationRemember();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.frameLayout, nextFrag,"findThisFragment")
//                        .addToBackStack(null)
//                        .commit();





            }
        });



        return root;
    }
}
