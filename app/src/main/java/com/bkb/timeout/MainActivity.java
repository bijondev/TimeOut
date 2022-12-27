package com.bkb.timeout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCLick=findViewById(R.id.btnCLick);

        btnCLick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("btnCLick",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Start");

                JsonObject _json= new JsonObject();
                _json.addProperty("SenAcct", "");
                _json.addProperty("UsrTokn", "");
                _json.addProperty("MobNumb", "");

                _json.addProperty("AppCode", "");
                _json.addProperty("IpAddress", "");
                Log.d("Request", ">>>>>>>>>>>>>>>>>>>>>>" + _json.toString());

                apiInterface = OperatingApiClient.getClient().create(APIInterface.class);

                Call<JsonObject> call = apiInterface.doGetListResources(_json);
                //Call<MultipleResource> call = apiInterface.doGetListResources();
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {


                        Log.d(
                                "onResponse",
                                ">>>>>>>>>>>>>>>>>>>>>>" + response.body().toString()
                        );
                        Log.d("btnCLick",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>End");
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        call.cancel();
                    }
                });

            }
        });



    }
}