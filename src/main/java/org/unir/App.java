package org.unir;

import org.unir.view.MainView;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        MainView view = MainView.getInstance();
        view.setVisible(true);
    }
}
