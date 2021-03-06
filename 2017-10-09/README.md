## 알고리즘의 설계
알고리즘을 설계하는 방법은 여러 가지다.<br>
삽입 정렬은 **점진적**인 방법을 사용한다. 즉, 원소 A[j]를 정렬된 부분 배열 A[1..j-1]의 적절한 위치에 삽입하여 다시 정렬된 부분 배열 A[1..j]를 만든다.<br>
### 분할정복 접근법
**재귀적** 구조를 가진 유용한 알고리즘이 많다. 이 알고리즘에서는 주어진 문제를 풀기 위해 자기 자신을 재귀적으로 여러 번 호출함으로써 밀접하게 연관된 부분 문제를 다룬다.<br>
이런 알고리즘들은 전형적으로 **분할정복** 접근법을 따른다.<br>
* 분할: 현재의 문제를 같은 문제를 다루는 다수의 부분 문제로 분할한다.
* 정복: 부분 문제를 재귀적으로 풀어서 정복한다. 부분 문제의 크기가 충분히 작으면 직접적인 방법으로 푼다.
* 결합: 부분 문제의 해를 결합하여 원래 문제의 해가 되도록 만든다.

**병합 정렬**은 분할정복 기법을 아주 잘 이용한다.
* 분할: 정렬할 n개 원소의 배열을 n/2개씩 부분 수열 두 개로 분할한다.
* 정복: 병합 정렬을 이용해 두 부분 배열을 재귀적으로 정렬한다.
* 결함: 정렬된 두 개의 부분 배열을 병합해 정렬된 배열 하나로 만든다.

병합 정렬의 핵심 작업은 "결합" 단계에서 정렬된 두 부분 수열을 병합하는 것이다.<br>
MERGE(A, p, q, r)이 필요하다. p <= q < r 이어야 되고, A[p..q]와 A[q+1..r]은 정렬돼 있어야 한다. 그리고 MERGE는 이를 병합한다.<br>
MERGE 프로시저는 쎄타n의 수행시간이 걸린다. n(r - p + 1)은 병합할 원소들의 개수다.
```
MERGE(A, p, q, r)

1   a = q - p + 1 // 2 - 1 = 1 (배열은 1부터 시작하기 때문에 1을 더해준다.)
2   b = r - q // 4 - 2 = 2 (1을 안 더해줘도 된다.)
3   L[1..a+1], R[1..b+1] // Left와 Right배열 생성

// L, R에 값을 넣어준다.
4   for i = 1 to a
5       L[i] = A[p + i - 1]
6   for i = 1 to b
7       R[i] = A[q + i]

8   L[a + 1] = Infinity // 마지막인지 확인하기
9   R[b + 1] = Infinity // 마지막인지 확인하기

10  i = 1 // 배열을 1부터 시작하기 때문에
11  j = 1

// i는 L의 idx 
// j는 R의 idx


12  for k = p to r // 정복 시작 k = p..r (L 배열만)
13      if L[i] <= R[j] // L[i]가 R[j]보다 작거나 같으면
14          A[k] = L[i] // A[k]에 L[i]를 넣는다
15          i = i + 1 // 그리고 i에 1을 더해준다.
16      else // 아니라면
17          A[k] = R[j] // A[k]에 R을 넣어준다.
18          j = j + 1 // j에 1을 더해준다.
```
* 초기조건: 루프의 첫 번째 반복이 시작되기 직전에는 k = p이므로 부분 배열 A[p..k-1]은 비어있다.
* 유지조건: 각 반복 시 루프 불변성이 유지됨을 보이기 위해 먼저 L[i] <= R[j]의 경우를 살표보자.
    * L[i]는 아직 A로 복사되지 않은 가장 작은 원소다. A[p..k - 1]은 k - p개의 가장 작은 원소를 가지고 있으므로 14행에서 L[i]를 A[k]로 복사하면 부분 배열 A[p..k]는 k - p + 1개의 가장 작은 원소를 정럴된 순서로 저장하게 된다.

    L[i] > R[j]라면 16-18행에서 비슷한 작업을 해준다.
* 종료조건: 종료될 때는 k = r + 1이다. L[1..a+1], R[1..b+1]에서 작은 순서대로 A에 두 개의 카드를 제외하고 저장하기 때문에 참이다. 두 개의 카드는 Infinity(무한대)이다.
