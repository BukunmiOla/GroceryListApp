package com.example.grocerylistapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String nameText, mailText,slackText, passText;
    TextInputEditText name, mail, slack, pass;
    TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        slack = findViewById(R.id.slack);
        pass = findViewById(R.id.pass);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameText = name.getText().toString();
                mailText = mail.getText().toString();
                slackText = slack.getText().toString();
                passText = pass.getText().toString();
                go_to_list();
            }
        });
    }

    private void go_to_list(){
        Intent next = new Intent(MainActivity.this, Lists.class);
        next.putExtra("name",nameText);
        next.putExtra("mail", mailText);
        next.putExtra("slack",slackText);
        startActivity(next);
    }
}
