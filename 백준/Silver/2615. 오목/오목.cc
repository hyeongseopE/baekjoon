
#include<stdio.h>
#include<stdlib.h>
#include<algorithm>
using namespace std;
int arr[20][20];
int xcnt =0;
void sub(int m,int a,int b,int x,int y,int cnt){

    if(cnt == 5 && arr[x+a][y+b]!=arr[x][y]){
        xcnt = cnt;
        return ;
    }
    if(arr[x+a][y+b] == m ){
        sub(m,a,b,x+a,y+b,cnt+1);
    }

}

int main(){

    for(int i=1;i<=19;i++){
        for(int j=1;j<=19;j++){
            scanf("%d",&arr[i][j]);
        }
    }

    for(int i=1;i<=19;i++){
        for(int j=1;j<=19;j++){
            if(arr[i][j] != 0 && arr[i][j] != arr[i+1][j-1]  ){
                sub(arr[i][j],-1,1,i,j,1);
            }
            if(arr[i][j] != 0 && arr[i][j] != arr[i][j-1] ){
                sub(arr[i][j],0,1,i,j,1);
            }
            if(arr[i][j] != 0 && arr[i][j] != arr[i-1][j-1] ){
                sub(arr[i][j],1,1,i,j,1);
            }
            if(arr[i][j] != 0 && arr[i][j] != arr[i-1][j] ){
                sub(arr[i][j],1,0,i,j,1);
            }
            if(xcnt == 5){
                printf("%d\n%d %d",arr[i][j],i,j);
                return 0;
            }

        }
    }

    if(xcnt == 0 ){
        printf("0");
    }


    return 0;
}
/*
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 2 0 0 2 2 2 1 0 0 0 0 0 0 0 0 0 0
0 0 1 2 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */

/*
#include<stdio.h>

int arr[6][6];
int chk[6][6];
int arrX[26];
int arrY[26];
int nx,ny,n,cnt =0;
int tx[4] = {-1,1,0,0};
int ty[4] = {0,0,-1,1};
void sub(int a,int b,int k){
    arrX[k] = a;
    arrY[k] = b;

    if(a==n-1 && b==n-1){
        printf("%d\n",k);
        for(int i=0; i<=k;i++){
            printf("(%d,%d)",arrX[i],arrY[i]);
        }
        printf("\n");
        cnt ++;
        return;
    }

    chk[a][b] = 1;

    for (int i=0;i<4;i++){
        nx = a+tx[i];
        ny = b+ty[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n ){ continue;}
        if(arr[nx][ny] && !chk[nx][ny]){
            sub(nx,ny,k+1);
        }
    }
    chk[a][b] = 0;

}

int main(){
    scanf("%d",&n);

    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            scanf("%d",&arr[i][j]);
        }
    }
    for(int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            printf("%d",arr[i][j]);
        }
        printf("\n");
    }
    sub(0,0,0);
    printf("%d",cnt);


    return 0;
}
/*
5
1 1 1 1 1
1 0 0 0 1
1 0 0 0 1
1 0 0 1 1
1 1 1 1 1

 */
