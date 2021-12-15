package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ScrollActivity extends AppCompatActivity {
    private Button logout;
    private Button tictaktoe;
    private Button truthanddare;
    private Button notepad;
    SwitchCompat switchCompat;
    SharedPreferences sharedPreferences = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        tictaktoe= findViewById(R.id.btngames);
        notepad = findViewById(R.id.notes);
        truthanddare = findViewById(R.id.truth_and_dare);
        switchCompat = findViewById(R.id.switchCompat);


        sharedPreferences = getSharedPreferences("Night" , 0);
        Boolean booleanValue = sharedPreferences.getBoolean("Night_Mode", true);

        if(booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat.setChecked(true);
        }

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switchCompat.setChecked(true);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("Night_Mode", true);
                    editor.commit();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switchCompat.setChecked(false);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("Night_Mode", false);
                    editor.commit();
                }
            }
        });





        logout = findViewById(R.id.logout);

        logout.setOnClickListener((v) -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Start_Activity.class));
        });

        tictaktoe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollActivity.this, Tic_Tak_Toe.class));

            }
        });

        truthanddare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StartActivitytd.class));

            }
        });

        notepad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollActivity.this, Notepad.class));

            }
        });


    }

}