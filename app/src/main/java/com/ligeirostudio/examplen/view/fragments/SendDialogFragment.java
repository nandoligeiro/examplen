package com.ligeirostudio.examplen.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.ligeirostudio.examplen.R;
import com.ligeirostudio.examplen.model.Contact;
import com.ligeirostudio.examplen.model.SendMoney;
import com.ligeirostudio.examplen.model.Transfers;
import com.ligeirostudio.examplen.rest.ApiRequester;
import com.ligeirostudio.examplen.utils.SharedPrefs;
import com.ligeirostudio.examplen.view.uicomponents.CircleTransform;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fernando.c.moreira on 01/09/2016.
 */
public class SendDialogFragment extends DialogFragment {
    public static final String TAG = "SendDialogFragment";

    Contact contact;
    String currentDateTimeString;

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.tv_phone_dialog)
    TextView phone;

    @BindView(R.id.tv_name_dialog)
    TextView name;

    @BindView(R.id.ed_Value)
    EditText editText;

    public SendDialogFragment() {
        super();
    }

    public void setContact(Contact contact){
        this.contact = contact;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.show();
        return dialog;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View convertedView = inflater.inflate(R.layout.send_money_dialog, container, false);
        ButterKnife.bind(this, convertedView);
        return convertedView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.with(getActivity()).load(contact.getPhoto()).transform(new CircleTransform()).into(image);
        name.setText(contact.getName());
        phone.setText(contact.getPhone());


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btnSend)
    public void sendMoney(){

        currentDateTimeString = DateFormat.getDateInstance().format(new Date());

        if(!editText.getText().toString().equals("")){

            double value = Double.parseDouble(editText.getText().toString());

            if (value > 0){
                SendMoney sendMoney = new SendMoney(0, contact.getId(), value, SharedPrefs.getString(getActivity(),"token"), currentDateTimeString);

                new ApiRequester().postSendMoney(sendMoney);
            }else {
                Toast.makeText(getActivity(),"Envie um valor maior que 0",Toast.LENGTH_SHORT);
            }

        }else{
            Toast.makeText(getActivity(),"Digite um Valor",Toast.LENGTH_SHORT);
        }




    }

    @Subscribe
    public void eventSend(String sendMoney) {

        if(sendMoney.equals("true")){
            Toast.makeText(getActivity(),"Enviado: "+" " +editText.getText().toString(),Toast.LENGTH_SHORT);
            dismiss();
        }else{
            Toast.makeText(getActivity(),"Erro ao Enviar Dinheiro. Tende novamente",Toast.LENGTH_SHORT);
        }


    }
}
