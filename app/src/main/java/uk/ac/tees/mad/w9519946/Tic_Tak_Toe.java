package uk.ac.tees.mad.w9519946;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Tic_Tak_Toe extends AppCompatActivity {

    ImageView back, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private String gameStart = "O";
    int b1=5, b2=5, b3=5, b4=5, b5=5, b6=5, b7=5, b8=5, b9=5;
    int i=0, xCount=0, oCount=0;
    private TextView Xscore, Oscore;
    private Button Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tak_toe);

        Reset = findViewById(R.id.reset);

        btn1 = findViewById(R.id.btnImage1);
        btn2 = findViewById(R.id.btnImage2);
        btn3 = findViewById(R.id.btnImage3);
        btn4 = findViewById(R.id.btnImage4);
        btn5 = findViewById(R.id.btnImage5);
        btn6 = findViewById(R.id.btnImage6);
        btn7 = findViewById(R.id.btnImage7);
        btn8 = findViewById(R.id.btnImage8);
        btn9 = findViewById(R.id.btnImage9);
        back = findViewById(R.id.back);

        Xscore = findViewById(R.id.AlphaX);
        Oscore = findViewById(R.id.BetaY);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues();
                oCount=0;
                xCount=0;
                btn1.setImageDrawable(null);
                btn2.setImageDrawable(null);
                btn3.setImageDrawable(null);
                btn4.setImageDrawable(null);
                btn5.setImageDrawable(null);
                btn6.setImageDrawable(null);
                btn7.setImageDrawable(null);
                btn8.setImageDrawable(null);
                btn9.setImageDrawable(null);
                Xscore.setText("Score Alpha: ===> " + String.valueOf(xCount));
                Oscore.setText("Score Beta: ===> " + String.valueOf(oCount));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tic_Tak_Toe.this, ScrollActivity.class));
                finish();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn1.setImageResource(R.drawable.cross);
                    b1 = 1;
                    i++;
                }
                else
                {
                    btn1.setImageResource(R.drawable.circle);
                    b1 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn2.setImageResource(R.drawable.cross);
                    b2 = 1;
                    i++;
                }
                else
                {
                    btn2.setImageResource(R.drawable.circle);
                    b2 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn3.setImageResource(R.drawable.cross);
                    b3 = 1;
                    i++;
                }
                else
                {
                    btn3.setImageResource(R.drawable.circle);
                    b3 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn4.setImageResource(R.drawable.cross);
                    b4 = 1;
                    i++;
                }
                else
                {
                    btn4.setImageResource(R.drawable.circle);
                    b4 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn5.setImageResource(R.drawable.cross);
                    b5 = 1;
                    i++;
                }
                else
                {
                    btn5.setImageResource(R.drawable.circle);
                    b5 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn6.setImageResource(R.drawable.cross);
                    b6 = 1;
                    i++;
                }
                else
                {
                    btn6.setImageResource(R.drawable.circle);
                    b6 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn7.setImageResource(R.drawable.cross);
                    b7 = 1;
                    i++;
                }
                else
                {
                    btn7.setImageResource(R.drawable.circle);
                    b7 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn8.setImageResource(R.drawable.cross);
                    b8 = 1;
                    i++;
                }
                else
                {
                    btn8.setImageResource(R.drawable.circle);
                    b8 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStart.equals("X"))
                {
                    btn9.setImageResource(R.drawable.cross);
                    b9 = 1;
                    i++;
                }
                else
                {
                    btn9.setImageResource(R.drawable.circle);
                    b9 = 0;
                    i++;
                }
                playerSelection();
                gameWinner();

            }
        });
    }


    private void gameWinner(){


        if ((b1==1)&&(b2==1)&&(b3==1)){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }


        else if ((b7==1)&&(b8==1)&&(b9==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));
        }

        else if ((b3==1)&&(b5==1)&&(b7==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }


        else if ((b4==1)&&(b5==1)&&(b6==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }

        else if ((b1==1)&&(b5==1)&&(b9==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }


        else if ((b1==1)&&(b4==1)&&(b7==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }


        else if ((b2==1)&&(b5==1)&&(b8==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }

        else if ((b3==1)&&(b6==1)&&(b9==1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Alpha Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            Xscore.setText("Score Alpha : ===> " + String.valueOf(xCount));

        }



        else if ((b1==0)&&(b2==0)&&(b3==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));
        }


        else if ((b4==0)&&(b5==0)&&(b6==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }

        else if ((b7==0)&&(b8==0)&&(b9==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }



        else if ((b1==0)&&(b4==0)&&(b7==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }

        else if ((b2==0)&&(b5==0)&&(b8==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }


        else if ((b3==0)&&(b6==0)&&(b9==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }

        else if ((b1==0)&&(b5==0)&&(b9==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }

        else if ((b3==0)&&(b5==0)&&(b7==0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Player Beta Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    btn1.setImageDrawable(null);
                    btn2.setImageDrawable(null);
                    btn3.setImageDrawable(null);
                    btn4.setImageDrawable(null);
                    btn5.setImageDrawable(null);
                    btn6.setImageDrawable(null);
                    btn7.setImageDrawable(null);
                    btn8.setImageDrawable(null);
                    btn9.setImageDrawable(null);
                    resetValues();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            Oscore.setText("Score Beta : ===> " + String.valueOf(oCount));

        }


        else{
            if (i==9) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("No Player Wins the game").setCancelable(false).setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setImageDrawable(null);
                        btn2.setImageDrawable(null);
                        btn3.setImageDrawable(null);
                        btn4.setImageDrawable(null);
                        btn5.setImageDrawable(null);
                        btn6.setImageDrawable(null);
                        btn7.setImageDrawable(null);
                        btn8.setImageDrawable(null);
                        btn9.setImageDrawable(null);
                        resetValues();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }

    }

    private void playerSelection(){
        if (gameStart.equals("X")){
            gameStart="O";
        }
        else{
            gameStart="X";
        }
    }

    private void resetValues() {
        b1 = 5;
        b2 = 5;
        b3 = 5;
        b4 = 5;
        b5 = 5;
        b6 = 5;
        b7 = 5;
        b8 = 5;
        b9 = 5;
        i = 0;
    }



}