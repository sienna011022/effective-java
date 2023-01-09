import com.example.item21.MyClass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class item21 {

    @Test
    void test_name(){
        MyClass myClass = new MyClass();
        Assertions.assertThat(myClass.printHello()).isEqualTo("Hello World");
    }
}
