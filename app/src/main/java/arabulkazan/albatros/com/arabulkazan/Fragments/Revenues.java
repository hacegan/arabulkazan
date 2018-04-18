package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import arabulkazan.albatros.com.arabulkazan.R;

/**
 * Created by PC on 29.03.2018.
 */

public class Revenues extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root =inflater.inflate(R.layout.fragment_revenues, container, false);
        TextView izleKazanButton=(TextView)root.findViewById(R.id.btn_izle_kazan);
        izleKazanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Revenues.this.getActivity(),"Test Denemeler",Toast.LENGTH_SHORT).show();
            }
        });
        return root;

    }
}