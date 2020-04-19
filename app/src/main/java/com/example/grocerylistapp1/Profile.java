package com.example.grocerylistapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {
    LinearLayout items, estimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        View add = findViewById(R.id.add);
        final TextInputLayout new_item = new TextInputLayout(Profile.this);
        final TextInputLayout new_cost = new TextInputLayout(Profile.this);
        final TextInputEditText new_item_child = new TextInputEditText(Profile.this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.addView(new_item);
                new_item.addView(new_item_child);
                estimate.addView(new_item);
                new_cost.addView(new_item_child);
            }
        });
        //    LinearLayout parentLayout = (LinearLayout)findViewById(R.id.body);
//    TextView textView = new TextView(Lists.this);
//    textView.setText("Child Row");
//    parentLayout.addView(textView);

    }
}
