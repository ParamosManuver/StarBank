package com.atlantis.starbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MembersActivity extends Activity {
    Button vw,dpst,apply;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.members);
        vw=(Button)findViewById(R.id.member_view);
        vw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(MembersActivity.this, AllCustomers.class);
                startActivity(view);
            }
        });
        dpst=(Button)findViewById(R.id.member_deposit);
        dpst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deposit=new Intent(MembersActivity.this,DepositActivity.class);
                startActivity(deposit);
            }
        });
        apply=(Button)findViewById(R.id.member_apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apply=new Intent(MembersActivity.this,LoanActivity.class);
                startActivity(apply);
            }
        });

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
            case R.id.menu_locations:
                locationActivity();
            case R.id.menu_exit:
                exitActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void homeActivity() {
        Intent home = new Intent(MembersActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(MembersActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(MembersActivity.this, LoginActivity.class);
        startActivity(login);
    }
    public void locationActivity() {
        Intent locations = new Intent(MembersActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void exitActivity() {
        finish();
    }
}

