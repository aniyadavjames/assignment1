package com.e.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    Button login;
    EditText email,password;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login=(Button)findViewById(R.id.login);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pass);

        fauth=FirebaseAuth.getInstance();


         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String mail,pass,namee;
                 mail=email.getText().toString().trim();
                 pass=password.getText().toString().trim();


                 if(TextUtils.isEmpty(mail))
                 {
                     Toast.makeText(login.this, "please enter email", Toast.LENGTH_SHORT).show();
                 }

                 if(TextUtils.isEmpty(pass))
                 {
                     Toast.makeText(login.this, "please enter password", Toast.LENGTH_SHORT).show();
                 }

                 fauth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {

                         if(task.isSuccessful())
                         {
                             Toast.makeText(login.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                             startActivity(new Intent(getApplicationContext(), home.class));
                         }
                         else
                             {
                                 Toast.makeText(login.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                             }

                     }
                 });
             }
         });



            }
}