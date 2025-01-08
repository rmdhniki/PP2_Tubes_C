package controller;

import view.HalamanUtamaView;
import view.LoginView;
import view.RegisterView;

public class MainController {
    private HalamanUtamaView halamanUtamaView;
    private LoginView loginView;
    private RegisterView registerView;

    public MainController() {
        halamanUtamaView = new HalamanUtamaView();

        // Listener untuk tombol Sign In
        halamanUtamaView.addSignInListener(e -> openLoginView());

        // Listener untuk tombol Sign Up
        halamanUtamaView.addSignUpListener(e -> openRegisterView());

        // Tampilkan halaman utama
        halamanUtamaView.setVisible(true);
    }

    private void openLoginView() {
        if (loginView == null) {
            loginView = new LoginView();

            // Listener untuk tombol Register di LoginView
            loginView.addRegisterListener(e -> {
                loginView.setVisible(false);
                openRegisterView();
            });

            // Listener untuk tombol Back di LoginView
            loginView.addBackListener(e -> {
                loginView.setVisible(false);
                halamanUtamaView.setVisible(true);
            });
        }
        loginView.setVisible(true);
        halamanUtamaView.setVisible(false);
    }

    private void openRegisterView() {
        if (registerView == null) {
            registerView = new RegisterView();

            // Listener untuk tombol Back di RegisterView
            registerView.addBackListener(e -> {
                registerView.setVisible(false);
                halamanUtamaView.setVisible(true);
            });
        }
        registerView.setVisible(true);

        if (loginView != null) {
            loginView.setVisible(false);
        }
        halamanUtamaView.setVisible(false);
    }
}
