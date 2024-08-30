package com.example.viewModel_android.ViewModel;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<String>> shoppingList;
    private MutableLiveData<List<String>> sampleList;


    public LiveData<List<String>> getShoppingList() {
        Log.e("View-Model: ", "*****");
        if (shoppingList == null) {
            shoppingList = new MutableLiveData<>();
            loadShoppingList();
        }
        return shoppingList;
    }

    public LiveData<List<String>> getSampleData() {
        sampleList = new MutableLiveData<>();
        List<String> shoppingListSample = new ArrayList<>();
        shoppingListSample.add("Bread");
        shoppingListSample.add("Bananas");
        sampleList.setValue(shoppingListSample);
        Log.e("View-Model-Sample: ", "+++++++");
        return sampleList;
    }

    private void loadShoppingList() {

        Handler myHandler = new Handler();

        myHandler.postDelayed(() -> {

            List<String> shoppingListSample = new ArrayList<>();
            shoppingListSample.add("Bread");
            shoppingListSample.add("Bananas");
            shoppingListSample.add("Peanut Butter");
            shoppingListSample.add("Eggs");
            shoppingListSample.add("Chicken breasts");

            long seed = System.nanoTime();
            Collections.shuffle(shoppingListSample, new Random(seed));

            shoppingList.setValue(shoppingListSample);

        }, 5000);
    }
}
