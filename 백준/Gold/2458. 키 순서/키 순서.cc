#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;


vector<int> vec[1010];
vector<int> vec2[1010];
int chk[1010],n,m,ix,iy,cnt,top,poll,q[1001],ans;

void bfs(int d,int t){
    top=poll=-1;
    q[++top] = d;
    chk[d] = 1;
    while(top!=poll){
        int tx = q[++poll];

        if(!t){
            for (int i = 0; i < vec[tx].size(); ++i) {
                int x = vec[tx].at(i);
                if(!chk[x]){
                    q[++top] = x;
                    chk[x] = 1;
                    cnt++;
                }
            }
        }else {
            for (int i = 0; i < vec2[tx].size(); ++i) {
                int x = vec2[tx].at(i);
                if(!chk[x]){
                    q[++top] = x;
                    chk[x] = 1;
                    cnt++;
                }
            }
        }

    }
}

int main() {
    scanf("%d%d",&n,&m);

    for (int i = 1; i <= m; ++i) {
        scanf("%d%d",&ix,&iy);
        vec[ix].push_back(iy);
        vec2[iy].push_back(ix);
    }
    /*
     *  1 |        1 | 2
     *  2 | 1      2 | 3
     *  3 | 2      3 |
     */

    for(int i=1;i<=n;i++) {
        sort(vec[i].begin(), vec[i].end());
        sort(vec2[i].begin(), vec2[i].end());
    }


    for (int i = 1; i <= n ; ++i) {
        cnt = 0;
        bfs(i,0);
        memset(chk,0,sizeof(chk));
        bfs(i,1);
        memset(chk,0,sizeof(chk));
        if(cnt == n-1){
            ans++;
        }
    }
    printf("%d",ans);

    return 0;
}
/*
 * 1 | 5               1 |
 * 2 |                 2 | 4 5
 * 3 | 4               3 |
 * 4 | 2 6             4 | 3 5
 * 5 | 2 4             5 | 1
 * 6 |                 6 | 4
 */