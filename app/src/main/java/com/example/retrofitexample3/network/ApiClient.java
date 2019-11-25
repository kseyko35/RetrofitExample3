package com.example.retrofitexample3.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static ApiClient instance;

    private ApiInterface apiInterface;

    private ApiClient() {
        init();
    }

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    private void init() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder = builder.addInterceptor(interceptor);


        builder = builder.addInterceptor(
                new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request original = chain.request();

                        Request.Builder requestBuilder = original.newBuilder()
                                .header("Content-Type", "application/json; charset=utf-8")
                                .header("android", "true")
                                .method(original.method(), original.body());

                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                });
        builder = builder.readTimeout(120, TimeUnit.SECONDS);
        builder = builder.connectTimeout(120, TimeUnit.SECONDS);
        OkHttpClient okHttpClient = builder.build();


        Gson gson = new GsonBuilder()
//                .excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .create();

        GsonConverterFactory factory = GsonConverterFactory.create(gson);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.spacexdata.com/v2/")
                .addConverterFactory(factory)
                .client(okHttpClient)
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
