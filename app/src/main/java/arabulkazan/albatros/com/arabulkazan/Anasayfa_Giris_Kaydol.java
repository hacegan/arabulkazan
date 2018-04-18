package arabulkazan.albatros.com.arabulkazan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import arabulkazan.albatros.com.arabulkazan.R;

public class Anasayfa_Giris_Kaydol  extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.anasayfa_giris_kaydol);
    }
}
