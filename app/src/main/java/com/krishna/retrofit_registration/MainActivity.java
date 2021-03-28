package com.krishna.retrofit_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText firstName,lastName,address,email,mobile,password;
    Button submit;
    String url = "http://10.0.2.2/android_php/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.eFname);
        lastName = findViewById(R.id.eLname);
        address = findViewById(R.id.eAddress);
        mobile = findViewById(R.id.eMobile);
        email = findViewById(R.id.eEmail);
        password = findViewById(R.id.ePassword);

        submit = findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerData();
            }
        });
    }

    public void registerData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myapi api = retrofit.create(myapi.class);

        Call<Model> call = api.addData(firstName.getText().toString(),lastName.getText().toString(),address.getText().toString(),mobile.getText().toString(),email.getText().toString(),password.getText().toString());

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                firstName.setText("");
                lastName.setText("");
                email.setText("");
                mobile.setText("");
                address.setText("");
                password.setText("");
                Toast.makeText(MainActivity.this,"Data inserted...", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}