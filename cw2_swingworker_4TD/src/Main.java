import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main extends JFrame {

    private JLabel statusLabel = new JLabel("Oczekiwanie...");
    private JButton startButton = new JButton("Start");

    public Main() {
        super("Naprawiona wersja (SwingWorker)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        add(startButton);
        add(statusLabel);

        startButton.addActionListener(e -> {

            SwingWorker<Void, String> worker = new SwingWorker<>() {

                @Override
                protected Void doInBackground() throws Exception {
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        publish("Pracuję... " + (i + 1) + "s");
                    }
                    return null;
                }

                @Override
                protected void process(List<String> chunks) {

                    String latest = chunks.get(chunks.size() - 1);
                    statusLabel.setText(latest);
                }

                @Override
                protected void done() {
                    statusLabel.setText("Zakończono pomyślnie!");
                }
            };

            worker.execute();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
