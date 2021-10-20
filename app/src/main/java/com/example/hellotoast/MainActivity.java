package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_INDEX = "count";
    private Button mToastButton;
    private Button mCountButton;
    private TextView mCountNumber;
    private Integer mNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        mToastButton = (Button) findViewById(R.id.button_toast);
        mCountButton = (Button) findViewById(R.id.button_count);
        mCountNumber = (TextView) findViewById(R.id.show_count);

        if (savedInstanceState != null) {
            mNumber = savedInstanceState.getInt(KEY_INDEX, 0);
            mCountNumber.setText(mNumber.toString());
        }
        mToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mCountNumber.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        mCountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNumber = Integer.parseInt(mCountNumber.getText().toString());
                mNumber++;
                 mCountNumber.setText(mNumber.toString());
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mNumber);
    }


}