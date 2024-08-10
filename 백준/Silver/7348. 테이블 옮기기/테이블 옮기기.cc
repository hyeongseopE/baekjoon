#include <stdio.h>
#include <algorithm>
using namespace std;
#define N 210
int main()
{
    int i,j,n,t,T;
	scanf("%d",&T);
	while(T--)
	{
		int s[N]={0},e[N]={0},room[N]={0},dab=0;
		scanf("%d",&n);
		for(i=0;i<n;i++)
		{
			scanf("%d%d",&s[i],&e[i]);
			if(s[i]>e[i]) { t=s[i]; s[i]=e[i]; e[i]=t;}
			if(s[i]%2==1) s[i]++; if(e[i]%2==1) e[i]++;
			for(j=s[i]/2;j<=e[i]/2;j++)
			{
				room[j]+=10;
				if(dab<room[j]) dab=room[j];
			}
		}
		printf("%d\n",dab);
	}
    return 0;
}