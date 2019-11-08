package com.juaracoding.herjuaracoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;

public class input_nama extends AppCompatActivity {

    public static int RESULT_CODE=222;
    /*private ArrayList<ModelD  ata> soal ;*/

    Button btnAdd;
    EditText SoalNama,SoalKalimat;
    /*private ArrayList<ModelData> dataNama ;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_nama);

        btnAdd = findViewById(R.id.btnAdd);
        SoalNama = findViewById(R.id.SoalNama);
        SoalKalimat = findViewById(R.id.SoalAlamat);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ModelData model = new ModelData();
                model.setNama(SoalNama.getText().toString());
                model.setAlamat(SoalKalimat.getText().toString());

                tulis(model);

                Intent intent = new Intent();
                intent.putExtra("data",model);

                setResult(RESULT_CODE,intent);

                finish();
            }
        });

    }
    public void tulis(ModelData data) {
        String fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Book1.csv";
        try {
            Writer wr = new FileWriter(fileName, true);
            wr.write(data.getNama() + ";");
            wr.write(data.getAlamat() + "\n");
            wr.flush();
            wr.close();
        } catch (IOException e) {
            Log.e("BELAJARIO", e.getMessage().toString());
            Toast.makeText(input_nama.this, "Data  gagal di insert ", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(input_nama.this, "Data berhasil di insert ", Toast.LENGTH_SHORT).show();

    }
}
