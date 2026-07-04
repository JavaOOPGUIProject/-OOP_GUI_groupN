import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
        String[] StColumns = {"Full Name","Lecture ID","Course Id","Email","Mobile Number"};
        Object [][] Stdata = {
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"},
                {"Sashan Avishka","Lec001","CTEC22023","sashanavishka7@gmail.com","773929933"}
        };
        DefaultTableModel model = new DefaultTableModel(Stdata,StColumns);
        JTable LectureTable = new JTable(model);
        LectureTable.setFont(new Font("SansSerif", Font.BOLD,12));
        LectureTable.setForeground(Color.DARK_GRAY);
        LectureTable.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,14));
        LectureTable.getTableHeader().setForeground(Active);
        LectureTable.setRowHeight(40);
        LectureTable.getTableHeader().setPreferredSize(new java.awt.Dimension(0,40));
        LectureTable.setGridColor(Active);
        LectureTable.setShowGrid(true);

        int tableWidth = LectureTable.getPreferredSize().width;

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
        SaveBtnPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,75));
        SaveBtnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        JTextField name = new JTextField();
        JTextField id = new JTextField();
        JTextField degree = new JTextField();
        JTextField email = new JTextField();
        JTextField mobile = new JTextField();

        JDialog dialog = new JDialog();
        dialog.setTitle("Add Lecture");
        dialog.setSize(400,300);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new BorderLayout(10,10));

        JPanel Form = new JPanel(new GridLayout(5,2,5,5));
        Form.setBorder(new EmptyBorder(20,40,20,40));

        Form.add(new JLabel("Full Name : "));
        Form.add(name);
        Form.add(new JLabel("Lecture ID : "));
        Form.add(id);
        Form.add(new JLabel("Course Id : "));
        Form.add(degree);
        Form.add(new JLabel("Email : "));
        Form.add(email);
        Form.add(new JLabel("Mobile : "));
        Form.add(mobile);

        dialog.add(Form,BorderLayout.CENTER);

        JButton save = new JButton("save");
        JPanel saveP = new JPanel();
        saveP.setLayout(new FlowLayout(FlowLayout.CENTER));
        saveP.add(save);
        dialog.add(saveP,BorderLayout.SOUTH);

        save.addActionListener(e -> {

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
        });

        addBtn.addActionListener(e -> {
            dialog.setVisible(true);
        });

//set edit button
        JTextField Editname = new JTextField();
        JTextField Editid = new JTextField();
        JTextField Editdegree = new JTextField();
        JTextField Editemail = new JTextField();
        JTextField Editmobile = new JTextField();

        JDialog EditDialog = new JDialog();
        EditDialog.setTitle("Update Lecture");
        EditDialog.setSize(400,300);
        EditDialog.setLocationRelativeTo(null);
        EditDialog.setLayout(new BorderLayout(10,10));

        JPanel EditForm = new JPanel(new GridLayout(5,2,5,5));
        EditForm.setBorder(new EmptyBorder(20,40,20,40));

        EditForm.add(new JLabel("Full Name : "));
        EditForm.add(Editname);
        EditForm.add(new JLabel("Lecture ID : "));
        EditForm.add(Editid);
        EditForm.add(new JLabel("Course Id : "));
        EditForm.add(Editdegree);
        EditForm.add(new JLabel("Email : "));
        EditForm.add(Editemail);
        EditForm.add(new JLabel("Mobile : "));
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

            if(Selected == -1){
                JOptionPane.showMessageDialog(this,"Please Select a Lecture Fisrts.");
                return;
            }

            Editname.setText(LectureTable.getValueAt(Selected,0).toString());
            Editid.setText(LectureTable.getValueAt(Selected,1).toString());
            Editdegree.setText(LectureTable.getValueAt(Selected,2).toString());
            Editemail.setText(LectureTable.getValueAt(Selected,3).toString());
            Editmobile.setText(LectureTable.getValueAt(Selected,4).toString());

            editingRow[0] = Selected;
            EditDialog.setVisible(true);
        });

        Update.addActionListener(e -> {

            if(editingRow[0] != -1){
                model.setValueAt(Editname.getText(),editingRow[0],0);
                model.setValueAt(Editid.getText(),editingRow[0],1);
                model.setValueAt(Editdegree.getText(),editingRow[0],2);
                model.setValueAt(Editemail.getText(),editingRow[0],3);
                model.setValueAt(Editmobile.getText(),editingRow[0],4);
            }

            EditDialog.dispose();
        });

    }
}