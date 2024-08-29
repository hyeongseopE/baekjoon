#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable : 6031)

#include<stdio.h>
#include<vector>
#include<algorithm>
using namespace std;

int v[1000003],s[1000003],dab[1000003];
int main()
{
	int n,x=0,i;
	scanf("%d", &n);

	for(i=1;i<=n;i++)
		scanf("%d",&v[i]);

	for(i=n;i>=1;i--)
	{
		while(x!=0 && s[x]<=v[i]) --x;
	
		dab[i]=s[x];
		s[++x]=v[i];
	}
	for(i=1;i<=n;i++)
		if(dab[i]==0)
			printf("-1 ");
		else
			printf("%d ",dab[i]);

	return 0;
}