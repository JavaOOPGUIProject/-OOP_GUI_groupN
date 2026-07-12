import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StudentPanel extends JPanel {

    Color Active = new Color(150,100,100);

    public StudentPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(20));
// add title
        JLabel StudentPage = new JLabel("Student");
        StudentPage.setFont(new Font("SansSerif", Font.BOLD, 45));
        StudentPage.setForeground(Active);
        StudentPage.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(StudentPage);
// add exit delet and add buttons (test)
        JPanel ButtonsRow = new JPanel();
        ButtonsRow.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 20));
        ButtonsRow.setOpaque(false);
        ButtonsRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        ButtonsRow.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton addBtn = new JButton("Add New");
        addBtn.setBackground(Color.WHITE);
        addBtn.setForeground(Color.DARK_GRAY);
        addBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        JButton editBtn = new JButton("Edit");
        editBtn.setBackground(Color.WHITE);
        editBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        editBtn.setForeground(Color.DARK_GRAY);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(Color.WHITE);
        deleteBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        deleteBtn.setForeground(Color.DARK_GRAY);


        addBtn.setBounds(100, 10, 150, 50);
        editBtn.setBounds(450, 10, 150, 50);
        deleteBtn.setBounds(800, 10, 150, 50);

        ButtonsRow.add(addBtn);
        ButtonsRow.add(editBtn);
        ButtonsRow.add(deleteBtn);

        add(ButtonsRow);

        add(Box.createVerticalStrut(10));
// add table
        String[] StColumns = {"Full Name", "Student ID", "Degree", "Email", "Mobile Number"};
        Object[][] Stdata = {
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"},
                {"Sashan Avishka", "CT/22/026", "BICT", "sashanavishka7@gmail.com", "773929933"}
        };
        DefaultTableModel model = new DefaultTableModel(Stdata, StColumns);
        JTable StudentTable = new JTable(model);
        StudentTable.setFont(new Font("SansSerif", Font.BOLD, 12));
        StudentTable.setForeground(Color.DARK_GRAY);
        StudentTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));
        StudentTable.getTableHeader().setForeground(Active);
        StudentTable.setRowHeight(40);
        StudentTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 40));
        StudentTable.setGridColor(Active);
        StudentTable.setShowGrid(true);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        StudentTable.setDefaultRenderer(Object.class, center);

        JScrollPane StScol = new JScrollPane(StudentTable);
        StScol.setBorder(BorderFactory.createEmptyBorder());
        StScol.setBorder(new LineBorder(Active));

        JPanel TablePanel = new JPanel(new BorderLayout());
        TablePanel.setBorder(new EmptyBorder(10, 30, 10, 30));
        TablePanel.add(StScol);
        add(Box.createVerticalStrut(20));
        add(TablePanel);
//add save changes button
        JButton SaveBtn = new JButton("Save Changes");
        SaveBtn.setBackground(Active);
        SaveBtn.setForeground(Color.WHITE);
        SaveBtn.setFont(new Font("SansSerif", Font.BOLD, 20));

        JPanel SaveBtnPanel = new JPanel();
        SaveBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 20));
        SaveBtnPanel.setOpaque(false);


        SaveBtnPanel.add(SaveBtn);

        add(SaveBtnPanel);

// set delete button access
        deleteBtn.addActionListener(e -> {
            int Selected = StudentTable.getSelectedRow();

            deleteBtn.setBackground(Active);

            if (Selected != -1) {
                JOptionPane.showMessageDialog(null, "Are you sure.!");
                model.removeRow(Selected);
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a Student First !");
            }
            deleteBtn.setBackground(Color.WHITE);
        });

