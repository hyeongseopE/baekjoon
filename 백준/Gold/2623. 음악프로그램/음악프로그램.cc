#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

vector<int> vec[1010];
int arr [1010];
int ix,iy,n,m,t,ans[1010],k,cnt;
int q[1010],top,poll;

void bfs(){
    while(top!=poll){
        int tx = q[++poll];
        if(!arr[tx]){
            ans[cnt++] = tx;
        }

        for (int i = 0; i <vec[tx].size() ; ++i) {
            int x = vec[tx].at(i);
            if(arr[x] == 1){
                q[++top] = x;
                arr[x] -- ;
            }else if(arr[x] > 1){
                arr[x]--;
            }
        }
    }
}

int main() {
    scanf("%d%d",&n,&m);

    for (int i = 0; i < m; ++i) {
        scanf("%d%d",&k,&ix);
        for (int j = 0; j < k-1; ++j) {
            scanf("%d",&iy);
            vec[ix].push_back(iy);
            arr[iy]++;
            ix = iy;
        }
    }

    top = poll = -1;
    for (int i = 1; i <= n; ++i) {
       if(!arr[i]){
           q[++top] = i;
       }
    }

    bfs();
    if(cnt == n){
        for (int i = 0; i < cnt; ++i) {
            printf("%d\n",ans[i]);
        }
    }else {
        printf("0");
    }

    return 0;
}
