#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
int arr[50001];
int main(){
    int n,q,h=-1,a,x,ans;
    scanf("%d%d",&n,&q);
    for (int i = 1; i <= n; ++i) {
        scanf("%d",&a);
        h = h+a;
        arr[i] = h;
    }
    for (int i = 0; i < q; ++i) {
        ans = 0;
        int left = 1,right = n-1;
        scanf("%d",&x);
        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == x){
                printf("%d\n",mid);
                ans = 1;
                break;
            }else if(arr[mid] < x){
                left = mid + 1;
            }else if (arr[mid] > x ){
                right = mid - 1;
            }
        }
        if(!ans) {
            printf("%d\n", left);
        }
    }





    return 0;
}