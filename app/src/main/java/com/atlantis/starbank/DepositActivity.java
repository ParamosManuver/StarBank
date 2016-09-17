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


public class DepositActivity extends Activity {
    EditText edit_deposit,usname;
    Button button_save;
    DatabaseHelper myDB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deposit);
        myDB=new DatabaseHelper(this);
        edit_deposit=(EditText)findViewById(R.id.deposit_amount);
        usname=(EditText)findViewById(R.id.deposit_uname);
        button_save=(Button)findViewById(R.id.deposit_deposit);


        AddDeposit();
    }
    public void AddDeposit(){
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=edit_deposit.getText().toString();
                int e2=Integer.parseInt(e1);
                boolean isInserted=myDB.insertDeposit(usname.getText().toString(),e2);
                if (isInserted==true){
                    Toast.makeText(DepositActivity.this,String.valueOf(e2)+" KSH saved",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(DepositActivity.this,"Money not saved",Toast.LENGTH_LONG).show();
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
        Intent locations = new Intent(DepositActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void homeActivity() {
        Intent home = new Intent(DepositActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(DepositActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(DepositActivity.this,LoginActivity.class);
        startActivity(login);
    }
    public void exitActivity() {
        finish();
    }
}
