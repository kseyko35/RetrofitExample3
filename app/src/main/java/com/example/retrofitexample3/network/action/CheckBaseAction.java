package com.example.retrofitexample3.network.action;




import com.example.retrofitexample3.model.BaseModel;
import com.example.retrofitexample3.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CheckBaseAction {
    public interface Listener {
        void getMainBaseResources(List<BaseModel> response);

        void onFailure(Call call, Throwable t);

    }

    public static void perform(final CheckBaseAction.Listener listener) {

        ApiClient.getInstance().getApiInterface().getBaseModel().enqueue(new Callback<List<BaseModel>>() {
            @Override
            public void onResponse(Call<List<BaseModel>> call, Response<List<BaseModel>> response) {
                if (listener != null) {
                    listener.getMainBaseResources(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<BaseModel>> call, Throwable t) {
                if (listener != null) {
                    listener.onFailure(call, t);
                }
            }
        });
    }
}
