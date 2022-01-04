package uk.ac.tees.mad.w9519946;

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

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth authentication;

    private EditText email_r;
    private TextView clickMe_r;

    private EditText password_r;
    private Button register_r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email_r = findViewById(R.id.Email_r);

        authentication = FirebaseAuth.getInstance();


        register_r = findViewById(R.id.register);

        password_r = findViewById(R.id.Password_r);



        register_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email_r.getText().toString();
                String txt_password = password_r.getText().toString();

                if (TextUtils.isEmpty(txt_email)|| TextUtils.isEmpty(txt_password)){
                    Toast.makeText(RegisterActivity.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length()<6){
                    Toast.makeText(RegisterActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else{
                    RegisterUser(txt_email, txt_password);
                }
            }
        });

        clickMe_r = findViewById(R.id.clickMe_r);

        clickMe_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }



    private void RegisterUser(String email, String password) {

        authentication.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Registering User Sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this , Start_Activity.class));
                    finish();

                } else{
                    Toast.makeText(RegisterActivity.this, "Registeration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}