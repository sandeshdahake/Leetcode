package algo;

/**
 * https://leetcode.com/problems/car-pooling/
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 *
 * You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
 *
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 *
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 */
public class Car_Pooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxPassengers = 0;
        int[] insideCar = new int[1001];
        for (int[] trip :  trips) {
            insideCar[trip[1]] += trip[0];
            insideCar[trip[2]] -= trip[0];
        }
        for (int i = 0; i <= 1000; i ++) {
            maxPassengers += insideCar[i];
            if (maxPassengers > capacity) return false;
        }
        return true;
    }
}
