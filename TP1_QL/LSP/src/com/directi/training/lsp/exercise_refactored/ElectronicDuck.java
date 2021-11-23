package com.directi.training.lsp.exercise_refactored;

public class ElectronicDuck implements IDuck
{
    private boolean _on = false;

    @Override
    public void quack() throws DuckException
    {
        if (_on) {
            System.out.println("Electronic duck quack...");
        } else {
            throw new DuckException("Can't quack when off");
        }
    }

    @Override
    public void swim() throws DuckException
    {
        if (_on) {
            System.out.println("Electronic duck swim...");
        } else {
            throw new DuckException("Cant swim when off");
        }
    }

    public void turnOn()
    {
        this._on = true;
    }

    public void turnOff()
    {
        this._on = false;
    }

}
