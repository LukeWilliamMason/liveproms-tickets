package com.example.luke.lppassage;

import android.content.Intent;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button logoutButton, scanButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutButton = (Button)findViewById(R.id.logoutButton);
        scanButton = (Button)findViewById(R.id.scanButton);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        logoutButton.setOnClickListener(this);
        scanButton.setOnClickListener(this);

    }

    @Override
   public void onClick(View view){
        {
            if (view == logoutButton){
                    SharedPrefManager.getInstance(this).logout();
                    finish();
                    startActivity(new Intent(this, LoginActivity.class));
            }
            if (view == scanButton){
                startActivity(new Intent(this,CameraActivity.class));
            }
        }
    }



}
