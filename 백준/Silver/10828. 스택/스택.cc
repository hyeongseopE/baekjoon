
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
using namespace std;
int stack[10001];
int top = -1;


int main(){
    char s[10];
    int n,x;

    scanf("%d",&n);
    for (int i = 0; i < n; i++) {
        scanf("%s",s);
        if(strcmp(s,"push")==0){
            scanf("%d",&x);
            stack[++top] = x;
        }else if(strcmp(s,"top")==0){
            if(top < 0){
                printf("%d\n",-1);
            }else{
                printf("%d\n",stack[top]);
            }
        }else if(strcmp(s,"size")==0){
            printf("%d\n",top+1);
        }else if(strcmp(s,"empty")==0){
            if(top < 0){
                printf("%d\n",1);
            }else {
                printf("%d\n",0);
            }
        }else if(strcmp(s,"pop")==0){
            if(top < 0){
                printf("%d\n",-1);
            }else{
                printf("%d\n",stack[top--]);
            }

        }
    }



    return 0;
}