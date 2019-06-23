package com.google.firebase.samples.apps.mlkit.java;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.samples.apps.mlkit.R;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

private ArrayList<ContactItem> contactItems;

    public static class ContactsViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView bigger;
        public TextView smaller;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.contactImgView);
            bigger = itemView.findViewById(R.id.textViewContactBigger);
            smaller = itemView.findViewById(R.id.textViewContactSmaller);
        }
    }

    public ContactsAdapter(ArrayList<ContactItem> items){

        this.contactItems = items;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item, viewGroup, false);
        ContactsViewHolder viewHolder = new ContactsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewHolder, int i) {
        ContactItem current = contactItems.get(i);

        contactsViewHolder.imageView.setImageResource(current.getImgResource());
        contactsViewHolder.smaller.setText(current.getTextSmaller());
        contactsViewHolder.bigger.setText(current.getTextBigger());
    }

    @Override
    public int getItemCount() {
        return contactItems.size();
    }
}
