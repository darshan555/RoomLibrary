package com.example.room_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText titleET,expenceET;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleET = findViewById(R.id.titleET);
        expenceET = findViewById(R.id.priceET);
        save = findViewById(R.id.saveBTN);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleET.getText().toString();
                String amount = expenceET.getText().toString();

                databaseHelper.expenceDAO().addData(
                        new Expence(title,amount)
                );

                ArrayList<Expence> arrayList = (ArrayList<Expence>) databaseHelper.expenceDAO().getAllExpence();

                for(int i = 0;i<arrayList.size();i++){
                    Log.d("Data","Title :"+arrayList.get(i).getTitle()+" Amount :"+arrayList.get(i).getAmount());
                }
            }
        });


    }
}