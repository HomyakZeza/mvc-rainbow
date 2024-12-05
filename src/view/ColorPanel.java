package view;

import controller.ColorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends JPanel {
    private ColorController controller;
    private Color selectedFirstColor;

    public ColorPanel() {
        setLayout(new GridLayout(1, 7)); // Сетка для кнопок цветов

        // Цвета радуги
        Color[] rainbowColors = {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                Color.BLUE, new Color(75, 0, 130), new Color(148, 0, 211)
        };

        for (Color color : rainbowColors) {
            JButton colorButton = new JButton();
            colorButton.setBackground(color);

            // Добавляем обработчик событий
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (controller == null) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Контроллер не установлен!",
                                "Ошибка",
                                JOptionPane.ERROR_MESSAGE
                        );
                        return;
                    }

                    if (selectedFirstColor == null) {
                        selectedFirstColor = color; // Устанавливаем первый цвет
                    } else {
                        controller.setFirstColor(selectedFirstColor); // Устанавливаем первый цвет в контроллер
                        controller.setSecondColor(color); // Устанавливаем второй цвет в контроллер
                        selectedFirstColor = null; // Сбрасываем выбор для следующей итерации
                    }
                }
            });

            add(colorButton);
        }
    }

    public void setController(ColorController controller) {
        this.controller = controller;
    }

    public void displayRainbow(java.util.List<Color> rainbow) {
        removeAll(); // Удаляем старые элементы
        for (Color color : rainbow) {
            JPanel colorPanel = new JPanel();
            colorPanel.setBackground(color);
            add(colorPanel);
        }
        revalidate();
        repaint();
    }
}
