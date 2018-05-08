package com.example.luke.lppassage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;
import com.journeyapps.barcodescanner.CaptureActivity;
import com.journeyapps.barcodescanner.ViewfinderView;

public class CameraActivity extends CaptureActivity {

    ViewfinderView barView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_camera);
        barView = (ViewfinderView)findViewById(R.id.zxing_viewfinder_view);
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Scan a ticket");
        integrator.setOrientationLocked(true);
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setBeepEnabled(false);
        integrator.initiateScan();
        super.onCreate(savedInstanceState);
    }
}
