#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;
int arr [12],n,m,cnt,s[4];
int min_Value = 1000000001;
int max_Value = -1000000001;

void bt(int x,int sum) {

    if(x == n){
        if(max_Value < sum){
            max_Value = sum;
        }
        if(min_Value > sum){
            min_Value = sum;
        }
        return;

    }


    for (int i = 0; i < 4; ++i) {
        if(s[i] >= 1){
            if(i == 0){
                s[i]--;
                bt(x+1,sum + arr[x]);
                s[i]++;
            }else if(i == 1){
                s[i]--;
                bt(x+1,sum - arr[x]);
                s[i]++;
            }else if(i == 2){
                s[i]--;
                bt(x+1,sum * arr[x]);
                s[i]++;
            }else if(i == 3){
                s[i]--;
                bt(x+1,sum / arr[x]);
                s[i]++;
            }

        }
    }

}

int main() {
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%d",&arr[i]);
    }

    for (int i = 0; i < 4; ++i) {
        scanf("%d",&s[i]); //덧 뺏 곱 나
    }

    bt(1,arr[0]);
    printf("%d\n%d",max_Value,min_Value);


    return 0;
}