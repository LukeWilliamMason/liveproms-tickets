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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.google.zxing.qrcode.encoder.QRCode;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


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
                scanQR(view);
            }
        }
    }

    public void scanQR(View view){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats();
        integrator.setPrompt("Scan a barcode");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setOrientationLocked(true);
        integrator.setBeepEnabled(false);
        integrator.setCaptureActivity(CameraActivity.class);
        integrator.initiateScan();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
        if(result.getContents()==null){
            Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, result.getContents(),Toast.LENGTH_LONG).show();
            validate(result.getContents().toString());
        }
    }
        else {
        super.onActivityResult(requestCode, resultCode, data);
    }
}

public void validate(final String code){

    StringRequest stringRequest = new StringRequest(
            Request.Method.POST,
            Constants.URL_SCAN,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject obj = new JSONObject(response);
                        if(!obj.getBoolean("error")){
                            SharedPrefManager.getInstance(getApplicationContext())
                                    .scan(
                                            obj.getString("code")
                                    );
                            Toast.makeText(getApplicationContext(),"Valid", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(
                                    getApplicationContext(),
                                    obj.getString("message"),
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(
                            getApplicationContext(),
                            "error",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
    ){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("code", code);
            return params;
        }

    };

    RequestHandler.getInstance(this).addToRequestQueue(stringRequest);
}

}

