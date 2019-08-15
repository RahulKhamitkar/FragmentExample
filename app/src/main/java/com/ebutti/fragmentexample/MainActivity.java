package com.ebutti.fragmentexample;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    TextView tvDescription;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);
        descriptions = getResources().getStringArray(R.array.descriptions);


        //the phone is in Portrait mode
        if(findViewById(R.id.portrait)!= null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();

        }

        if (findViewById(R.id.layout_landscape) != null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();

        }

    }

    @Override
    public void itemSelected(int index) {
        tvDescription.setText(descriptions[index]);

        if(findViewById(R.id.portrait)!= null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .hide(manager.findFragmentById(R.id.listFragment))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
