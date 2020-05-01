package com.imtiaz.layoutinfalte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Context mContext;
    private LinearLayout llTextList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // context
        mContext = MainActivity.this;
        // init linerLayout
        llTextList = findViewById(R.id.ll_text_list);
        // call display text rows
        displayAllTexts();
    }

    // displays the text card list
    private void displayAllTexts() {
        // remove all child views first
        llTextList.removeAllViews();
        // string resource array
        String[] itemArray = getResources().getStringArray(R.array.list_items);
        // looping through all the items
        for (int i = 0; i < itemArray.length; i++) {
            // inflating views
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

            assert inflater != null;
            @SuppressLint("InflateParams") final View view = inflater.inflate(R.layout.row_text, null);
            // textView
            TextView txtItem = view.findViewById(R.id.txt_item);
            // setting data
            txtItem.setText(itemArray[i]);
            // adding the view card to the list view
            llTextList.addView(view);
        }
    }
}
