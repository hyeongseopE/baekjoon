#include <stdio.h>
#include <algorithm>

using namespace std;

int main(){
    int a[3];
    for(int i = 0;i < 3;i++)
        scanf("%d", &a[i]);
    sort(a, a + 3);
    printf("%d", a[1] + a[2]);
}