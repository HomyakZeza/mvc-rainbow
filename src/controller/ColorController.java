package controller;

import model.ColorModel;
import model.RainbowBuilder;
import view.ColorPanel;

import java.awt.Color;
import java.util.List;

public class ColorController {
    private final ColorModel model;
    private final ColorPanel view;

    public ColorController(ColorModel model, ColorPanel view) {
        this.model = model;
        this.view = view;
    }

    public void setFirstColor(Color color) {
        model.setFirstColor(color);
    }

    public void setSecondColor(Color color) {
        model.setSecondColor(color);
    }

    public void generateRainbow() {
        RainbowBuilder builder = new RainbowBuilder()
                .setStartColor(model.getFirstColor())
                .setEndColor(model.getSecondColor());
        List<Color> rainbow = builder.build();
        view.displayRainbow(rainbow);
    }
}
