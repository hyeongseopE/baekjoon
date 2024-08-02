#include<stdio.h>

long long stack[80001];
long long top=-1;


int main(){
    long long n,x,cnt=0;
    scanf("%lld",&n);
    for(int i=0;i<n;i++){
        scanf("%lld",&x);
        if(top < 0 || stack[top] > x ){
            stack[++top] = x; //
        }else if(stack[top] <= x ){
            while(1){
                cnt += top;
                top --;
                if(top < 0 ||stack[top] > x){
                    stack[++top] = x;
                    break;
                }
            }
        }
    }


    if(top > 0 ){
        while(1){
            top --;
            if(top < 0){
                printf("%lld",cnt);
                break;
            }
            if(stack[top] > stack[top+1]){
                cnt += top+1;
            }
        }
    }else{
        printf("%lld",cnt);
    }



    return 0;
}