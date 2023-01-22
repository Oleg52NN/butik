package myButik.projeсt;

public class RatingBuyer extends Rating {

    double amount = 0;

    public void addEstimation(int amount) {
        estimation.add(amount);
    }

    @Override
    public double getRating() {
        for (double e : estimation
        ) {
            amount += e;
        }
        return amount;
    }
}
