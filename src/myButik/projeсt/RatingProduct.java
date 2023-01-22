package myButik.projeсt;

public class RatingProduct extends Rating {

    @Override
    public void addEstimation(int estimate) {
        estimation.add(estimate);
    }

    @Override
    public double getRating() {
        if (estimation.size() == 0) {
            return 0;
        }
        double amount = 0;
        for (Integer e : estimation
        ) {
            amount += e;
        }
        return amount / ((double) estimation.size());
    }

}
