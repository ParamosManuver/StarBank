package com.atlantis.starbank;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity{
    Button abt,log,crt,ext,lct,us;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        abt=(Button)findViewById(R.id.home_about);
        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about=new Intent(HomeActivity.this,AboutActivity.class);
                startActivity(about);

            }
        });
        log=(Button)findViewById(R.id.home_login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login =new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(login);


            }
        });
        crt=(Button)findViewById(R.id.home_create);
        crt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create=new Intent(HomeActivity.this,CreateActivity.class);
                startActivity(create);

            }
        });
        ext=(Button)findViewById(R.id.home_exit);
        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lct=(Button)findViewById(R.id.home_locations);
        lct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loc=new Intent(HomeActivity.this,LocationsActivity.class);
                startActivity(loc);
            }
        });
        us=(Button)findViewById(R.id.home_us);
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAll();
            }
        });


    }
    public void viewAll(){
        StringBuffer bf=new StringBuffer();
        bf.append("Head Office" + "\n");
        bf.append("NAIROBI"+"\n");
        bf.append("Star Bank Plaza" + "\n");
        bf.append("Phone:+25472090654"+"\n");
        bf.append("Email:info@starbank.com" + "\n");
        bf.append("Facebook:Star_bank"+"\n");
        bf.append("Instagram:@Star_bank" + "\n");
        showMessage("Contacts Us", bf.toString());
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                homeActivity();
                return true;
            case R.id.menu_about:
                aboutActivity();
                return true;
            case R.id.menu_login:
                loginActivity();
                return true;
            case R.id.menu_exit:
                exitActivity();
            case R.id.menu_locations:
                locationActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void locationActivity() {
        Intent locations = new Intent(HomeActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void homeActivity() {
        Intent home = new Intent(HomeActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(HomeActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(login);
    }
    public void exitActivity() {
        finish();
    }
}
