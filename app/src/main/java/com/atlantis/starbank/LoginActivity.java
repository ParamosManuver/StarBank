package com.atlantis.starbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity {
    Button login;
    DatabaseHelper myDB;
    EditText pass,uname;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login=(Button)findViewById(R.id.login_button);
        pass=(EditText)findViewById(R.id.login_pass);
        uname=(EditText)findViewById(R.id.login_uname);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myDB = new DatabaseHelper(LoginActivity.this);
                    String s_name=uname.getText().toString();
                    String stored_name=myDB.getUser(s_name);
                    String s_pass = pass.getText().toString();
                    String stored_pass = myDB.getPass(s_pass);
                    if (s_pass.equals(stored_pass) && (s_name.equals(stored_name))) {
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                        Intent club = new Intent(LoginActivity.this,MembersActivity.class);
                        startActivity(club);
                    }
                    else Toast.makeText(LoginActivity.this,"Unsuccessful",Toast.LENGTH_LONG).show();

                }
                finally {
                    finish();
                }
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
            case R.id.menu_exit:
                exitActivity();
            case R.id.menu_locations:
                locationActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void locationActivity() {
        Intent locations = new Intent(LoginActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void homeActivity() {
        Intent home = new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(LoginActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(LoginActivity.this,LoginActivity.class);
        startActivity(login);
    }
    public void exitActivity() {
        finish();
    }
}
