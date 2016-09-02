package com.ligeirostudio.examplen.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ligeirostudio.examplen.R;
import com.ligeirostudio.examplen.rest.ApiRequester;
import com.ligeirostudio.examplen.utils.SharedPrefs;
import com.ligeirostudio.examplen.view.uicomponents.FragmentUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.btnSendMoney)
    View btnSendMoney;

    @BindView(R.id.btnHistory)
    View btnHistory;

    @BindView(R.id.tv_name)
    TextView name;

    @BindView(R.id.tv_email)
    TextView email;


    private Unbinder unbinder;

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name.setText("Fernando Costa");
        email.setText("fernando.m.costa@live.com");

        if(SharedPrefs.getString(getActivity(),"token") == null){
            new ApiRequester().generateToken(name.getText().toString(), email.getText().toString());
        }

    }

    @OnClick(R.id.layoutImgContainer)
    public void onClickPhoto(){

    }

    @OnClick(R.id.btnSendMoney)
    public void btnSendMoney(){
        FragmentUtils.getOrCreate(getActivity(),"sendMoney", new SendMoneyFragment(), R.id.fragment_container);

    }

    @OnClick(R.id.btnHistory)
    public void btnHistory(){
        FragmentUtils.getOrCreate(getActivity(),"history", new HistoryFragment(), R.id.fragment_container);

    }

    @Subscribe
    public void token(String token) {

        SharedPrefs.setString(getActivity(),"token", token);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);

    }


}
