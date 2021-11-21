package com.example.jobx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SignUpPhone extends AppCompatActivity {
    Button btnNext;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_phone);

        btnNext = findViewById(R.id.btnNext);
        phone = findViewById(R.id.phone);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkPhone()) {
                    return;
                }

                //change here for final build
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+977" + phone.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        SignUpPhone.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                Toast.makeText(SignUpPhone.this, "Verified", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(SignUpPhone.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String backendOTP, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                Intent intent = new Intent(getApplicationContext(), SignUpOTP.class);
                                intent.putExtra("mobile", phone.getText().toString());
                                intent.putExtra("otp",backendOTP);
                                startActivity(intent);
                            }
                        }
                );


                /*Intent intent = new Intent(getApplicationContext(), SignUpOTP.class);
                intent.putExtra("mobile", phone.getText().toString());
                startActivity(intent);*/
            }
        });
    }

    private boolean checkPhone() {
        String phoneVal = phone.getText().toString().toLowerCase(Locale.ROOT);
        if (phoneVal.length() != 10) {
            phone.setError("Please fill the field correctly ");
            return false;
        } else {
            phone.setError(null);
            return true;
        }
    }
}