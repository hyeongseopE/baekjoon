#include <stdio.h>
#include<stdlib.h>
int n,map[10][10],r[10][10],c[10][10],t[10][10];
void back(int x,int y)
{
	int i,j;
	if(y==9) x++,y=0; // 범위를 벗어났어면 다음줄로
	
	if(x==9)          // 답을 찾았다면 출력하고 종료
	{
		for(i=0;i<9;i++)
		{
			for(j=0;j<9;j++)
				printf("%d ",map[i][j]);
			printf("\n");
		}
		exit(0);
	}
	if(map[x][y]!=0) back(x,y+1); // 이미 숫자가 있다면 지나간다
	else
	{
		for(i=1;i<=9;i++)         // 숫자가 없다면 1~9까지수를 넣어본다
		{
			if(!(r[x][i]+c[y][i]+t[x/3*3+y/3][i]))
			{
				r[x][i]=c[y][i]=t[x/3*3+y/3][i]=1;
				map[x][y]=i;
				back(x,y+1);
				map[x][y]=0;
				r[x][i]=c[y][i]=t[x/3*3+y/3][i]=0;
			}
		}
	}
}
int main()
{
	int i,j;
	for(i=0;i<9;i++)
	{
		for(j=0;j<9;j++)
		{
			scanf("%d",&map[i][j]);
			if(map[i][j]==0) continue;
			r[i][map[i][j]]=1;           // 행chk
			c[j][map[i][j]]=1;           // 열chk
			t[i/3*3+j/3][map[i][j]]=1;   // 사각 chk
		}
	}
	back(0,0);
    return 0;
}