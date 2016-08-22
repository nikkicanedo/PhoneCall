package com.nikkay.canedo.phonecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText number;
    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.etPhoneNum);
        call = (Button) findViewById(R.id.btnCall);

        call.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+number.getText().toString()));
            startActivity(callIntent);
        }catch(SecurityException e){
            Toast.makeText(MainActivity.this, "Call Rejected", Toast.LENGTH_SHORT).show();
        }
    }
}