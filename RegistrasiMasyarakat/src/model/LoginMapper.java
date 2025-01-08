package model;


public interface LoginMapper {
    int validateLogin(String email, String password);

    // Tambahkan metode untuk pendaftaran
    int registerUser(String emailOrPhone, String password);
}
