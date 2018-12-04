package com.marolix.doctorapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.marolix.doctorapp.font.TextView_AvenirLTStd_Book;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class OrderMedicinesActivity extends AppCompatActivity implements View.OnClickListener {

    TextView search_medicines, call, upload_prescription;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_medicines);

        search_medicines = findViewById(R.id.search_medicines);
        call = findViewById(R.id.call);
        upload_prescription = findViewById(R.id.upload_prescription);

        call.setOnClickListener(this);
        search_medicines.setOnClickListener(this);
        upload_prescription.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_medicines:
                startActivity(new Intent(OrderMedicinesActivity.this, MedicineBookActivity.class));
                break;
            case R.id.call:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:8686831655"));

                if (ActivityCompat.checkSelfPermission(OrderMedicinesActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
                break;

            case R.id.upload_prescription:
                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(OrderMedicinesActivity.this);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                mImageUri = resultUri;
//                prof_image.setImageURI(resultUri);
                String photo_path = resultUri.getPath();
                Intent in = new Intent(OrderMedicinesActivity.this, UploadPrescriptionActivity.class);
                in.putExtra("IMAGE", photo_path);
                startActivity(in);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
