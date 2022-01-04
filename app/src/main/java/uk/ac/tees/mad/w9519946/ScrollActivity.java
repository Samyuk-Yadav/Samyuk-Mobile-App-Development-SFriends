package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ScrollActivity extends AppCompatActivity {
    private Button logout_button;
    SwitchCompat switchCompat_button;
    private Button tictaktoe_button;
    private Button truthanddare_button;
    SharedPreferences sharedPreferences = null;
    private Button notepad_button;
    private Button maps_button;
    private Button covid_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);



        sharedPreferences = getSharedPreferences("Night" , 0);
        Boolean booleanValue = sharedPreferences.getBoolean("Night_Mode", true);

        if(booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat_button.setChecked(true);
        }

        switchCompat_button = findViewById(R.id.switchCompat);

        switchCompat_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    switchCompat_button.setChecked(true);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("Night_Mode", true);
                    editor.commit();
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    switchCompat_button.setChecked(false);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("Night_Mode", false);
                    editor.commit();
                }
            }
        });

        logout_button = findViewById(R.id.logout);

        logout_button.setOnClickListener((v) -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Start_Activity.class));
        });
        tictaktoe_button = findViewById(R.id.btngames);

        tictaktoe_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollActivity.this, Tic_Tak_Toe.class));

            }
        });
        truthanddare_button = findViewById(R.id.truth_and_dare);

        truthanddare_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StartActivitytd.class));

            }
        });

        notepad_button = findViewById(R.id.notes);

        notepad_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollActivity.this, Notepad.class));

            }
        });
        maps_button = findViewById(R.id.maps);

        maps_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollActivity.this, MainActivityGM.class));
            }
        });
        covid_button = findViewById(R.id.covid);

        covid_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollActivity.this, MainActivityCovid.class ));
            }
        });


    }

}