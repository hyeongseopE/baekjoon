#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;

int m,n,k,top=-1,poll=-1,x1,y1,k1,ans,min_value,cnt;
int map[1010][1010],chk[1010][1010][11];
int tx[4] = {-1,1,0,0};
int ty[4] = {0,0,-1,1};
struct queue{
    int x,y,k;
}q[10010000];
void bfs(int x,int y,int g){
    q[++top].x=x;
    q[top].y=y;
    q[top].k=g;
    chk[x][y][g]=1;
    while(top!=poll){
        x1 = q[++poll].x;
        y1 = q[poll].y;
        k1 = q[poll].k;
        if(x1 == n-1 && y1 == m-1){
            if(cnt >=1){
                if(chk[x1][y1][k1] < min_value){
                    min_value = chk[x1][y1][k1];
                }
            }else{
                min_value = chk[x1][y1][k1];
            }
//            printf("k:%d   chk[%d][%d][%d]:%d\n",k1,x1,y1,k1,chk[x1][y1][k1]);

            ans = 1;
            cnt++;
        }

        for (int i = 0; i < 4; ++i) {
            int nx = x1 + tx[i];
            int ny = y1 + ty[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m){ continue;}
            if(chk[nx][ny][k1] == 0 && map[nx][ny] == 0){
                q[++top].x = nx;
                q[top].y = ny;
                q[top].k = k1;
                chk[nx][ny][k1] = chk[x1][y1][k1] + 1;
            }else if(chk[nx][ny][k1+1] == 0 && map[nx][ny] == 1 &&  k1  < k){
                q[++top].x = nx;
                q[top].y = ny;
                chk[nx][ny][k1+1] = chk[x1][y1][k1] + 1;
//                chk[x1][y1][k+1] = chk[x1][y1][k];
                q[top].k = k1 + 1;
            }
        }
    }

}

int main() {
    scanf("%d%d%d",&n,&m,&k);

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            scanf("%1d",&map[i][j]);
        }
    }

    bfs(0,0,0);

    if(ans) {
        printf("%d",min_value);
    }else{
        printf("-1");
    }
    return 0;
}