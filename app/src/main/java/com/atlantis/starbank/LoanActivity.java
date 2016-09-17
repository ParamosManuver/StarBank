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

public class LoanActivity extends Activity {
    EditText usname,loan;
    Button apply;
    DatabaseHelper myDB;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan);
        myDB=new DatabaseHelper(this);
        loan=(EditText)findViewById(R.id.loan_amount);
        usname=(EditText)findViewById(R.id.loan_uname);
        apply=(Button)findViewById(R.id.loan_loan);
        AddLoan();


    }
    public void AddLoan(){
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=loan.getText().toString();
                int e2=Integer.parseInt(e1);
                boolean isInserted=myDB.insertLoan(usname.getText().toString(),e2);
                if (isInserted==true){
                    Toast.makeText(LoanActivity.this, String.valueOf(e2) + " KSH loan borrowed", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoanActivity.this,"Loan not processed",Toast.LENGTH_LONG).show();
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
            case R.id.menu_locations:
                locationActivity();
            case R.id.menu_exit:
                exitActivity();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void homeActivity() {
        Intent home = new Intent(LoanActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(LoanActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(LoanActivity.this, LoginActivity.class);
        startActivity(login);
    }
    public void locationActivity() {
        Intent locations = new Intent(LoanActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void exitActivity() {
        finish();
    }
}

