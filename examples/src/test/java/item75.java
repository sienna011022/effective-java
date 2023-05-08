import com.example.MyIndexOutOfBoundsException;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class item75 {
    @Test
    void create() {

        try {
            // 인덱스가 범위를 벗어났을 경우 예외 발생

            throw new MyIndexOutOfBoundsException(0, 9, 10);
        } catch (MyIndexOutOfBoundsException e) {
            // 예외 처리
            System.out.println(e.getMessage());
        }
    }


}
