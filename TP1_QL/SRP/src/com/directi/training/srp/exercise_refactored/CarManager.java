package com.directi.training.srp.exercise_refactored;

public class CarManager
{
    private final CarDao _carsDao;
    private final CarFormatter _carsFormatter;
    private final CarRater _carsRater;

    public CarManager(CarDao carsDao,CarFormatter carsFormatter,CarRater carsRater){
        _carsDao = carsDao;
        _carsFormatter = carsFormatter;
        _carsRater = carsRater;
    }

    public Car getCarById (final String carId)
    {
        return _carsDao.getFromDb(carId);
    }

    public String getCarsNames()
    {
        return _carsFormatter.getNames(_carsDao.getAll());
    }

    public Car getBestCar()
    {
        return _carsRater.getBest(_carsDao.getAll());
    }
}
