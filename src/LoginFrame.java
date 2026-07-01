import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {

    // Layouts
    CardLayout cardLayout;
    JPanel formPanel;

    //Tabs
    JLabel signInTab;
    JLabel signUpTab;


    Color activeColor = Color.MAGENTA;
    Color inactiveColor = Color.GRAY;

    public LoginFrame() {

        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ----------------------- LEFT PANEL ------------------------------------------------------------------
        JPanel leftpanel = new JPanel();
        leftpanel.setBackground(Color.MAGENTA);
        leftpanel.setPreferredSize(new Dimension(750, 600));
        leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

        leftpanel.add(Box.createVerticalStrut(400));

        JLabel title = new JLabel("Faculty Management");
        JLabel title2 = new JLabel("System");

        title.setFont(new Font("Arial", Font.BOLD, 50));
        title2.setFont(new Font("Arial", Font.BOLD, 50));

        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftpanel.add(title);
        leftpanel.add(title2);

        leftpanel.add(Box.createVerticalStrut(250));

        JLabel bottom_Title01 = new JLabel("Faculty OF Computing and Technology");
        JLabel bottom_Title02 = new JLabel("Manage your academic journey");

        bottom_Title01.setFont(new Font("Arial", Font.BOLD, 20));
        bottom_Title02.setFont(new Font("Arial", Font.PLAIN, 18));

        bottom_Title01.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottom_Title02.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftpanel.add(bottom_Title01);
        leftpanel.add(bottom_Title02);

        // ---------------------------- RIGHT PANEL ---------------------------------------------------
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        //TOP Panel(SIGN IN / SIGN UP)
        JPanel Toppanel = new JPanel();
        Toppanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 20));

        signInTab = new JLabel("Sign In");
        signUpTab = new JLabel("Sign Up");

        signInTab.setFont(new Font("Arial", Font.BOLD, 35));
        signUpTab.setFont(new Font("Arial", Font.BOLD, 35));

        setActiveTab(signInTab, true);
        setActiveTab(signUpTab, false);

        Toppanel.add(signInTab);
        Toppanel.add(signUpTab);

        //CARD LAYOUT FOR FORMS
        cardLayout = new CardLayout();
        formPanel = new JPanel(cardLayout);

        formPanel.add(createSignInForm(), "signin");
        formPanel.add(createSignUpForm(), "signup");

        cardLayout.show(formPanel, "signin");

        // CLICK EVENTS
        signInTab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(formPanel, "signin");
                setActiveTab(signInTab, true);
                setActiveTab(signUpTab, false);
            }
        });

        signUpTab.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(formPanel, "signup");
                setActiveTab(signInTab, false);
                setActiveTab(signUpTab, true);
            }
        });

        rightPanel.add(Toppanel, BorderLayout.NORTH);
        rightPanel.add(formPanel, BorderLayout.CENTER);

        //ADD TO FRAME
        add(leftpanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    //Sign in Form Function
    private JPanel createSignInForm() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        panel.add(Box.createVerticalStrut(55));

        //Username
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.BOLD, 35));
        username.setForeground(Color.MAGENTA);
        username.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Username_Field
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(500, 40));
        userField.setPreferredSize(new Dimension(500, 40));
        userField.setAlignmentX(Component.LEFT_ALIGNMENT);
        userField.setFont(new Font("Arial", Font.PLAIN, 30));

        //Password
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 35));
        password.setForeground(Color.MAGENTA);
        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Password_Field
        JTextField password_Field = new JTextField();
        password_Field.setMaximumSize(new Dimension(500, 40));
        password_Field.setPreferredSize(new Dimension(500, 40));
        password_Field.setAlignmentX(Component.LEFT_ALIGNMENT);
        password_Field.setFont(new Font("Arial", Font.PLAIN, 30));

        //Role_text
        JLabel role = new JLabel("Role");
        role.setFont(new Font("Arial", Font.BOLD, 35));
        role.setForeground(Color.MAGENTA);
        role.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Button_Panel (role buttons + sign in button together)
        JPanel Button_Panel = new JPanel();
        Button_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        Button_Panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Admin_button
        JButton admin_button = new JButton("Admin");
        admin_button.setPreferredSize(new Dimension(150, 40));
        admin_button.setBackground(Color.MAGENTA);
        admin_button.setForeground(Color.WHITE);

        //Student_button
        JButton student_button = new JButton("Student");
        student_button.setPreferredSize(new Dimension(150, 40));
        student_button.setBackground(Color.MAGENTA);
        student_button.setForeground(Color.WHITE);

        //Lecturer_button
        JButton lecturer_button = new JButton("Lecturer");
        lecturer_button.setPreferredSize(new Dimension(150, 40));
        lecturer_button.setBackground(Color.MAGENTA);
        lecturer_button.setForeground(Color.WHITE);

        Button_Panel.add(admin_button);
        Button_Panel.add(student_button);
        Button_Panel.add(lecturer_button);

        //Sign In button — placed right below the 3 role buttons
        JButton signInButton = new JButton("Sign In");
        signInButton.setBackground(Color.MAGENTA);
        signInButton.setForeground(Color.WHITE);
        signInButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        signInButton.setMaximumSize(new Dimension(500, 45));

        //Adding all components to the panel
        panel.add(username);
        panel.add(Box.createVerticalStrut(15));
        panel.add(userField);

        panel.add(Box.createVerticalStrut(45));
        panel.add(password);
        panel.add(Box.createVerticalStrut(15));
        panel.add(password_Field);

        panel.add(Box.createVerticalStrut(25));
        panel.add(role);

        panel.add(Box.createVerticalStrut(15));
        panel.add(Button_Panel);

        panel.add(Box.createVerticalStrut(20));
        panel.add(signInButton);

        panel.add(Box.createVerticalGlue());

        signInButton.addActionListener(e -> {
            new DashboardFrame();
            dispose();
        });

        return panel;
    }

    //SignUp form Function
    private JPanel createSignUpForm() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));

        panel.add(Box.createVerticalStrut(55));

        //Username
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.BOLD, 35));
        username.setForeground(Color.MAGENTA);
        username.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Username_Field
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(500, 40));
        userField.setPreferredSize(new Dimension(500, 40));
        userField.setAlignmentX(Component.LEFT_ALIGNMENT);
        userField.setFont(new Font("Arial", Font.PLAIN, 30));

        //Password
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 35));
        password.setForeground(Color.MAGENTA);
        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Password_Field
        JTextField password_Field = new JTextField();
        password_Field.setMaximumSize(new Dimension(500, 40));
        password_Field.setPreferredSize(new Dimension(500, 40));
        password_Field.setAlignmentX(Component.LEFT_ALIGNMENT);
        password_Field.setFont(new Font("Arial", Font.PLAIN, 30));

        //Confirm Password
        JLabel confirm = new JLabel("Confirm Password");
        confirm.setFont(new Font("Arial", Font.BOLD, 35));
        confirm.setForeground(Color.MAGENTA);
        confirm.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Confirm_Password_Field
        JTextField confirmField = new JTextField();
        confirmField.setMaximumSize(new Dimension(500, 40));
        confirmField.setPreferredSize(new Dimension(500, 40));
        confirmField.setAlignmentX(Component.LEFT_ALIGNMENT);
        confirmField.setFont(new Font("Arial", Font.PLAIN, 30));

        //Role_text
        JLabel role = new JLabel("Role");
        role.setFont(new Font("Arial", Font.BOLD, 35));
        role.setForeground(Color.MAGENTA);
        role.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Button_Panel
        JPanel Button_Panel = new JPanel();
        Button_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        Button_Panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton admin_button = new JButton("Admin");
        admin_button.setPreferredSize(new Dimension(150, 40));
        admin_button.setBackground(Color.MAGENTA);
        admin_button.setForeground(Color.WHITE);

        JButton student_button = new JButton("Student");
        student_button.setPreferredSize(new Dimension(150, 40));
        student_button.setBackground(Color.MAGENTA);
        student_button.setForeground(Color.WHITE);

        JButton lecturer_button = new JButton("Lecturer");
        lecturer_button.setPreferredSize(new Dimension(150, 40));
        lecturer_button.setBackground(Color.MAGENTA);
        lecturer_button.setForeground(Color.WHITE);

        Button_Panel.add(admin_button);
        Button_Panel.add(student_button);
        Button_Panel.add(lecturer_button);

        //Sign up Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.MAGENTA);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        signUpButton.setMaximumSize(new Dimension(500, 45));

        //Adding_Components
        panel.add(username);
        panel.add(Box.createVerticalStrut(15));
        panel.add(userField);

        panel.add(Box.createVerticalStrut(45));
        panel.add(password);
        panel.add(Box.createVerticalStrut(15));
        panel.add(password_Field);

        panel.add(Box.createVerticalStrut(45));
        panel.add(confirm);
        panel.add(Box.createVerticalStrut(15));
        panel.add(confirmField);

        panel.add(Box.createVerticalStrut(25));
        panel.add(role);

        panel.add(Box.createVerticalStrut(15));
        panel.add(Button_Panel);

        panel.add(Box.createVerticalStrut(10));
        panel.add(signUpButton);

        signUpButton.addActionListener(e -> {
            new DashboardFrame();
            dispose();
        });

        return panel;
    }

    private void setActiveTab(JLabel label, boolean active) {
        label.setForeground(active ? activeColor : inactiveColor);
    }

}