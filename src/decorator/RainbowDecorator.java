package decorator;

import java.awt.Color;
import java.util.List;

public abstract class RainbowDecorator implements Rainbow {
    protected Rainbow rainbow;

    public RainbowDecorator(Rainbow rainbow) {
        this.rainbow = rainbow;
    }

    @Override
    public List<Color> getColors() {
        return rainbow.getColors();
    }
}
