//Write a program to solve a fractional Knapsack problem using a greedy method.

import java.util.*;

class Item {
    double profit;
    double weight;

    public Item(double profit, double weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class Knapsack_3 
 {

    static double fractionalKnapsack(double W, Item[] arr) {
        Arrays.sort(arr, (a, b) -> Double.compare(b.profit / b.weight, a.profit / a.weight));

            // Arrays.sort(arr, new Comparator<Item>() {
            //     public int compare(Item a, Item b) {
            //         double ratioA = a.profit / a.weight;
            //         double ratioB = b.profit / b.weight;
            //         return Double.compare(ratioB, ratioA);
            //     }
            // });


        double finalProfit = 0.0;

        for (Item item : arr) {
            if (item.weight <= W) {
                W -= item.weight;
                finalProfit += item.profit;
            } else {
                finalProfit += item.profit * (W / item.weight);
                break;
            }
        }
        return finalProfit;
    }

    public static void main(String[] args) {
        double W = 50;
        Item[] arr = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};

        double maxProfit = fractionalKnapsack(W, arr);
        System.out.println("Maximum profit we can obtain = " + maxProfit);
    }
}

