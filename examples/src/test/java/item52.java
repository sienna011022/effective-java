import com.example.item52.CollectionClassifier;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class item52 {


    @Test
    void error_다중정의() {
        Collection<?>[] collections = {
            new HashSet<String>(),
            new ArrayList<Integer>(),
            new HashMap<String, String>().values()
        };
        List<String> names = new ArrayList<>();
        // Collection 만 세번 나온다
        for (Collection<?> collection : collections) {
            names.add(CollectionClassifier.classify(collection));
        }
        Assertions.assertThat(names).isEqualTo(Arrays.asList("Set","List","Collection"));
    }

    @Test
    void remove의배신(){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i = -3 ; i < 3 ; i++){
            set.add(i);
            list.add(i);
        }

        for(int i = 0 ; i < 3 ; i++){
            set.remove(i);
            list.remove(i);
        }
        //둘이 다름
        //기대값 = [-3,-2,-1]
        System.out.println(set);
        System.out.println(list);
    }


    @Test
    void remove고치기(){
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i = -3 ; i < 3 ; i++){
            set.add(i);
            list.add(i);
        }

        for(int i = 0 ; i < 3 ; i++){
            set.remove(i);
            list.remove((Integer)i);
        }
        //둘이 다름
        //기대값 = [-3,-2,-1]
        System.out.println(set);
        System.out.println(list);
    }
}
