import javax.swing.*;
import java.awt.*;

public class Student extends JFrame {

    Color purple = new Color(150, 100, 100);
    CardLayout cardLayout;
    JPanel contentPanel;

    private JTextField fullNameField = new JTextField();
    private JTextField studentNoField = new JTextField();
    private JTextField degreeField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField mobileField = new JTextField();

    private String username;

    public Student(String username) {

        this.username = username;
        setTitle("Student Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());



        //Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, getHeight()));
        leftPanel.setBackground(new Color(150,100,100));
        leftPanel.setBackground(purple);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createVerticalStrut(40));

        JLabel welcome = new JLabel("Welcome," + username);
        welcome.setFont(new Font("Arial", Font.BOLD, 35));
        welcome.setForeground(Color.WHITE);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(welcome);

        leftPanel.add(Box.createVerticalStrut(60));

        RoundedButton profileButton =
                new RoundedButton("Profile Details", 20);

        RoundedButton timetableButton =
                new RoundedButton("Time Table", 20);

        RoundedButton courseButton =
                new RoundedButton("Course Enrolled", 20);


        Dimension buttonSize = new Dimension(420, 65);


        profileButton.setBackground(Color.WHITE);
        profileButton.setForeground(purple);

        timetableButton.setBackground(Color.WHITE);
        timetableButton.setForeground(Color.GRAY);

        courseButton.setBackground(Color.WHITE);
        courseButton.setForeground(Color.GRAY);

        profileButton.setMaximumSize(buttonSize);
        timetableButton.setMaximumSize(buttonSize);
        courseButton.setMaximumSize(buttonSize);

        profileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        timetableButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        courseButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        profileButton.setFont(new Font("Arial", Font.BOLD, 30));
        timetableButton.setFont(new Font("Arial", Font.BOLD, 30));
        courseButton.setFont(new Font("Arial", Font.BOLD, 30));

        leftPanel.add(profileButton);
        leftPanel.add(Box.createVerticalStrut(35));

        leftPanel.add(timetableButton);
        leftPanel.add(Box.createVerticalStrut(35));

        leftPanel.add(courseButton);

        leftPanel.add(Box.createVerticalGlue());
        RoundedButton logoutButton = new RoundedButton("LOG OUT", 20);

        logoutButton.setPreferredSize(new Dimension(300, 60));
        logoutButton.setMaximumSize(new Dimension(300, 60));
        logoutButton.setFont(new Font("Arial", Font.BOLD, 24));

        logoutButton.setBackground(Color.WHITE);
        logoutButton.setForeground(purple);

        logoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(logoutButton);
        leftPanel.add(Box.createVerticalStrut(30));

        logoutButton.addActionListener(e -> {

            dispose();

            new LoginFrame();

        });

        ImageIcon Exit = new ImageIcon("images/Exit.png");
        Image scaled = Exit.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon ScaledIcon = new ImageIcon(scaled);

        JButton ExitButton = new JButton(ScaledIcon);
        ExitButton.setAlignmentX((Component.CENTER_ALIGNMENT));
        ExitButton.setBorderPainted(false);
        ExitButton.setContentAreaFilled(false);
        ExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        leftPanel.add(ExitButton);
        leftPanel.add(Box.createVerticalStrut(20));

        ExitButton.addActionListener(e ->{
            new LoginFrame();
            dispose();
        });


        //Right panel
        cardLayout    = new CardLayout();
        contentPanel  = new JPanel(cardLayout);

        //Profile Panel
        JPanel profilePanel = new JPanel();
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Profile Details");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setForeground(new Color(150,100,100));
        title.setForeground(purple);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        System.out.println(fullNameField);

        RoundedButton saveButton = new RoundedButton("Save Changes", 20);
        saveButton.setFont(new Font("Arial", Font.BOLD, 22));

        saveButton.setMaximumSize(new Dimension(550, 65));
        saveButton.setPreferredSize(new Dimension(550, 65));

        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        saveButton.setBackground(purple);
        saveButton.setForeground(Color.WHITE);

        saveButton.setBackground(new Color(150,100,100));

        profilePanel.add(Box.createVerticalStrut(60));
        JLabel titlepanel = new JLabel("Profile Details");
        titlepanel.setFont(new Font("Arial", Font.BOLD, 35));
        titlepanel.setForeground(new Color(150,100,100));
        titlepanel.setForeground(purple);
        titlepanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        profilePanel.add(titlepanel);
        profilePanel.add(Box.createVerticalStrut(40));

        profilePanel.add(createRow("Full Name"));
        profilePanel.add(Box.createVerticalStrut(40));

        profilePanel.add(createRow("Student ID"));
        profilePanel.add(Box.createVerticalStrut(40));

        profilePanel.add(createRow("Degree"));
        profilePanel.add(Box.createVerticalStrut(40));

        profilePanel.add(createRow("Email"));
        profilePanel.add(Box.createVerticalStrut(40));

        profilePanel.add(createRow("Mobile Number"));
        profilePanel.add(Box.createVerticalStrut(60));

        profilePanel.add(saveButton);

        //Timetable
        Color timetablePurple = purple;
        Color cellBg          = new Color(200, 200, 210);
        int   cellH           = 70;

        String[] columns = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String[][] rows  = {
                {"08.00", "OOP", "OOP", "OOP", "OOP", "OOP"},
                {"10.00", "OOP", "OOP", "OOP", "OOP", "OOP"},
                {null},
                {"01.00", "SE",  "OOP", "SE",  "SE",  "SE"},
                {"03.00", "SE",  "OOP", "SE",  "SE",  "SE"},
        };

        JPanel timetablePanel = new JPanel();
        timetablePanel.setLayout(new BoxLayout(timetablePanel, BoxLayout.Y_AXIS));

        JLabel ttTitle = new JLabel("Time Table");
        ttTitle.setFont(new Font("Arial", Font.BOLD, 35));
        ttTitle.setForeground(purple);
        ttTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel tablePanel = new JPanel(new GridBagLayout());
        tablePanel.setMaximumSize(new Dimension(900, 600));
        tablePanel.setPreferredSize(new Dimension(900, 500));
        tablePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill    = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets  = new Insets(0, 0, 0, 0);

        //Header row
        for (int col = 0; col < columns.length; col++) {
            gbc.gridx     = col;
            gbc.gridy     = 0;
            gbc.gridwidth = 1;
            tablePanel.add(makeTTCell(columns[col],
                    new Font("Arial", Font.BOLD, 22),
                    cellBg, timetablePurple, cellH, timetablePurple), gbc);
        }

        //Data rows
        int gridRow = 1;
        for (String[] row : rows) {
            if (row[0] == null) {
                gbc.gridx     = 0;
                gbc.gridy     = gridRow;
                gbc.gridwidth = 6;
                tablePanel.add(makeTTCell("Interval",
                        new Font("Arial", Font.BOLD, 28),
                        timetablePurple, Color.WHITE, cellH, timetablePurple), gbc);
                gbc.gridwidth = 1;
            } else {
                gbc.gridx = 0;
                gbc.gridy = gridRow;
                tablePanel.add(makeTTCell(row[0],
                        new Font("Arial", Font.BOLD, 20),
                        cellBg, timetablePurple, cellH, timetablePurple), gbc);

                for (int col = 1; col < columns.length; col++) {
                    gbc.gridx = col;
                    tablePanel.add(makeTTCell(row[col],
                            new Font("Arial", Font.PLAIN, 20),
                            cellBg, timetablePurple, cellH, timetablePurple), gbc);
                }
            }
            gridRow++;
        }

        timetablePanel.add(Box.createVerticalStrut(40));
        timetablePanel.add(ttTitle);
        timetablePanel.add(Box.createVerticalStrut(30));
        timetablePanel.add(tablePanel);
        timetablePanel.add(Box.createVerticalGlue());

        //Course enrolled panel
        JPanel coursePanel = new JPanel();
        coursePanel.setLayout(new BoxLayout(coursePanel, BoxLayout.Y_AXIS));

        JLabel courseTitle = new JLabel("Courses Enrolled");
        courseTitle.setFont(new Font("Arial", Font.BOLD, 35));
        courseTitle.setForeground(purple);
        courseTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] courseColumns = {"Course code", "Course name", "Credits", "Grade"};
        String[][] courseRows  = {
                {"ETEC 21062", "OOP", "2", "A+"},
                {"ETEC 21052", "OOP", "2", "B" },
                {"ETEC 21042", "OOP", "2", "A" },
                {"ETEC 21032", "OOP", "2", "D" },
                {"ETEC 21022", "OOP", "2", "C" },
                {"ETEC 21012", "OOP", "2", "B" },
        };

