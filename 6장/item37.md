## ordinal 인덱싱 대신 EnumMap을 사용하라

배열이나 리스트를 꺼낼 때 ordinal 메서드로 꺼내는 경우가 있다.
생애 주기 별로 3개의 집합으로 묶고 각 식물을 해당 집합 안에 넣는다.
집합들을 배열 하나에 넣고 생애주기의 ordinal 값을 그 배열의 인덱스로 사용한다

```java
 public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        //집합을 세개 만든 다음에
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            // 0 : set
            plantsByLifeCycle[i] = new HashSet<>();
        }

        //집합하나당[0].add(plant)//리스트를 넣음 원래는 [식물1,식물2]
        List<Plant> garden = new ArrayList<>(); // 편의상 빈 리스트로 초기화 했다. =>원래는 식물 모음
        for (Plant plant : garden) {
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);
        }

        // 결과 출력
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s : %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}
```
## 문제들
* 배열은 제네릭과 호환되지 않음 => 비검사 형변환을 해야함
* 배열은 각 인덱스의 의미를 몰라서 출력 값에 직접 이름을 달아줘야함
* 정수를 사용해서 에러가 날 가능성 높음

지금 구현한 내용은 , 열거타입 '상수' (ordinal())를 값으로 매핑하는 일이였음.
그러니 Map을 사용할 수 있다.
열거타입을 키로 사용할 수 있게끔 한게 EnumMap

* EnumMap이 받는 키 타입의 class객체는 한정적 타입 토큰으로 런타임 제너릭 정보를 제공한다.
* 직접 출력결과에 이름을 달 필요도 없고
* 배열 인덱스에 계산하는 과정에서 오류가 날 가능성도 없다.
