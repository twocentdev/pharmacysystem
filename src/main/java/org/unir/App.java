package org.unir;

import org.unir.view.MainView;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        MainView view = MainView.getInstance();
        view.setVisible(true);
    }
}
