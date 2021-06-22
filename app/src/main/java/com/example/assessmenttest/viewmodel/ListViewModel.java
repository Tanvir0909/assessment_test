package com.example.assessmenttest.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assessmenttest.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends ViewModel {

    public MutableLiveData<List<CountryModel>> countries = new MutableLiveData<List<CountryModel>>();
    public MutableLiveData<Boolean> countryLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    public void refresh(){
        fatchCountries();
    }

    private void fatchCountries() {
        CountryModel countryModel= new CountryModel("Bangladesh", "Dhaka");
        CountryModel countryMode2= new CountryModel("India", "Dhaka");
        CountryModel countryMode3= new CountryModel("Nepal", "Dhaka");
        CountryModel countryMode4= new CountryModel("Bhutan", "Dhaka");
        CountryModel countryMode5= new CountryModel("China", "Dhaka");
        CountryModel countryMode6= new CountryModel("Usa", "Dhaka");

        List<CountryModel> list = new ArrayList<>();
        list.add(countryModel);
        list.add(countryMode2);
        list.add(countryMode3);
        list.add(countryMode4);
        list.add(countryMode5);
        list.add(countryMode6);
        list.add(countryModel);
        list.add(countryMode2);
        list.add(countryMode3);
        list.add(countryMode4);
        list.add(countryMode5);
        list.add(countryMode6);
        list.add(countryModel);
        list.add(countryMode2);
        list.add(countryMode3);
        list.add(countryMode4);
        list.add(countryMode5);
        list.add(countryMode6);
        list.add(countryModel);
        list.add(countryMode2);
        list.add(countryMode3);
        list.add(countryMode4);
        list.add(countryMode5);
        list.add(countryMode6);

        countries.setValue(list);
        countryLoadError.setValue(false);
        loading.setValue(false);
    }
}
