import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LecturePanel extends JPanel {
    Color Active = new Color(150,100,100);
    public LecturePanel(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(Box.createVerticalStrut(20));

        // Define Center Lable
        JLabel LecLable= new JLabel("Lectures");
        LecLable.setFont(new Font("SansSerif", Font.BOLD, 45));
        LecLable.setForeground(Active);
        LecLable.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(LecLable);

 // add exit delet and add buttons
        JPanel ButtonsRow = new JPanel();
        ButtonsRow.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
        ButtonsRow.setOpaque(false);
        ButtonsRow.setMaximumSize(new Dimension(Integer.MAX_VALUE,75));
        ButtonsRow.setAlignmentX(Component.CENTER_ALIGNMENT);


        JButton addBtn = new JButton("Add New");
        addBtn.setBackground(Color.WHITE);
        addBtn.setForeground(Color.DARK_GRAY);
        addBtn.setFont(new Font("SansSerif", Font.BOLD,20));
        JButton editBtn = new JButton("Edit");
        editBtn.setBackground(Color.WHITE);
        editBtn.setFont(new Font("SansSerif", Font.BOLD,20));
        editBtn.setForeground(Color.DARK_GRAY);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(Color.WHITE);
        deleteBtn.setFont(new Font("SansSerif", Font.BOLD,20));
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
        String[] StColumns = {"Full Name","Department","Course Teaching","Email","Mobile Number"};
        Object [][] Stdata = {
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Software Engineering","CTEC22023","sashanavishka7@gmail.com","773929933"}

        };

        DefaultTableModel model = new DefaultTableModel(Stdata,StColumns);
        JTable LectureTable = new JTable(model);
        LectureTable.setFont(new Font("SansSerif", Font.BOLD,12));
        LectureTable.setForeground(Color.DARK_GRAY);
        LectureTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,18));
        LectureTable.getTableHeader().setForeground(Active);
        LectureTable.setRowHeight(40);
        LectureTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0,40));
        LectureTable.setGridColor(Active);
        LectureTable.setShowGrid(true);

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        LectureTable.setDefaultRenderer(Object.class,center);

        JScrollPane StScol = new JScrollPane(LectureTable);
        StScol.setBorder(BorderFactory.createEmptyBorder());
        StScol.setBorder(new LineBorder(Active));
        JPanel TablePanel = new JPanel(new BorderLayout());

        TablePanel.setBorder(new EmptyBorder(10,30,10,30));
        TablePanel.add(StScol);
        add(Box.createVerticalStrut(20));
        add(TablePanel);

        //add save changes button
        JButton SaveBtn = new JButton("Save Changes");
        SaveBtn.setBackground(Active);
        SaveBtn.setForeground(Color.WHITE);
        SaveBtn.setFont(new Font("SansSerif", Font.BOLD,20));

        JPanel SaveBtnPanel = new JPanel();
        SaveBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
        SaveBtnPanel.setOpaque(false);


        SaveBtnPanel.add(SaveBtn);

        add(SaveBtnPanel);


        // set delete button access
        deleteBtn.addActionListener(e -> {
            int Selected = LectureTable.getSelectedRow();

            if(Selected != -1) {
                JOptionPane.showMessageDialog(null,"Are you sure.");
                model.removeRow(Selected);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Select a row First !");
            }
        });

