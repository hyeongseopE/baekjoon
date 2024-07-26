#include<stdio.h>
char a[101],s[101];
int main()
{
	int top=-1,i;
	scanf("%s",&a);
	for(i=0;a[i]!=0;i++)
	{
		if(a[i]>='A' && a[i]<='Z')          // 알파벳인경우 출력
			printf("%c",a[i]);
		else if(top==-1 || a[i]=='(')      // 스택이 비어있거나 열린괄호를 만나면 넣어준다
			s[++top]=a[i];
		else if(a[i]==')')                 // 닫힌괄호면 열린괄호까지 빼준다
		{
			while(1)
			{
				if(s[top]=='(') break;
				printf("%c",s[top--]);
			}
			top--;
		}
		else if(a[i]=='*' || a[i]=='/')   // 곱하기나 나누기이면 *,/빼고 넣어준다
		{
			while(1)
			{
				if(top==-1 || s[top]=='('|| s[top]=='+' || s[top]=='-') break;
				printf("%c",s[top--]);
			}
			s[++top]=a[i];
		}
		else if(a[i]=='+' || a[i]=='-')  // 더하기나 빼기면 *,/,+,-를 빼고 넣어준다
		{
			while(1)
			{
				if(top==-1 || s[top]=='(' ) break;
				printf("%c",s[top--]);
			}
			s[++top]=a[i];
		}

	}
	while(1)                   // 스택에 남은 자료 출력
	{
		if(top==-1) break;
		printf("%c",s[top--]);
	}

	return 0;
}