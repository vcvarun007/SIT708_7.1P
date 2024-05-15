package com.example.lostnfoundapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ViewItem extends AppCompatActivity {
    TextView nameTextView, descriptionTextView, phoneTextView, locationTextView, dateTextView, typeTextView;
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_detail);
        dbHelper = new DBHelper(this);
        database = dbHelper.getWritableDatabase();
        nameTextView = findViewById(R.id.name_text);
        descriptionTextView = findViewById(R.id.description_text);
        phoneTextView = findViewById(R.id.phone_text);
        locationTextView = findViewById(R.id.location_text);
        dateTextView = findViewById(R.id.date_text);
        Intent intent = getIntent();
        String[] itemData = intent.getStringArrayExtra("itemData");
        nameTextView.setText("Name: " + itemData[1]);
        phoneTextView.setText("Phone: " + itemData[3]);
        descriptionTextView.setText("Description: " + itemData[2]);
        dateTextView.setText("Date: " + itemData[5]);
        locationTextView.setText("Location: " + itemData[4]);

        findViewById(R.id.remove_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.delete("my_table", "id = ?", new String[]{String.valueOf(itemData[0])});
                Toast.makeText(ViewItemActivity.this, "Item Deleted Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
