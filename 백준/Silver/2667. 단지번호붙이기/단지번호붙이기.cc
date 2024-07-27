
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<algorithm>
using namespace std;
int arr[26][26], chk[26][26],cntChk[26],nx,ny,n,cnt,mapCnt,max_num,t;
int tx[4] = {-1,1,0,0};
int ty[4] = {0,0,-1,1};

void map(int a, int b){
    if(!arr[a][b]){
        return;
    }
    chk[a][b] = true;
    mapCnt ++;

    for(int i=0;i<4;i++){
        nx = a+tx[i];
        ny = b+ty[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n){ continue;}
        if(arr[nx][ny] && !chk[nx][ny]){
            map(nx,ny);
        }

    }

}

int main(){

    scanf("%d",&n);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%1d",&arr[i][j]);
        }
    }


    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(arr[i][j] && !chk[i][j]){
                map(i,j);
                cntChk[cnt] = mapCnt;
                cnt++;
            }
            mapCnt = 0;
        }
    }

    for(int i=0;i<cnt;i++){
        for(int j=i+1;j<cnt;j++){
            if(cntChk[i] > cntChk[j]){
                t = cntChk[i];cntChk[i]=cntChk[j];cntChk[j]=t;
            }
        }
    }
    
    printf("%d\n",cnt);
    for(int i=0;i<cnt;i++){
        if(i==cnt-1){
            printf("%d",cntChk[i]);
        }else{
            printf("%d\n",cntChk[i]);    
        }
        
    }
    return 0;
}