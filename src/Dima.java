import java.util.*;

public class Dima {

    static public int x = -1, y = -1;
    static public boolean fFlag = false;

    static Queue<Pair> q = new LinkedList<Pair>();
    static Stack<Pair> path = new Stack<Pair>();
    static int map[][] = {  {0, 0, 0, 0, 0},
                            {0, 1, 1, 1, 0},
                            {0, 1, 9, 0, 0},
                            {0, 1, 0, 0, 0},
                            {6, 1, 0, 0, 0}};

    static Pair grid[][] = new Pair[5][5];

    public static void main(String[] args) {

        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                grid[i][j] = new Pair(-1, -1);
            }
        }

        grid[2][2].setXY(2, 2); // start point
        q.add(new Pair(2, 2)); // add first node
        DFS();
        if (!fFlag) {
            System.out.println("sorry, NOT FOUND");
        } else {
            System.out.println("next step: " + backTrace(new Pair(x, y)));
        }
        System.out.println("All path:");
        for (Pair el:path) {
            System.out.println(el);
        }

    }

    static public void DFS() {
        if (q.isEmpty()) return;
        Pair curr = q.remove();
        if (map[curr.x][curr.y] == 6) {
            fFlag = true;
            System.out.println("FIND:" + curr.x + " " + curr.y);
            x = curr.x;
            y = curr.y;
            return;
        }
        map[curr.x][curr.y] = 5; // visited

        // push in queue children (from 4 possible)
        if (curr.x > 0 && (map[curr.x - 1][curr.y] == 0 || map[curr.x - 1][curr.y] == 6)) {
            q.add(new Pair(curr.x - 1, curr.y));
            grid[curr.x - 1][curr.y].setXY(curr.x, curr.y);
        }
        if (curr.x < 4 && (map[curr.x + 1][curr.y] == 0 || map[curr.x + 1][curr.y] == 6)) {
            q.add(new Pair(curr.x + 1, curr.y));
            grid[curr.x + 1][curr.y].setXY(curr.x, curr.y);
        }
        if (curr.y > 0 && (map[curr.x][curr.y - 1] == 0 || map[curr.x][curr.y - 1] == 6)) {
            q.add(new Pair(curr.x, curr.y - 1));
            grid[curr.x][curr.y - 1].setXY(curr.x, curr.y);
        }
        if (curr.y < 4 && (map[curr.x][curr.y + 1] == 0 || map[curr.x][curr.y + 1] == 6)) {
            q.add(new Pair(curr.x, curr.y + 1));
            grid[curr.x][curr.y + 1].setXY(curr.x, curr.y);
        }
        DFS();
    }

    static public Pair backTrace(Pair p) {
        if (grid[p.x][p.y].x == p.x && grid[p.x][p.y].y == p.y) {
            path.pop();
            return path.peek();
        }
        path.push(new Pair(grid[p.x][p.y].x, grid[p.x][p.y].y));
        return backTrace(path.peek());
    }
}

class Pair {
    int x,y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y; }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y; }

    public String toString() {
        return "x: " + x + ", y: " + y;
    }
}