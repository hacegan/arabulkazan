package arabulkazan.albatros.com.arabulkazan;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import arabulkazan.albatros.com.arabulkazan.Pojos.Mywallet_Pojo;
import arabulkazan.albatros.com.arabulkazan.R;

public class CuzdanimAdapter extends RecyclerView.Adapter<CuzdanimAdapter.MyViewHolder> {

    private List<Mywallet_Pojo> cuzList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tur,tarih,tutar;

        public MyViewHolder(View view) {
            super(view);
            tur = (TextView) view.findViewById(R.id.rectur);
            tarih = (TextView) view.findViewById(R.id.rectar);
            tutar = (TextView) view.findViewById(R.id.rectut);
        }
    }


    public CuzdanimAdapter(List<Mywallet_Pojo> moviesList) {
        this.cuzList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cuzdanim_list_rows, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Mywallet_Pojo czdn = cuzList.get(position);
        holder.tur.setText(czdn.getTur());
        holder.tarih.setText(czdn.getTarih());
        holder.tutar.setText(czdn.getTutar());
    }

    @Override
    public int getItemCount() {
        return cuzList.size();
    }
}