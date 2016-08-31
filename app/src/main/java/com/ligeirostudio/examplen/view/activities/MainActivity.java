package com.ligeirostudio.examplen.view.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ligeirostudio.examplen.R;
import com.ligeirostudio.examplen.rest.ApiRequester;
import com.ligeirostudio.examplen.view.fragments.HistoryFragment;
import com.ligeirostudio.examplen.view.fragments.HomeFragment;
import com.ligeirostudio.examplen.view.fragments.SendMoneyFragment;
import com.ligeirostudio.examplen.view.uicomponents.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentUtils.getOrCreate(this,"home", new HomeFragment(), R.id.fragment_container);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

}
