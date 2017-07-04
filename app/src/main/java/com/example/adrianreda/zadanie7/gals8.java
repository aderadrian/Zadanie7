package com.example.adrianreda.zadanie7;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.view.View.OnClickListener;


public class gals8 extends AppCompatActivity
{
    static final private int CUSTOM_ALERT_DIALOG = 4;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s8);
        button2 = (Button) findViewById(R.id.button2);
        initButtonsClick();
    }
    private void initButtonsClick() {
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        showDialog(CUSTOM_ALERT_DIALOG);
                        break;
                    default:
                        break;
                }
            }

        };
        button2.setOnClickListener(listener);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case CUSTOM_ALERT_DIALOG:
                return createCustomAlertDialog();
            default:
                return null;

        }
    }



    private Dialog createCustomAlertDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View layout = getCustomDialogLayout();
        dialogBuilder.setView(layout);
        dialogBuilder.setTitle("W sprzedazy od 28 kwietnia");
        return dialogBuilder.create();
    }

    private View getCustomDialogLayout() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.dialog, (ViewGroup)findViewById(R.id.layout_root));
    }





    public void Powrot(View view)
    {
        finish();
    }


}