package com.juaracoding.dewabrata;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juaracoding.dewabrata.model.biodata.JuaraTextjalan;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BiodataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<JuaraTextjalan> dataItemList;

    public List<JuaraTextjalan> getDataItemList() {
        return dataItemList;
    }

    public BiodataAdapter(List<JuaraTextjalan> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        this.context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_biodata, parent, false);
        BiodataAdapter.Penampung penampung = new BiodataAdapter.Penampung(view);
        return penampung;


    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        ((Penampung)holder).txtId.setText(dataItemList.get(position).getId());
        ((Penampung)holder).txtDari.setText(dataItemList.get(position).getDari());
        ((Penampung)holder).txtText.setText(dataItemList.get(position).getText());
        ((Penampung)holder).txtTime.setText(dataItemList.get(position).getTime());
        ((Penampung)holder).txtStatus.setText(dataItemList.get(position).getStatus());



    }




    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }


    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtId,txtDari,txtText,txtTime,txtStatus;

        public Penampung(View itemView) {
            super(itemView);
            //  itemView.setOnClickListener(this);
            txtId = (TextView) itemView.findViewById(R.id.txtId);
            txtDari = (TextView) itemView.findViewById(R.id.txtDari);
            txtText = (TextView) itemView.findViewById(R.id.txtText);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
            txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);


        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " + txtDari.getText());
        }
    }


}
