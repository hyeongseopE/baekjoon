#include <stdio.h>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;


vector<int> vec[10100];
vector<int> w[10100];
int chk[10010],n,m,ix,iy,cnt,top,poll,q[10100],ans,wei,v1,v2,c;

void bfs(int d,int mid){
    top=poll=-1;
    q[++top] = d;
    chk[d] = 1;
    while(top!=poll){
        int tx = q[++poll];

        if(tx == v2){
            c = 0;
            break;
        }
        for (int i = 0; i < vec[tx].size(); ++i) {
            int x = vec[tx].at(i);
            if (!chk[x]) {
//                printf("w[%d][%d]:%d mid:%d \n",tx,x,w[tx][x],mid);
                if(w[tx].at(i) >= mid){
                    q[++top] = x;
                    chk[x] = 1;
                    cnt++;
                }else {
                    c = 1;
                }

            }
        }
    }
}

int main() {
    scanf("%d%d",&n,&m);

    for (int i = 1; i <= m; ++i) {
        scanf("%d%d%d",&ix,&iy,&wei);
        vec[ix].push_back(iy);
        vec[iy].push_back(ix);
        w[ix].push_back(wei);
        w[iy].push_back(wei);
    }
    scanf("%d%d",&v1,&v2);


    int left = 0,right = 1000000000;
    while(left <= right){
        int mid = (left+right)/2;
        c=0;
        memset(chk,0, sizeof(chk));
        bfs(v1,mid);
        if(c == 1){
            right = mid - 1;
        }else{
            left = mid + 1;
            ans = mid;
        }
    }

    printf("%d",ans);

    return 0;
}
