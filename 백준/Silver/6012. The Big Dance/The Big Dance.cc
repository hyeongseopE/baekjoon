#include<stdio.h>
int sub(int m,int n){
    if(n-m ==1){
        return n*m;
    }
    if(n == m){
        return 0;
    }
    return sub(m,(n+m)/2) + sub(((n+m)/2)+1,n);

}
int main(){
    int n;
    scanf("%d",&n);
    printf("%d",sub(1,n));



    return 0;
}