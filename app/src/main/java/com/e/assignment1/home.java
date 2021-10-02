package com.e.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new first()).commit();

        bottomNavigationView =(BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment =null;



                switch (item.getItemId()){

                    case R.id.first:fragment= new first();break;

                    case R.id.second:fragment= new second(); break;
                    case R.id.third:fragment= new third(); break;
                    case R.id.forth:fragment= new forth(); break;


                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,fragment).commit();
                return true;
            }
        });



    }





    }
