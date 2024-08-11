#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<algorithm>
using namespace std;
int arr [200010];

int main() {
    int n,c,cnt,t,ans;
    scanf("%d%d",&n,&c);
    for (int i = 0; i < n; ++i) {
        scanf("%d",&arr[i]);
    }

    sort(arr,arr+n);

    int left = 0, right = arr[n-1];
    while(left <= right){
        cnt = 1;

        int mid = (left+right)/2;

        t = arr[0]+mid;
        for (int i = 0; i < n; ++i) {
            if(arr[i] >= t){
                cnt++;
                t = arr[i]+mid;
            }
            if(cnt == c){ans = mid;break;}

        }

        if(cnt == c){
            left = mid + 1;

        }else {
            right = mid -1;
        }
    }
    printf("%d\n",ans);


    return 0;
}