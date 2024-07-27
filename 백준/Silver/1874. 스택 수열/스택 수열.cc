
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
using namespace std;
int stack[1000001];
char ans [10000001];
int top=-1;


int main(){
    int n,x,cnt=1,ansCnt=-1;
    scanf("%d",&n);
    for(int i=1;i<=n;i++){
        scanf("%d",&x);
        if(cnt <= x){
            for(int j=cnt;j<=x;j++){
                stack[++top] = cnt++;
                ans[++ansCnt] = '+';
            }
            top--;
            ans[++ansCnt] = '-';
        }else if(stack[top] == x){
            top --;
            ans[++ansCnt] = '-';
        }else if(stack[top] != x){
            ans[++ansCnt] = 'N';
            break;
        }
    }

    if(ans[ansCnt] == 'N'){
        printf("NO");
    }else{
        for(int i=0;i<=ansCnt;i++){
            printf("%c\n",ans[i]);
        }
    }

    return 0;
}