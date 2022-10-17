package com.example.mvvmkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmkullanimi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;
    private ViewModel viewModel;
    //temel mimarida bunlara gerek vardi. DataBinding ile kalmadi.
    //private TextView textViewSonuc;
    //private EditText editTextSayi1, editTextSayi2;
    //private Button buttonToplama, buttonCarpma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim= DataBindingUtil.setContentView(this,R.layout.activity_main); //tasarim baglandi.
        viewModel = new ViewModelProvider(this).get(ViewModel.class); //bağlantı ViewModel buraya.
        tasarim.setMainActivityNesnesi(this);//xml de olusturulan nesneye yetki verdik.
        //textViewSonuc = findViewById(R.id.textViewSonuc);
        //editTextSayi1 = findViewById(R.id.editTextSayi1);
        //editTextSayi2 = findViewById(R.id.editTextSayi2);
        //buttonToplama = findViewById(R.id.buttonToplama);
        //buttonCarpma = findViewById(R.id.buttonCarpma);

        //tasarim.textViewSonuc.setText("0");
        //tasarim.setHesaplamaSonucu("0");
        viewModel.getSonuc().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tasarim.setHesaplamaSonucu(s);

            }
        });

    }

    public void buttonToplamaTikla(String alinanSayi1,String alinanSayi2){
        viewModel.toplamaYap(alinanSayi1,alinanSayi2);
        //xml de yazdik.
        //String alinanSayi1 = tasarim.editTextSayi1.getText().toString();
        //String alinanSayi2 = tasarim.editTextSayi2.getText().toString();

        //ViewModel'a tasidik.
        //int sayi1 = Integer.parseInt(alinanSayi1);
        //int sayi2 = Integer.parseInt(alinanSayi2);
        //int toplam = sayi1 + sayi2;

        //tasarim.textViewSonuc.setText(String.valueOf(toplam));

    }

    public void buttonCarpmaTikla(String alinanSayi1,String alinanSayi2){
        viewModel.carpmaYap(alinanSayi1,alinanSayi2);


        //String alinanSayi1 = tasarim.editTextSayi1.getText().toString();
        //String alinanSayi2 = tasarim.editTextSayi2.getText().toString();

        //int sayi1 = Integer.parseInt(alinanSayi1);
        //int sayi2 = Integer.parseInt(alinanSayi2);
        //int carpma = sayi1 * sayi2;

        //tasarim.textViewSonuc.setText(String.valueOf(carpma));

    }
}