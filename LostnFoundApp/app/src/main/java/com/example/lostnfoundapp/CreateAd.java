package com.example.lostnfoundapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CreateAd extends AppCompatActivity {
    EditText adNameInput, adDescriptionInput, adPhoneInput, adDateInput, adLocationInput;
    Button saveButton;
    private DBHelper dbHelper;
    private SQLiteDatabase database;
    RadioButton lostRadioButton, foundRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_ad);
        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        adNameInput = findViewById(R.id.name_input);
        adDescriptionInput = findViewById(R.id.description_input);
        adPhoneInput = findViewById(R.id.phone_input);
        adDateInput = findViewById(R.id.date_input);
        adLocationInput = findViewById(R.id.location_input);
        saveButton = findViewById(R.id.save_button);
        lostRadioButton = findViewById(R.id.radioButtonLost);
        foundRadioButton = findViewById(R.id.radioButtonFound);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataToDB();
            }
        });
    }

    private void addDataToDB() {
        String name = adNameInput.getText().toString();
        String description = adDescriptionInput.getText().toString();
        String phone = adPhoneInput.getText().toString();
        String date = adDateInput.getText().toString();
        String location = adLocationInput.getText().toString();
        String type = "";
        if(lostRadioButton.isChecked()) type = "lost";
        else if(foundRadioButton.isChecked()) type = "found";
        if(name.isEmpty() || description.isEmpty() || phone.isEmpty() || date.isEmpty() || location.isEmpty() || type.isEmpty()) {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("description", description);
        values.put("phone", phone);
        values.put("date", date);
        values.put("type", type);
        values.put("location", location);
        database.insert("my_table", null, values);
        Toast.makeText(this, "Advert created successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

}