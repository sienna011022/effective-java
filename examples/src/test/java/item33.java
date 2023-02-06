import com.example.item33.Favorites;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class item33 {

    @Test
    void 타입_설정_제한() {
        //나는 키나 값에 여러개의 타입을 넣고 싶은데,,,

        Map<Integer, String> example = new HashMap<>();
        example.put(1234, "1234");
        //컴파일 에러
        example.put("1234",1234);
    }

    @Test
    void 타입_안전_컨테이너() {
        Favorites f = new Favorites();
        //이제 key값에 타입을 보장해줄 수 있다.
        f.putFavorite(String.class, "JAVA");
        f.putFavorite(Integer.class, 1234);

        String favoriteString = f.getFavorite(String.class);

        System.out.printf("%s", favoriteString);

    }

    @Test
    void 로타입_사용() {
        Favorites f = new Favorites();
        f.putFavorite((Class) Integer.class, "Integer의 인스턴스가 아닙니다.");
        assertThatThrownBy(() -> f.getFavorite(Integer.class))
            .isInstanceOf(ClassCastException.class);
    }
}
