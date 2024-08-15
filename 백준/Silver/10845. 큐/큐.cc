#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<algorithm>
using namespace std;
int arr [10001],top=-1,poll=-1;
char c[6];

int main() {
    int n,m;
    scanf("%d",&n);
    for (int i = 0; i < n; ++i) {
        scanf("%s",c);
        if(!strcmp(c,"push")){
            scanf("%d",&m);
            arr[++top] = m;
        }else if(!strcmp(c,"pop")){
            if(top == poll){
                printf("-1\n");
            }else{
                printf("%d\n",arr[++poll]);
            }

        }else if(!strcmp(c,"size")){
            printf("%d\n",top - poll);
        }else if(!strcmp(c,"empty")){
            if(top == poll){
                printf("1\n");
            }else{
                printf("0\n");
            }
        }else if(!strcmp(c,"front")){
            if(top == poll){
                printf("-1\n");
            }else{
                printf("%d\n",arr[++poll]);
                poll --;
            }
        }else if(!strcmp(c,"back")){
            if(top == poll){
                printf("-1\n");
            }else{
                printf("%d\n",arr[top]);
            }
        }
    }


    return 0;
}