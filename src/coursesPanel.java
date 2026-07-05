import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class coursesPanel extends JPanel {
    Color Active = new Color(150,100,100);
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

        JButton editBtn = new JButton("Add New");
        editBtn.setBackground(Color.WHITE);
        editBtn.setForeground(Color.DARK_GRAY);
        editBtn.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton deleteBtn = new JButton("Add New");
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
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
                { "CTEC22023", "OOP", "3", "sashan Avishka"},
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







    }
}