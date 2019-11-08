package com.juaracoding.dewabrata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.juaracoding.dewabrata.APIService.APIClient;
import com.juaracoding.dewabrata.APIService.APIInterfacesRest;
import com.juaracoding.dewabrata.model.biodata.ModelBiodata;
import com.juaracoding.dewabrata.model.post.ModelPost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {

    EditText txtId,txtNama,txtDeskripsi,txtWaktu,txtStatus;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        txtId = findViewById(R.id.txtId);
        txtNama = findViewById(R.id.txtNama);
        txtDeskripsi = findViewById(R.id.txtText);
        txtWaktu = findViewById(R.id.txtWaktu);
        txtStatus = findViewById(R.id.txtStatus);

        btnAdd = findViewById(R.id.btnTambah);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
                Intent intent = new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setData() {

        final APIInterfacesRest apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        final Call<ModelPost> data = apiInterface.setData(txtId.getText().toString(), txtNama.getText().toString(), txtDeskripsi.getText().toString(), txtWaktu.getText().toString(), txtStatus.getText().toString());

        data.enqueue(new Callback<ModelPost>() {
            @Override
            public void onResponse(Call<ModelPost> call, Response<ModelPost> response) {

                try {
                    if (response.body() != null)
                        Toast.makeText(AddActivity.this, " response message " + response.body().toString(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ModelPost> call, Throwable t) {

                Toast.makeText(AddActivity.this, "Terjadi gangguan koneksi", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });
    }
}