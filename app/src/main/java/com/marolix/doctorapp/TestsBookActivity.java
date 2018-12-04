package com.marolix.doctorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marolix.doctorapp.adapter.SpecialitiesAdapter;
import com.marolix.doctorapp.adapter.TestsAdapter;

public class TestsBookActivity extends AppCompatActivity {

    private RecyclerView specialities_rc;

    private TestsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests_book);
        specialities_rc = findViewById(R.id.specialities_rc);
        specialities_rc.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TestsAdapter(this);
        specialities_rc.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
