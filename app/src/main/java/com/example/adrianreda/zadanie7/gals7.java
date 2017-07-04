package com.example.adrianreda.zadanie7;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class gals7 extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s7);
    }
    public void Cena(View view)
    {
        createPlainAlertDialog().show();
    }

    private Dialog createPlainAlertDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Cena");
        dialogBuilder.setMessage("od 2049.00 zl");
        return dialogBuilder.create();
    }


    public void Powrot(View view)
    {
        finish();
    }


}