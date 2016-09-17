package com.atlantis.starbank;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutActivity extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
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
        Intent locations = new Intent(AboutActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void homeActivity() {
        Intent home = new Intent(AboutActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(AboutActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(AboutActivity.this,LoginActivity.class);
        startActivity(login);
    }
    public void exitActivity() {
        finish();
    }
}

