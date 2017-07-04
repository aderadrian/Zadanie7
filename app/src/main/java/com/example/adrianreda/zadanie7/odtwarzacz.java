package com.example.adrianreda.zadanie7;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class odtwarzacz extends AppCompatActivity
{
    private static final int RECORD_REQUEST_CODE = 101;
    private static final String TAG = "MyActivity";
    private MediaRecorder mediaRecorder;
    private Button PlaySound;
    private Button StopSound;
    private String mFileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.odtwarzacz);
        audioRecorderService();

    }


    private MediaPlayer mediaPlayer;

    public void playSound(View view){
        createAlertDialogWithList().show();

    }
    public void stopSound(View view){
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }


    }


    public void play(){
        if(mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.mik);
        mediaPlayer.start();
    }
    public void play2(){
        if(mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.dim);
        mediaPlayer.start();
    }



    private Dialog createAlertDialogWithList() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final String[] options = {"Mike Posner-I took pill in Ibiza", "Dimitri Vegas, MOGUAI & Like Mike - Mammoth"};
        dialogBuilder.setTitle("Lista utworow");
        dialogBuilder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                Toast.makeText(getApplicationContext(), "Wybrałeś: " + options[position], Toast.LENGTH_LONG).
                        show();
                if (options[position].equals("Mike Posner-I took pill in Ibiza")) {
                    play();
                } else {
                    play2();
                }

            }
        });
        return dialogBuilder.create();
    }










    protected void audioRecorderService(){

        final Button button1 = (Button) findViewById(R.id.button3);
        final Button button2 = (Button) findViewById(R.id.button5);
        PlaySound = (Button)findViewById(R.id.button6);
        StopSound = (Button)findViewById(R.id.button7);

        button2.setEnabled(false);
        PlaySound.setEnabled(false);
        StopSound.setEnabled(false);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                startRecording();
                button1.setEnabled(false);
                button2.setEnabled(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stopRecording();
                button2.setEnabled(false);
                PlaySound.setEnabled(true);
                StopSound.setEnabled(true);
                onPlayButtonClick();
                onStopButtonClick();
            }
        });
    }

    private void prepareRecording(){
        mediaRecorder = new MediaRecorder();
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(mFileName);
    }

    private void startRecording(){
        prepareRecording();
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start();
    }

    private void stopRecording(){
        if(null != mediaRecorder) {
            mediaRecorder.stop();
            mediaRecorder.release();
            mediaRecorder = null;
        }
    }
    public void onPlayButtonClick(){
        PlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    playSound();
                    PlaySound.setEnabled(false);
                    StopSound.setEnabled(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onStopButtonClick(){
        StopSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSound();
                PlaySound.setEnabled(true);
                StopSound.setEnabled(false);
            }
        });
    }

    private void playSound() throws IOException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(mFileName);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    private void stopSound(){
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.stop();
        mediaPlayer.release();
    }


























    public void Powrot(View view)
    {
        if(mediaPlayer != null) {
            mediaPlayer.release();
        }
        finish();
    }






}