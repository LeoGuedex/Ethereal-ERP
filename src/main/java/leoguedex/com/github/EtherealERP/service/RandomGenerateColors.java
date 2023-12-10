package leoguedex.com.github.EtherealERP.service;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerateColors {

    private final static Random random = new Random();
    @Getter
    private final List<String> randomColor;

    public RandomGenerateColors(int size) {
        randomColor = generate(size);
    }

    private static List<String> generate(int size) {
        List<String> colors = new ArrayList<>();

        for(int i = 0 ; i < size; i++){
            int red = random.nextInt(256);
            int blue = random.nextInt(256);
            int green = random.nextInt(256);

            colors.add(String.format("#%02X%02X%02X", red, green, blue));
        }

        return colors;
    }
}
