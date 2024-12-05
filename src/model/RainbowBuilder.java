package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class RainbowBuilder {
    private Color startColor;
    private Color endColor;

    public RainbowBuilder setStartColor(Color startColor) {
        this.startColor = startColor;
        return this;
    }

    public RainbowBuilder setEndColor(Color endColor) {
        this.endColor = endColor;
        return this;
    }

    public List<Color> build() {
        List<Color> rainbow = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            float ratio = (float) i / 10;
            int red = (int) (startColor.getRed() * (1 - ratio) + endColor.getRed() * ratio);
            int green = (int) (startColor.getGreen() * (1 - ratio) + endColor.getGreen() * ratio);
            int blue = (int) (startColor.getBlue() * (1 - ratio) + endColor.getBlue() * ratio);
            rainbow.add(new Color(red, green, blue));
        }
        return rainbow;
    }
}
