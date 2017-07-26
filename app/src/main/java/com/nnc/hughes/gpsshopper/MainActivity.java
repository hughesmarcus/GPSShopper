package com.nnc.hughes.gpsshopper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.nnc.hughes.gpsshopper.data.HockeyAPI;
import com.nnc.hughes.gpsshopper.data.JSONResponse;
import com.nnc.hughes.gpsshopper.data.Roster;

import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private String PLAYER= "player";
    private RecyclerView recyclerView;
    private ArrayList<Roster> roster;
    private RosterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }



    //
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        loadJSON();
    }



    //
    private void launch(Roster player){

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(PLAYER, player);
        startActivity(intent);
    }



    //
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jc-xerxes.gpshopper.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        HockeyAPI request = retrofit.create(HockeyAPI.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                roster = new ArrayList<>(Arrays.asList(jsonResponse.getRoster()));
                adapter = new RosterAdapter(getApplicationContext(),roster );
                recyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(Roster player) {
                        launch(player);

                    }
                });
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
