package com.ezgiorman.shariingdata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText enterage;
    TextView yourage;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterage = findViewById(R.id.enterAge);
        yourage = findViewById(R.id.yourAge);

      sharedPreferences = this.getSharedPreferences("com.ezgiorman.shariingdata" , Context.MODE_PRIVATE); //Veri depolama kodu

      int storedAge = sharedPreferences.getInt("storedAge" , 0);

      if(storedAge==0)
      {
          yourage.setText("Your Age: ");
      } else
      {
          yourage.setText("Your Age: " + storedAge);
      }





    }

    public void save (View view)
    {
        if(!enterage.getText().toString().isEmpty())
        {
            int userAge = Integer.parseInt(enterage.getText().toString()); //alınan veriyi integer değere çevirme kodu
            yourage.setText( "your age:" + userAge);

            sharedPreferences.edit().putInt("storedAge", userAge).apply(); //kaydedilen veriyi gösterme kodu
        }
    }

    public void delete (View view)
    {
        int sharedData = sharedPreferences.getInt("storedAge" , 0);

        if(sharedData != 0)
        {
            sharedPreferences.edit().remove("StoredAge").apply(); //girilmiş veriyi silme kodu
            yourage.setText("your age: ");
        }

    }


}