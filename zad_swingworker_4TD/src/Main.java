import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GlownyView view = new GlownyView();
            UzytkownikModel model = new UzytkownikModel();
            new GlownyController(view, model);
        });
    }
}
