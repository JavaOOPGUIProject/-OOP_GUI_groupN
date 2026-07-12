import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class coursesPanel extends JPanel {
    Color Active = new Color(0,0,12);
    public coursesPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(20));

        // Define Center Lable
        JLabel CouLable = new JLabel("Courses");
        CouLable.setFont(new Font("SansSerif", Font.BOLD, 45));
        CouLable.setForeground(Active);
        CouLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(CouLable);

        // add exit delet and add buttons

        JPanel ButtonRow = new JPanel();
        ButtonRow.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 20));
        ButtonRow.setOpaque(false);
        ButtonRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));
        ButtonRow.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Define add,edit,delet buttons
        JButton addBtn = new JButton("Add New");
        addBtn.setBackground(Color.WHITE);
        addBtn.setForeground(Color.DARK_GRAY);
        addBtn.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton editBtn = new JButton("Edit");
        editBtn.setBackground(Color.WHITE);
        editBtn.setForeground(Color.DARK_GRAY);
        editBtn.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(Color.WHITE);
        deleteBtn.setForeground(Color.DARK_GRAY);
        deleteBtn.setFont(new Font("SansSerif", Font.BOLD, 20));

        addBtn.setBounds(100, 10, 150, 50);
        editBtn.setBounds(450, 10, 150, 50);
        deleteBtn.setBounds(800, 10, 150, 50);

        ButtonRow.add(addBtn);
        ButtonRow.add(editBtn);
        ButtonRow.add(deleteBtn);

        add(ButtonRow);

        add(Box.createVerticalStrut(10));
//add Course Table

        String[] CourseColumns = {"Course Code", "Course Name", "Credits", "Lecture"};
        String[][] Coursedata = {
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"},
                {"CTEC22023", "OOP", "3", "sashan Avishka"}
        };

        DefaultTableModel model = new DefaultTableModel(Coursedata,CourseColumns);
        JTable CourseTable = new JTable(model);
        CourseTable.setForeground(Color.DARK_GRAY);
        CourseTable.setFont(new Font("SansSerif",Font.BOLD,12));
        CourseTable.getTableHeader().setForeground(Active);
        CourseTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,18));
        CourseTable.setRowHeight(40);
        CourseTable.getTableHeader().setPreferredSize(new Dimension(0,40));
        CourseTable.setGridColor(Active);
        CourseTable.setShowGrid(true);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        CourseTable.setDefaultRenderer(Object.class,center);

        JScrollPane CourseScroll = new JScrollPane(CourseTable);
        CourseScroll.setBorder(BorderFactory.createEmptyBorder());
        CourseScroll.setBorder(new LineBorder(Active));

        JPanel TablePanel = new JPanel(new BorderLayout());
        TablePanel.setBorder(new EmptyBorder(10,30,10,30));
        TablePanel.add(CourseScroll);
        add(Box.createVerticalStrut(20));
        add(TablePanel);

//Add Save Changes Button
        JButton saveBtn = new JButton("Save Changes");
        saveBtn.setBackground(Active);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFont(new Font("SansSerif",Font.BOLD,20));


        JPanel saveBtnPanel = new JPanel();
        saveBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
        saveBtnPanel.setOpaque(false);

        saveBtnPanel.add(saveBtn);
        add(saveBtnPanel);

//Set delete button
        deleteBtn.addActionListener(e->{
            int selected = CourseTable.getSelectedRow();

            deleteBtn.setBackground(Active);

            if (selected != -1){
                JOptionPane.showMessageDialog(null,"Are You Sure.!");
                model.removeRow(selected);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Select a Course Fist.!");
            }
            deleteBtn.setBackground(Color.WHITE);

        });

//Set Add Button

        JTextField CourseCode = new JTextField();
        JTextField CourseName = new JTextField();
        JTextField Credits = new JTextField();
        JTextField Lecture = new JTextField();

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

        form.add(new JLabel("Course Code"));
        form.add(CourseCode);
        form.add(new JLabel("Course Name"));
        form.add(CourseName);
        form.add(new JLabel("Credits"));
        form.add(Credits);
        form.add(new JLabel("Lecture"));
        form.add(Lecture);

        dialog.add(form,BorderLayout.CENTER);

        JButton save = new JButton("save");
        JPanel saveP = new JPanel();
        saveP.setLayout(new FlowLayout(FlowLayout.CENTER));
        saveP.add(save);
        dialog.add(saveP,BorderLayout.SOUTH);

        save.addActionListener(e ->{

            if(CourseCode.getText().trim().isEmpty() ||
                    CourseName.getText().trim().isEmpty() ||
                    Credits.getText().trim().isEmpty() ||
                    Lecture.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(dialog, "Please fill all fields!");
                return;
            }

            model.addRow(new Object[]{
                    CourseCode.getText(),
                    CourseName.getText(),
                    Credits.getText(),
                    Lecture.getText()
            });

            CourseCode.setText("");
            CourseName.setText("");
            Credits.setText("");
            Lecture.setText("");

            dialog.dispose();
            addBtn.setBackground(Color.WHITE);

        });
            addBtn.addActionListener(e1 -> {
                addBtn.setBackground(Active);
                dialog.setVisible(true);
        });

//set edit button

        JTextField EditCourseCode = new JTextField();
        JTextField EditCourseName = new JTextField();
        JTextField EditCredits = new JTextField();
        JTextField EditLecture = new JTextField();

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

        EditForm.add(new JLabel("Course Code"));
        EditForm.add(EditCourseCode);
        EditForm.add(new JLabel("Course Name"));
        EditForm.add(EditCourseName);
        EditForm.add(new JLabel("Credits"));
        EditForm.add(EditCredits);
        EditForm.add(new JLabel("Lecture"));
        EditForm.add(EditLecture);

        EditDialog.add(EditForm,BorderLayout.CENTER);

        JButton Update = new JButton("Update");
        JPanel UpdateP = new JPanel();
        UpdateP.setLayout(new FlowLayout(FlowLayout.CENTER));
        UpdateP.add(Update);
        EditDialog.add(UpdateP,BorderLayout.SOUTH);

        final int [] editingRow = {-1};

        editBtn.addActionListener(e ->{
            int Selected = CourseTable.getSelectedRow();

            editBtn.setBackground(Active);

            if(Selected == -1){
                JOptionPane.showMessageDialog(this,"Please Select a Course First.");
                editBtn.setBackground(Color.WHITE);
                return;
            }

            EditCourseCode.setText(CourseTable.getValueAt(Selected,0).toString());
            EditCourseName.setText(CourseTable.getValueAt(Selected,1).toString());
            EditCredits.setText(CourseTable.getValueAt(Selected,2).toString());
            EditLecture.setText(CourseTable.getValueAt(Selected,3).toString());

            editingRow [0] = Selected;
            EditDialog.setVisible(true);
        });

        Update.addActionListener(e -> {
            if(editingRow [0] != -1){
                model.setValueAt(EditCourseCode.getText(),editingRow[0],0);
                model.setValueAt(EditCourseName.getText(),editingRow[0],1);
                model.setValueAt(EditCourseName.getText(),editingRow[0],2);
                model.setValueAt(EditLecture.getText(),editingRow[0],3);
            }

            EditDialog.dispose();
            editBtn.setBackground(Color.WHITE);
        });
    }
}