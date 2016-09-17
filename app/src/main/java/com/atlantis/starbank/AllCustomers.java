package com.atlantis.starbank;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class AllCustomers extends Activity{
    DatabaseHelper myDB;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.customers);
        myDB = new DatabaseHelper(this);
        viewAll();
    }
    public void viewAll() {
        EditText uname;
        uname=(EditText)findViewById(R.id.login_uname);
        Cursor res;
        res = myDB.getAllData(uname.getText().toString());
        if (res.getCount() == 0) {
            showMessage("Error", "No data found");
            return;
        } else {
            StringBuffer bf = new StringBuffer();
            while (res.moveToNext()) {
                bf.append("ID:"+res.getString(0)+ "\n");
                bf.append("First name:" + res.getString(1) + "\n");
                bf.append("Second name:" + res.getString(2) + "\n");
                bf.append("Username:" + res.getString(3) + "\n");
                bf.append("Email:" + res.getString(4) + "\n");
                bf.append("Gender:" + res.getString(6) + "\n");
                bf.append("Date of birth:" + res.getString(7) + "\n");
                bf.append("Residence:" + res.getString(8) + "\n");
            }
            showMessage("CUSTOMERS LIST", bf.toString());
        }
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(Message);
        b.show();
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
        Intent locations = new Intent(AllCustomers.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void homeActivity() {
        Intent home = new Intent(AllCustomers.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(AllCustomers.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(AllCustomers.this,LoginActivity.class);
        startActivity(login);
    }
    public void exitActivity() {
        finish();
    }

}
