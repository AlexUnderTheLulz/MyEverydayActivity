package com.example.myeverydayactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView day, month;
    ProgressBar PUps, Prisedania;
    Button startPUps, startPrisedania;
    Dialog dialog;

    TextView CurrentPUps, CurrentPrisedania, CurrentSetPUps, CurrentSetPrisedania;

    EditText number;
    Button submit;

    Button button_set;

    EditText number_set;
    Button setSettings;

    int CurrentProgressPUps, CurrentProgressPrisedania = 0;

    int SetColichestvo = 100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        day = findViewById(R.id.day);
        month = findViewById(R.id.month);

        startPUps = findViewById(R.id.startPUps);
        PUps = findViewById(R.id.PUps);
        PUps.setMax(SetColichestvo);

        startPrisedania = findViewById(R.id.startPrisedania);
        Prisedania = findViewById(R.id.Prisedania);
        Prisedania.setMax(SetColichestvo);

        CurrentPUps = findViewById(R.id.CurrentPUps);
        CurrentPrisedania = findViewById(R.id.CurrentPrisedania);

        CurrentSetPUps = findViewById(R.id.CurrentSetPUps);
        CurrentSetPrisedania = findViewById(R.id.CurrentSetPrisedania);

        button_set = findViewById(R.id.button_set);

        dialog = new Dialog(MainActivity.this);

        Date CurrentDate = Calendar.getInstance().getTime();
        String FormattedDate = DateFormat.getDateInstance(DateFormat.FULL).format(CurrentDate);
        String[] split = FormattedDate.split(",");

        day.setText(split[0]);
        month.setText(split[1]);

        CurrentPUps.setText(String.valueOf(CurrentProgressPUps));
        CurrentPrisedania.setText(String.valueOf(CurrentProgressPrisedania));

        startPUps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_layout();
            }
        });

        startPrisedania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1_layout();
            }
        });

        button_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { set_dialog_layout(); }
        });
    }

    private void dialog_layout() {
        dialog.setContentView(R.layout.dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        number = dialog.findViewById(R.id.number);
        submit = dialog.findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Progress = Integer.parseInt(number.getText().toString());
                CurrentProgressPUps = CurrentProgressPUps + Progress;
                PUps.setProgress(CurrentProgressPUps);
                CurrentPUps.setText(String.valueOf(CurrentProgressPUps));
                Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    private void dialog1_layout() {
        dialog.setContentView(R.layout.dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        number = dialog.findViewById(R.id.number);
        submit = dialog.findViewById(R.id.buttonSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Progress1 = Integer.parseInt(number.getText().toString());
                CurrentProgressPrisedania = CurrentProgressPrisedania + Progress1;
                Prisedania.setProgress(CurrentProgressPrisedania);
                CurrentPrisedania.setText(String.valueOf(CurrentProgressPrisedania));
                Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }

    private void set_dialog_layout() {
        dialog.setContentView(R.layout.set_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(true);

        number_set = dialog.findViewById(R.id.number_set);
        setSettings = dialog.findViewById(R.id.setSettings);

        setSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int set = Integer.parseInt(number_set.getText().toString());
                CurrentSetPUps.setText(String.valueOf(set));
                CurrentSetPrisedania.setText(String.valueOf(set));
                PUps.setMax(set);
                Prisedania.setMax(set);
                Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}