package com.directi.training.lsp.exercise_refactored;

import org.yaml.snakeyaml.events.Event;

public class Pool
{
    public void run()
    {
        Duck donaldDuck = new Duck();
        ElectronicDuck workingelectronicDuck = new ElectronicDuck();
        ElectronicDuck notWorkingelectronicDuck = new ElectronicDuck();
        workingelectronicDuck.turnOn();
        quack(donaldDuck, workingelectronicDuck,notWorkingelectronicDuck);
        swim(donaldDuck, workingelectronicDuck,notWorkingelectronicDuck);
    }

    private void quack(IDuck... ducks)
    {
        for (IDuck duck : ducks) {
            try {
                duck.quack();
            } catch (DuckException e) {
                e.printStackTrace();
            }
        }
    }

    private void swim(IDuck... ducks)
    {
        for (IDuck duck : ducks) {
            try {
                duck.swim();
            } catch (DuckException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        Pool pool = new Pool();
        pool.run();
    }
}
