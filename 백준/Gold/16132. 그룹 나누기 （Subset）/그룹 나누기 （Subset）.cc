#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;
int n,sum,t,x;
long long arr[650];

int main() {

    scanf("%d",&n);
    sum = (n*(n+1))/2;
    arr[0] = 1;

    if(sum % 2 == 0) {
        x = sum/2;
        for (int i = 1; i <= n; ++i) {
            for (int j = x-i; j >= 0 ; --j) {
                if(arr[j] > 0){
                    arr[j+i] += arr[j];
                }
            }
        }
    }else{
        printf("0");
        exit(0);
    }

    printf("%d",arr[sum/2]/2);


    return 0;
}