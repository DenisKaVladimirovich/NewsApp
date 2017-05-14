package com.example.myapplication;

import android.view.View;
import android.widget.Toast;

/**
 * Created by Денис on 14.05.2017.
 */

public class PostClickListener implements View.OnClickListener {

    private int pvh;

    public PostClickListener(){}

    public PostClickListener(int pvh) {
        this.pvh = pvh;
    }

    @Override
    public void onClick(View v) {

        Person p = MainActivity.getPerson(pvh);
        Toast.makeText(v.getContext(), p.name, Toast.LENGTH_SHORT).show();
    }
}
