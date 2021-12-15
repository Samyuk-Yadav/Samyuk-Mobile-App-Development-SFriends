package uk.ac.tees.mad.w9519946;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splashscreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    Animation topAnim , sideAnim, bottomAnim;
    ImageView image;
    SharedPreferences preferenceshared;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Splashscreen", "onCreate");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.splashscreen);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animations);
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_animations);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animations);

        image = findViewById(R.id.image);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        logo.setAnimation(sideAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                preferenceshared = getSharedPreferences("Screen_introduction", MODE_PRIVATE);
                boolean userTimeOne = preferenceshared.getBoolean("userTimeOne", true);

                if(userTimeOne) {
                    SharedPreferences.Editor editor = preferenceshared.edit();
                    editor.putBoolean("userTimeOne",false);
                    editor.commit();

                    startActivity(new Intent(Splashscreen.this, Introduction.class));
                    finish();
                }
                else {
                    startActivity(new Intent(Splashscreen.this, Start_Activity.class));
                    finish();
                }
            }
        } ,SPLASH_SCREEN);
    }
}