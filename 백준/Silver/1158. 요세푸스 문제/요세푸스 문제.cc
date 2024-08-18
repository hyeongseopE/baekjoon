#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;

int n,k,q[5001*5001],top=-1,poll=-1,a=-1,cnt;
int main() {
    scanf("%d%d",&n,&k);

    for (int i = 1; i <= n; ++i) {
        q[++top] = i;
    }

    while(top!=poll){
        for (int i = 0; i < k-1; ++i) {
            int x = q[++poll];
            q[++top] = x;
        }
        q[++a] = q[++poll];
    }

    for (int i = 0; i <= a; ++i) {

        if(a == 0){
            printf("<%d>",q[i]);
        }else if(i == 0){
            printf("<%d, ",q[i]);
        }else if(i == a){
            printf("%d>",q[i]);
        }else{
            printf("%d, ",q[i]);
        }



    }

    return 0;
}