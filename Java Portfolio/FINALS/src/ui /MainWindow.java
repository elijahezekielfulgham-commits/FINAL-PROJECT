package ui;

import controller.TaskManager;
import model.Task;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class MainWindow extends JFrame {

    private final TaskManager taskManager;
    private JTable table;
    private DefaultTableModel tableModel;
    private TaskForm taskForm;
    public MainWindow(TaskManager taskManager) {
        this.taskManager = taskManager;
        initUI();
    }

    private void initUI() {
        setTitle("To-Do List Application");
        setSize(800, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(e -> openForm());
        tableModel = new DefaultTableModel(new Object[]{
                "Task ID", "Task Name", "Task Description", "Status"
        }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
    }
    private void openForm() {
        if (taskForm == null || !taskForm.isDisplayable()) {
            taskForm = new TaskForm(this, taskManager);
            taskForm.setVisible(true);
        }
    }
    public void refreshTable() {
        tableModel.setRowCount(0);
        for (Task t : taskManager.getTasks()) {
            tableModel.addRow(new Object[]{
                    t.getTaskId(), t.getTaskName(), t.getTaskDescription(), t.getStatus()
            });
        }
    }
}
