package com.gzeinnumer.cureencyedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.gzeinnumer.cureencyedittext.helper.FunctionGlobal;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
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

            }

            @Override
            public void afterTextChanged(Editable editable) {
                editText.removeTextChangedListener(this);
                String nominal = editText.getText().toString().trim().replace(",", "").replace(".", "");
                if (!nominal.equals("")) {
                    try {
                        int inilen = editText.getText().length();
                        int cp = editText.getSelectionStart();
                        editText.setText(FunctionGlobal.formatangka(nominal));
                        int sel = cp + (editText.getText().length() - inilen);
                        if (sel <= 0 || sel > editText.getText().length()) {
                            editText.setSelection(editText.getText().length() - 1);
                        } else {
                            editText.setSelection(sel);
                        }
                    } catch (NumberFormatException e) {
                        Log.e(TAG, "afterTextChanged: " + e.getMessage());
                    }
                }
                editText.addTextChangedListener(this);
                String input = editable.toString();
                input = input.replace(",", "");
                tv.setText(input);
            }
        });
    }
}