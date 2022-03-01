package com.example.javaupbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.javaupbit.upbit.GetJWTToken;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("hi?");

        String TOKEN = getToken();
        System.out.println(TOKEN);

        UpbitServiceAPI service = UpbitServiceGenerator.createService(UpbitServiceAPI.class, TOKEN);
        getLoadMarketCode(service);


    }

    private void getLoadMarketCode(UpbitServiceAPI service) {

        service.getMarketCode().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    System.out.println("===========");
                    System.out.println(response.body().toString());
                    System.out.println("===========");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


    private String getToken() {
        GetJWTToken getJWTToken = new GetJWTToken();
        String token = getJWTToken.getToken();
        return token;
    }
}

