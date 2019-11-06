package com.example.karyaseni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class reset extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText editEmail3;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        getSupportActionBar().hide();

        init();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail3.getText().toString();
                mAuth.sendPasswordResetEmail(email);
                Toast.makeText(getApplicationContext(), "Recovery Email has been  sent to " + email ,
                        Toast.LENGTH_LONG).show();
                editEmail3.setText("");
            }
        });

    }

    private void init(){
        mAuth = FirebaseAuth.getInstance();
        editEmail3 = findViewById(R.id.editEmail3);
        btnReset = findViewById(R.id.btnReset);
    }
}

