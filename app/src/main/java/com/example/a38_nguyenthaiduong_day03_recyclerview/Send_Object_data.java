package com.example.a38_nguyenthaiduong_day03_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class Send_Object_data extends AppCompatActivity {

    EditText edtname, edtnumber;
    Button btngetinfor;
    Contact contact;
    Intent intent;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__object_data);

        edtname = findViewById(R.id.edtname);
        edtnumber = findViewById(R.id.edtnumber);
        btngetinfor = findViewById(R.id.btngetinfor);

        intent = getIntent();
        contact = (Contact) intent.getSerializableExtra("object");

        edtnumber.setText(contact.getNumber());
        edtname.setText(contact.getName());

        i = intent.getIntExtra("position", 100);
        btngetinfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString();
                String number = edtnumber.getText().toString();

                intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("inputname", name);
                intent.putExtra("inputnumber", number);
                intent.putExtra("edtposition", i);
                startActivity(intent);
            }
        });

    }
}