        JPanel courseTablePanel = new JPanel(new GridBagLayout());
        courseTablePanel.setMaximumSize(new Dimension(1000, 700));
        courseTablePanel.setPreferredSize(new Dimension(1000, 600));
        courseTablePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        GridBagConstraints cgbc = new GridBagConstraints();
        cgbc.fill    = GridBagConstraints.BOTH;
        cgbc.weightx = 1.0;
        cgbc.weighty = 1.0;
        cgbc.insets  = new Insets(0, 0, 0, 0);

        // Header row
        for (int col = 0; col < courseColumns.length; col++) {
            cgbc.gridx = col;
            cgbc.gridy = 0;
            courseTablePanel.add(makeTTCell(courseColumns[col],
                    new Font("Arial", Font.BOLD, 22),
                    cellBg, purple, cellH, purple), cgbc);
        }

        // Data rows
        for (int r = 0; r < courseRows.length; r++) {
            for (int col = 0; col < courseColumns.length; col++) {
                cgbc.gridx = col;
                cgbc.gridy = r + 1;
                courseTablePanel.add(makeTTCell(courseRows[r][col],
                        new Font("Arial", Font.BOLD, 20),
                        cellBg, purple, cellH, purple), cgbc);
            }
        }

        coursePanel.add(Box.createVerticalStrut(40));
        coursePanel.add(courseTitle);
        coursePanel.add(Box.createVerticalStrut(30));
        coursePanel.add(courseTablePanel);
        coursePanel.add(Box.createVerticalGlue());