// set add button
        JTextField Fullname = new JTextField();
        JTextField Department = new JTextField();
        JTextField CourseTeaching = new JTextField();
        JTextField email = new JTextField();
        JTextField mobile = new JTextField();

        JDialog dialog = new JDialog();
        dialog.setTitle("Add Lecture");
        dialog.setSize(400,300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout(10,10));
        dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                addBtn.setBackground(Color.WHITE);
            }
        });


        JPanel Form = new JPanel(new GridLayout(5,2,5,5));
        Form.setBorder(new EmptyBorder(20,40,20,40));

        Form.add(new JLabel("Full Name : "));
        Form.add(Fullname);
        Form.add(new JLabel("Department : "));
        Form.add(Department);
        Form.add(new JLabel("Course Teaching : "));
        Form.add(CourseTeaching);
        Form.add(new JLabel("Email : "));
        Form.add(email);
        Form.add(new JLabel("Mobile Number : "));
        Form.add(mobile);

        dialog.add(Form,BorderLayout.CENTER);

        JButton save = new JButton("save");
        JPanel saveP = new JPanel();
        saveP.setLayout(new FlowLayout(FlowLayout.CENTER));
        saveP.add(save);
        dialog.add(saveP,BorderLayout.SOUTH);

        save.addActionListener(e -> {

            if(Fullname.getText().trim().isEmpty() ||
                    Department.getText().trim().isEmpty() ||
                    CourseTeaching.getText().trim().isEmpty() ||
                    email.getText().trim().isEmpty() ||
                    mobile.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(dialog, "Please fill all fields!");
                return;
            }

            model.addRow(new Object[]{
                    Fullname.getText(),
                    Department.getText(),
                    CourseTeaching.getText(),
                    email.getText(),
                    mobile.getText()
            });
            Fullname.setText("");
            Department.setText("");
            CourseTeaching.setText("");
            email.setText("");
            mobile.setText("");

            dialog.dispose();
            dialog.setBackground(Color.WHITE);
        });

        addBtn.addActionListener(e -> {
            addBtn.setBackground(Active);
            dialog.setVisible(true);
        });

//set edit button
        JTextField EditFullname = new JTextField();
        JTextField EditDepartment = new JTextField();
        JTextField EditCourseTeaching = new JTextField();
        JTextField Editemail = new JTextField();
        JTextField Editmobile = new JTextField();

        JDialog EditDialog = new JDialog();
        EditDialog.setTitle("Update Lecture");
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

        EditForm.add(new JLabel("Full Name : "));
        EditForm.add(EditFullname);
        EditForm.add(new JLabel("Department : "));
        EditForm.add(EditDepartment);
        EditForm.add(new JLabel("Course Teaching : "));
        EditForm.add(EditCourseTeaching);
        EditForm.add(new JLabel("Email : "));
        EditForm.add(Editemail);
        EditForm.add(new JLabel("Mobile Number : "));
        EditForm.add(Editmobile);

        EditDialog.add(EditForm,BorderLayout.CENTER);

        JButton Update = new JButton("Update");
        JPanel UpdateP = new JPanel();
        UpdateP.setLayout(new FlowLayout(FlowLayout.CENTER));
        UpdateP.add(Update);
        EditDialog.add(UpdateP,BorderLayout.SOUTH);

        final int[] editingRow = {-1};

        editBtn.addActionListener(e -> {
            int Selected = LectureTable.getSelectedRow();

            editBtn.setBackground(Active);

            if(Selected == -1){
                JOptionPane.showMessageDialog(this,"Please Select a Lecture First.");
                editBtn.setBackground(Color.WHITE);

                return;
            }

            EditFullname.setText(LectureTable.getValueAt(Selected,0).toString());
            EditDepartment.setText(LectureTable.getValueAt(Selected,1).toString());
            EditCourseTeaching.setText(LectureTable.getValueAt(Selected,2).toString());
            Editemail.setText(LectureTable.getValueAt(Selected,3).toString());
            Editmobile.setText(LectureTable.getValueAt(Selected,4).toString());

            editingRow[0] = Selected;
            EditDialog.setVisible(true);
        });

        Update.addActionListener(e -> {

            if(editingRow[0] != -1){
                model.setValueAt(EditFullname.getText(),editingRow[0],0);
                model.setValueAt(EditDepartment.getText(),editingRow[0],1);
                model.setValueAt(EditCourseTeaching.getText(),editingRow[0],2);
                model.setValueAt(Editemail.getText(),editingRow[0],3);
                model.setValueAt(Editmobile.getText(),editingRow[0],4);
            }

            EditDialog.dispose();
            editBtn.setBackground(Color.WHITE);

        });

    }
}