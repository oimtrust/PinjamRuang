package com.oimtrust.pinjamruang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.oimtrust.pinjamruang.activity.ApproveLoginActivity;
import com.oimtrust.pinjamruang.activity.StaffLoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView staffText, approveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        staffText   = (TextView) findViewById(R.id.staff_btn);
        approveText = (TextView) findViewById(R.id.approve_btn);

        staffText.setOnClickListener(this);
        approveText.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog  = new AlertDialog.Builder(this);
        dialog.setTitle("Anda yakin akan keluar?");
        dialog.setCancelable(false)
                .setPositiveButton("Iya",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })
                .setNegativeButton("Tidak",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.staff_btn:
                staffButton();
                break;

            case R.id.approve_btn:
                approveButton();
                break;
        }
    }

    private void approveButton() {
        startActivity(new Intent(getApplicationContext(), ApproveLoginActivity.class));
    }

    private void staffButton() {
        startActivity(new Intent(getApplicationContext(), StaffLoginActivity.class));
    }
}
