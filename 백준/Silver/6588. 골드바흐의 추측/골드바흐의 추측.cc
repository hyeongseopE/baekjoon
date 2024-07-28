#include <stdio.h>
#include <vector>

const int MAX = 1000000;
std::vector<bool> isPrime(MAX + 1, true);


void sieve() {
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= MAX; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
    }
}

int main() {
    sieve(); 
    int n;

    while (true) {
        scanf("%d", &n);
        if (n == 0) break;
        
        bool found = false;
        for (int i = 3; i <= n / 2; i += 2) {
            if (isPrime[i] && isPrime[n - i]) {
                printf("%d = %d + %d\n", n, i, n - i);
                found = true;
                break;
            }
        }

        if (!found) {
            printf("Goldbach's conjecture is wrong.\n");
        }
    }

    return 0;
}