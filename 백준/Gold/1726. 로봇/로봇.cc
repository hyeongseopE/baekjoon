#define MAXN 100
#include<stdio.h>
#include<queue>
#include<algorithm>
using namespace std;

int N,M,K,cnt,map[MAXN][MAXN],chk[4][MAXN][MAXN],sx,sy,sd,ex,ey,ed;
int turn[4][2]={2,3,2,3,0,1,0,1};
int zx[4]={0,0,1,-1},zy[4]={1,-1,0,0};
struct temp
{
	int x,y,d;
}t;
queue<temp> q;

void BFS(int x,int y,int d)
{
	int i,nx,ny,nd,tx,ty;

	chk[d][x][y]=1;
	t.x=x; t.y=y; t.d=d;
	q.push(t);
	while(!q.empty())
	{
		t=q.front();
		q.pop();
		nx=t.x; ny=t.y; nd=t.d;
		if(ex-1==nx && ey-1==ny && ed-1==nd)
		{
			printf("%d",chk[ed-1][ex-1][ey-1]-1);
			exit(0);
		}
		for(i=0;i<2;i++)                 // 회전하는 경우
		{
			if(!chk[turn[nd][i]][nx][ny])
			{
				chk[turn[nd][i]][nx][ny]=chk[nd][nx][ny]+1;
				t.x=nx; t.y=ny; t.d=turn[nd][i];
				q.push(t);
			}
		}
		for(i=1;i<=3;i++)                 // 전진하는 경우
		{
			tx=nx+zx[nd]*i; ty=ny+zy[nd]*i;
			if(tx<0 || tx>=N || ty<0 || ty>=M) break;
			if(map[tx][ty]) break;
			if(!chk[nd][tx][ty])
			{
				chk[nd][tx][ty]=chk[nd][nx][ny]+1;
				t.x=tx; t.y=ty; t.d=nd;
				q.push(t);
			}
		}
	}
}
int main()
{
	int i,j;

	scanf("%d%d",&N,&M); // 행,열
	for(i=0;i<N;i++)
	{
		for(j=0;j<M;j++)
		{
			scanf("%d",&map[i][j]);
		}
	}
	scanf("%d%d%d",&sx,&sy,&sd);
	scanf("%d%d%d",&ex,&ey,&ed);

	BFS(sx-1,sy-1,sd-1);
	return 0;
}