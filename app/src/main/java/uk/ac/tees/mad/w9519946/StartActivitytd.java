package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class StartActivitytd extends AppCompatActivity {

    private Button dare;
    private Button start_spin12;
    private Button truth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("StartActivitytd", "onCreate");
        setContentView(R.layout.activity_start_td);


        truth = findViewById(R.id.truth1);

        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TruthActivitytd.class));
            }
        });

        start_spin12 = findViewById(R.id.start_12spin);

        start_spin12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivitytd.class));
            }
        });

        dare = findViewById(R.id.dare1);

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DareActivitytd.class));
            }
        });

    }
}