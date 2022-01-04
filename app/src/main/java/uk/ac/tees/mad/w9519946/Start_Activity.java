package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Start_Activity extends AppCompatActivity {

    private Button register;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("StarActivity", "onCreate");
        setContentView(R.layout.activity_start);


        login = findViewById(R.id.login);

        login.setOnClickListener(v -> {
            startActivity(new Intent(Start_Activity.this, LoginActivity.class));
            finish();
        });

        register = findViewById(R.id.register);

        register.setOnClickListener(v -> {
            startActivity(new Intent(Start_Activity.this, RegisterActivity.class));
            finish();
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startActivity(new Intent(Start_Activity.this, ScrollActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
    }
}