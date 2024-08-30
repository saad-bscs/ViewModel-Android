package com.example.viewModel_android.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.viewModel_android.R;
import com.example.viewModel_android.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ProgressBar progressBar;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLayouts();

    }

    public void initializeLayouts() {
        listView = findViewById(R.id.list);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getShoppingList().observe(this, shoppingList -> {

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    shoppingList);

            listView.setAdapter(adapter);

            progressBar.setVisibility(View.GONE);
        });

        viewModel.getSampleData().observe(this, sampleList -> {
            Log.e("viewModel-observer: ", "=====");
        });
    }
}