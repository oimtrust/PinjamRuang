package com.oimtrust.pinjamruang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.oimtrust.pinjamruang.MainActivity;
import com.oimtrust.pinjamruang.R;

public class StaffLoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login);

        registerButton    = (TextView)    findViewById(R.id.registerStaffLogin_button);

        registerButton.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerStaffLogin_button:
                registerStaffButton();
                break;
        }
    }

    private void registerStaffButton() {
        startActivity(new Intent(getApplicationContext(), StaffRegisterActivity.class));
    }
}
