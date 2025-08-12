import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task6 {
    public static void main(String[] args) {
        // Frame setup
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Text field to enter tasks
        JTextField taskField = new JTextField();
        frame.add(taskField, BorderLayout.NORTH);

        // List model and JList to display tasks
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add task action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText(""); // Clear input
            }
        });

        // Delete selected task action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}

