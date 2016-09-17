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

public class CreateActivity extends Activity{
    EditText fname,sname,uname,email,pass,gender,dob,resid;
    Button save;
    DatabaseHelper myDB;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        myDB=new DatabaseHelper(this);
        fname=(EditText)findViewById(R.id.create_firstname);
        sname=(EditText)findViewById(R.id.create_secondname);
        uname=(EditText)findViewById(R.id.create_username);
        email=(EditText)findViewById(R.id.create_email);
        pass=(EditText)findViewById(R.id.create_password);
        gender=(EditText)findViewById(R.id.create_gender);
        dob=(EditText)findViewById(R.id.create_dob);
        resid=(EditText)findViewById(R.id.create_residence);
        save=(Button)findViewById(R.id.create_save);
        AddData();
    }
    public  void AddData(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted=myDB.insertData(fname.getText().toString(),sname.getText().toString(),uname.getText().toString(),email.getText().toString(),pass.getText().toString(),gender.getText().toString(),dob.getText().toString(),resid.getText().toString());
                if (isInserted==true){
                    Toast.makeText(CreateActivity.this,"Data Saved \n You are now a Member",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(CreateActivity.this,"Data not Saved \n try Again",Toast.LENGTH_LONG).show();

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
        Intent locations = new Intent(CreateActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void homeActivity() {
        Intent home = new Intent(CreateActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(CreateActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(CreateActivity.this,LoginActivity.class);
        startActivity(login);
    }
    public void exitActivity() {
        finish();
    }
}
