import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame {

    //see the user selectrole
    private String selectedRole = "";

    // Layouts
    CardLayout cardLayout;
    JPanel formPanel;

    //Tabs
    JLabel signInTab;
    JLabel signUpTab;

    public Color activeColor = new Color(150,100,100);
    public Color inactiveColor = Color.GRAY;




    public LoginFrame() {

        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ----------------------- LEFT PANEL ------------------------------------------------------------------
        JPanel leftpanel = new JPanel();

        leftpanel.setBackground(activeColor);

        leftpanel.setBackground(activeColor);

        leftpanel.setPreferredSize(new Dimension(750, 600));
        leftpanel.setLayout(new BoxLayout(leftpanel, BoxLayout.Y_AXIS));

        leftpanel.add(Box.createVerticalStrut(280));

        //graduation cap symbol
        JLabel capIcon = new JLabel("🎓");
        capIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 150));
        capIcon.setForeground(Color.WHITE);
        capIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftpanel.add(capIcon);
        leftpanel.add(Box.createVerticalStrut(30));

        JLabel title = new JLabel("Faculty Management");
        JLabel title2 = new JLabel("System");


        title.setFont(new Font("SansSerif", Font.BOLD, 50));
        title2.setFont(new Font("SansSerif", Font.BOLD, 50));
        title.setForeground(Color.white);
        title2.setForeground(Color.white);

        title.setFont(new Font("Arial", Font.BOLD, 50));
        title2.setFont(new Font("Arial", Font.BOLD, 50));


        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftpanel.add(title);
        leftpanel.add(title2);

        leftpanel.add(Box.createVerticalStrut(70));


        JLabel bottom_Title01 = new JLabel("Faculty of Computing & Technology");
        JLabel bottom_Title02 = new JLabel("Manage your academic journey");

        bottom_Title01.setFont(new Font("Arial", Font.BOLD, 20));
        bottom_Title02.setFont(new Font("Arial", Font.PLAIN, 18));

        bottom_Title01.setForeground(Color.WHITE);
        bottom_Title02.setForeground(Color.WHITE);

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

        username.setForeground (activeColor);

        username.setForeground(activeColor);

        username.setAlignmentX(Component.LEFT_ALIGNMENT);


        //Username_Field
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(500, 40));
        userField.setPreferredSize(new Dimension(500, 40));
        userField.setAlignmentX(Component.LEFT_ALIGNMENT);
        userField.setFont(new Font("Arial", Font.PLAIN, 30));
        userField.setOpaque(false);
        userField.setBorder(new RoundedBorder(activeColor, 25, 3));

        //Password
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 35));

        password.setForeground(activeColor);
        password.setForeground(activeColor);

        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Password_Field
        JTextField password_Field = new JTextField();
        password_Field.setMaximumSize(new Dimension(500, 40));
        password_Field.setPreferredSize(new Dimension(500, 40));
        password_Field.setAlignmentX(Component.LEFT_ALIGNMENT);
        password_Field.setFont(new Font("Arial", Font.PLAIN, 30));
        password_Field.setOpaque(false);
        password_Field.setBorder(new RoundedBorder(activeColor, 25, 3));

        //Role_text
        JLabel role = new JLabel("Role");
        role.setFont(new Font("Arial", Font.BOLD, 35));
        role.setForeground(activeColor);
        role.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Button_Panel (role buttons + sign in button together)
        JPanel Button_Panel = new JPanel();
        Button_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        Button_Panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Admin_button
        RoundedButton admin_button = new RoundedButton("Admin",25);
        admin_button.setPreferredSize(new Dimension(150, 40));
        admin_button.setBackground(activeColor);
        admin_button.setForeground(Color.WHITE);

        //Student_button
        RoundedButton student_button = new RoundedButton("Student",25);
        student_button.setPreferredSize(new Dimension(150, 40));
        student_button.setBackground(activeColor);
        student_button.setForeground(Color.WHITE);

        //Lecturer_button
        RoundedButton lecturer_button = new RoundedButton("Lecturer",25);
        lecturer_button.setPreferredSize(new Dimension(150, 40));
        lecturer_button.setBackground(activeColor);
        lecturer_button.setForeground(Color.WHITE);

        Button_Panel.add(admin_button);
        Button_Panel.add(student_button);
        Button_Panel.add(lecturer_button);


        admin_button.addActionListener(e -> {
            selectedRole = "Admin";
            selectRoleButton(
                    admin_button,
                    admin_button,
                    student_button,
                    lecturer_button
            );
        });

        student_button.addActionListener(e -> {
            selectedRole = "Student";
            selectRoleButton(
                    student_button,
                    admin_button,
                    student_button,
                    lecturer_button
            );
        });

        lecturer_button.addActionListener(e -> {
            selectedRole = "Lecturer";
            selectRoleButton(
                    lecturer_button,
                    admin_button,
                    student_button,
                    lecturer_button
            );
        });



        //Sign In button — placed right below the 3 role buttons
        //JButton signInButton = new JButton("Sign In");
        RoundedButton signInButton = new RoundedButton("Sign In",30);
        signInButton.setBackground(activeColor);

       // signInButton.setBackground(purple);
        signInButton.setForeground(Color.WHITE);
        signInButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        signInButton.setPreferredSize(new Dimension(500, 70));
        signInButton.setMaximumSize(new Dimension(500, 70));
        signInButton.setFont(new Font("Arial", Font.BOLD, 28));

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

            if (selectedRole.equals("Student")) {
                new Student();   // Student page

            } else if (selectedRole.equals("Admin")) {
                new AdminDashboard();   // Admin page

            } else if (selectedRole.equals("Lecturer")) {
                new LecturerDashboard(); // Lecturer page

            } else {
                JOptionPane.showMessageDialog(this,
                        "Please select a role!");
                return;
            }

            dispose();
        });

        return panel;
    }
    private void selectRoleButton(
            RoundedButton selected,
            RoundedButton admin_button,
            RoundedButton student_button,
            RoundedButton lecturer_button) {

        admin_button.setBackground(activeColor);
        student_button.setBackground(activeColor);
        lecturer_button.setBackground(activeColor);

        admin_button.setForeground(Color.WHITE);
        student_button.setForeground(Color.WHITE);
        lecturer_button.setForeground(Color.WHITE);

        selected.setBackground(new Color(220,150,150));
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
        username.setForeground(activeColor);
        username.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Username_Field
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(500, 40));
        userField.setPreferredSize(new Dimension(500, 40));
        userField.setAlignmentX(Component.LEFT_ALIGNMENT);
        userField.setFont(new Font("Arial", Font.PLAIN, 30));
        userField.setOpaque(false);
        userField.setBorder(new RoundedBorder(activeColor, 30, 3));


        //Password
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 35));
        password.setForeground(activeColor);
        password.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Password_Field
        JTextField password_Field = new JTextField();
        password_Field.setMaximumSize(new Dimension(500, 40));
        password_Field.setPreferredSize(new Dimension(500, 40));
        password_Field.setAlignmentX(Component.LEFT_ALIGNMENT);
        password_Field.setFont(new Font("Arial", Font.PLAIN, 30));
        password_Field.setOpaque(false);
        password_Field.setBorder(new RoundedBorder(activeColor, 30, 3));

        //Confirm Password
        JLabel confirm = new JLabel("Confirm Password");
        confirm.setFont(new Font("Arial", Font.BOLD, 35));
        confirm.setForeground(activeColor);
        confirm.setAlignmentX(Component.LEFT_ALIGNMENT);


        //Confirm_Password_Field
        JTextField confirmField = new JTextField();
        confirmField.setMaximumSize(new Dimension(500, 40));
        confirmField.setPreferredSize(new Dimension(500, 40));
        confirmField.setAlignmentX(Component.LEFT_ALIGNMENT);
        confirmField.setFont(new Font("Arial", Font.PLAIN, 30));
        confirmField.setOpaque(false);
        confirmField.setBorder(new RoundedBorder(activeColor, 30, 3));


        //Role_text
        JLabel role = new JLabel("Role");
        role.setFont(new Font("Arial", Font.BOLD, 35));
        role.setForeground(activeColor);
        role.setForeground(activeColor);
        role.setAlignmentX(Component.LEFT_ALIGNMENT);

        //Button_Panel
        JPanel Button_Panel = new JPanel();
        Button_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        Button_Panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        RoundedButton admin_button = new RoundedButton("Admin",25);
        admin_button.setPreferredSize(new Dimension(150, 40));
        admin_button.setBackground(activeColor);
        admin_button.setForeground(Color.WHITE);

        RoundedButton student_button = new RoundedButton("Student",25);
        student_button.setPreferredSize(new Dimension(150, 40));
        student_button.setBackground(activeColor);
        student_button.setForeground(Color.WHITE);

        RoundedButton lecturer_button = new RoundedButton("Lecturer",25);
        lecturer_button.setPreferredSize(new Dimension(150, 40));
        lecturer_button.setBackground(activeColor);
        lecturer_button.setForeground(Color.WHITE);

        Button_Panel.add(admin_button);
        Button_Panel.add(student_button);
        Button_Panel.add(lecturer_button);

        //Sign up Button
        //JButton signUpButton = new JButton("Sign Up");

        RoundedButton signUpButton = new RoundedButton("Sign Up",30);
        signUpButton.setBackground(activeColor);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        signUpButton.setPreferredSize(new Dimension(500, 70));
        signUpButton.setMaximumSize(new Dimension(500, 70));
        signUpButton.setFont(new Font("Arial", Font.BOLD, 28));

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
            new Student();
            dispose();
        });

        return panel;
    }

    private void setActiveTab(JLabel label, boolean active) {
        label.setForeground(active ? activeColor : inactiveColor);

        if (active) {
            label.setBorder(BorderFactory.createMatteBorder(
                    0, 0, 4, 0, activeColor
            ));
        } else {
            label.setBorder(BorderFactory.createEmptyBorder(
                    0, 0, 4, 0
            ));
        }
    }


}