package com.e.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button register,login;
    EditText name,email,password;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        register=(Button)findViewById(R.id.openaccount);
        login=(Button)findViewById(R.id.login);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pass);

        fauth=FirebaseAuth.getInstance();
        if(fauth.getCurrentUser()!=null)
        {
            Toast.makeText(this, "already logged in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), home.class));

        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail,pass,namee;
                mail=email.getText().toString().trim();
                pass=password.getText().toString().trim();
                namee=name.getText().toString().trim();

                if(TextUtils.isEmpty(mail))
                {
                    Toast.makeText(MainActivity.this, "please enter email", Toast.LENGTH_SHORT).show();
                }

                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(MainActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(namee))
                {
                    Toast.makeText(MainActivity.this, "please enter name", Toast.LENGTH_SHORT).show();
                }


                fauth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "user created", Toast.LENGTH_SHORT).show();

                        } else
                        {
                            Toast.makeText(MainActivity.this, "error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), com.e.assignment1.login.class));

            }
        });
    }


}