#include<stdio.h>
#include<string.h>
#include<algorithm>
using namespace std;
int arr[2001];

struct tmp{
    int s,e,w;
}t[100001];

int chk (tmp o1, tmp o2){
    return o1.e < o2.e;
}
int main(){

    int n,cnt=0,c,m,j=0;
    scanf("%d%d%d",&n,&c,&m);
    for (int i = 0; i < m; ++i) {
        scanf("%d%d%d",&t[i].s,&t[i].e,&t[i].w);
    }

    sort(t,t+m,chk);


//    for (int i = 0; i < m; ++i) {
//        printf("%d %d %d\n",t[i].s,t[i].e,t[i].w);
//    }

    int sum = 0;
    for (int i = 0; i < m; ++i) {
        int max = 0;
        for (int k = t[i].s; k < t[i].e ; ++k) {
            if(max < arr[k]){
                max = arr[k];
            }
        }
        int x = c - max;
        if(max < c ){
            if(x < t[i].w){
                for (int k = t[i].s; k < t[i].e; ++k) {
                    arr[k] += c-max;
                }
                sum += x;
            }else{
                for (int k = t[i].s; k < t[i].e; ++k) {
                    arr[k] += t[i].w;
                }
                sum += t[i].w;
            }
        }

    }


    printf("%d",sum);

    return 0;
}