package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;


import java.util.Random;

public class MainActivitytd extends AppCompatActivity {

    private Button btn1, truthBtn1, dareBtn1;
    private ImageView imgView1;
    private Random random = new Random();
    private int lastDirection;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_td);

        btn1 = findViewById(R.id.button1);
        truthBtn1 = findViewById(R.id.btn1);
        imgView1 = findViewById(R.id.imageView1);
        dareBtn1 = findViewById(R.id.btn2);

        truthBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TruthActivitytd.class));
            }
        });

        dareBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DareActivitytd.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn1.setEnabled(true);
        truthBtn1.setEnabled(false);
        dareBtn1.setEnabled(false);
    }

    public void spin(View view) {
        int newDirection = random.nextInt(5400);
        float pivotX = imgView1.getWidth()/2;
        float pivotY = imgView1.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mp = MediaPlayer.create(MainActivitytd.this, R.raw.audio);
                mp.start();
                btn1.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mp.stop();
                mp.release();
                mp = null;
                truthBtn1.setEnabled(true);
                dareBtn1.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        lastDirection = newDirection;
        imgView1.startAnimation(rotate);
    }
}
