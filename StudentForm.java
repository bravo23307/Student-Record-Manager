import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class StudentForm extends JFrame {
    private JTextField nameField, rollField, marksField;
    private JTextArea displayArea;
    private DatabaseManager dbManager;

    public StudentForm() {
        dbManager = new DatabaseManager();

        setTitle("Student Record Manager");
        setLayout(null);
        setSize(400, 400);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 20);
        add(nameField);

        JLabel rollLabel = new JLabel("Roll No:");
        rollLabel.setBounds(20, 60, 100, 20);
        add(rollLabel);

        rollField = new JTextField();
        rollField.setBounds(120, 60, 200, 20);
        add(rollField);

        JLabel marksLabel = new JLabel("Marks:");
        marksLabel.setBounds(20, 100, 100, 20);
        add(marksLabel);

        marksField = new JTextField();
        marksField.setBounds(120, 100, 200, 20);
        add(marksField);

        JButton addButton = new JButton("Add Student");
        addButton.setBounds(120, 140, 150, 30);
        add(addButton);

        displayArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 190, 340, 140);
        add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rollNo = Integer.parseInt(rollField.getText());
                int marks = Integer.parseInt(marksField.getText());
                dbManager.addStudent(name, rollNo, marks);
                displayStudents();
            }
        });

        displayStudents();
        setVisible(true);
    }

    private void displayStudents() {
        try {
            ResultSet rs = dbManager.getAllStudents();
            displayArea.setText("");
            while (rs.next()) {
                displayArea.append("Name: " + rs.getString("name") +
                                   ", Roll No: " + rs.getInt("rollNo") +
                                   ", Marks: " + rs.getInt("marks") + "\\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentForm();
    }
}
