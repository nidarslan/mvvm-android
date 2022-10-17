package com.example.mvvmkullanimi;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    //degisken olustur degiskene metodlarla yonet.
    private MutableLiveData<String> sonuc;

    public ViewModel(){
        sonuc = new MutableLiveData<String>("0");
    }

    public MutableLiveData<String> getSonuc() {
        return sonuc;
    }
    public void toplamaYap(String alinanSayi1,String alinanSayi2){

        int sayi1 = Integer.parseInt(alinanSayi1);
        int sayi2 = Integer.parseInt(alinanSayi2);

        int toplam = sayi1 + sayi2;
        sonuc.setValue(String.valueOf(toplam));

    }

    public void carpmaYap(String alinanSayi1,String alinanSayi2){

        int sayi1 = Integer.parseInt(alinanSayi1);
        int sayi2 = Integer.parseInt(alinanSayi2);

        int carpma = sayi1 * sayi2;
        sonuc.setValue(String.valueOf(carpma));

    }

}
