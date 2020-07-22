package com.example.mockito_try;

public class MainActivityPresenter {
    private User user;
    private View view;
    IRepository repository;

    public MainActivityPresenter(User user, IRepository repository) {
        this.user = user;
        this.view = view;
        this.repository = repository;
    }

    public void getData(int i) {
        String value = "isaac";
        if (i == 1) {
            value = "moses";
        }
        String s = repository.getData(value);
        if (s != null && s.equals("isa")) {
            user.setFullName(s);
        } else {
            user.setEmail(s);
        }
    }

    public void updateFullName(String fullName) {
        user.setFullName(fullName);
        view.updateUserInfoTextView(user.toString());

    }

    public void updateEmail(String email) {
        user.setEmail(email);
        view.updateUserInfoTextView(user.toString());

    }

    public interface View {

        void updateUserInfoTextView(String info);

        void showProgressBar();

        void hideProgressBar();

    }
}
