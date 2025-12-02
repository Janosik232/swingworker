import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JLabel statusLabel = new JLabel("Oczekiwanie...");
    private JButton startButton = new JButton("Start");

    public Main() {
        super("Zawieszająca wersja (antywzorzec)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    statusLabel.setText("Pracuję... " + (i + 1) + "s");
                }
                statusLabel.setText("Zakończono blokadę.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
