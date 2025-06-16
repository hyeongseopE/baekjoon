import java.util.Scanner;

public class Main {
    static int N, M, x, y, K;
    static int[][] board;
    static int[] dice = new int[6]; // 0: 윗면, 1: 바닥면, 2: 앞면, 3: 뒷면, 4: 왼쪽, 5: 오른쪽
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            int dir = sc.nextInt();

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            x = nx;
            y = ny;

            rollDice(dir);

            if (board[x][y] == 0) {
                board[x][y] = dice[1];
            } else {
                dice[1] = board[x][y];
                board[x][y] = 0;
            }

            System.out.println(dice[0]);
        }

        sc.close();
    }

    static void rollDice(int dir) {
        int top = dice[0];
        int bottom = dice[1];
        int front = dice[2];
        int back = dice[3];
        int left = dice[4];
        int right = dice[5];

        switch (dir) {
            case 1: // 동쪽
                dice[0] = left;
                dice[1] = right;
                dice[4] = bottom;
                dice[5] = top;
                dice[2] = front;
                dice[3] = back;
                break;

            case 2: // 서쪽
                dice[0] = right;
                dice[1] = left;
                dice[4] = top;
                dice[5] = bottom;
                dice[2] = front;
                dice[3] = back;
                break;

            case 3: // 북쪽
                dice[0] = front;
                dice[1] = back;
                dice[2] = bottom;
                dice[3] = top;
                dice[4] = left;
                dice[5] = right;
                break;

            case 4: // 남쪽
                dice[0] = back;
                dice[1] = front;
                dice[2] = top;
                dice[3] = bottom;
                dice[4] = left;
                dice[5] = right;
                break;
        }
    }
}