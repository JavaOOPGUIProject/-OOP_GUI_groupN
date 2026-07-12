import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DepartmentsPanel extends JPanel {
    Color Active = new Color(150,100,100);
    public DepartmentsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(20));

        //Define Center Lable
        JLabel DepLable = new JLabel("Departments");
        DepLable.setFont(new Font("SansSerif",Font.BOLD,45));
        DepLable.setForeground(Active);
        DepLable.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(DepLable);

        JPanel ButtonRow = new JPanel();
        ButtonRow.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
        ButtonRow.setOpaque(false);
        ButtonRow.setMaximumSize(new Dimension(Integer.MAX_VALUE,75));

        JButton addBtn = new JButton("Add New");
        addBtn.setBackground(Color.WHITE);
        addBtn.setForeground(Color.DARK_GRAY);
        addBtn.setFont(new Font("SansSerif",Font.BOLD,20));

        JButton editBtn = new JButton("Edit");
        editBtn.setBackground(Color.WHITE);
        editBtn.setForeground(Color.DARK_GRAY);
        editBtn.setFont(new Font("SansSerif",Font.BOLD,20));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(Color.WHITE);
        deleteBtn.setForeground(Color.DARK_GRAY);
        deleteBtn.setFont(new Font("SansSerif",Font.BOLD,20));

        addBtn.setBounds(100,10,150,50);
        editBtn.setBounds(450,10,150,50);
        deleteBtn.setBounds(800,10,150,50);

        ButtonRow.add(addBtn);
        ButtonRow.add(editBtn);
        ButtonRow.add(deleteBtn);

        add(ButtonRow);

        add(Box.createVerticalStrut(10));
//add Course Table

        String[] CourseColumns = {"Name", "HOD", "Degree","No Of Staff"};
        String[][] Coursedata = {

        };

        DefaultTableModel model = new DefaultTableModel(Coursedata,CourseColumns);
        JTable DepartmentTable = new JTable(model);
        DepartmentTable.setForeground(Color.DARK_GRAY);
        DepartmentTable.setFont(new Font("SansSerif",Font.BOLD,12));
        DepartmentTable.getTableHeader().setForeground(Active);
        DepartmentTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,18));
        DepartmentTable.setRowHeight(40);
        DepartmentTable.getTableHeader().setPreferredSize(new Dimension(0,40));
        DepartmentTable.setGridColor(Active);
        DepartmentTable.setShowGrid(true);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        DepartmentTable.setDefaultRenderer(Object.class,center);

        JScrollPane CourseScroll = new JScrollPane(DepartmentTable);
        CourseScroll.setBorder(BorderFactory.createEmptyBorder());
        CourseScroll.setBorder(new LineBorder(Active));

        JPanel TablePanel = new JPanel(new BorderLayout());
        TablePanel.setBorder(new EmptyBorder(10,30,10,30));
        TablePanel.add(CourseScroll);
        add(Box.createVerticalStrut(20));
        add(TablePanel);

//Add Save Changes Button
        JButton saveBtn = new JButton("Save changes");
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setBackground(Active);
        saveBtn.setFont(new Font("sansSerif",Font.BOLD,20));

        JPanel saveBtnPanel = new JPanel();
        saveBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
        saveBtnPanel.setOpaque(false);

        saveBtnPanel.add(saveBtn);
        add(saveBtnPanel);

// set delete button access
        deleteBtn.addActionListener(e -> {
            int Selected = DepartmentTable.getSelectedRow();

            deleteBtn.setBackground(Active);

            if(Selected != -1) {
                JOptionPane.showMessageDialog(null,"Are you sure.!");
                model.removeRow(Selected);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Select a Student First !");
            }
            deleteBtn.setBackground(Color.WHITE);
        });

