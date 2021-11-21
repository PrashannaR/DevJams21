package com.example.jobx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUpOTP extends AppCompatActivity {

    Button btnNext;

    EditText input1, input2, input3, input4, input5, input6;
    TextView resend;

    String getOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_otp);

        btnNext = findViewById(R.id.btnNext);

        resend = findViewById(R.id.resend);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        input6 = findViewById(R.id.input6);

        getOTP = getIntent().getStringExtra("otp");


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!checkOTPOne() || !checkOTPTwo() || !checkOTPThree() || !checkOTPFour() || !checkOTPFive() || !checkOTPSix()) {
                    return;
                }

                if (!input1.getText().toString().isEmpty() && !input2.getText().toString().isEmpty() && !input3.getText().toString().isEmpty() &&
                        !input4.getText().toString().isEmpty() && !input5.getText().toString().isEmpty() && !input6.getText().toString().isEmpty()) {
                    String enterOTP = input1.getText().toString() +
                            input2.getText().toString() +
                            input3.getText().toString() +
                            input4.getText().toString() +
                            input5.getText().toString() +
                            input6.getText().toString();
                    if (getOTP != null) {
                        Toast.makeText(getApplicationContext(), "Wait", Toast.LENGTH_SHORT).show();

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getOTP, enterOTP);

                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(getApplicationContext(), SignUpDetails.class);
                                             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(SignUpOTP.this, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    } else {
                        Toast.makeText(getApplicationContext(), "An error occurred, Please Retry", Toast.LENGTH_SHORT).show();
                    }

                }

                startActivity(new Intent(getApplicationContext(), SignUpDetails.class));


            }
        });

        OPTMove();

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+977" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        SignUpOTP.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                Toast.makeText(SignUpOTP.this, "Verified", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(SignUpOTP.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newBackendOTP, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                getOTP = newBackendOTP;
                                Toast.makeText(SignUpOTP.this, "OTP Sent Successfully", Toast.LENGTH_SHORT).show();

                            }
                        }
                );
            }
        });
    }

    private void OPTMove() {
        input1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        input5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()) {
                    input6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    private boolean checkOTPOne() {
        String one = input1.getText().toString().trim();
        if (one.isEmpty()) {
            input1.setError("Fill in the OTP");
            return false;
        } else {
            input1.setError(null);
            return true;
        }


    }

    private boolean checkOTPTwo() {
        String two = input2.getText().toString().trim();
        if (two.isEmpty()) {
            input2.setError("Fill in the OTP");
            return false;
        } else {
            input2.setError(null);
            return true;
        }


    }

    private boolean checkOTPThree() {
        String three = input3.getText().toString().trim();
        if (three.isEmpty()) {
            input3.setError("Fill in the OTP");
            return false;
        } else {
            input3.setError(null);
            return true;
        }


    }

    private boolean checkOTPFour() {
        String four = input4.getText().toString().trim();
        if (four.isEmpty()) {
            input4.setError("Fill in the OTP");
            return false;
        } else {
            input4.setError(null);
            return true;
        }


    }

    private boolean checkOTPFive() {
        String five = input5.getText().toString().trim();
        if (five.isEmpty()) {
            input5.setError("Fill in the OTP");
            return false;
        } else {
            input5.setError(null);
            return true;
        }


    }

    private boolean checkOTPSix() {
        String six = input6.getText().toString().trim();
        if (six.isEmpty()) {
            input6.setError("Fill in the OTP");
            return false;
        } else {
            input6.setError(null);
            return true;
        }


    }


}