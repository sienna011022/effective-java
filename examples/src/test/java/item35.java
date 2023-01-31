import com.example.item35.Ensemble;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class item35 {

    @Test
    @DisplayName("인덱스를 구하기 위해 ordinal을 쓸 수 있다(지양)")
    void ordinal_사용(){
        Assertions.assertThat(Ensemble.DUET.numberOfMusicans()).isEqualTo(2);
    }
}
