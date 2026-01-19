package main;
import controller.TaskManager;
import ui.MainWindow;
public class Main {
  
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TaskManager manager = new TaskManager();
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
