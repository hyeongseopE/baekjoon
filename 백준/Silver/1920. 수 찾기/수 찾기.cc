#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;

int t [100001];
int main(){

    int n,m,found,ans;
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%d",&t[i]);
    }

    sort(t,t+n);

    scanf("%d",&m);
    for (int i = 0; i < m; ++i) {
        scanf("%d",&found);
        int left = 0,right = n-1;
        ans = 0;
        while(left <= right){

            int mid = (left+right)/2;

            if(t[mid] == found){
                ans = 1;
                break;
            }else if(found < t[mid]){
                right = mid - 1;
            }else if (found > t[mid]){
                left = mid + 1;
            }

        }
        printf("%d\n",ans);

    }




    return 0;
}