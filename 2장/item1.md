### 1. 생성자 대신 정적 팩터리 메서드를 고려하라[본인 발표]
#### **장점**
- **이름을 가질 수 있다.**

생성자로 인스턴스를 생성하려면 ex.new Qustion()으로만 호출을 하여서, 객체의 특성을 잘 설명하지 못함.

또한 엉뚱한 생성자를 호출하는 실수도 할 수 있다.

반면 정적 팩토리 메서드만 잘 지으면 객체의 특성을 쉽게 묘사할 수 있다.

위의 예시에서도 newQuestion()으로 새로운 객체를 생성해줌이(키워드로) 잘 드러난다.

- **호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.**

특히 만약 immutable클래스라면? 불변임이 보장되어, 미리 인스턴스를 만들어 놓거나 생성한 인스턴스를 캐싱하여 재활용 할 수 있다.

캐싱을 한다면 → 생성 비용이 큰 객체가 자주 요청되는 상황이라면 성능을 끌어 올려준다.

이는 flywight 패턴과 비슷함.

- 💡 flyweight 패턴이란?

  Factory를 만들어 인스턴스의 생성 여부를 체크하고, 인스턴스가 있다면 더 이상 생성하지 않고 기존의 인스턴스를 리턴하여 불필요한 인스턴스 생성을 줄이는 디자인 패턴이다.공유를 통해 대량의 객체들을 효과적으로 지원하는 방법이다.

  반복 요청에 같은 객체를 반환하는 식으로 인스턴스의 생존을 철저히 통제할 수 있다!

  인스턴스를 통제하면 얻은 이득?

    1. 클래스를 싱글턴으로 만들 수 있다.
    2. 인스턴스화 불가(noninstantiable)로 만들 수 있다.
    3. 인스턴스가 단 하나뿐임을 보장할 수 있다.

**[예시]**

lotto 미션에서 lotto 번호 45개를 생성하여 번호를 뽑는 상황

요청될 때마다 45개씩 생성하여 뽑으면 기하급수적으로 생성 비용이 커짐.

1 ~ 45 number를 가진 LOTTO_NUMBERS_POOL 리스트에 캐싱

```java
private static final int FIRST_NUM = 1;
private static final int MAX_NUM = 45;
private static final int LAST_NUM = 6;
private static final List<Integer> LOTTO_NUMBERS_POOL = new ArrayList<>();

static {
   for (int i = FIRST_NUM; i <= MAX_NUM; i++) {
      LOTTO_NUMBERS_POOL.add(i);
   }
}
```

그리고 정적 팩토리 메서드를 통해 pool에 이미 존재하는 인스턴스들을 그대로 반환해줍니다.

```java
public class RandomLottoFactory {

	private static final int FIRST_NUM = 1;
	private static final int MAX_NUM = 45;
	private static final int LAST_NUM = 6;
	private static final List<Integer> LOTTO_NUMBERS_POOL = new ArrayList<>();

	static {
		for (int i = FIRST_NUM; i <= MAX_NUM; i++) {
			LOTTO_NUMBERS_POOL.add(i);
		}
	}

	public List<Integer> randomLotto() {
		List<Integer> lottoSet = new ArrayList<>();
		Collections.shuffle(LOTTO_NUMBERS_POOL);

		for (int i = FIRST_NUM; i <= LAST_NUM; i++) {
			lottoSet.add(LOTTO_NUMBERS_POOL.get(i));
		}

		Collections.sort(lottoSet);
		return lottoSet;
	}

}
```

이렇게 코드가 개선되면 최초 1 ~ 45 까지의 LottoNumber 인스턴스 생성 비용 외에 사용하는 비용이 없다.

- **반환 타입의 하위타입 객체를 반환할 수 있는 능력이 있다**

이 능력은 반환할 객체의 클래스를 자유롭게 선택할 수 있게 하는 ‘엄청난 유연성' 을 선물한다고 한다.

```java
public class Account {
	public Account() {}
}

public class AccountFactory {
	public static Account of(int money) {
		if(money > 100) {
			return new VipAccount();
		}
		else {
			return new NormalAccount();
		}
	}
}

public class VipAccount extends Account{
	public Vip() {}
}

public class NormalAccount extends Account{
	public Normal() {}
}
```

다음 코드처럼 보유한 돈에 따라, Account의 하위 타입인 Vip, Normal 인스턴스를 반환할 수 있다.

자바의 Collections도 대부분의 구현체를 한개의 정적 팩터리 메서드를 통해 얻게 함.

클라이언트 입장에서 알아야 될게 적어짐.

- **입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.**

```java
public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
    Enum<?>[] universe = getUniverse(elementType);
    if (universe == null)
        throw new ClassCastException(elementType + " not an enum");
    if (universe.length <= 64)
        return new RegularEnumSet<>(elementType, universe);
    else
        return new JumboEnumSet<>(elementType, universe);
}
```

EnumSet 클래스의 경우 public 생성자 없이 default 생성자만 존재한다.

대신에 정적 팩토리 메서드를 적용하였는데, universe의 크기를 계산하여 64 이하일 경우, RegularEnumSet 을, 65 이상일 경우 JumboEnumSet 을 리턴해준다.

> 클라이언트는 이 두 클래스의 존재를 모른다. 팩토리가 건내주는 객체가 RegularEnumSet인지 아니면 JumboEnumSet 인지 알지 못하며 알 필요도 없다.
>

- **정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스를 작성할 필요가 없다.**

간단하게만 이해해보면 JDBC 프레임 워크에 있는getConnections()를 예시로 들 수 있다.

getConnection을 할 때 우리는 mysql로 할지, Oracle로 연결할지 호출시에 정할 것이다.

그래서 getConnection은 작성될 시점에는 이러한 프레임워크에 종속되지 않고, 호출될 때 맞는 인스턴스를 구현해서 리턴한다.
