package graphs;

public class Graph {
    private static int maxN = 10; // максимальное количество вершин
    private int[][] mas; // матрица смежности - показывает наличие связи между вершинами 1 - да есть переход, 0 - нет перехода
    Vertex[] vertexList; // список вершин
    private int curN; // счётчик текущей вершины
    private MyStack stack = new MyStack();
    private MyQueue queue = new MyQueue();
    public Graph() {
       vertexList = new Vertex[maxN];
       mas = new int[maxN][maxN];
       curN = 0;
    }

    public static int getMaxN() {
        return maxN;
    }

    public void setMaxN(int maxN) {
        this.maxN = maxN;
    }

    public void addVertex(char name) {
        vertexList[curN++] = new Vertex(name);
    }

    public void addEdge(int start, int end, int val) {
        mas[start][end] = 1;
        mas[end][start] = val;
    }

    public int check(int v) {
        for (int i = 0; i < curN; i++) {
            if (mas[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    // обход в глубину
    public void passInDeep(int index) {
        System.out.println(vertexList[index].name); // вывод имени вершины
        vertexList[index].isVisited = true;
        stack.push(index); // добавляем вершину в стэк

        while (!stack.isEmpty()) {
            int neigh = check(stack.peek()); // поиск соседа вершины

            if (neigh == -1) { // если нет не посещенного соседа возвращаемся назад
                neigh = stack.pop();
            } else {
                System.out.println(vertexList[neigh].name);
                vertexList[neigh].isVisited = true;
                stack.push(neigh);
            }
        }
        for (int i = 0; i < curN; i++) { // сброс состояния
            vertexList[i].isVisited = false;
        }
    }

    // обход в ширину
    public void passInWidth(int index) {
        System.out.println(vertexList[index].name); // вывод имени вершины
        vertexList[index].isVisited = true;
        queue.insert(index); // добавляем вершину в очередь

        int vertex;

        while (!queue.isEmpty()) {
            int temp = queue.remove();

            while ((vertex = check(temp)) != -1) {
                System.out.println(vertexList[vertex].name);
                vertexList[vertex].isVisited = true;
                queue.insert(vertex);
            }
        }
        for (int i = 0; i < curN; i++) { // сброс состояния
            vertexList[i].isVisited = false;
        }
    }

}
