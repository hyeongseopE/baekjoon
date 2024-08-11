#include <stdio.h>
int a[10000],dab;
int main()
{
	int n,m,i,l,r,mid,max=0,sum;
	scanf("%d",&n); //지방의 수
	for(i=0;i<n;i++)
	{
		scanf("%d",&a[i]);
		if(max<a[i]) max=a[i];
	}
	scanf("%d",&m); // 총예산
	
	l=0; r=max;
	while(l<=r)
	{
		sum=0;
		mid=(l+r)/2;
		for(i=0;i<n;i++)
		{
			if(a[i]>mid) sum+=mid;
			else sum+=a[i];
		}
		if(sum>m) r=mid-1;
		else l=mid+1,dab=mid;
	}
	printf("%d",dab);
	return 0;
}