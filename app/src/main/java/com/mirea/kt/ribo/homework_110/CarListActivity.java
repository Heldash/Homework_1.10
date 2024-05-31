package com.mirea.kt.ribo.homework_110;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarListActivity extends AppCompatActivity {
    private CarAdapter carAdapter;
    private DBManager dbManager;
    private Button addCarBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        RecyclerView recyclerView = findViewById(R.id.car_list_rec);
        dbManager = new DBManager(new MySqlHelper(this,
                "my_database.db",null,1));
        carAdapter = new CarAdapter(dbManager.loadAllCarsFromDatabase());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(carAdapter);
        addCarBtn = findViewById(R.id.add_car_btn);
        addCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityResultLaunch.launch(new Intent(getApplicationContext(),AddCarActivity.class));
            }
        });
    }
    ActivityResultLauncher<Intent> activityResultLaunch = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK){
                        Log.d("CarListActivity","Обновление списка машин");
                        carAdapter.setCars(dbManager.loadAllCarsFromDatabase());
                        carAdapter.notifyDataSetChanged();
                    }
                }
            }
    );

}