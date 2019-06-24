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


/**
 * Adapter which connects and binds data between Recycler view holder and contacts view holder
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private ArrayList<ContactItem> contactItems;
    private OnItemClickListener listener;


    // parent activity will implement this method to respond to click events
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickLietener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView bigger;
        private TextView smaller;

        public ContactsViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.contactImgView);
            bigger = itemView.findViewById(R.id.textViewContactBigger);
            smaller = itemView.findViewById(R.id.textViewContactSmaller);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            listener.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }


    public ContactsAdapter(ArrayList<ContactItem> items) {

        this.contactItems = items;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item, viewGroup, false);
        ContactsViewHolder viewHolder = new ContactsViewHolder(v, this.listener);
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
