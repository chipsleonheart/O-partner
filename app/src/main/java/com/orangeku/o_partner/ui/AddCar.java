package com.orangeku.o_partner.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orangeku.o_partner.R;
import com.orangeku.o_partner.model.Mobil;

public class AddCar extends AppCompatActivity {

    private EditText no_stnk, jenis_mobil, merk_mobil, bbm ;
    private FirebaseDatabase db;
    private DatabaseReference mRef;
    private ProgressBar progressBar;
    private Button btnSignup, btnSave, btnReset;
    private Mobil mobil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // set the view now
        setContentView(R.layout.add_car);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        no_stnk = (EditText) findViewById(R.id.no_stnk);
        jenis_mobil = (EditText) findViewById(R.id.jenis_mobil);
        merk_mobil = (EditText) findViewById(R.id.merk_mobil);
        bbm = (EditText) findViewById(R.id.bbm);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnReset = (Button) findViewById(R.id.btn_reset_password);
        db = FirebaseDatabase.getInstance();
        mRef = db.getReference("mobil");


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                saveNewMobil(no_stnk.getText().toString(),jenis_mobil.getText().toString(),merk_mobil.getText().toString(),Integer.parseInt(bbm.getText().toString()));
                progressBar.setVisibility(View.GONE);
                Toast.makeText(AddCar.this,getString(R.string.save_succses),Toast.LENGTH_LONG).show();
                clearEditText();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddCar.this, ResetPasswordActivity.class));
            }
        });


    }

    private void saveNewMobil(String nostnk, String jnsmobil, String merk, int bbml){
        mobil = new Mobil(nostnk,jnsmobil,merk,bbml);

        mRef.child(nostnk).setValue(mobil);
    }
    private void clearEditText(){
        no_stnk.setText("");
        jenis_mobil.setText("");
        merk_mobil.setText("");
        bbm.setText("");

    }
}