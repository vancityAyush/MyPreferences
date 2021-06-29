package com.ak11.mypreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button btnSave;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        btnSave = findViewById(R.id.btnSave);
        edtText = findViewById(R.id.edtText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                sharedPreferences.edit().clear().commit();
                onResume();
            break;
            case R.id.settings2:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.root, new SettingsFragment())
//                        .commit();
                startActivity(new Intent(MainActivity.this,PreferenceActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        boolean isDarkMode = sharedPreferences.getBoolean("DARK_MODE",false);
        if(isDarkMode)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        String txtButton = sharedPreferences.getString("DEFAULT_BUTTON_TEXT","Save");
        btnSave.setText(txtButton);

        Float txtSize = Float.parseFloat(sharedPreferences.getString("TEXT_SIZE","20"));
        edtText.setTextSize(txtSize);
        btnSave.setTextSize(txtSize);

        boolean isGrey = sharedPreferences.getBoolean("DARK_GREY",false);
        if(isGrey){
            findViewById(R.id.root).setBackgroundResource(android.R.color.darker_gray);
            btnSave.setBackgroundResource(android.R.color.darker_gray);
            edtText.setBackgroundResource(android.R.color.darker_gray);
        }


        super.onResume();
    }
}