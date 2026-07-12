import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DegreesPanel extends JPanel {
        Color Active = new Color(150,100,100);
        public DegreesPanel() {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(Box.createVerticalStrut(20));

//Define Center Lable
            JLabel DegLable = new JLabel("Degrees");
            DegLable.setFont(new Font("SansSerif",Font.BOLD,45));
            DegLable.setForeground(Active);
            DegLable.setAlignmentX(Component.CENTER_ALIGNMENT);

            add(DegLable);

// add exit delet and add buttons
            JPanel ButtonRow = new JPanel();
            ButtonRow.setLayout(new FlowLayout(FlowLayout.CENTER,150,20));
            ButtonRow.setOpaque(false);
            ButtonRow.setMaximumSize(new Dimension(Integer.MAX_VALUE,75));
            ButtonRow.setAlignmentX(Component.CENTER_ALIGNMENT);

// Define add,edit,delet buttons
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

            String[] CourseColumns = {"Degree", "Department", "No Of Student"};
            String[][] Coursedata = {
                    {"BICT", "Network Engineering", "300"},
                    {"BICT", "Software Engineering", "250"},
                    {"BICT", "Game and Animation", "150"},
                    {"BET", "Automobile Engineering", "150"},
                    {"BET", "Matirial", "150"},
                    {"BET", "Sustainable", "150"},
                    {"BSC", "Data Analysis" , "150"},
                    {"BSC", "Software Engineering", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"},
                    {"BSC", "Cyber Security Engineer", "150"}

            };

            DefaultTableModel model = new DefaultTableModel(Coursedata,CourseColumns);
            JTable DegreesTable = new JTable(model);
            DegreesTable.setForeground(Color.DARK_GRAY);
            DegreesTable.setFont(new Font("SansSerif",Font.BOLD,12));
            DegreesTable.getTableHeader().setForeground(Active);
            DegreesTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,18));
            DegreesTable.setRowHeight(40);
            DegreesTable.getTableHeader().setPreferredSize(new Dimension(0,40));
            DegreesTable.setGridColor(Active);
            DegreesTable.setShowGrid(true);

            DefaultTableCellRenderer center = new DefaultTableCellRenderer();
            center.setHorizontalAlignment(JLabel.CENTER);
            DegreesTable.setDefaultRenderer(Object.class,center);

            JScrollPane CourseScroll = new JScrollPane(DegreesTable);
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

//set delete button
            deleteBtn.addActionListener(e->{
                int selected = DegreesTable.getSelectedRow();

                deleteBtn.setBackground(Active);

                if(selected != -1){
                    JOptionPane.showMessageDialog(null,"Are you Sure.!");
                    model.removeRow(selected);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please Select a Degree First.!");
                }
               deleteBtn.setBackground(Color.WHITE);
            });

 //Set Add Button
            JTextField Degree = new JTextField();
            JTextField Department = new JTextField();
            JTextField NoOfStudent = new JTextField();


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

            form.add(new JLabel("Degree"));
            form.add(Degree);
            form.add(new JLabel("Department"));
            form.add(Department);
            form.add(new JLabel("No Of Students"));
            form.add(NoOfStudent);

            dialog.add(form,BorderLayout.CENTER);

            JButton save = new JButton("save");
            JPanel saveP = new JPanel();
            saveP.setLayout(new FlowLayout(FlowLayout.CENTER));
            saveP.add(save);
            dialog.add(saveP,BorderLayout.SOUTH);

            save.addActionListener(e ->{

                if(Degree.getText().trim().isEmpty() ||
                        Department.getText().trim().isEmpty() ||
                        NoOfStudent.getText().trim().isEmpty()){

                    JOptionPane.showMessageDialog(dialog, "Please fill all fields!");
                    return;
                }

                model.addRow(new Object[]{
                        Degree.getText(),
                        Department.getText(),
                        NoOfStudent.getText()
                });

                Degree.setText("");
                Department.setText("");
                NoOfStudent.setText("");

                dialog.dispose();
                addBtn.setBackground(Color.WHITE);

            });
            addBtn.addActionListener(e1 -> {
                addBtn.setBackground(Active);
                dialog.setVisible(true);
            });

//set edit button

            JTextField EditDegree = new JTextField();
            JTextField EditDepartment = new JTextField();
            JTextField EditNoOfStudent = new JTextField();

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

            EditForm.add(new JLabel("Degree"));
            EditForm.add(EditDegree);
            EditForm.add(new JLabel("Department"));
            EditForm.add(EditDepartment);
            EditForm.add(new JLabel("No Of Students"));
            EditForm.add(EditNoOfStudent);


            EditDialog.add(EditForm,BorderLayout.CENTER);

            JButton Update = new JButton("Update");
            JPanel UpdateP = new JPanel();
            UpdateP.setLayout(new FlowLayout(FlowLayout.CENTER));
            UpdateP.add(Update);
            EditDialog.add(UpdateP,BorderLayout.SOUTH);

            final int [] editingRow = {-1};

            editBtn.addActionListener(e ->{

                int Selected = DegreesTable.getSelectedRow();

                editBtn.setBackground(Active);

                if(Selected == -1){
                    JOptionPane.showMessageDialog(this,"Please Select a Course First.");
                    editBtn.setBackground(Color.WHITE);
                    return;
                }

                EditDegree.setText(DegreesTable.getValueAt(Selected,0).toString());
                EditDepartment.setText(DegreesTable.getValueAt(Selected,1).toString());
                EditNoOfStudent.setText(DegreesTable.getValueAt(Selected,2).toString());

                editingRow [0] = Selected;
                EditDialog.setVisible(true);
            });

            Update.addActionListener(e -> {
                if(editingRow [0] != -1){
                    model.setValueAt(EditDegree.getText(),editingRow[0],0);
                    model.setValueAt(EditDepartment.getText(),editingRow[0],1);
                    model.setValueAt(EditNoOfStudent.getText(),editingRow[0],2);
                }

                EditDialog.dispose();
                editBtn.setBackground(Color.WHITE);
            });
        }
    }

