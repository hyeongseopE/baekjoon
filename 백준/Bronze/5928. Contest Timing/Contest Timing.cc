#include <iostream>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int d, h, m;

    cin >> d >> h >> m;

    int minute = 11 + 11 * 60 + 11 * 1440;
    int answer = m + h * 60 + d * 1440 - minute;

    cout << (answer < 0 ? -1 : answer);

    return 0;
}