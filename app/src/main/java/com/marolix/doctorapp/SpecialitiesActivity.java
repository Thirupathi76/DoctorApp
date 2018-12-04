package com.marolix.doctorapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marolix.doctorapp.adapter.SpecialitiesAdapter;

public class SpecialitiesActivity extends AppCompatActivity {

    private RecyclerView specialities_rc;
    private SpecialitiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);

        specialities_rc = findViewById(R.id.specialities_rc);
        specialities_rc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SpecialitiesAdapter(this);
        specialities_rc.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
