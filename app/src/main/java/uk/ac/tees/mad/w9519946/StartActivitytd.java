package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class StartActivitytd extends AppCompatActivity {

    private Button dare;
    private Button start_spin;
    private Button truth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("StartActivitytd", "onCreate");
        setContentView(R.layout.activity_start_td);

        start_spin = findViewById(R.id.start_spin);
        truth = findViewById(R.id.truth);
        dare = findViewById(R.id.dare);



        start_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivitytd.class));
            }
        });

        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TruthActivitytd.class));
            }
        });

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DareActivitytd.class));
            }
        });

    }
}