//Set Add Button
        JTextField Name = new JTextField();
        JTextField HOD = new JTextField();
        JTextField Degree = new JTextField();
        JTextField NoOfStaff = new JTextField();


        JDialog dialog = new JDialog();
        dialog.setTitle("Add Course");
        dialog.setSize(400,300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout(10,10));
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                addBtn.setBackground(Color.WHITE);
            }
        });


        JPanel form = new JPanel(new GridLayout(5,2,5,5));
        form.setBorder(new EmptyBorder(20,40,20,40));

        form.add(new JLabel("Name"));
        form.add(Name);
        form.add(new JLabel("HOD"));
        form.add(HOD);
        form.add(new JLabel("Degree"));
        form.add(Degree);
        form.add(new JLabel("No Of Staff"));
        form.add(NoOfStaff);


        dialog.add(form,BorderLayout.CENTER);

        JButton save = new JButton("save");
        JPanel saveP = new JPanel();
        saveP.setLayout(new FlowLayout(FlowLayout.CENTER));
        saveP.add(save);
        dialog.add(saveP,BorderLayout.SOUTH);

        save.addActionListener(e ->{

            if(Name.getText().trim().isEmpty() ||
                    HOD.getText().trim().isEmpty() ||
                    Degree.getText().trim().isEmpty() ||
                    NoOfStaff.getText().trim().isEmpty() ){

                JOptionPane.showMessageDialog(dialog, "Please fill all fields!");
                return;
            }

            model.addRow(new Object[]{
                    Name.getText(),
                    HOD.getText(),
                    Degree.getText(),
                    NoOfStaff.getText()

            });

                    Name.setText("");
                    HOD.setText("");
                    Degree.setText("");
                    NoOfStaff.setText("");

            dialog.dispose();
            addBtn.setBackground(Color.WHITE);

        });
        addBtn.addActionListener(e1 -> {
            addBtn.setBackground(Active);
            dialog.setVisible(true);
        });

//set edit button

        JTextField EditName = new JTextField();
        JTextField EditHOD = new JTextField();
        JTextField EditDegree = new JTextField();
        JTextField EditNoOfStaff = new JTextField();

        JDialog EditDialog = new JDialog();
        EditDialog.setTitle("Update Course");
        EditDialog.setSize(400,300);
        EditDialog.setLocationRelativeTo(null);
        EditDialog.setLayout(new BorderLayout(10,10));
        EditDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        EditDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                editBtn.setBackground(Color.WHITE);
            }
        });


        JPanel EditForm = new JPanel(new GridLayout(5,2,5,5));
        EditForm.setBorder(new EmptyBorder(20,40,20,40));

        EditForm.add(new JLabel("Name"));
        EditForm.add(EditName);
        EditForm.add(new JLabel("HOD"));
        EditForm.add(EditHOD);
        EditForm.add(new JLabel("Degree"));
        EditForm.add(EditDegree);
        EditForm.add(new JLabel("No Of Staff"));
        EditForm.add(EditNoOfStaff);


        EditDialog.add(EditForm,BorderLayout.CENTER);

        JButton Update = new JButton("Update");
        JPanel UpdateP = new JPanel();
        UpdateP.setLayout(new FlowLayout(FlowLayout.CENTER));
        UpdateP.add(Update);
        EditDialog.add(UpdateP,BorderLayout.SOUTH);

        final int [] editingRow = {-1};

        editBtn.addActionListener(e ->{

            int Selected = DepartmentTable.getSelectedRow();

            editBtn.setBackground(Active);

            if(Selected == -1){
                JOptionPane.showMessageDialog(this,"Please Select a Course First.");
                editBtn.setBackground(Color.WHITE);
                return;
            }

            EditName.setText(DepartmentTable.getValueAt(Selected,0).toString());
            EditHOD.setText(DepartmentTable.getValueAt(Selected,1).toString());
            EditDegree.setText(DepartmentTable.getValueAt(Selected,2).toString());
            EditNoOfStaff.setText(DepartmentTable.getValueAt(Selected,3).toString());

            editingRow [0] = Selected;
            EditDialog.setVisible(true);
        });

        Update.addActionListener(e -> {
            if(editingRow [0] != -1){
                model.setValueAt(EditName.getText(),editingRow[0],0);
                model.setValueAt(EditHOD.getText(),editingRow[0],1);
                model.setValueAt(EditDegree.getText(),editingRow[0],2);
                model.setValueAt(EditNoOfStaff.getText(),editingRow[0],3);
            }

            EditDialog.dispose();
            editBtn.setBackground(Color.WHITE);
        });
    }
}

