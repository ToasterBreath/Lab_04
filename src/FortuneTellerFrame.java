import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    JPanel mainPnl, titlePnl, displayPnl, cmdPnl;
    JLabel titleLbl;
    ImageIcon icon;
    JScrollPane scroller;
    JTextArea fortuneTA;
    JButton quitBtn, fortuneBtn;
    ArrayList<String> Fortunes;

    int curFortuneDex = -1;

    public FortuneTellerFrame(){
        Fortunes = new ArrayList<>();
        loadFortunes();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();

        setTitle("Fortune Teller");
        setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().width * 0.75),(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.75));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void loadFortunes(){
        Fortunes.add("A beautiful, smart, and loving person will be coming into your life.");
        Fortunes.add("A dubious friend may be an enemy in camouflage.");
        Fortunes.add("A faithful friend is a strong defense.");
        Fortunes.add("A feather in the hand is better than a bird in the air.");
        Fortunes.add("A fresh start will put you on your way.");
        Fortunes.add("A friend asks only for your time not your money.");
        Fortunes.add("A friend is a present you give yourself.");
        Fortunes.add("A funny coincidence will make your day.");
        Fortunes.add("A gambler not only will lose what he has, but also will lose what he doesn’t have.");
        Fortunes.add("A golden egg of opportunity falls into your lap this month.");
        Fortunes.add("A good friendship is often more important than a passionate romance.");
        Fortunes.add("A good time to finish up old tasks.");
        Fortunes.add("A hunch is creativity trying to tell you something.");
        Fortunes.add("A lifetime friend shall soon be made.");
        Fortunes.add("A lifetime of happiness lies ahead of you.");
        Fortunes.add("Get bent, idiot.");
        Fortunes.add("You will explode in approximately 13462 seconds.");
        Fortunes.add("You must let it ride.");
        Fortunes.add("17 Black.");
    }
    public void createTitlePanel(){
        titlePnl = new JPanel();
        icon = new ImageIcon(System.getProperty("user.dir") + "/src/fortuneTeller.png");
        System.out.println(icon.getIconHeight());
        System.out.println(icon.getIconWidth());
        System.out.println(System.getProperty("user.dir") + "/src/fortuneTeller.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setText("Get your Fortune!");
        titleLbl.setFont(new Font ("Times New Roman", Font.PLAIN,32));
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.TOP);
        titlePnl.setBackground(new Color(2,0,107));
        titleLbl.setForeground(new Color(255, 255, 255));
        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }
    public void createDisplayPanel(){
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(15,50);
        fortuneTA.setEditable(false);
        fortuneTA.setFont(new Font("MS Comic Sans", Font.PLAIN, 16));
        displayPnl.setBackground(new Color(2,0,107));
        fortuneTA.setBackground(new Color(246, 255, 211));
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }
    public void createControlPanel(){
        Random rnd = new Random();
        cmdPnl = new JPanel();
        cmdPnl.setLayout(new GridLayout(1,2));
        fortuneBtn = new JButton("Get a fortune!");
        quitBtn = new JButton("Quit");

        fortuneBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        quitBtn.setFont(new Font("Arial", Font.PLAIN, 16));

        quitBtn.addActionListener((ActionEvent ae) ->{
           int response = JOptionPane.showConfirmDialog(quitBtn,"Are you sure you want to quit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
           if(response == JOptionPane.YES_OPTION){
               System.exit(0);
           }
        });

        fortuneBtn.addActionListener((ActionEvent ae) ->{
            int newDex = curFortuneDex;
            //System.out.println("Current Index: " + curFortuneDex);
            do{
                newDex = rnd.nextInt(0,Fortunes.size());
            }while(curFortuneDex == newDex);
            //System.out.println("New Index: " + newDex);

            fortuneTA.append(Fortunes.get(newDex) + "\n");
            curFortuneDex = newDex;
        });

        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);
        mainPnl.add(cmdPnl, BorderLayout.SOUTH);
    }
}
