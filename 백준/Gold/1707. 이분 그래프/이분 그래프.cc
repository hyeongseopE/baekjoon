#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

vector<int> vec[20010];
int ix,iy,n,m,t,chk[20010],ans;




void dfs(int d,int c){

    if(ans == 1){return ;}
    chk[d] = c;
    for (int i = 0; i < vec[d].size(); ++i) {
        int x = vec[d].at(i);
        if(chk[x] == -1){
            dfs(x,!c);
        }else {
            if(chk[x] == c){ans = 1;}
        }
    }
}

int main() {
    scanf("%d",&t);

    for (int i = 0; i < t; ++i) {

        scanf("%d%d",&n,&m);
        ans = 0;
        fill(chk,chk+n+1,-1);
        for (int j = 1; j <= n ; ++j) {
            vec[j].clear();
        }
        for (int j = 1; j <= m; ++j) {
            scanf("%d%d",&ix,&iy);
            vec[ix].push_back(iy);
            vec[iy].push_back(ix);
        }

        for (int j = 1; j <= n; ++j) {
            if(chk[j] == -1){
                dfs(j,1);
            }
            if(ans == 1){break;}
        }
        if(ans){
            printf("NO\n");
        }else{
            printf("YES\n");
        }

    }



    return 0;
}
