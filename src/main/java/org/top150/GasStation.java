package org.top150;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost,
 * return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0;
        int currentFuel = 0;
        // total fuel minus total gas consumption
        // if it's positive, there has to be one legal solution
        int totalFuelExtra = 0;
        for (int i = 0; i < gas.length; i++) {
            // fuel the tank
            currentFuel += gas[i] - cost[i];
            totalFuelExtra += gas[i] - cost[i];
            if (currentFuel < 0) {
                currentFuel = 0;
                // insufficient fuel during the last interval
                // thus start point can not be in it
                startIndex = i + 1;
            }
        }
        if (totalFuelExtra >=0) {
            // since the problem claims there will be only one solution
            return startIndex;
        } else {
            return -1;
        }
    }
}
