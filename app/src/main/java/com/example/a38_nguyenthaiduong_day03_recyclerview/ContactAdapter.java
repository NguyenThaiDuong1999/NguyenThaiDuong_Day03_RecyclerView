package com.example.a38_nguyenthaiduong_day03_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHoder> {

    List<Contact> contacts;
    IonClickContact ionClickContact;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }
    public void setIonClickContact(IonClickContact ionClickContact) {
        this.ionClickContact = ionClickContact;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_activity, parent, false);

        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, final int position) {
        final Contact contact = contacts.get(position);

        holder.tvnumber.setText(contact.getNumber());
        holder.tvname.setText(contact.getName());

        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionClickContact.onClickName(contact.getName());
            }
        });

        holder.tvnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ionClickContact.onClickNumber(contact, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView tvname, tvnumber;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tvname);
            tvnumber = itemView.findViewById(R.id.tvnumber);
        }
    }
}
