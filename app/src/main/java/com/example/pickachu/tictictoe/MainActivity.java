package com.example.pickachu.tictictoe;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private int turn=0,GameState[]={10,10,10,10,10,10,10,10,10},end=0,spin1=0,spin2=0;
   //10 is just a default value

//Setting images and Changing turns

    public void ImageTapped(View view)
    {

        ImageView mytapped = (ImageView) view;
        int Tag = Integer.parseInt(mytapped.getTag().toString());


        if(GameState[Tag]==10&&end==0) {


            if (turn == 0) {
                mytapped.setImageResource(R.drawable.cross);
                mytapped.animate().rotation(spin1+=360).setDuration(800);
                turn = 1;
                GameState[Tag]=100;
            } else if (turn == 1) {
                mytapped.setImageResource(R.drawable.circle);
                mytapped.animate().rotationX(spin2+=360).setDuration(800);
                turn = 0;
                GameState[Tag]=200;
            }
        }
        else{
            if(end!=1) {
                Toast.makeText(MainActivity.this, "This place is already filled", Toast.LENGTH_SHORT).show();
            }
        }
        win("'X' Wins",100);
        win("'O' Wins",200);

    }

    //Resetting Logic

   public void PlayAgain(View view)
   {

       turn=0;
       end=0;

       for (int i=0;i<GameState.length;i++) {

           GameState[i]=10;
       }

    LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.LL1);

    for (int i = 0; i < linearLayout1.getChildCount(); i++) {
        ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
    }

       LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.LL2);

       for (int i = 0; i < linearLayout2.getChildCount(); i++) {
           ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
       }

       LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.LL3);

       for (int i = 0; i < linearLayout3.getChildCount(); i++) {
           ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
       }

}

    public void win(String s,int val) {

           if (     GameState[0] == GameState[1] && GameState[1] == GameState[2] && GameState[2] ==  val
                   ||GameState[3] == GameState[4] && GameState[4] == GameState[5] && GameState[5] == val
                   ||GameState[6] == GameState[7] && GameState[7] == GameState[8] && GameState[8] == val
                   ||GameState[0] == GameState[3] && GameState[3] == GameState[6] && GameState[6] == val
                   ||GameState[1] == GameState[4] && GameState[4] == GameState[7] && GameState[7] == val
                   ||GameState[2] == GameState[5] && GameState[5] == GameState[8] && GameState[8] == val
                   ||GameState[0] == GameState[4] && GameState[4] == GameState[8] && GameState[8] == val
                   ||GameState[2] == GameState[4] && GameState[4] == GameState[6] && GameState[6] == val
                    ) {
                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage(s)
                        .setPositiveButton("Ok",null)
                        .show();
                end=1;
            }
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(1);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
