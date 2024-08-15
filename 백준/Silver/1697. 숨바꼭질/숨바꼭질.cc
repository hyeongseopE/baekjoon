#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<algorithm>
using namespace std;
int q[1000000],chk[1000000],top=-1,poll=-1,k,e,nx,cnt;
int tx[3] = {-1,1};
struct Node{
    int cnt;
}node[1000000];
int bfs(int x){
    q[++top] = x;
    node[top].cnt = cnt++;
    chk[x] = 1;
    while(top != poll){
        nx = q[++poll];
        if(nx == k){
            return node[nx].cnt;
        }
        for (int i = 0; i < 3; ++i) {
            if(i == 2){
                e = nx * 2;
            }else{
                e = nx + tx[i];
            }
            if(!chk[e] && (e >= 0 && e <= 100000)){
                q[++top] = e;
                node[e].cnt = node[nx].cnt+1;
                chk[e] = 1;
            }
        }
    }
    return -1;
}

int main() {
    int n;
    scanf("%d%d",&n,&k);

    printf("%d",bfs(n));




    return 0;
}