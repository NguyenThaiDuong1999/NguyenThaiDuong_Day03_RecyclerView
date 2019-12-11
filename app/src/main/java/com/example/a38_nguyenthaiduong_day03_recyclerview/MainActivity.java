package com.example.a38_nguyenthaiduong_day03_recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contact> contacts;
    Contact contact1, contact2, contact3, contact4, contact5;
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);
        contacts = new ArrayList<>();

        contact1 = new Contact("Mr A", "111");
        contact2 = new Contact("Mr B", "112");
        contact3 = new Contact("Mr C", "113");
        contact4 = new Contact("Mr D", "114");
        contact5 = new Contact("Mr E", "115");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 3, LinearLayoutManager.HORIZONTAL, false);

        contactAdapter = new ContactAdapter(contacts);

        contactAdapter.setIonClickContact(new IonClickContact() {
            @Override
            public void onClickName(String name) {
                Toast.makeText(getBaseContext(), "Name: "+name, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onClickNumber(Contact contact, int i) {
                intent = new Intent(getBaseContext(), Send_Object_data.class);
                intent.putExtra("object", contact);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(layoutManager);

        intent = getIntent();
        String name = intent.getStringExtra("inputname");
        String number = intent.getStringExtra("inputnumber");
        int i1 = intent.getIntExtra("edtposition", 100);
        if(name != null && number != null) {
            contacts.get(i1).setName(name);
            contacts.get(i1).setNumber(number);
        }

    }
}
