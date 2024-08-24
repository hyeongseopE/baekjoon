#include<stdio.h>

int N,dab,chk[20],Lchk[40],Rchk[40];

void back(int k)
{
	int i;
	if(k>N)
	{
		dab++;
		return ;
	}
	for(i=1;i<=N;i++)
	{
		if(!(chk[i]+Lchk[k-i+N]+Rchk[k+i]))
		{
			chk[i]=Lchk[k-i+N]=Rchk[k+i]=1;
			back(k+1);
			chk[i]=Lchk[k-i+N]=Rchk[k+i]=0;
		}
	}
}
int main()
{
	
	scanf("%d",&N);
	back(1);
	printf("%d",dab);
	return 0;
}