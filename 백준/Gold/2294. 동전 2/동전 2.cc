#include <stdio.h>
#include <algorithm>
#include <cstring>
using namespace std;

int dp[100010], t, n;
int arr[101];

int main() {
    scanf("%d%d", &n, &t);

    for (int i = 0; i < n; ++i) {
        scanf("%d", &arr[i]);
    }

    // dp 배열 초기화
    fill(dp, dp + t + 1, 1e9);  // 충분히 큰 값으로 초기화
    dp[0] = 0;

    // 동적 계획법 실행
    for (int i = 0; i < n; ++i) {
        for (int j = arr[i]; j <= t; ++j) {
            dp[j] = min(dp[j], dp[j - arr[i]] + 1);
        }
    }

    // 결과 출력
    if (dp[t] == 1e9) {
        printf("-1\n");  // 해당 금액을 만들 수 없는 경우
    } else {
        printf("%d\n", dp[t]);
    }

    return 0;
}
