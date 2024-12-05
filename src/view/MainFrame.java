package view;

import controller.ColorController;
import model.ColorModel;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Rainbow Builder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Создаем модель
        ColorModel model = new ColorModel();

        // Создаем панель и контроллер
        ColorPanel panel = new ColorPanel();
        ColorController controller = new ColorController(model, panel);

        // Устанавливаем контроллер для панели
        panel.setController(controller);

        // Добавляем верхнюю панель инструментов
        JToolBar toolBar = new JToolBar();
        JButton generateButton = new JButton("Generate Rainbow");
        generateButton.addActionListener(e -> controller.generateRainbow());
        toolBar.add(generateButton);
        add(toolBar, "North"); // Добавляем на верхнюю часть окна

        // Добавляем основную панель
        add(panel);

        setVisible(true);
    }
}
