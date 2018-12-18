package com.marolix.doctorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.marolix.doctorapp.adapter.ClinicHAdapter;
import com.marolix.doctorapp.adapter.DoctorsVAdapter;

public class DoctorsClinicActivity extends AppCompatActivity {

     private RecyclerView doctors_rc, clinics_rc;
     private ClinicHAdapter clinicHAdapter;
     private DoctorsVAdapter doctorsVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_clinic);

        doctors_rc = findViewById(R.id.doctors_rc);
        clinics_rc = findViewById(R.id.clinics_rc);

        clinics_rc.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        doctors_rc.setLayoutManager(new LinearLayoutManager(this));

        clinicHAdapter = new ClinicHAdapter(DoctorsClinicActivity.this);
        doctorsVAdapter = new DoctorsVAdapter(this);

        doctors_rc.setAdapter(doctorsVAdapter);
        clinics_rc.setAdapter(clinicHAdapter);
        doctorsVAdapter.notifyDataSetChanged();
        clinicHAdapter.notifyDataSetChanged();

    }
}
