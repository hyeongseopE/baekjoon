#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<algorithm>
using namespace std;
double x1[3],x2[3];
double left ,right;

int main() {
    double x;
    scanf("%lf",&right);

    for (int i = 0; i < 3; i++) {
        scanf("%lf%lf",&x1[i],&x2[i]);
    }

    for (int i = 0; i < 3; ++i) {
        if(x1[i] == x2[i]){ continue;}

        x = (x1[i]+x2[i])/2.0;

        if(x-left < right-x){
            left = x;
            for (int j = i+1; j < 3; ++j) {
                if(x1[j] < left){
                    x1[j] = 2 * left - x1[j];
                }
                if(x2[j] < left){
                    x2[j] = 2 * left - x2[j];
                }
            }
        }else{
            right = x;
            for (int j = i+1; j < 3; ++j) {
                if(x1[j] > right){
                    x1[j] = 2 * right - x1[j];
                }
                if(x2[j] > right){
                    x2[j] = 2 * right - x2[j];
                }
            }
        }


    }
    printf("%.1lf",right - left);
    return 0;
}