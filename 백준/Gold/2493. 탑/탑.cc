#include <stdio.h>
#define M 500001
int s[M][2],dab[M],a[M];
int main()
{
	int n,i,j,k;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		scanf("%d",&a[i]);
	}
	
	k=-1;
	for(i=n;i>=1;i--)
	{
		if(k==-1 || s[k][0]>a[i])             // 스택이 비어있거나 현재값보다 스택에 있는값이 크면 넣어준다
			s[++k][0]=a[i],s[k][1]=i;
		else
		{
			for(k;k>=0 && s[k][0]<=a[i];--k) // 현재값보다 스택에 있는값이 작거나같으면 빼낸다
			{
				dab[s[k][1]]=i;
			}
			s[++k][0]=a[i],s[k][1]=i; // 현재값을 스택에 넣어준다
		}
	}
	for(i=1;i<=n;i++)
	{
		printf("%d ",dab[i]);
	}
    return 0;
}