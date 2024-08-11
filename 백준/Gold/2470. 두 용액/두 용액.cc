#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<algorithm>
using namespace std;

int t[1000100];

int main(){
    int n,dl,dr,max_value = 0x7fffffff,c1,c2;

    int x;
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%d",&t[i]);
    }

    sort(t,t+n);


    for (int i = 0; i < n; ++i) {

        int left = i+1;
        int right = n-1;
        if(t[i] < 0 ){
            x = abs(t[i]);
        }else if (t[i] > 0 ){
            x = -t[i];
        }
        while(left <= right){

            int mid = (left+right)/2;

            if(t[mid] == x){
                printf("%d %d",t[i],x);
                exit(0);
            }else if (t[mid] < x){
                left = mid + 1;
            }else if (t[mid] > x){
                right = mid - 1;
            }
        }

        dl = t[i]+t[left];
        if(dl < 0){dl = dl*-1;}
        if(left < n && max_value > dl){
            max_value = dl; c1 = t[i]; c2 = t[left];
        }

        dr = t[i]+t[right];
        if(dr < 0){dr = dr * -1;}
        if(right > i && max_value > dr){
            max_value = dr; c1 = t[i]; c2 = t[right];
        }


    }
    printf("%d %d",c1,c2);
    return 0;
}