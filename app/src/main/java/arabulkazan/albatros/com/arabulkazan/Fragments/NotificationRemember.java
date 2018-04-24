package arabulkazan.albatros.com.arabulkazan.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import arabulkazan.albatros.com.arabulkazan.R;

public class NotificationRemember extends Fragment implements AdapterView.OnItemSelectedListener {
Spinner kacdk,hangisaat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_revenues, container, false);

kacdk=root.findViewById(R.id.kacdkhatirlatspinner);
hangisaat=root.findViewById(R.id.hangisaathatirlatspinner);

kacdk.setOnItemSelectedListener(this);


hangisaat.setOnItemSelectedListener(this);

        List<String> kacdklist = new ArrayList<String>();

        kacdklist.add("10 dk sonra");
        kacdklist.add("15 dk sonra");
        kacdklist.add("20 dk sonra");
        kacdklist.add("25 dk sonra");
        kacdklist.add("30 dk sonra");
        kacdklist.add("1 saat sonra");
        kacdklist.add("2 saat sonra");
        kacdklist.add("3 saat sonra");
        kacdklist.add("5 saat sonra");
        kacdklist.add("10 saat sonra");
        kacdklist.add("1  gün sonra");
        kacdklist.add("2 saat sonra");
        kacdklist.add("1 hafta sonra");

        List<String> hangilist = new ArrayList<String>();


        hangilist.add("Saat 1 de 2de vs");
        hangilist.add("15 dk sonra");
        hangilist.add("20 dk sonra");
        hangilist.add("25 dk sonra");
        hangilist.add("30 dk sonra");
        hangilist.add("1 saat sonra");
        hangilist.add("2 saat sonra");
        hangilist.add("3 saat sonra");
        hangilist.add("5 saat sonra");
        hangilist.add("10 saat sonra");
        hangilist.add("1  gün sonra");
        hangilist.add("2 saat sonra");
        hangilist.add("1 hafta sonra");

        return root;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
