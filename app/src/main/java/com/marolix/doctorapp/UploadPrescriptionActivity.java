package com.marolix.doctorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.io.File;

public class UploadPrescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_prescription);

        final RelativeLayout image_layout = findViewById(R.id.image_layout);
        ImageView image = findViewById(R.id.image_captured);
        Button capture = findViewById(R.id.capture);
        ImageView cut = findViewById(R.id.cut_image);


        String path = getIntent().getStringExtra("IMAGE");
        Picasso.get().load(new File(path)).into(image);

        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_layout.setVisibility(View.GONE);
            }
        });

    }
}
