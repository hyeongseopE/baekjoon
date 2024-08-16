#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <algorithm>
using namespace std;

int chk[100100], cnt[100100],q[100100],top=-1,poll=-1;
int n, k;

void bfs(int x) {
    q[++top] = x;
    chk[x] = 1;
    cnt[x] = 1;

    while (top != poll) {
        int nx = q[++poll];

        for (int i = 0; i < 3; ++i) {
            int e;
            if (i == 0) e = nx - 1;
            else if (i == 1) e = nx + 1;
            else e = nx * 2;

            if (e < 0 || e > 100000) continue;

            if (chk[e] == 0) {
                chk[e] = chk[nx] + 1;
                cnt[e] = cnt[nx];
                q[++top] = e;
            } else if (chk[e] == chk[nx] + 1) {
                cnt[e] += cnt[nx];
            }
        }
    }
}

int main() {
    scanf("%d%d", &n, &k);

    bfs(n);
    printf("%d\n%d\n", chk[k] - 1, cnt[k]);

    return 0;
}