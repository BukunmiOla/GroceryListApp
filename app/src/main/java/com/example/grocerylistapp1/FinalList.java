package com.example.grocerylistapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class FinalList extends AppCompatActivity {

    ImageView share;
    ListView item_list;
    List item = new ArrayList();
    ArrayAdapter items_adapter;
    String name,  total;
    int total_estimate;
    MaterialTextView infoText, totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_list);

        item_list= findViewById(R.id.items);

        item.add("Butter");
        item.add("Cheese");
        item.add("Tissue");
        item.add("Brush");
        item.add("Bread");
        item.add("Snickers");
        item.add("Toothpaste");

        items_adapter= new ArrayAdapter(FinalList.this, android.R.layout.simple_list_item_1, item);

        item_list.setAdapter(items_adapter);
        total_estimate = 6400;

        Intent text = getIntent();
        name = text.getExtras().getString("info");
        total = "Your total cost is: "+total_estimate;

        infoText = findViewById(R.id.name);
        totalText = findViewById(R.id.total);
        infoText.setText(name);
        totalText.setText(total);

        share =  findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    protected void sendEmail() {
        Log.i("Profile email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Profile mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(FinalList.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
