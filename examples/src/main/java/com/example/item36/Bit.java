package com.example.item36;

import org.w3c.dom.Text;

import java.util.Objects;

public class Bit {
    public static final int STYLE_BOLD = 1 << 0; // 1
    public static final int STYLE_ITALIC = 1 << 1; // 2
    public static final int STYLE_UNDERLINE = 1 << 2; // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;  // 8

    public void applyStyles(int styles) {
        System.out.printf("Applying styles %s to text%n",
            Objects.requireNonNull(styles));
    }

    // 사용 예
    public static void main(String[] args) {
        Bit text = new Bit();
        // | 대응되는 연산자 중에 하나라도 1이면 1을 반환 OR연산
        // OR연산을 통해 여러 상수를 하나의 집합에 모을 수 있다
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    }
}
