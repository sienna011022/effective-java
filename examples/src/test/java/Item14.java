
import com.example.examples.Equals;
import com.example.examples.Fruit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Item14 {

    @Test
    void compareToNum(){
        Integer x = 3;
        Integer y = 4;
        Double z = 1.0;

        System.out.println( x.compareTo(y) );  // x랑 y랑 비교 ==> x가 더 작음 -1
        System.out.println( x.compareTo(3) );  //  x랑 3이랑 비교 ==> 둘이 같음 0
        System.out.println( x.compareTo(2) );  //  x랑 2랑 비교 ==> x가 더 큼 1
        System.out.println( z.compareTo(2.7) );  //  z와 2.7비교 ==> z가 더 작음 -1
    }

    @Test
    void 반사성_테스트(){
        Integer x = 3;
        Integer y = 4;
        Assertions.assertThat(x.compareTo(y)).isEqualTo(-(y.compareTo(x)));  //-1 과 -(+1)은 같다
    }

    @Test
    void 추이성_테스트(){
        Integer x = 5;
        Integer y = 4;
        Integer z = 3;
        Assertions.assertThat(x.compareTo(y)).isEqualTo(1);
        Assertions.assertThat(y.compareTo(z)).isEqualTo(1);
        Assertions.assertThat(x.compareTo(z)).isEqualTo(1);

    }

    @Test
    void 대칭성_테스트(){
        String string1 = "HAPPY";
        String string2 = "HAPPY";
        Assertions.assertThat(string1.compareTo(string2)).isEqualTo(0);
    }

    @Test
    void equalsTest(){
        Set bigDecimalHashSet = new HashSet<>(); //HashSet에서는 equals를 이용한 동치 비교 : 정렬을 해주지 않는다 => 확인 방법?!
        bigDecimalHashSet.add(new BigDecimal("1.0")); // BigDecimal은 equals와 compareTo를 모두 사용한다.
        bigDecimalHashSet.add(new BigDecimal("1.00"));

        Set bigDecimalTreeSet = new TreeSet(); // TreeSet에서는 compareTo를 이용한 동치 비교
        bigDecimalTreeSet.add(new BigDecimal("1.0"));
        bigDecimalTreeSet.add(new BigDecimal("1.00"));

        System.out.println(bigDecimalHashSet.size());   // 2
        System.out.println(bigDecimalTreeSet.size());   // 1

        System.out.println(new BigDecimal("1.0").equals(new BigDecimal("1.00")));    // false : 서로 다른 객체로 인식
        System.out.println(new BigDecimal("1.0").compareTo(new BigDecimal("1.00"))); // 0 서로 같은 객체로 인식
    }

//    @Test
//    void compareWithEqual() {
//        Integer A = 1;
//        System.out.println(A.equals(1.0));    // 타입에 관여하지 않고 일단 비교 진행
//        System.out.println(A.compareTo(1.0)); // 타입이 서로 다르면 컴파일 단계에서 ClassCastException
//    }

    @Test
    void compareToMessage(){
        String str = "abcd";

        // 1) 비교대상에 문자열이 포함되어있을 경우
        System.out.println( str.compareTo("abcd") );  // 0 (같은 경우는 숫자나 문자나 0을 리턴)
        System.out.println( str.compareTo("ab") );  //  2
        System.out.println( str.compareTo("a") );  //  3
        System.out.println( str.compareTo("c") );  //  -2
        System.out.println( "".compareTo(str) );  //  -4

        // 2) 비교대상과 전혀 다른 문자열인 경우
        System.out.println( str.compareTo("zefd") );  //  -25
        System.out.println( str.compareTo("zEFd") );  //  -25
        System.out.println( str.compareTo("ABCD") );  //  32
    }
    @Test
    @DisplayName("String이 Comparable을 구현하여 자동으로 sort해준다")
    void sort(){
        String[] args = {"c","b","a"};
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        System.out.println(s);
    }

    @Test
    @DisplayName("compareTo 수행 시간 비교")
    void 수행시간비교(){
        long start = System.currentTimeMillis();
        Fruit fruit = new Fruit("사과",1000,10);
        Fruit fruit2 = new Fruit("사과",3000,50);
        int result = fruit.compareTo(fruit2);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        Assertions.assertThat(result).isEqualTo(-1);
    }

}
