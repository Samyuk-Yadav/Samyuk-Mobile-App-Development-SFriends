package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import HelperClasses.Slider_Adapter;

public class Introduction extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    int position_current;

    Slider_Adapter slider_adapter;
    Button start;

    TextView[] dots;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Introduction", "onCreate");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_introduction);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.scroll);
        start = findViewById(R.id.start_let);

        //Adapter Calling
        slider_adapter = new Slider_Adapter(this);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
        viewPager.setAdapter(slider_adapter);
    }

    public void nxt(View view){
        viewPager.setCurrentItem(position_current+1);
    }


    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), Start_Activity.class));
        finish();
    }

    private void addDots(int position){

        dotsLayout.removeAllViews();
        dots = new TextView[6];

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);

        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }


    }

    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            position_current = position;
            if (position == 0) {
                start.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                start.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                start.setVisibility(View.INVISIBLE);
            } else if (position == 3) {
                start.setVisibility(View.INVISIBLE);
            } else if (position == 4) {
                start.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(Introduction.this, R.anim.bottom_animations);
                start.setAnimation(animation); start.setVisibility(View.VISIBLE);
            }
        }


        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };
}