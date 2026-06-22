import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame{

    public LoginFrame(){
        //Setup the Frame and layout
        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //----------------creating the Left panel---------------------------------------
        JPanel leftpanel = new JPanel();
        leftpanel.setBackground(Color.magenta);
        leftpanel.setPreferredSize(new Dimension(750,600));
        leftpanel.setLayout(new BoxLayout(leftpanel,BoxLayout.Y_AXIS));

        //Spacing the from top of left panel
        leftpanel.add(Box.createVerticalStrut(400));

        JLabel Title = new JLabel("Faculty Management");
        JLabel Title_rest = new JLabel("System");

        //Setup the properties of Labels
        Title.setFont(new Font("Arial",Font.BOLD,50));
        Title_rest.setFont(new Font("Arial",Font.BOLD,50));
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        Title_rest.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftpanel.add(Title);
        leftpanel.add(Title_rest);

        //spacing with the above label
        leftpanel.add(Box.createVerticalStrut(250));


        JLabel bottom_T = new JLabel("Faculty of Computing and Technology");
        bottom_T.setFont(new Font("Arial",Font.BOLD,20));
        bottom_T.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftpanel.add(bottom_T);

        JLabel bottom_T_rest = new JLabel("Manage your academic journey");
        bottom_T_rest.setFont(new Font("Arial",Font.PLAIN,18));
        bottom_T_rest.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftpanel.add(bottom_T_rest);

        //-------------------------creating the Right panel-----------------------------------
        JPanel rightpanel = new JPanel();
        rightpanel.setPreferredSize(new Dimension(750,600));
        rightpanel.setLayout(new BoxLayout(rightpanel,BoxLayout.Y_AXIS));
        rightpanel.setBorder(new javax.swing.border.EmptyBorder(0, 60, 0, 0));

        rightpanel.add(Box.createVerticalStrut(300));

        //-------------------------Username------------------------------------------------------
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Arial",Font.BOLD,30));
        username.setForeground(Color.magenta);
        rightpanel.add(username);

        //Making properties of text field
        JTextField username_field = new JTextField(25);
        username_field.setMaximumSize(new Dimension(300, 50));
        username_field.setPreferredSize(new Dimension(300, 50));
        username_field.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightpanel.add(username_field);
        username_field.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
        username_field.setText("Kumara Sangakkara");

        rightpanel.add(Box.createVerticalStrut(20));

        //----------------------------password----------------------------------------------
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial",Font.BOLD,30));
        password.setForeground(Color.magenta);
        rightpanel.add(password);

        //password field properties making
        JTextField password_field = new JTextField(25);
        password_field.setMaximumSize(new Dimension(300, 50));
        password_field.setPreferredSize(new Dimension(300, 50));
        password_field.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightpanel.add(password_field);
        password_field.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));

        rightpanel.add(Box.createVerticalStrut(20));

        //--------------------buttons----------------------------------------------------------------------
        JLabel Role = new JLabel("Role");
        Role.setFont(new Font("Arial",Font.BOLD,30));
        Role.setForeground(Color.magenta);
        rightpanel.add(Role);

        rightpanel.add(Box.createVerticalStrut(10));

        JPanel button_panel = new JPanel();
        button_panel.setLayout(new BoxLayout(button_panel,BoxLayout.X_AXIS));
        button_panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton admin_button = new JButton("Admin");
        admin_button.setFont(new Font("Arial", Font.BOLD, 18));
        admin_button.setMaximumSize(new Dimension(150, 40));  // width, height
        admin_button.setBackground(Color.magenta);
        admin_button.setForeground(Color.white);

        JButton student_button = new JButton("Student");
        student_button.setFont(new Font("Arial", Font.BOLD, 18));
        student_button.setMaximumSize(new Dimension(150, 40));
        student_button.setBackground(Color.magenta);
        student_button.setForeground(Color.white);

        JButton Lecturer_button = new JButton("Lecturer");
        Lecturer_button.setFont(new Font("Arial", Font.BOLD, 18));
        Lecturer_button.setMaximumSize(new Dimension(150, 40));
        Lecturer_button.setBackground(Color.magenta);
        Lecturer_button.setForeground(Color.white);

        //Adding the buttons
        button_panel.add(admin_button);
        button_panel.add(Box.createRigidArea(new Dimension(50, 0)));
        button_panel.add(student_button);
        button_panel.add(Box.createRigidArea(new Dimension(50, 0)));
        button_panel.add(Lecturer_button);
        rightpanel.add(button_panel);


        add(leftpanel, BorderLayout.WEST);
        add(rightpanel, BorderLayout.CENTER);



    }



}


