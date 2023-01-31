import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class item26 {

    @Test
    void raw_example(){
        List stringCollection = new ArrayList(); // String을 넣으려고 만든 컬렉션
        stringCollection.add("1");
        stringCollection.add("2");
        // 이런 저런 문자열 값들이 들어다가
        stringCollection.add(2); // 컴파일 오류 x => 정상 작동

        stringCollection.stream()
            .forEach(number -> Assertions.assertThat(number.getClass()).isEqualTo(String.class)); // 그런데 타입은 다른게 들어감.
    }

    @Test
    @DisplayName("제너릭을 사용하면 String 인스턴스만 넣어야함을 컴파일러가 인지하게 된다")
    void raw_right_example(){
        List<String> stringCollection = new ArrayList(); // String을 넣으려고 만든 컬렉션
        stringCollection.add("1");
        stringCollection.add("2");
        //stringCollection.add(2); // 컴파일 오류 0
    }

    @Test
    @DisplayName("모든 타입을 받고 싶다면 Object 제너릭 타입을 씁시다")
    void object(){
        List<Object> stringCollection = new ArrayList<>(); //난 모든 타입을 받을거야!!
        stringCollection.add(1);
        stringCollection.add("2");
    }

    @Test
    @DisplayName("와일드 카드에는 null외에 어떤 것도 더할 수 없다")
    void wild() {
        List<String> stringCollection = new ArrayList<>();
        wildCardTypeMethod(stringCollection); // 컴파일에러 발생x
    }

    private static void wildCardTypeMethod(final List<?> stringCollection) {
        stringCollection.get(0);
//        stringCollection.add(1); // 컴파일 에러
//      stringCollection.add("1"); // 컴파일 에러
    }

}

