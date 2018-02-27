package com.example.kyle.encryptionapp;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText message = (EditText) findViewById(R.id.editText);
        final Button encryptButton = (Button) findViewById(R.id.button);
        final Button decryptButton = (Button) findViewById(R.id.button2);
        encryptButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                InputMethodManager inputmngr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                EditText keyText = (EditText) findViewById(R.id.editText2);
                inputmngr.hideSoftInputFromInputMethod(message.getWindowToken(), 0);
                String word = message.getText().toString();
                int key = Integer.parseInt(keyText.getText().toString());
                CaesarCipher cipher = new CaesarCipher(word, key);
                word = cipher.encrypt();
                TextView text = (TextView) findViewById(R.id.textView2);
                text.setVisibility(View.VISIBLE);
                text.setText(word);
            }
        });
        decryptButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText keyText = (EditText) findViewById(R.id.editText2);
                String word = message.getText().toString();
                int key = Integer.parseInt(keyText.getText().toString());
                CaesarCipher cipher = new CaesarCipher(word, key);
                word = cipher.decrypt();
                TextView text = (TextView) findViewById(R.id.textView2);
                text.setVisibility(View.VISIBLE);
                text.setText(word);
            }
        });
    }

    public void makeInvisible(View v){
        TextView text = (TextView) findViewById(R.id.textView2);
        text.setVisibility(View.INVISIBLE);
    }
}
