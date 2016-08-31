package com.ligeirostudio.examplen.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ligeirostudio.examplen.R;
import com.ligeirostudio.examplen.model.Contact;
import com.ligeirostudio.examplen.model.Transfers;
import com.ligeirostudio.examplen.view.uicomponents.CircleTransform;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Fernando on 8/28/16.
 */
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    Context context;
    List<Transfers> listTransfers;
    private Unbinder unbinder;

    public HistoryAdapter(Context context) {
        this.context = context;
        this.listTransfers = new ArrayList<>();
        EventBus.getDefault().register(this);
    }


    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_view_contacts, parent, false);
        return new HistoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {

        if (listTransfers.size() > 0) {

            Contact contact = new Contact();

            Transfers transfers = listTransfers.get(position);

            contact = contact.findContact(transfers.getClientId());

            if (contact != null) {

                holder.name.setText(contact.getName());
                holder.telephone.setText(contact.getPhone());
                Picasso.with(context).load(contact.getPhoto()).transform(new CircleTransform()).into(holder.image);


            }

        }


    }


    @Subscribe
    public void transfers(ArrayList<Transfers> transfers) {

        listTransfers = transfers;

        notifyDataSetChanged();

    }


    @Override
    public int getItemCount() {
        return listTransfers.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {

        public HistoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @BindView(R.id.image)
        ImageView image;

        @BindView(R.id.tv_name)
        TextView name;

        @BindView(R.id.tv_telephone)
        TextView telephone;
    }
}
