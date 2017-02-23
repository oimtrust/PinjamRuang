package com.oimtrust.pinjamruang.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.oimtrust.pinjamruang.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StaffRegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Spinner editGender;
    TextView editBirthday, btnLoginHere;

    private DatePickerDialog mDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_register);

        String listGender[]   = {"-Pilih Gender-", "Laki-Laki","Perempuan"};

        editGender      = (Spinner)     findViewById(R.id.genderStaffRegister_spinner);
        editBirthday    = (TextView)    findViewById(R.id.birthdayStaffRegister_textview);
        btnLoginHere    = (TextView)    findViewById(R.id.loginStaffRegister_button);

        //Untuk membuat list gender
        ArrayAdapter<String> adapterListGender  = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listGender);
        adapterListGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editGender.setAdapter(adapterListGender);

        //Untuk menampilkan tanggal, inputan tanggal lahir
        dateFormatter   = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        setDateTimeField();

        //Kembali ke menu login
        btnLoginHere.setOnClickListener(this);
    }

    private void setDateTimeField() {
        editBirthday.setOnClickListener(this);

        Calendar newCalendar    = Calendar.getInstance();
        mDatePickerDialog       = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                editBirthday.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.birthdayStaffRegister_textview:
                mDatePickerDialog.show();
                break;

            case R.id.loginStaffRegister_button:
                startActivity(new Intent(getApplicationContext(), StaffLoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), StaffLoginActivity.class));
        finish();
    }
}
