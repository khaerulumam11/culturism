package com.example.khaerulumam.culturism;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistrasiActivity extends AppCompatActivity {

    private TextInputLayout email1,nama,pass, retypepass;
    private Button regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        email1 = findViewById(R.id.email);
        nama = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        retypepass = findViewById(R.id.repassword);
        regis = findViewById(R.id.btn_regis);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrasi();
            }
        });

    }

    private void registrasi() {
        String gmail = email1.getEditText().getText().toString();
        String name = nama.getEditText().getText().toString();
        String pass1 = pass.getEditText().getText().toString();
        String repass1 = retypepass.getEditText().getText().toString();

        if(!isValidateEmail(gmail)){
            Toast.makeText(this, "Email kosong atau salah",Toast.LENGTH_LONG).show();
        }else if(!isEmptyField(pass1)){
            Toast.makeText(this, "Password harus diisi",Toast.LENGTH_LONG).show();
        }else if(!isEmptyField(name)){
            Toast.makeText(this, "Nama harus diisi",Toast.LENGTH_LONG).show();
        }else if(!isEmptyField(repass1)){
            Toast.makeText(this, "Retype password harus diisi",Toast.LENGTH_LONG).show();
        }else if(!isMatch(pass1,retypepass)){
            Toast.makeText(this, "Password tidak cocok",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Register Berhasil",Toast.LENGTH_LONG).show();
        }
    }

    private boolean isMatch(String pass1, TextInputLayout retypepass) {
        return pass1.equals(retypepass);
    }

    private boolean isEmptyField(String pass1) {
        return !TextUtils.isEmpty(pass1);
    }

    private boolean isValidateEmail(String gmail) {
        return !TextUtils.isEmpty(gmail)&& Patterns.EMAIL_ADDRESS.matcher(gmail).matches();
    }
}
