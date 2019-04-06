package com.example.akshay.PollingApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        email = findViewById(R.id.editText);
        password  = findViewById(R.id.editText2);
        register = findViewById(R.id.button2);
        final String convertemail = email.getText().toString();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidEmail(convertemail)){
                    Intent i;
                    i =  new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);
                    finish();
                    // Do database thing;
                }
                else{
                    Toast.makeText(getApplicationContext(),"Not a valid email address",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public static boolean isValidEmail(String target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

}
