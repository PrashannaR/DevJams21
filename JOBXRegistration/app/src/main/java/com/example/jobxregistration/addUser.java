package com.example.jobxregistration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addUser extends AppCompatActivity {
    public static final int CAMERA_PERMISSION_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;

    Button btnNext;
    ImageView addPhoto;
    EditText userName, address, phone, aadahar;
    String currentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        btnNext = findViewById(R.id.btnNext);
        addPhoto = findViewById(R.id.addPhoto);
        userName = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        aadahar = findViewById(R.id.aadhaar);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkName() || !checkAddress() || !checkPhone() || !checkAadhar()){
                    return;
                }

                //get values
                String user = userName.getText().toString();
                String add = address.getText().toString();
                String ph = phone.getText().toString();
                String aadh = aadahar.getText().toString();

                Intent intent = new Intent(addUser.this, workDetails.class);
                //stores values
                intent.putExtra("User", user);
                intent.putExtra("Address", add);
                intent.putExtra("phone", ph);
                intent.putExtra("aadhar", aadh);
                intent.putExtra("photo", currentPhotoPath);

                startActivity(intent);

            }
        });

        //open camera
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               cameraPermission();
            }
        });
    }

    //check camera permission
    private void cameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        }else {
           // openCamera();
            dispatchTakePictureIntent();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == CAMERA_PERMISSION_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //openCamera();
                dispatchTakePictureIntent();
            }else {
                Toast.makeText(this, "Camera needs permission", Toast.LENGTH_SHORT).show();
            }
        }
    }


    //thumbnail
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST_CODE){
           // Bitmap image = (Bitmap) data.getExtras().get("data");
            //addPhoto.setImageBitmap(image);

            if(resultCode == Activity.RESULT_OK){
                File f = new File(currentPhotoPath);
                addPhoto.setImageURI(Uri.fromFile(f));
                Log.d("cam", "URL: " + Uri.fromFile(f));

            }
        }
    }



    //image storage
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    //image capture
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent,CAMERA_REQUEST_CODE );
            }
        }
    }




















    private boolean checkName(){
        String nameValue = userName.getText().toString().trim();
        if(nameValue.isEmpty()){
            userName.setError("Please enter the name");
            return false;
        }else {
            userName.setError(null);
            return true;
        }
    }

    private boolean checkAddress(){
        String addValue = address.getText().toString().trim();
        if(addValue.isEmpty()){
            address.setError("Please enter the name");
            return false;
        }else {
            address.setError(null);
            return true;
        }
    }

    private boolean checkPhone(){
        String phoneValue = phone.getText().toString().trim();
        if(phoneValue.isEmpty()){
            phone.setError("Please enter the name");
            return false;
        }else {
            phone.setError(null);
            return true;
        }
    }
    private boolean checkAadhar(){
        String aadharValue = aadahar.getText().toString().trim();
        if(aadharValue.isEmpty()){
            aadahar.setError("Please enter the name");
            return false;
        }else {
            aadahar.setError(null);
            return true;
        }
    }
}