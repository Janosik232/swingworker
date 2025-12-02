import javax.swing.*;
import java.awt.*;

public class GlownyView extends JFrame {

    public JTextField poleLogin = new JTextField(15);
    public JPasswordField poleHaslo = new JPasswordField(15);
    public JButton przyciskZaloguj = new JButton("Zaloguj");
    public JLabel statusLabel = new JLabel(" ");

    public GlownyView() {
        super("System Logowania");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Login:"));
        add(poleLogin);

        add(new JLabel("Hasło:"));
        add(poleHaslo);

        add(przyciskZaloguj);
        add(statusLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
