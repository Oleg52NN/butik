package myButik.projeсt;

import java.util.ArrayList;
import java.util.List;

public abstract class Rating {

    List<Integer> estimation = new ArrayList<>();

    public abstract void addEstimation(int estimate);

    public abstract double getRating();
}
