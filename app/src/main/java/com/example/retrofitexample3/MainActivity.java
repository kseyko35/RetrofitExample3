package com.example.retrofitexample3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.example.retrofitexample3.model.BaseModel;
import com.example.retrofitexample3.network.action.CheckBaseAction;

import java.util.List;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements CheckBaseAction.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBaseAction.perform(this);

    }

    @Override
    public void getMainBaseResources(List<BaseModel> response) {

        Toast.makeText(this,response.get(1).getRocket().getFirst_stage().getCores().get(0).getCore_serial(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
