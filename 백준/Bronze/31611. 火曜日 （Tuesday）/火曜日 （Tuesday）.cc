#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int X;

    cin >> X;
    cout << (int)((X % 7) == 2) << '\n';

    return 0;
}