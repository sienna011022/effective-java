import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class item72 {


    @Test
    void ConcurrentException() {
        List<Integer> numbers = new ArrayList<>();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                numbers.add(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            Iterator<Integer> it = numbers.iterator();
            while (it.hasNext()) {
                Integer number = it.next();
                if (number % 2 == 0) {
                    it.remove();
                }
            }
        });
        //스레드가 async , non-blocking인가요.?이라 문제가 발생하나?
        //멀티스레드 동작을 지원함.
        // 스레드는 공유자원!!!!!!!!!!!
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(numbers.size());
    }


    @Test
    @DisplayName("지원하지 않는 메서드")
    void unsupport(){
        List<String> newList = Arrays.asList("이펙티브","짱");
        newList.remove("이펙티브");
    }
}

