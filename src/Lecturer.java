import javax.swing.*;
import java.awt.*;

public class Lecturer extends JFrame {

    Color purple = new Color(150, 100, 100);

    public Lecturer() {

        setTitle("Lecturer Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left Panel
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(350, 0));
        leftPanel.setBackground(purple);
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        leftPanel.add(Box.createVerticalStrut(50));

        JLabel welcome = new JLabel("Welcome, Lecturer");
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcome.setForeground(Color.WHITE);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(welcome);
        leftPanel.add(Box.createVerticalStrut(60));

        JButton profileBtn = new JButton("Profile");
        JButton coursesBtn = new JButton("Courses");
        JButton studentsBtn = new JButton("Students");
        JButton logoutBtn = new JButton("Logout");

        JButton[] buttons = {profileBtn, coursesBtn, studentsBtn, logoutBtn};

        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(250, 50));
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            leftPanel.add(btn);
            leftPanel.add(Box.createVerticalStrut(20));
        }

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Lecturer Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(purple);

        centerPanel.add(title, BorderLayout.NORTH);

        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setFont(new Font("Arial", Font.PLAIN, 22));
        info.setText(
                "Welcome to the Lecturer Dashboard.\n\n" +
                        "You can:\n" +
                        "• View Profile\n" +
                        "• Manage Courses\n" +
                        "• View Students\n"
        );

        centerPanel.add(new JScrollPane(info), BorderLayout.CENTER);

        // Logout
        logoutBtn.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

}