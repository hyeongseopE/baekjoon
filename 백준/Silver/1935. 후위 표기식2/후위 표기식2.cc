
#include<stdio.h>
#include<stdlib.h>
#include<algorithm>
using namespace std;
char s[27];
double stack[101],num[101];
int top = -1;
int main(){
    int n;
    scanf("%d %s",&n,s);
    for(int i=0;i<n;i++){
        scanf("%lf",&num[i]);
    }

    for(int i=0;s[i]!=0;i++){
        if(s[i] >= 'A' && s[i] <= 'Z'){
            stack[++top] = num[s[i]-'A'];
        }else if(s[i] == '*'){
            top--;
            stack[top] *= stack[top+1];
        }else if(s[i] == '+'){
            top--;
            stack[top] += stack[top+1];
        }else if(s[i] == '/'){
            top--;
            stack[top] /= stack[top+1];
        }else if(s[i] == '-'){
            top--;
            stack[top] -= stack[top+1];
        }
    }

    printf("%.2lf",stack[0]);
    return 0;
}