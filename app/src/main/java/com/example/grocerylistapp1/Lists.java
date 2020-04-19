package com.example.grocerylistapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.textview.MaterialTextView;

public class Lists extends AppCompatActivity {
    ImageView add, done;
    String name, mail, slack, info, total;
    int total_estimate;
    MaterialTextView nameText, mailText;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);


        Intent text = getIntent();
        name = text.getExtras().getString("name");
        mail = text.getExtras().getString("mail");
        slack = text.getExtras().getString("slack");
        info = "Hi! " + name +"\nEmail:"+ mail + "\nSlack-Id"+slack+ "\nYour List items are";
        total = "Your total cost is: "+total_estimate;


        mailText = findViewById(R.id.mail);
        nameText = findViewById(R.id.name);
        mailText.setText(mail);
        nameText.setText(name);




        done = findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
            }
        });



       }
        private void create(){
            Intent add = new Intent(Lists.this,FinalList.class);
            add.putExtra("info",info);
            add.putExtra("total",total);
            startActivity(add);


        }
        }
