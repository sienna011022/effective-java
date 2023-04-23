import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class item61 {

    @Test
    void 참조_기본_비교() {
        Integer wrapped = Integer.valueOf(3);
        int basic = 3;

        Assertions.assertThat(wrapped == basic).isEqualTo(true);
    }


    @Test
    void 비교자_에러() {
        Integer wrapped = new Integer(3);
        Integer wrapped2 = new Integer(3);

        //왜 같다고 하지..?
        Assertions.assertThat(wrapped == wrapped2).isEqualTo(false);
    }
    //캐싱 문제



}
