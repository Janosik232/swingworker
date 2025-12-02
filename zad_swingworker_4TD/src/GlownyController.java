import javax.swing.*;

public class GlownyController {

    private GlownyView view;
    private UzytkownikModel model;

    public GlownyController(GlownyView view, UzytkownikModel model) {
        this.view = view;
        this.model = model;

        inicjalizujAkcje();
    }

    private void inicjalizujAkcje() {
        view.przyciskZaloguj.addActionListener(e -> {

            SwingWorker<Boolean, Void> worker = new SwingWorker<>() {

                @Override
                protected Boolean doInBackground() {

                    SwingUtilities.invokeLater(() -> {
                        view.przyciskZaloguj.setEnabled(false);
                        view.statusLabel.setText("Trwa weryfikacja danych...");
                    });

                    String login = view.poleLogin.getText();
                    String haslo = new String(view.poleHaslo.getPassword());

                    return model.walidujLogowanie(login, haslo);
                }

                @Override
                protected void done() {
                    try {
                        boolean wynik = get();

                        if (wynik) {
                            view.statusLabel.setText("Logowanie pomyślne!");
                        } else {
                            view.statusLabel.setText("Błędny login lub hasło!");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.statusLabel.setText("Wystąpił błąd.");
                    }


                    view.przyciskZaloguj.setEnabled(true);
                }
            };

            worker.execute();
        });
    }
}
