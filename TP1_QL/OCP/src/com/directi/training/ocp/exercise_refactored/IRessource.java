package com.directi.training.ocp.exercise_refactored;

public interface IRessource {
    int findFree();
    void markBusy(int idRessource);
    void markFree(int idRessource);
}