package com.mirea.kt.ribo.homework_110;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car,
                parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.modelCar.setText(car.getBrand());
        holder.numberCar.setText(car.getNumber());
        holder.yearCar.setText(String.valueOf(car.getYear()));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView modelCar,numberCar,yearCar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            modelCar = itemView.findViewById(R.id.modelCar);
            numberCar = itemView.findViewById(R.id.numberCar);
            yearCar = itemView.findViewById(R.id.yearCar);

        }
    }
}
