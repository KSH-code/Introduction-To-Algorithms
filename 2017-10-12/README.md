### 버블 정렬의 타당성
버블 정렬은 비효율적이지만 인기 있는 정렬 알고리즘이다. 이는 정렬되지 않은 이웃 원소를 반복적으로 바꿔 수열을 정렬한다.<br>
```
BUBLESORT(A)
1   for i = 1 to A.length - 1
2       for j = A.length downto i + 1
3           if A[j] < A[j - 1]
4               A[j]와 A[j-1]을 바꿈
```
1. 2-4행의 for 루프에 대한 루프 불변성을 자세히 설명하고 증명해라
* 초기조건: 초기조건은 루프가 돌기전 즉 배열의 크기가 1일때는 정렬되어 있으니 참
* 유지조건: 배열이 {3, 2, 1} 일때
    1. {1, 3, 2}
    2. {1, 2, 3}
    * 보면 j = [A.length..i+1]이고 i는 [1..A.length]까지 올라간다. 그러면 반복할때 마다 i에 제일 작은값이 들어가게 된다.
* 종료조건: 종료하게 되면 i가 4인경우인데 이미 정렬이 되어있다.
2. 1에서 증명한 루프 불변성의 종료조건을 활용해 부등식 A[1]<=A[2]<=A[3]...을 증명해라
* 반복문이 돌때마다 i..A.length의 길이에서 제일 작은값이 차례대로 들어가기 때문에 참이다.
3. 버블 정렬의 최악의 경우는 쎄타 n<sub>2</sub> 삽입 정렬과 비교하면 많은 데이터가 있을 때 효율적이다.