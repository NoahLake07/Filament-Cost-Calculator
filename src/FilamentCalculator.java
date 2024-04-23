import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import java.awt.*;

public class FilamentCalculator {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new Error("Unable to initialize FlatLaf");
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Filament Cost Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            JPanel content = new JPanel();
            content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
            content.setAlignmentX(Component.LEFT_ALIGNMENT);
            content.add(new FilamentForm());

            frame.add(content);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);  // Center the frame
        });
    }
}
