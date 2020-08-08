package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    public EditText email1;
    public EditText pswd;
    public Button signup1;
    public FirebaseAuth mfire1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email1 = findViewById(R.id.editText2);
        pswd = findViewById(R.id.editText3);
        signup1 = findViewById(R.id.button);
        mfire1 = FirebaseAuth.getInstance();
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email1.getText().toString();
                String p = pswd.getText().toString();
                if (e.isEmpty()) {
                    email1.requestFocus();
                } else if (p.isEmpty()) {
                    pswd.requestFocus();
                } else if (!(e.isEmpty() && p.isEmpty())) {
                    mfire1.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(signup.this, "Sign up successfull", Toast.LENGTH_SHORT).show();
                                Intent I=new Intent(signup.this,login.class);
                                startActivity(I);


                            } else if (!(task.isSuccessful())) {
                                Toast.makeText(signup.this, "Sign up unsuccessfull", Toast.LENGTH_SHORT).show();
                            }
                        }


                    });

                }
            }
        });
    }
}

