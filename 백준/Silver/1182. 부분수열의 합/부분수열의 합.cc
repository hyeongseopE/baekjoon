#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;
int arr [21],n,m,sum,cnt;
void bt(int x,int c){

    if(x == n){
        if(sum == m && c >= 1){
            cnt++;
            return;
        }else{
            return;
        }
    }
    sum += arr[x];
    bt(x+1,c+1);
    sum -= arr[x];
    bt(x+1,c);

}

int main() {
    scanf("%d%d",&n,&m);

    for (int i = 0; i < n; ++i) {
        scanf("%d",&arr[i]);
    }

    bt(0,0);
    printf("%d",cnt);

    return 0;
}