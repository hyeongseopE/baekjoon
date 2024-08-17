#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;

int chk[101][101];
int map[101][101];
int n,m,top,poll,cnt,ans;
int tx[4] = {-1,1,0,0};
int ty[4] = {0,0,-1,1};
struct queue{
    int x,y;
}q[10100];

void bfs(int x,int y) {
    top = poll = -1;
    q[++top].x = x;
    q[top].y = y;
    chk[x][y] = 1;
    while (top != poll) {
        int x1 = q[++poll].x;
        int y1 = q[poll].y;

        for (int i = 0; i < 4; ++i) {
            int nx = x1 + tx[i];
            int ny = y1 + ty[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){ continue;}
            if(!chk[nx][ny] && map[nx][ny] == 0){
                q[++top].x = nx;
                q[top].y = ny;
                chk[nx][ny]++;
            }else if(map[nx][ny]){
                chk[nx][ny]++;
            }

        }
     }
    


}

int main() {
    scanf("%d%d", &n, &m);

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            scanf("%d",&map[i][j]);
        }
    }

    while(1){
        ans = 1;
        bfs(0,0);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m ; ++j) {
                if(chk[i][j]==1){
                    chk[i][j] = 0;
                }else if(chk[i][j] >= 2){
                    map[i][j] = 0;
                    chk[i][j] = 0;
                }
                if(map[i][j]){ans = 0;}
            }
        }


        cnt++;
        if(ans){printf("%d",cnt);return 0;}

    }

    return 0;
}