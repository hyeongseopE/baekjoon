#include <stdio.h>
int map[101][101],chk[101][101],top=-1,poll=-1,n,m,x1,y1;
int tx[4] = {-1,1,0,0};
int ty[4] = {-0,0,-1,1};
struct Node{
    int x,y,cnt=1;
}node[101][101];
struct q {
    int x,y;
}q[10001];
int bfs(int x,int y)
{
    q[++top].x = x;
    q[top].y = y;
    chk[x][y] = 1;
    while(top != poll){
        poll++;
        x1 = q[poll].x;
        y1 = q[poll].y;
        node[x1][y1].x = x1;
        node[x1][y1].y = y1;

        if(node[x1][y1].x == n-1 && node[x1][y1].y == m-1){
            return node[x1][y1].cnt;
        }
        for(int i=0; i<4; i++){
            int nx = x1 + tx[i];
            int ny = y1 + ty[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){continue;}
            if(!chk[nx][ny] && map[nx][ny]){
                top++;
                q[top].x = nx;
                q[top].y = ny;
                node[nx][ny].cnt = node[x1][y1].cnt +1;
                chk[nx][ny] = 1;
            }
        }
    }
    return -1;
}
int main()
{
    scanf("%d%d",&n,&m);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            scanf("%1d",&map[i][j]);
        }
    }

    printf("%d",bfs(0,0));

    return 0;
}