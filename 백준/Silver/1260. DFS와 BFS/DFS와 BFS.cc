#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;
int m,n,v,ix,iy,dcnt;
vector<int> vec[1010];
int chk[1010];
int ans[1010],ans2[1010];

int vitsit[1010];
int q[1010];
int top,poll,c;
void bfs(int x){
    top=poll=-1;
    q[++top] = x;
    vitsit[x] = 1;
    ans2[c] = x;
    while(top != poll){
        int tx = q[++poll];

        for (int i = 0; i < vec[tx].size(); ++i) {
            int b = vec[tx].at(i);
            if(!vitsit[b]){
                q[++top] = b;
                vitsit[b] = 1;
                ans2[++c] = b;

            }
        }

    }

}



void dfs(int d){
    chk[d] = 1;
    ans[dcnt++] = d;
    for (int i = 0; i < vec[d].size(); ++i) {
        int x = vec[d].at(i);
        if(!chk[x]) {
            dfs(x);
        }
    }

}

int main() {
    scanf("%d%d%d",&m,&n,&v);


    for (int i = 0; i < n; ++i) {
        scanf("%d%d",&ix,&iy);
        vec[ix].push_back(iy);
        vec[iy].push_back(ix);
    }
    for(int i=1;i<=m;i++)
    {
        sort(vec[i].begin(),vec[i].end());
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
