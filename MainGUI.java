import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainGUI extends JFrame {
JTextField idField, nameField, ageField, diseaseField;
JButton addBtn, updateBtn, deleteBtn, clearBtn;
JTable table;
    DefaultTableModel model;
 Hospital service = new Hospital();
 public MainGUI() {
 setTitle("Hospital Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
JPanel inputPanel = new JPanel(new GridLayout(4, 2));
idField = new JTextField();
        nameField = new JTextField();
        ageField = new JTextField();
        diseaseField = new JTextField();
inputPanel.add(new JLabel("Patient ID"));
        inputPanel.add(idField);
inputPanel.add(new JLabel("Name"));
        inputPanel.add(nameField);
 inputPanel.add(new JLabel("Age"));
        inputPanel.add(ageField);
 inputPanel.add(new JLabel("Disease"));
        inputPanel.add(diseaseField);
 add(inputPanel, BorderLayout.NORTH);
 JPanel buttonPanel = new JPanel();
addBtn = new JButton("Add");
updateBtn = new JButton("Update");
deleteBtn = new JButton("Delete");
clearBtn = new JButton("Clear");

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);
add(buttonPanel, BorderLayout.CENTER);
 model = new DefaultTableModel();
model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Disease");        
 table = new JTable(model);
 JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.SOUTH);
addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });
 updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePatient();
            }
        });
 deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletePatient();
            }
        });
 clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
 setVisible(true);
    }
 void addPatient() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String disease = diseaseField.getText();
service.addPatient(new Patient(id, name, age, disease));
refreshTable();
        clearFields();
    }
 void updatePatient() {
        int id = Integer.parseInt(idField.getText());
service.updatePatient(
                id,
                nameField.getText(),
                Integer.parseInt(ageField.getText()),
                diseaseField.getText()
        );
refreshTable();
    }
void deletePatient() {
        int id = Integer.parseInt(idField.getText());

        service.deletePatient(id);
        refreshTable();
    }
void refreshTable() {
        model.setRowCount(0);
 for (Patient p : service.getPatients()) {
            model.addRow(new Object[]{
                    p.id,
                    p.name,
                    p.age,
                    p.disease
            });  } }
 void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        diseaseField.setText("");
    }
     public static void main(String[] args) {
        new MainGUI();
    }
}