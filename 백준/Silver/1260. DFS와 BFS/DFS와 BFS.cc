#include <stdio.h>
#include <algorithm>
#include <cstring>
using namespace std;
int m,n,v,ix,iy,dcnt;
int map[1001][1001];
int chk[1001];
int ans[1001],ans2[1001];

int vitsit[1001];
int q[1001];
int top,poll,c;
void bfs(int x){
    top=poll=-1;
    q[++top] = x;
    vitsit[x] = 1;
    ans2[c] = x;
    while(top != poll){
        int tx = q[++poll];

        for (int i = 1; i <= m; ++i) {
            if(map[tx][i] == 1 && !vitsit[i]){
                q[++top] = i;
                vitsit[i] = 1;
                ans2[++c] = i;

            }
        }

    }

}



void dfs(int d){
    chk[d] = 1;
    ans[dcnt++] = d;
    if(dcnt > n){return;}
    for (int i = 1; i <= m; ++i) {
        if(map[d][i]==1&&!chk[i]){
            dfs(i);
        }
    }

}

int main() {
    scanf("%d%d%d",&m,&n,&v);

    for (int i = 0; i < n; ++i) {
        scanf("%d%d",&ix,&iy);
        map[ix][iy] = 1;
        map[iy][ix] = 1;
    }


    dfs(v);
    bfs(v);

    for (int i = 0; i < dcnt; ++i) {
        printf("%d ",ans[i]);
    }
    printf("\n");
    for (int i = 0; i <= c; ++i) {
        printf("%d ",ans2[i]);
    }

    return 0;
}
