
public class NutsInOasis {

    public static double getMaxNuts(double nuts, double d, int c, int f) {
        // base case:
        // We have the capacity to carry all nuts,
        // so fetch all the nuts in one trip
        if (nuts <= c) {
            double nutsAtDestination = nuts - d * f;
            return (nutsAtDestination >= 0.0) ? nutsAtDestination : 0.0;  // out of fuel!
        }

        // # trips you would travel back and forth
        int numTrips = (int) (2 * (Math.ceil(nuts / c) - 1.0) + 1);
        // how many nuts you consume per km
        double costPerKm = numTrips * f;
        // remaining weight of nuts after consumption
        double remainingnuts = c * (Math.ceil(nuts / c) - 1.0);
        // this is the distance you are able to travel before you
        // reach ONE LESS round trip fetching nuts
        // derived from eq: N - costPerKm * traveled = remainingnuts
        double traveled = (nuts - remainingnuts) / costPerKm;

        // we are able to travel greater (or equal) than the remaining
        // distance, so fetch the nuts right to the destination
        if (traveled >= d) return nuts - d * costPerKm;

        // calculate recursively as we travel ONE less round trip now.
        return getMaxNuts(remainingnuts, d - traveled, c, f);
    }

}
