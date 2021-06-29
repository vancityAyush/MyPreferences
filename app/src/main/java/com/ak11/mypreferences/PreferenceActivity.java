package com.ak11.mypreferences;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

public class PreferenceActivity extends android.preference.PreferenceActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.my_preferences);
    }
}
