package com.ligeirostudio.examplen.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ligeirostudio.examplen.R;
import com.ligeirostudio.examplen.model.Contact;
import com.ligeirostudio.examplen.view.activities.MainActivity;
import com.ligeirostudio.examplen.view.adapters.SendMoneyAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SendMoneyFragment extends Fragment {


    public SendMoneyFragment() {
        // Required empty public constructor
    }


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    SendMoneyAdapter sendMoneyAdapter;
    private Unbinder unbinder;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_money, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbar();
        setAdapter();
    }

    public void setAdapter() {

        ArrayList<Contact> contacts = new ArrayList();

        for (int i = 0; i < 15; i++){
            contacts.add(new Contact("1","Fenando Costa", "(11) 99999-9999","xx"));

        }



        sendMoneyAdapter = new SendMoneyAdapter(getActivity(), contacts);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(sendMoneyAdapter);
    }

    public void setToolbar() {

        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.icn_back);
        toolbarTitle.setText("Enviar Dinheiro");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
