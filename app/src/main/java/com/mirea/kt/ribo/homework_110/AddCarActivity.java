package com.mirea.kt.ribo.homework_110;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddCarActivity extends AppCompatActivity {
    private EditText editTextBrand, editTextNumber, editTextYear;
    private Button buttonSave;
    private Button buttonContinue;



    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        editTextBrand = findViewById(R.id.editTextBrand);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextYear = findViewById(R.id.editTextYear);
        buttonSave = findViewById(R.id.buttonSave);
        buttonContinue = findViewById(R.id.buttonContinue);


        buttonSave.setOnClickListener(v->{
            String brand = editTextBrand.getText().toString();
            String number = editTextNumber.getText().toString();
            String year = editTextYear.getText().toString() ;
            if(!brand.isEmpty() && !number.isEmpty() && !year.isEmpty() ){
                boolean result = dbManager.saveCarToDatabase(new Car(brand,number,Integer.parseInt(year)));
                if(result){
                    Toast.makeText(this, "Машина сохранена", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Ошибка при сохранении", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show();
            }
        });
        buttonContinue.setOnClickListener(v->{
            setResult(RESULT_OK,new Intent());
            finish();
        });

        this.dbManager = new DBManager(new MySqlHelper(this,"my_database.db",null,1));
    }
}