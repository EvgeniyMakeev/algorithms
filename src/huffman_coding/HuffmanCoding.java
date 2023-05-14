package huffman_coding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HuffmanCoding {

    class Node implements Comparable<Node>{
        // суммарная частота встречи символа
        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }
    // класс для узлов у которых есть дети
    class InternalNode extends Node{
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            // сумма равна сумме левого и правого ребёнка
            super(left.sum + left.sum);
            this.left = left;
            this.right = right;
        }
    }

    // класс для листьев
    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            // сумма всегда равная тому, сколько раз этот символ встречается
            super(count);
            this.symbol = symbol;
        }
    }

    public void run() throws FileNotFoundException {
        Scanner input = new Scanner(new File("input2.txt"));
        String s = input.next();
        input.close();
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
//        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        Map<Character, Node> charNodes = new HashMap<>();
        //приоритетная очередь (на вершине очереди хранится минимальный элемент)
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode leafNode = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), leafNode);
            priorityQueue.add(leafNode);
        }
        int sum = 0;
        // склеиваем листы в узлы
        while (priorityQueue.size() > 1) {
            Node first = priorityQueue.poll();
            Node second = priorityQueue.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            priorityQueue.add(node);
        }
        System.out.println(count.size() + " " + sum);
        Node root = priorityQueue.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(charNodes.get(c).code);
        }
        System.out.println(stringBuilder);
    }
}