import java.util.*;

public class Dima {

    static Queue<Pair> q = new LinkedList<Pair>();
    static int map[][] = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 9, 6, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0}};
    static Pair grid[][] = new Pair[5][5];

    Dima() {
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                grid[i][j] = new Pair(-1, -1); } } }

    public static void main(String[] args) {
        q.add(new Pair(2,2)); // add first node
        DFS(); }

    static public void DFS() {
        if (q.isEmpty()) return;
        Pair curr = q.remove();
        if (map[curr.x][curr.y] == 6) {
            System.out.println("FIND:" + curr.x + " " + curr.y);
            return; }
        map[curr.x][curr.y] = 5;
        // push in queue children (from 4 possible)
        if (curr.x > 0 && (map[curr.x - 1][curr.y] == 0 || map[curr.x - 1][curr.y] == 6)) {
            q.add(new Pair(curr.x - 1, curr.y)); }
        if (curr.x < 4 && (map[curr.x + 1][curr.y] == 0 || map[curr.x + 1][curr.y] == 6)) {
            q.add(new Pair(curr.x + 1, curr.y)); }
        if (curr.y > 0 && (map[curr.x][curr.y - 1] == 0 || map[curr.x][curr.y - 1] == 6)) {
            q.add(new Pair(curr.x, curr.y - 1)); }
        if (curr.y < 4 && (map[curr.x][curr.y + 1] == 0 || map[curr.x][curr.y + 1] == 6)) {
            q.add(new Pair(curr.x, curr.y + 1)); }

        System.out.println("-> " + curr.x + " " + curr.y);
        DFS(); } }

class Pair {
    int x,y;
    Pair() {}
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
