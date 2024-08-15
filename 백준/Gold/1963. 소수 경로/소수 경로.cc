#include <stdio.h>
#define M 10100
int n,n1,st,ed,x,t,i,j,c,v;
int x1,x2,x3,x4,y1,y2,y3,y4;
int a[M],chk[M],s[M],chk1[M],b[M];
void bfs()
{
    st=ed=-1;
    a[++st]=n;
    chk[n]=1;
    while(st!=ed)
    {
        x=a[++ed];
        if(x==n1) break;

        y1=x/1000;
        y2=x/100%10;
        y3=x/10%10;
        y4=x%10;
        for(i=0 ; i<=9 ; i++)
        {
            x1=i*1000+y2*100+y3*10+y4;
            x2=y1*1000+i*100+y3*10+y4;
            x3=y1*1000+y2*100+i*10+y4;
            x4=y1*1000+y2*100+y3*10+i;
            if(i!=0 && chk1[x1]==0 && chk[x1]==0)
            {
                a[++st]=x1;
                chk[x1]=1;
                b[st]=b[ed]+1;
            }
            if(chk1[x2]==0 && chk[x2]==0)
            {
                a[++st]=x2;
                chk[x2]=1;
                b[st]=b[ed]+1;
            }
            if(chk1[x3]==0 && chk[x3]==0)
            {
                a[++st]=x3;
                chk[x3]=1;
                b[st]=b[ed]+1;
            }
            if(chk1[x4]==0 && chk[x4]==0)
            {
                a[++st]=x4;
                chk[x4]=1;
                b[st]=b[ed]+1;
            }
        }
    }
    printf("%d\n", b[ed]);
}
int main()
{
    scanf("%d",&v);
    for(i=2 ; i*i<=10000 ; i++)
    {
        if(chk1[i]==0)
        {
            for(j=i+i ; j<=10000 ; j+=i) chk1[j]=1;
        }
    }
    for(j=0;j<v;j++){
        scanf("%d%d",&n,&n1);
        bfs();
        for (int k = 1000; k <= 10000; ++k) {
            b[k] = 0;
            chk[k] = 0;
        }
    }



    return 0;
}