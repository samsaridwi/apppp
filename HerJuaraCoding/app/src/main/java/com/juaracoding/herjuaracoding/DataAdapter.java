package com.juaracoding.herjuaracoding;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private ArrayList<ModelData> dataItemList;

    public DataAdapter(ArrayList<ModelData> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        this.context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_nama, parent, false);
        Penampung penampung = new Penampung(view);
        return penampung;


    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        TextView txtNama = ((Penampung)holder).txtNama;
        TextView txtAlamat = ((Penampung)holder).txtAlamat;
        txtNama.setText(dataItemList.get(position).getNama());
        txtAlamat.setText(dataItemList.get(position).getAlamat());



    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();
    }


    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtNama;
        public TextView txtAlamat;
        public Penampung(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtAlamat = (TextView) itemView.findViewById(R.id.txtAlamat);
        }
        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " " +txtNama.getText());
        }
    }


}