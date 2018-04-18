package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.w3c.dom.Text;

import arabulkazan.albatros.com.arabulkazan.Helpers.UI;
import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class Main extends android.support.v4.app.Fragment {
  private  static SliderLayout sliderShow;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_main_page, container, false);

        TextView txtMyReferans=(TextView)root.findViewById(R.id.main_txtReferansNum);
        TextView txtWellcomeMessage=(TextView)root.findViewById(R.id.main_text_header);

        txtMyReferans.setText("Referans Numaranız:"+ UI.getString(Main.this.getActivity(),"myReferans"));
        txtWellcomeMessage.setText("Hoşgeldin:"+ UI.getString(Main.this.getActivity(),"adi")+" "+UI.getString(Main.this.getActivity(),"soyadi")+"!");

        sliderShow = (SliderLayout)root.findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(getActivity());
        textSliderView
                .description("Tıkla Kazan")
                .image("https://www.automzen.com/upload/banner2.jpg");

        sliderShow.addSlider(textSliderView);

        return root;

    }


    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }
}