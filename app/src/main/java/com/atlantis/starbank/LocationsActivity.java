package com.atlantis.starbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class LocationsActivity extends Activity {
    ListView locList;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList=new ArrayList();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locations);
        locList=(ListView)findViewById(R.id.location_list);
        mArrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,mNameList);
        mArrayAdapter.add("Star Bank-Nairobi,Kenya" + "\n" +"Biashara Street"+ "\n" +
                "P.O. BOX 1212-0100" + "\n" + "Nairobi"+"\n"+"Open Hours"+"\n"+
                "Mon-Fri 8 to 5"+"\n"+"Sat 9 to 12");

        mArrayAdapter.add("Star Bank-Kigali,Rwanda" + "\n" +"Makongole Road"+ "\n" +
                "P.O. BOX 1212-0100" + "\n" + "Kigali"+"\n"+"Open Hours"+"\n"+
                "Mon-Fri 8 to 5"+"\n"+"Sat 9 to 12");

        mArrayAdapter.add("Star Bank-Kampala,Uganda" + "\n" +"Museveni Road"+ "\n" +
                "P.O. BOX 09-0100" + "\n" + "Kampala"+"\n"+"Open Hours"+"\n"+
                "Mon-Fri 8 to 5"+"\n"+"Sat 9 to 12");

        mArrayAdapter.add("Star Bank-Kiambu,Kenya" + "\n" +"Kiambu Street"+ "\n" +
                "P.O. BOX 96-0900" + "\n" + "Kiambu"+"\n"+"Open Hours"+"\n"+
                "Mon-Fri 8 to 5"+"\n"+"Sat 9 to 12");

        locList.setAdapter(mArrayAdapter);

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
        Intent home = new Intent(LocationsActivity.this,HomeActivity.class);
        startActivity(home);
    }
    public void aboutActivity() {
        Intent about = new Intent(LocationsActivity.this,AboutActivity.class);
        startActivity(about);
    }
    public void loginActivity() {
        Intent login = new Intent(LocationsActivity.this, LoginActivity.class);
        startActivity(login);
    }
    public void locationActivity() {
        Intent locations = new Intent(LocationsActivity.this,LocationsActivity.class);
        startActivity(locations);
    }
    public void exitActivity() {
        finish();
    }
}
