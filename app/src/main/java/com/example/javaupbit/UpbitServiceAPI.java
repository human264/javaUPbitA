package com.example.javaupbit;


import com.example.javaupbit.dto.AccountsResponseDTO;
import com.example.javaupbit.dto.MarketCodeDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UpbitServiceAPI {

    @GET("/accounts")
    Call<String> getStoreListOrderByGrade();

    @GET("market/all")
    Call<ResponseBody> getMarketCode3();

    @GET("market/all")
    Call<MarketCodeDTO> getMarketCode();


}
