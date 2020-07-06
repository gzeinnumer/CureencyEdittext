package com.gzeinnumer.cureencyedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();
                if (!input.isEmpty()) {

                    input = input.replace(",", "");

                    DecimalFormat format = new DecimalFormat("#,###,###");
                    String newPrice = format.format(Double.parseDouble(input));

                    editText.removeTextChangedListener(this);

                    editText.setText(newPrice);
                    editText.setSelection(newPrice.length());

                    editText.addTextChangedListener(this);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = editText.getText().toString();
                input = input.replace(",", "");
                tv.setText(input);
            }
        });
    }
}