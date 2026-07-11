import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JPanel currentCenterPanel;

    public GUI(){
        Color Active = new Color(150,100,100);

        setTitle("Students Admin page ");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // create left side panel
        JPanel LsidePanel = new JPanel();
        LsidePanel.setLayout(new BoxLayout(LsidePanel,BoxLayout.Y_AXIS));
        LsidePanel.setBackground(Active);
        LsidePanel.setPreferredSize(new Dimension(500,0));
        LsidePanel.add(Box.createVerticalStrut(40));
        add(LsidePanel,BorderLayout.WEST);

        LsidePanel.add(Box.createVerticalStrut(50));
// create left panel title
        JLabel Title = new JLabel("Welcome, Admin");
        Title.setFont(new Font("SansSerif", Font.BOLD,45));
        Title.setForeground(Color.WHITE);
        Title.setAlignmentX(Component.CENTER_ALIGNMENT);
        LsidePanel.add(Title);

        LsidePanel.add(Box.createVerticalStrut(60));

//Add Navigations

        String[] NavigateItems = {"Students","Lectures","courses","Departments","Degrees"};
        JButton[] NavButtons = new JButton[NavigateItems.length];
        for(int i = 0;i<NavigateItems.length;i++) {
            JButton Navigate = new JButton(NavigateItems[i]);
            Navigate.setForeground(Color.DARK_GRAY);
            Navigate.setBackground(Color.WHITE);
            Navigate.setPreferredSize(new Dimension(350, 55));
            Navigate.setFont(new Font("SansSerif", Font.BOLD, 32));
            Navigate.setCursor(new Cursor(Cursor.HAND_CURSOR));

            if (NavigateItems[i].equals("Students")) {
                Navigate.setForeground(Active);
            }
            else {
                Navigate.setForeground(Color.DARK_GRAY);
            }

            NavButtons[i] = Navigate;

            // On click: change only this button's font color, reset all others
            Navigate.addActionListener(e -> {
                for (JButton btn : NavButtons) {
                    btn.setForeground(Color.DARK_GRAY);
                }
                Navigate.setForeground(Active );
            });

            JPanel NavigateWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER,8,0));
            NavigateWrapper.setOpaque(false);
            NavigateWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE,55));
            NavigateWrapper.add(Navigate);
            LsidePanel.add(NavigateWrapper);


            if (i < NavigateItems.length - 1) {
                LsidePanel.add(Box.createVerticalStrut(30));
            }

            if (NavigateItems[i].equals("Students")) {
                Navigate.addActionListener(e -> {
                    switchCenterPanel(new StudentPanel());
                });
            }

            if (NavigateItems[i].equals("Lectures")) {
                Navigate.addActionListener(e -> {
                    switchCenterPanel(new LecturePanel());
                });
            }
            if (NavigateItems[i].equals("courses")) {
                Navigate.addActionListener(e -> {
                    switchCenterPanel(new coursesPanel());
                });
            }
            if (NavigateItems[i].equals("Departments")) {
                Navigate.addActionListener(e -> {
                    switchCenterPanel(new DepartmentsPanel());
                });
            }
            if (NavigateItems[i].equals("Degrees")) {
                Navigate.addActionListener(e -> {
                    switchCenterPanel(new DegreesPanel());
                });
            }
        }

        LsidePanel.add(Box.createVerticalGlue());

        ImageIcon Exit = new ImageIcon("images/Exit.png");
        Image scaled = Exit.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon ScaledIcon = new ImageIcon(scaled);

        JButton ExitButton = new JButton(ScaledIcon);
        ExitButton.setAlignmentX((Component.CENTER_ALIGNMENT));
        ExitButton.setBorderPainted(false);
        ExitButton.setContentAreaFilled(false);
        ExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LsidePanel.add(ExitButton);
        LsidePanel.add(Box.createVerticalStrut(20));

        ExitButton.addActionListener(e ->{
            new LoginFrame();
            dispose();
        });

// create right side panel (Students shown by default)
        switchCenterPanel(new StudentPanel());
    }

   //Swaps between  Panels
    private void switchCenterPanel(JPanel newPanel) {
        if (currentCenterPanel != null) {
            remove(currentCenterPanel);


        }
        currentCenterPanel = newPanel;
        add(currentCenterPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
}