// set add button
        JTextField name = new JTextField();
        JTextField id = new JTextField();
        JTextField degree = new JTextField();
        JTextField email = new JTextField();
        JTextField mobile = new JTextField();

        JDialog dialog = new JDialog();
        dialog.setTitle("Add Student");
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                addBtn.setBackground(Color.WHITE);
            }
        });


        JPanel Form = new JPanel(new GridLayout(5, 2, 5, 5));
        Form.setBorder(new EmptyBorder(20, 40, 20, 40));

        Form.add(new JLabel("Full Name : "));
        Form.add(name);
        Form.add(new JLabel("Student ID : "));
        Form.add(id);
        Form.add(new JLabel("Degree : "));
        Form.add(degree);
        Form.add(new JLabel("Email : "));
        Form.add(email);
        Form.add(new JLabel("Mobile Number : "));
        Form.add(mobile);

        dialog.add(Form, BorderLayout.CENTER);

        JButton save = new JButton("save");
        JPanel saveP = new JPanel();
        saveP.setLayout(new FlowLayout(FlowLayout.CENTER));
        saveP.add(save);
        dialog.add(saveP, BorderLayout.SOUTH);

        save.addActionListener(e -> {

            if (name.getText().trim().isEmpty() ||
                    id.getText().trim().isEmpty() ||
                    degree.getText().trim().isEmpty() ||
                    email.getText().trim().isEmpty() ||
                    mobile.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(dialog, "Please fill all fields!");
                return;
            }

            model.addRow(new Object[]{
                    name.getText(),
                    id.getText(),
                    degree.getText(),
                    email.getText(),
                    mobile.getText()
            });
            name.setText("");
            id.setText("");
            degree.setText("");
            email.setText("");
            mobile.setText("");

            dialog.dispose();
            addBtn.setBackground(Color.WHITE);
        });

        addBtn.addActionListener(e -> {
            addBtn.setBackground(Active);
            dialog.setVisible(true);

        });

//set edit button
        JTextField Editname = new JTextField();
        JTextField Editid = new JTextField();
        JTextField Editdegree = new JTextField();
        JTextField Editemail = new JTextField();
        JTextField Editmobile = new JTextField();

        JDialog EditDialog = new JDialog();
        EditDialog.setTitle("Update Student");
        EditDialog.setSize(400, 300);
        EditDialog.setLocationRelativeTo(null);
        EditDialog.setLayout(new BorderLayout(10, 10));
        EditDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        EditDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                editBtn.setBackground(Color.WHITE);
            }
        });


        JPanel EditForm = new JPanel(new GridLayout(5, 2, 5, 5));
        EditForm.setBorder(new EmptyBorder(20, 40, 20, 40));

        EditForm.add(new JLabel("Full Name : "));
        EditForm.add(Editname);
        EditForm.add(new JLabel("Student ID : "));
        EditForm.add(Editid);
        EditForm.add(new JLabel("Degree : "));
        EditForm.add(Editdegree);
        EditForm.add(new JLabel("Email : "));
        EditForm.add(Editemail);
        EditForm.add(new JLabel("Mobile : "));
        EditForm.add(Editmobile);

        EditDialog.add(EditForm, BorderLayout.CENTER);

        JButton Update = new JButton("Update");
        JPanel UpdateP = new JPanel();
        UpdateP.setLayout(new FlowLayout(FlowLayout.CENTER));
        UpdateP.add(Update);
        EditDialog.add(UpdateP, BorderLayout.SOUTH);

        final int[] editingRow = {-1};

        editBtn.addActionListener(e -> {
            int Selected = StudentTable.getSelectedRow();

            editBtn.setBackground(Active);

            if (Selected == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Sudent First.");
                editBtn.setBackground(Color.WHITE);
                return;
            }

            Editname.setText(StudentTable.getValueAt(Selected, 0).toString());
            Editid.setText(StudentTable.getValueAt(Selected, 1).toString());
            Editdegree.setText(StudentTable.getValueAt(Selected, 2).toString());
            Editemail.setText(StudentTable.getValueAt(Selected, 3).toString());
            Editmobile.setText(StudentTable.getValueAt(Selected, 4).toString());

            editingRow[0] = Selected;
            EditDialog.setVisible(true);
        });

        Update.addActionListener(e -> {

            if (editingRow[0] != -1) {
                model.setValueAt(Editname.getText(), editingRow[0], 0);
                model.setValueAt(Editid.getText(), editingRow[0], 1);
                model.setValueAt(Editdegree.getText(), editingRow[0], 2);
                model.setValueAt(Editemail.getText(), editingRow[0], 3);
                model.setValueAt(Editmobile.getText(), editingRow[0], 4);
            }

            EditDialog.dispose();
            editBtn.setBackground(Color.WHITE);
        });
    }
}