        //Left panel elements
        contentPanel.add(profilePanel,   "profile");
        contentPanel.add(timetablePanel, "timetable"); // timetable card added
        contentPanel.add(coursePanel,    "course");    // course card added

        //Button actions
        profileButton.addActionListener(e  -> cardLayout.show(contentPanel, "profile"));
        timetableButton.addActionListener(e -> cardLayout.show(contentPanel, "timetable"));
        courseButton.addActionListener(e   -> cardLayout.show(contentPanel, "course"));

        add(leftPanel,   BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Helper for timetable cells
    private JPanel makeTTCell(String text, Font font,
                              Color bg, Color fg,
                              int preferredHeight, Color borderColor) {
        JPanel cell = new JPanel(new GridBagLayout());
        cell.setBackground(bg);
        cell.setBorder(BorderFactory.createLineBorder(borderColor, 1));
        cell.setPreferredSize(new Dimension(0, preferredHeight));

        JLabel lbl = new JLabel(text, SwingConstants.CENTER);
        lbl.setFont(font);
        lbl.setForeground(fg);
        cell.add(lbl);
        return cell;
    }

    private JPanel createRow(String text) {
        JPanel row = new JPanel();
        row.setBackground(Color.WHITE);
        row.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 0));
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 65));
        row.setPreferredSize(new Dimension(800, 65));

        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(180, 35));
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setForeground(new Color(150,100,100));

        label.setForeground(purple);

        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(500, 55));
        field.setFont(new Font("Arial", Font.PLAIN, 22));
        field.setOpaque(false);
        field.setBorder(new RoundedBorder(purple, 30, 3));

        row.add(label);
        row.add(field);
        return row;
    }

}
