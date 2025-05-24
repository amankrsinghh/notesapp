package com.example.notes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

FloatingActionButton floatbtn;
RecyclerView recyclerView;
ArrayList<NotesModel> list;
 NotesHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        floatbtn = findViewById(R.id.floatbtn);
        recyclerView = findViewById(R.id.recyclerview);
        helper = new NotesHelper(MainActivity2.this);
        list = new ArrayList<>();

        Cursor cursor = helper.getData();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                list.add(new NotesModel(cursor.getString(1),cursor.getString(2),cursor.getInt(0)));
            }
        }

NotesAdapter adapter = new NotesAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


floatbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity2.this,Add_notes.class);
        startActivity(intent);
    }
});







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}