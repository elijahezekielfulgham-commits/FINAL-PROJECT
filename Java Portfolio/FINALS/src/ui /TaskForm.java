package ui;
import controller.TaskManager;
import model.Task;
import javax.swing.*;
import java.awt.*;
public class TaskForm extends JDialog {
  
    private JTextField txtId;
    private JTextField txtName;
    private JTextArea txtDesc;
    private JComboBox<String> cboStatus;
    private final TaskManager taskManager;
    private final MainWindow parent;
    public TaskForm(MainWindow parent, TaskManager taskManager) {
        super(parent, "Add Task", true);
        this.parent = parent;
        this.taskManager = taskManager;
        initForm();
    }

  
    private void initForm() {
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        txtId = new JTextField(String.valueOf(taskManager.generateNextId()));
        txtId.setEditable(false);
        txtName = new JTextField();
        txtDesc = new JTextArea(3, 15);
        cboStatus = new JComboBox<>(new String[]{
                "NOT STARTED", "ONGOING", "DONE"
        });
        panel.add(new JLabel("Task ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Task Name:"));
        panel.add(txtName);
        panel.add(new JLabel("*Task Description:"));
        panel.add(new JScrollPane(txtDesc));
        panel.add(new JLabel("Status:"));
        panel.add(cboStatus);

        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(e -> saveTask());
        add(panel, BorderLayout.CENTER);
        add(btnSave, BorderLayout.SOUTH);
    }

    private void saveTask() {
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "The name task is required");
            return;
        }
        Task task = new Task(
                Integer.parseInt(txtId.getText()),
                txtName.getText(),
                txtDesc.getText(),
                cboStatus.getSelectedItem().toString()
        );
        taskManager.addTask(task);
        parent.refreshTable();
        dispose();
    }
}
