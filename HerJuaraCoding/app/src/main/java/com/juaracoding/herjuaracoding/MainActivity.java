package com.juaracoding.herjuaracoding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.filepicker.controller.DialogSelectionListener;
import com.developer.filepicker.model.DialogConfigs;
import com.developer.filepicker.model.DialogProperties;
import com.developer.filepicker.view.FilePickerDialog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static int REQUEST_CODE = 111;
    /*public ArrayList<ModelData> itemList = new ArrayList<ModelData>();*/
    private ArrayList<ModelData> soal ;

    Button btnImport, btnInput;
    RecyclerView lstData;
    DataAdapter itemArrayAdapter;

    /*ArrayList<ModelData> dataNama ;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnImport = findViewById(R.id.btnImport);
        btnInput = findViewById(R.id.btnTambah);
        lstData = findViewById(R.id.lstData);

       /* dataNama = getIntent().getParcelableArrayListExtra("data");

        setList(dataNama);*/


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }


        DialogProperties properties = new DialogProperties();
        properties.selection_mode = DialogConfigs.SINGLE_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.root = new File(DialogConfigs.DEFAULT_DIR);
        properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        properties.offset = new File(DialogConfigs.DEFAULT_DIR);
        properties.extensions = null;

        final FilePickerDialog dialog = new FilePickerDialog(MainActivity.this, properties);
        dialog.setTitle("Pilih file csv");

        dialog.setDialogSelectionListener(new DialogSelectionListener() {
            @Override
            public void onSelectedFilePaths(String[] files) {
                //files is the array of the paths of files selected by the Application User.

                ArrayList<ModelData> dummy =   baca(files[0]);
             /*   for(int x = 0 ;x < dummy.size();x++){
                    soal.add(dummy.get(x));
                }*/
                setList(soal);
                setList(files[0]);
            }
        });


        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, input_nama.class);
                startActivityForResult(intent,REQUEST_CODE);
                intent.putParcelableArrayListExtra("data",soal);


            }
        });



        btnImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();

            }
        });
    }


    public ArrayList<ModelData> baca(String fileName) {
        ArrayList<ModelData> todoList = new ArrayList<>();

        try {


            Scanner scanner = new Scanner(new File(fileName));
            Scanner valueScanner = null;
            int index = 0;


            while (scanner.hasNextLine()) {
                valueScanner = new Scanner(scanner.nextLine());
                valueScanner.useDelimiter(";");
                ModelData todo = new ModelData();

                while (valueScanner.hasNext()) {
                    String data = valueScanner.next();
                    if (index == 0) {
                        todo.setNama(data);
                    } else if (index == 1) {
                        todo.setAlamat(data);
                    }
                    index++;
                }
                index = 0;
                todoList.add(todo);
            }

            scanner.close();
        } catch (IOException e) {

        }

        return todoList;
    }


    public void setList(ArrayList<ModelData>soal) {
        itemArrayAdapter = new DataAdapter(soal);

        lstData.setLayoutManager(new LinearLayoutManager(this));
        lstData.setItemAnimator(new DefaultItemAnimator());
        lstData.setAdapter(itemArrayAdapter);
        lstData.invalidate();
    }

   /* public void setList2(){
        DataAdapter itemArrayAdapter = new DataAdapter(itemList);

        lstData.setLayoutManager(new LinearLayoutManager(this));
        lstData.setItemAnimator(new DefaultItemAnimator());
        lstData.setAdapter(itemArrayAdapter);
    }*/

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == input_nama.RESULT_CODE) {
            soal = data.getParcelableArrayListExtra("data");
            setList(soal);
        }
        super.onActivityResult(requestCode, resultCode, data);

}
}


