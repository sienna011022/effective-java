## toString은 항상 재정의하라
toString 메서드는 항상 Object의 단순한 결과 값만을 반환한다.

```
Human hu = new Human()
System.out.println(hu.toString())
출력 값 ==> test.Human@15db9732
```

이렇게 단순 '의미 없는' 값이 나오길 마련

그리하여 String 클래스나 File 클래스에서 이를 재정의하여 의미있는 값을 리턴해줌
toString 규약 중에서도 => 간결하면서 사람이 읽기 쉬운 형태의 유익한 절보를 반환해야한다 라고 한다.

* toString을 사용한 시스템은 디버깅하기 쉽다
    * 진단 메세지를 남길 수 있다
    * ex ) phoneNumber에 연결할 수 없습니다
* 실전에서 그 객체가 담은 모든 정보를 반환하는것이 좋다
* 포맷화를 진행하였다면 그 포맷에 맞는 정적 팩토리 메서드 or 생성자를 제공하자
    * ex ) BigInteger(int,int,Random) or BigInteger.probablePrime()
    * 하지만 포맷화는 장단점이 존재한다
    * 장점 => 표준적이며 명확함 
    * 단점 => 포맷이 변경될 시 엉망이된다
* 포맷을 진행하든 말든 의도는 명확하게 밝히자
* 대신 포맷 진행 여부와 관련 없이 toString이 반환값에 포함된 정보를 얻어올 수있는 API를 제공하자
* 하위 클래스들이 공유해야할 문자열 표현이 있는 추상클래스라면 toString을 재정의해주자.

``` 
@Override
    public String toString() {
        return "RefreshTokenRequest{" +
            "refreshToken=" + refreshToken +
            ", memberId='" + memberId + '\'' +
            ", roles=" + roles +
            '}';
    }
```
