#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;

int dp[1001],d[1001],t[1001],n,cnt,c,Max_Value,x,e,ans[1001],w;

int main() {

    scanf("%d",&n);

    for (int i = 0; i < n; ++i) {
        scanf("%d",&dp[i]);
        d[i] = 1;
        t[i] = -1;
    }

    for (int i = 1; i < n; ++i) {
        int index = i;
        x=0;e=0;
        if(dp[i] > dp[i-1]){
            x = d[i];
            for (int j = 0; j < i; ++j) {
                if(x <= d[j] && dp[i] > dp[j]){
                    x = d[j];
                    index = j;
                }
            }
            d[i] = d[index]+1; // 깊이
            t[i] = index;      // 역추적

        }else{
            x = d[i];
            for (int j = 0; j < i; ++j) {
                if(dp[i] > dp[j] && x <= d[j]){
                    x = d[j];
                    index = j;
                    e=1;
                }
            }
            if(e==1){
                d[i] = d[index]+1;
                t[i] = index;
            }

        }
    }
    
    for (int i = 0; i < n; ++i) {
        if(d[i] > Max_Value){Max_Value = d[i];cnt=i;}
    }
    for (int i = cnt; i >= 0; i--) {
        if(cnt == i ){
            ans[w++] = dp[i];
            cnt = t[i];
        }
    }

    printf("%d\n",w);
    for (int i = w-1; i >= 0 ; --i) {
        printf("%d ",ans[i]);
    }


}