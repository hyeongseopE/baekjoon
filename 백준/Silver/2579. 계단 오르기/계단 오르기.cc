#include <stdio.h>
#include <algorithm>
#include <cstring>
using namespace std;

int dp1[301],dp2[301],dp[301],t,n,c,sum,sum2;
int arr[301];

int main() {
    scanf("%d",&n);


    for (int i = 1; i <= n; ++i) {
        scanf("%d",&arr[i]);
    }
    dp1[1] = dp2[1] = arr[1];
    dp1[2]=arr[1]+arr[2]; // 30
    dp2[2]=arr[2];        // 10

    for (int i = 3; i <= n; ++i) {

        dp1[i] = dp2[i-1]+arr[i];
        dp2[i] = max(dp2[i-2],dp1[i-2])+arr[i];


    }

    printf("%d",max(dp1[n],dp2[n]));
    return 0;
}
