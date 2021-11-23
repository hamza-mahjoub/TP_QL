package com.directi.training.srp.exercise_refactored;

import java.util.List;

public class CarRater {

    public Car getBest(List<Car> carsDb)
    {
        Car bestCar = null;
        for (Car car : carsDb) {
            if (bestCar == null || car.getModel().compareTo(bestCar.getModel()) > 0) {
                bestCar = car;
            }
        }
        return bestCar;
    }
}
