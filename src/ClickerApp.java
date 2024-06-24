import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class ClickerApp {

    private int leftClickCount = 0;
    private int middleClickCount = 0;
    private int rightClickCount = 0;

    public ClickerApp() {
        // Создаем главное окно
        JFrame frame = new JFrame("Кликер");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Создаем JLabel для отображения информации
        JLabel label = new JLabel("Кнопка не была нажата", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        frame.add(label, BorderLayout.CENTER);

        // Создаем кнопку
        JButton button = new JButton("Нажми меня");
        frame.add(button, BorderLayout.SOUTH);

        // Добавляем слушателя для кнопки
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String buttonType;
                if (SwingUtilities.isLeftMouseButton(e)) {
                    leftClickCount++;
                    buttonType = "левая кнопка мыши";
                } else if (SwingUtilities.isMiddleMouseButton(e)) {
                    middleClickCount++;
                    buttonType = "средняя кнопка мыши";
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    rightClickCount++;
                    buttonType = "правая кнопка мыши";
                } else {
                    buttonType = "неизвестная кнопка мыши";
                }
                updateLabel(label);
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });

        // Устанавливаем расположение окна по центру экрана
        frame.setLocationRelativeTo(null);

        // Делаем окно видимым
        frame.setVisible(true);
    }

    private void updateLabel(JLabel label) {
        label.setText("<html>Левая кнопка мыши: " + leftClickCount +
                "<br>Средняя кнопка мыши: " + middleClickCount +
                "<br>Правая кнопка мыши: " + rightClickCount + "</html>");
    }

    public static void main(String[] args) {
        // Запуск приложения
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClickerApp();
            }
        });
    }
}
