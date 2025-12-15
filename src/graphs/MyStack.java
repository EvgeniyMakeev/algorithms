package graphs;

public class MyStack {
    private int size = Graph.getMaxN();
    private int top;
    private int[] array;

    public MyStack() {
        array = new int[size];
        top = -1; // пусто
    }

    // добавление вершины
    public void push(int v) {
        array[++top] = v;
    }

    // выдает и удаляет вершину
    public int pop() {
        return array[top--];
    }

    // выдает не удаляя
    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}
