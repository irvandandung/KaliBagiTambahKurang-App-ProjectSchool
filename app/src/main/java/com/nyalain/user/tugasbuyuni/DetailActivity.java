package com.nyalain.user.tugasbuyuni;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.nyalain.user.tugasbuyuni.fragment.bagi;
import com.nyalain.user.tugasbuyuni.fragment.kali;
import com.nyalain.user.tugasbuyuni.fragment.kurang;
import com.nyalain.user.tugasbuyuni.fragment.tambah;

public class DetailActivity extends AppCompatActivity {
//    private String TAG = getClass().getSimpleName();
    Fragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String menu = getIntent().getStringExtra("MENU");
        switch (menu){

            case "0" :
                menuFragment = new tambah();
                break;
            case "1" :
                menuFragment = new kurang();
                break;
            case "2" :
                menuFragment = new kali();
                break;
            case "3" :
                menuFragment = new bagi();
                break;
        }
        if (menuFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout,menuFragment)
                    .commit();
        }

        //Log.d(TAG, "onCreate: " + menu);

    }

}
