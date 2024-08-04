#include<stdio.h>
#include<string.h>

int arrX [101], arrY[101];


int main(){
    int v,m,n,x=2,y=2,t,sum=0;
    scanf("%d%d%d",&arrY[1],&arrX[1],&n);

    for (int i=0;i<n;i++){
        scanf("%d%d",&v,&m);
        if(v){
            arrY[y] = m;
            y++;
        }else{
            arrX[x] = m;
            x++;
        }
    }

    for(int i=0;i<x-1;i++){
        for(int j=i;j<x;j++){
            if(arrX[i] > arrX[j]){
                t=arrX[i];arrX[i]=arrX[j];arrX[j]=t;
            }
        }
    }

    for(int i=0;i<y-1;i++){
        for(int j=i;j<y;j++){
            if(arrY[i] > arrY[j]){
                t=arrY[i];arrY[i]=arrY[j];arrY[j]=t;
            }
        }
    }

    t=0;
    for(int i=1;i<x;i++){
        for (int j = 1; j < y; j++) {
            sum = (arrX[i] - arrX[i-1])*(arrY[j] - arrY[j-1]);
            if(t < sum){
                t = sum;
            }
        }
    }

    printf("%d",t);

    return 0;
}