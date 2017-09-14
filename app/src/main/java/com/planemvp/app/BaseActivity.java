package com.planemvp.app;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Hari on 14/09/17.
 */

public class BaseActivity extends AppCompatActivity {
    public void toast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
