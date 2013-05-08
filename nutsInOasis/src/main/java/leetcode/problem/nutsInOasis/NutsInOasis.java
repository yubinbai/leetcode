package leetcode.problem.nutsInOasis;

/**
 * A pile of nuts is in an oasis, across a desert from a town. The pile contains
 * ‘N’ kg of nuts, and the town is ‘D’ kilometers away from the pile.
 * 
 * The goal of this problem is to write a program that will compute ‘X’, the
 * maximum amount of nuts that can be transported to the town.
 * 
 * The nuts are transported by a horse drawn cart that is initially next to the
 * pile of nuts. The cart can carry at most ‘C’ kilograms of nuts at any one
 * time. The horse uses the nuts that it is carrying as fuel. It consumes ‘F’
 * kilograms of nuts per kilometer traveled regardless of how much weight it is
 * carrying in the cart. The horse can load and unload the cart without using up
 * any nuts.
 * 
 * Your program should have a function that takes as input 4 real numbers
 * D,N,F,C and returns one real number: ‘X’
 * 
 */
public class NutsInOasis {

	public static double getMaxNuts(double nuts, double d, int C, int F) {
		// base case:
		// We have the capacity to carry all nuts,
		// so fetch all the nuts in one trip
		if (nuts <= C) {
			double nutsAtDestination = nuts - d * F;
			return (nutsAtDestination >= 0.0) ? nutsAtDestination : 0.0;  // out of fuel!
		}

		// # trips you would travel back and forth
		int numTrips = (int) (2 * (Math.ceil(nuts / C) - 1) + 1);
		// how many nuts you consume per km
		double costPerKm = numTrips * F;
		// remaining weight of nuts after consumption
		double remainingnuts = C * (Math.ceil(nuts / C) - 1.0);
		// this is the distance you are able to travel before you
		// reach ONE LESS round trip fetching nuts
		// derived from eq: N - costPerKm * traveled = remainingnuts
		double traveled = (nuts - remainingnuts) / costPerKm;

		// we are able to travel greater (or equal) than the remaining
		// distance, so fetch the nuts right to the destination
		if (traveled >= d)
			return nuts - d * costPerKm;

		// calculate recursively as we travel ONE less round trip now.
		return getMaxNuts(remainingnuts, d - traveled, C, F);
	}

}
