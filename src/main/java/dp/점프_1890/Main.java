package dp.점프_1890;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static long[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                visited[i][j] = -1;
            }
        }

        System.out.println(func(0, 0));
    }

    private static long func(int r, int c) {
        if (r == N - 1 && c == N - 1) return 1;
        if (visited[r][c] == -1) {
            visited[r][c] = 0;
            for (int i = 0; i < 2; i++) {
                int w = map[r][c];
                int nr = r + (w * dr[i]);
                int nc = c + (w * dc[i]);
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                visited[r][c] += func(nr, nc);
            }
        }
        return visited[r][c];
    }
}
