package com.directi.training.srp.exercise_refactored;

import java.util.List;

public class CarFormatter {

    public String getNames(List<Car> carsDb)
    {
        StringBuilder sb = new StringBuilder();
        for (Car car : carsDb) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
