package com.ligeirostudio.examplen.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ligeirostudio.examplen.R;
import com.ligeirostudio.examplen.model.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Fernando on 8/28/16.
 */
public class SendMoneyAdapter extends RecyclerView.Adapter<SendMoneyAdapter.SendMoneyViewHolder> {

    Context context;
    List<Contact> listContact;

    public SendMoneyAdapter(Context context, List<Contact> listContact) {
        this.context = context;
        this.listContact = listContact;
    }


    @Override
    public SendMoneyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_view_contacts, parent, false);
        return new SendMoneyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SendMoneyViewHolder holder, int position) {

        Contact contact = listContact.get(position);

        holder.name.setText(contact.getId());
        holder.telephone.setText(contact.getphone());


    }


    @Override
    public int getItemCount() {
        return listContact.size();
    }

    public class SendMoneyViewHolder extends RecyclerView.ViewHolder {

        public SendMoneyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        @OnClick(R.id.card_view)
        public void onClickCardView() {

            Log.d("LS", "Click");
        }

        @BindView(R.id.card_view)
        CardView cardView;

        @BindView(R.id.image)
        ImageView image;

        @BindView(R.id.tv_name)
        TextView name;

        @BindView(R.id.tv_telephone)
        TextView telephone;
    }
}
