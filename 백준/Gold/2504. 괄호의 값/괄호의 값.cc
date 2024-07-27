#include <stdio.h>
#include <string.h>
char a[150],st1[150];
int n,st[150],sum,sw,key=-1;
int main()
{
	int i,j;
	scanf("%s",a);
	n=strlen(a);
	for(i=0; i<n; i++)                     // 성립이 되는 괄호인지 판단
	{
		if(a[i]=='(' || a[i]=='[') st1[++key]=a[i];
		else if(a[i]==')' && st1[key]=='(' && key>-1) key--;
		else if(a[i]==']' && st1[key]=='[' && key>-1) key--;
		else { sw=1;  break; }
	}
	if(sw==1 || key!=-1) { printf("0"); return 0;}
	
	key=-1;
	for(i=0; i<n; i++)
	{
		sum=0;
		if(a[i]=='(') st[++key]=-1;        // (인경우 -1로 스택에 넣어줌
		else if(a[i]=='[') st[++key]=-2;   // [인경우 -2로 스택에 넣어줌
		else if(a[i]==')')                 // )인경우 (숫자를 더한후)*2 스택에 넣어줌
		{
			while(st[key]!=-1)
			{
				sum+=st[key--];
			}
			if(sum==0) st[key]=2;
			else st[key]=sum*2;
		}
		else if(a[i]==']')                 // ]인경우 [숫자를 더한후]*3 스택에 넣어줌
		{
			while(st[key]!=-2)
			{
				sum+=st[key--];
			}
			if(sum==0) st[key]=3;
			else st[key]=sum*3;
		}

	}

	sum=0;
	for(i=0; i<=key; i++)
	{
		sum+=st[i];
	}
	printf("%d\n",sum);
	return 0;
}