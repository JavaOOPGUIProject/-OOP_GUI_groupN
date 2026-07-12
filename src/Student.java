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

        profileButton.setBackground(Color.WHITE);
        profileButton.setForeground(purple);

        timetableButton.setBackground(Color.WHITE);
        timetableButton.setForeground(Color.GRAY);

        courseButton.setBackground(Color.WHITE);
        courseButton.setForeground(Color.GRAY);

        Dimension buttonSize = new Dimension(420, 65);

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

        profilePanel.add(saveButton);

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



        // ---- Add cards ----
        contentPanel.add(profilePanel,   "profile");


        // ---- Button actions ----
        profileButton.addActionListener(e  -> cardLayout.show(contentPanel, "profile"));
        timetableButton.addActionListener(e -> cardLayout.show(contentPanel, "timetable"));
        courseButton.addActionListener(e   -> cardLayout.show(contentPanel, "course"));

        add(leftPanel,   BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
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

        JTextField field;

        switch (text) {
            case "Full Name":
                field = fullNameField;
                break;

            case "Student ID":
                field = studentNoField;
                break;

            case "Degree":
                field = degreeField;
                break;

            case "Email":
                field = emailField;
                break;

            case "Mobile Number":
                field = mobileField;
                break;

            default:
                field = new JTextField();
        }

        field.setPreferredSize(new Dimension(500, 55));
        field.setFont(new Font("Arial", Font.PLAIN, 22));
        field.setOpaque(false);
        field.setBorder(new RoundedBorder(purple, 30, 3));



        row.add(label);
        row.add(field);
        return row;
    }

}