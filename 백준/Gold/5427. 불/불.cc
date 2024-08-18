#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <memory.h>
#define MX 1010
char map[MX][MX];
int chk[MX][MX], fire[MX][MX];
int w, h, sx, sy, fx, fy, tx, ty, st, ed;
int dx[] = { -1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1 };
int ans;

struct data {
	int x, y;
}q1[MX*MX],q2[MX*MX];
void find1(void)
{
	while (st != ed)
	{
		tx = q1[++ed].x; ty = q1[ed].y;
		for (int i = 0; i < 4; i++)
		{
			if (tx + dx[i] < 0 || ty + dy[i] < 0 || tx + dx[i] >= w || ty + dy[i] >= h) continue;
			if (fire[ty + dy[i]][tx + dx[i]] == -1 || fire[ty + dy[i]][tx + dx[i]] != 0) continue;
			q1[++st].x = tx + dx[i];
			q1[st].y = ty + dy[i];
			fire[ty + dy[i]][tx + dx[i]] = fire[ty][tx] + 1;
		}
	}
}
void find2(void)
{
	st = ed = -1;
	q2[++st].x = sx; q2[st].y = sy;
	chk[sy][sx] = 1;
	while (st != ed)
	{
		tx = q2[++ed].x; ty = q2[ed].y;
		for (int i = 0; i < 4; i++)
		{
			if (tx + dx[i] < 0 || ty + dy[i] < 0 || tx + dx[i] >= w || ty + dy[i] >= h) {
				ans = chk[ty][tx]; break;
			}
			if (chk[ty + dy[i]][tx + dx[i]] == -1 || chk[ty + dy[i]][tx + dx[i]] != 0) continue;
			if (fire[ty + dy[i]][tx + dx[i]]!=0 && chk[ty][tx] + 1 >= fire[ty + dy[i]][tx + dx[i]]) continue;
			q2[++st].x = tx + dx[i];
			q2[st].y = ty + dy[i];
			chk[ty + dy[i]][tx + dx[i]] = chk[ty][tx] + 1;
		}
		if (ans != -1)break;
	}
}
int main(void)
{
	int T;
	scanf("%d",&T);
	while (T--)
	{
		memset(fire, 0, sizeof(fire));
		memset(chk, 0, sizeof(chk));
		st = ed = -1; ans = -1;
		int maxnum = 1, im = 0;
		scanf("%d%d",&w,&h);
		for (int i = 0; i < h; i++)
		{
			for (int j = 0; j < w; j++)
			{
				scanf(" %c", &map[i][j]);
				if (map[i][j] == '@') { sx = j; sy = i; map[i][j] = '.'; }
				if (map[i][j] == '*') { q1[++st].x = j; q1[st].y = i; map[i][j] = '.'; fire[i][j] = 1; }
				if (map[i][j] == '#') { chk[i][j] = -1; fire[i][j] = -1; }
			}
		}
		find1();
		find2();
		if (ans == -1) printf("IMPOSSIBLE\n");
		else printf("%d\n",ans);
	}
	return 0;
}