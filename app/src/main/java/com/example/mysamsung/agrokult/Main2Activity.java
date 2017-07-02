package com.example.mysamsung.agrokult;

import android.content.ClipData;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;



public class Main2Activity extends AppCompatActivity {
    private Button btnLogout;
    private Session session;
    private Button btninterest;
    private Button btnbusiness;
    private Button btnprofile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnbusiness=(Button)findViewById(R.id.btnbusiness);
        btnbusiness.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                shift2();
            }
        });
        btnprofile=(Button)findViewById(R.id.btnprofile);
        btnprofile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                shift3();
            }
        });

        btninterest =(Button)findViewById(R.id.btninterest);
        btninterest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                shift();
            }

        });
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }



    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(Main2Activity.this,MainActivity.class));
    }
    public void shift (){
        startActivity(new Intent(Main2Activity.this,Personal.class));
    }
    public void shift2 (){
        Intent i = new Intent(this,business.class);
        startActivity(i);
    }
    public void shift3 (){
        Intent i = new Intent(this,interest.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_username){


           return true;
        }
        return true;

    }



}