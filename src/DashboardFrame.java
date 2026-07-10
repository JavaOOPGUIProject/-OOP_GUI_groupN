import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    Color purple = new Color(150, 100, 100);
    CardLayout cardLayout;
    JPanel contentPanel;

    public DashboardFrame() {

        setTitle("DashboardFrame");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(500, getHeight()));
        leftPanel.setBackground(purple);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createVerticalStrut(40));

        JLabel welcome = new JLabel("Welcome, Kumar");
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


        //Right panel
        cardLayout    = new CardLayout();
        contentPanel  = new JPanel(cardLayout);

        //Profile Panel
        JPanel profilePanel = new JPanel();
        profilePanel.setBackground(Color.WHITE);
        profilePanel.setLayout(new BoxLayout(profilePanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Profile Details");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setForeground(purple);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        profilePanel.add(Box.createVerticalStrut(50));
        profilePanel.add(title);
        profilePanel.add(Box.createVerticalStrut(70));

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

        RoundedButton saveButton = new RoundedButton("Save Changes", 20);
        saveButton.setFont(new Font("Arial", Font.BOLD, 22));

        saveButton.setMaximumSize(new Dimension(550, 65));
        saveButton.setPreferredSize(new Dimension(550, 65));

        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        saveButton.setBackground(purple);
        saveButton.setForeground(Color.WHITE);

        profilePanel.add(saveButton);



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