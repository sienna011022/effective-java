## 다 쓴 객체 잠조를 해제하라

[메모리 누수]

점차 가비지 컬렉션 활동과 메모리 사용량이 늘어나 성능이 저하될것이다.

메모리누수는 꺼낸 객체들을 회수하지 않았을 때 생긴. 그 객체들의 참조를 가지고 있기 때문이다.
    
활성 영역밖의 참조 

    객체 참조 하나를 살려두면 가비지 컬렉터는 그 객체 뿐만 아니라 참조하고 있는 모든 객체 회수 불가
리스너, 콜백 패턴

[해법]
- 해당 참조를 다 쓰고 null처리

    하지만 모든 객체를 다 쓰자마자 일일히 null 처리하는건 지저분, 이건 예외적인 경우로 처야함
- 가장 BEST? 참조를 담은 변수를 유효범위 밖으로 밀어내는것이다.

[원인]

왜 stack은 메모리 누수에 취약한가?
- 자기 메모리를 직접 관리하기 떄문이다.자기가 관리해서 Gc는 메모리를 다 썼는지 알길이 없음.
- 캐시 역시 메모리 누수를 일으키는 주범이다. 

[대안]

Weak HashMap : 엔트리가 살아있는 캐시가 필요한 상황


[더 알고 싶은 것]
* 가비지 컬렉터
* 스택 영역
* Weak Hash map
* 좋은 객체 참조 방법이 더있나???
