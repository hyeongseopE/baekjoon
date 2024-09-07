#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;


vector<int> vec[1010];
int chk[1010],n,m,ix,iy,cnt;

void dfs(int d){
    chk[d] = 1;
    for (int i = 0; i < vec[d].size() ; ++i) {
        int x = vec[d].at(i);
        if(!chk[x]){
            dfs(x);

        }
    }

}

int main() {
    scanf("%d%d",&n,&m);


    for (int i = 1; i <= m; ++i) {
        scanf("%d%d",&ix,&iy);
        vec[ix].push_back(iy);
        vec[iy].push_back(ix);
    }

    for(int i=1;i<=n;i++) {
        sort(vec[i].begin(), vec[i].end());
    }

    for (int i = 1; i <= n; ++i) {
        if(!chk[i]) {
            dfs(i);
            cnt++;
        }
    }

    printf("%d",cnt);

    return 0;
}
