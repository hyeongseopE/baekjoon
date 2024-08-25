#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;

long long chk[100];
int n;

void dp(int x){
    if(chk[x] != 0 ){return;}
    if(x <= 2){chk[x] = 1; return;}
    dp(x-2);
    dp(x-1);
    chk[x] = chk[x-2]+chk[x-1];

}
int main() {

    scanf("%d",&n);
    dp(n);
    printf("%lld",chk[n]);


}