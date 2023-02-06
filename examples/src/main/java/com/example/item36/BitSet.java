package com.example.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static com.example.item36.Bit.STYLE_BOLD;

public class BitSet {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // 어떤 Set을 넘겨도 되나, EnumSet이 가장 좋다.
    public void applyStyles(Set<Style> styles) {
        System.out.printf("Applying styles %s to text%n",
            Objects.requireNonNull(styles));
    }


    // 사용 예
    public static void main(String[] args) {
        BitSet text = new BitSet();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

