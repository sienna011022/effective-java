package com.example.item52;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class CollectionClassifier {

    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> s) {
        return "List";
    }

    public static String classify(Collection<?> s) {
        return "Collection";
    }
}
