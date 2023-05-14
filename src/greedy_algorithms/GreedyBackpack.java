package greedy_algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// Наполнение рюкзака с макс стоимостью (можно брать часть товара)
// Жадный алгоритм
public class GreedyBackpack {

    class Item implements Comparable<Item>{
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {
//            double r1 = (double) cost / weight;
//            double r2 = (double) o.cost / o.weight;

            // Убрали double при сравнении (для скорости и избежания ошибок)
            long r1 = (long) cost * o.weight;
            long r2 = (long) o.cost * weight;
            return -Long.compare(r1, r2);
        }
    }
//    private int greedyKnapsack(int n) {
//        return a;
//    }

    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        int n = input.nextInt();
        int w = input.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < items.length; i++) {
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        input.close();

        System.out.println("Жадный Рюкзак V1");
        System.out.println("Вместимость рюкзака = " + w);
        System.out.println("Переданные вещи:");

        for (Item item : items) {
            System.out.println(item.toString());
        }
// Можно так или использовать интерфейс в классе
//        Arrays.sort(items, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                double r1 = (double) o1.cost / o1.weight;
//                double r2 = (double) o2.cost / o2.weight;
//                return -Double.compare(r1, r2);
//            }
//        });

        Arrays.sort(items);

//        for (Item item : items) {
//            System.out.println(item.toString());
//        }

        double result = 0;
        for (Item item : items) {
            if (item.weight <= w) {
                result += item.cost;
                w -= item.weight;
            } else {
                result +=  item.cost * (double) w / item.weight;
//                w = 0;  //Можно и так
                break;
            }
        }


        System.out.println("Максимальная стоимость = " + result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new GreedyBackpack().run();
    }
}
