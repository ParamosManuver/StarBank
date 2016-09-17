package com.atlantis.starbank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread splashTimer=new Thread(){
            public void run(){
                try{
                    sleep(2000);

                    Intent home=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(home);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{  finish(); }
            }
        };
        splashTimer.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}


