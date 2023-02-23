import Game.Actions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Random;

class Weapon{
    public int getHealth() {return health;}
    public int getAttack() {return attack;}
    public int getMagic() {return magic;}
    public int getMana() {return mana;}
    public int getDexterity() {return dexterity;}
    public void setDexterity(int dexterity) {this.dexterity = dexterity;}
    public int getDefense() {return defense;}
    public void setAttack(int attack) {this.attack = attack;}
    private int health;
    private int attack;
    private int magic;
    private int mana;
    private int dexterity;
    private int defense;
       public Weapon(String weaponName){
        String name = weaponName;
    }
}

class Human{
    private int health, attack, magic, mana, dexterity, defense;
    private String name;
    public Human(String name){
        health = 100;
        attack = 10;
        magic = 0;
        mana = 0;
        dexterity = 25;
        defense = 10;

        this.name = name;
        }
        public void setHealth(int healthToSet){
            this.health = healthToSet;
        }
        public void setAttack(int attackToSet){
            this.attack = attackToSet;
        }
        public int getAttack(){
            return this.attack;
        }
        public String getName() {return name;}
        public int getHealth() {return health;}
        public int getMagic() {return magic;}
        public int getMana() {return mana;}
        public int getDexterity() {return dexterity;}
        public int getDefense() {return defense;}
        }

public abstract class Main {
    public static String nameOne = "Spiderman";
    public static String nameTwo = "Batman";
    public static String humanNameOne, humanNameTwo;
    public static int humanAttackOne, humanDefenseOne, humanMagicOne, humanManaOne, humanHealthOne, humanDexterityOne;
    public static int humanAttackTwo, humanDefenseTwo, humanMagicTwo, humanManaTwo, humanHealthTwo, humanDexterityTwo;
    public static int weaponAttackOne, weaponAttackTwo, weaponAttackThree;
    public static int weaponDexterityOne, weaponDexterityTwo, weaponDexterityThree;
    public static int weaponAttributeOne, weaponAttributeTwo, weaponAttributeThree;
    public static int baseHAOne, baseHATwo;
    public static JTextArea console;
    public static JScrollPane console2;
    public static JTextArea console001;
    public static JTextArea console002;
    public static JLabel filler;
    public static JLabel filler5;
    public static JLabel filler2;
    public static JLabel filler3;
    public static JComboBox weaponCombo01;
    public static JComboBox weaponCombo02;

    public static void main(String[] args) {
        // Makes window
        createWindow();
        //Creates first player
        Human Batman = new Human("Batman");
        // System.out.println("He who always wins " + Batman.humanName);
        //Defines global attributes of human One
        humanNameOne = Batman.getName();
        humanAttackOne = Batman.getAttack();
        humanDefenseOne = Batman.getDefense();
        humanDexterityOne = Batman.getDexterity();
        humanHealthOne = Batman.getHealth();
        humanMagicOne = Batman.getMagic();
        humanManaOne = Batman.getMana();

        //Creates second player
        Human Spiderman = new Human("Spiderman");
        //System.out.println("He with responsibility issues " + Spiderman.humanName);
        // Defines global attributes of human Two
        humanNameTwo = Spiderman.getName();
        humanAttackTwo = Spiderman.getAttack();
        humanDefenseTwo = Spiderman.getDefense();
        humanDexterityTwo = Spiderman.getDexterity();
        humanHealthTwo = Spiderman.getHealth();
        humanMagicTwo = Spiderman.getMagic();
        humanManaTwo = Spiderman.getMana();

        Weapon Axe = new Weapon("Axe");
        Axe.setAttack(100);
        weaponAttackOne = Axe.getAttack();
        //System.out.println(Axe.attack);

        Weapon Sword = new Weapon("Sword");
        Sword.setAttack(75);
        weaponAttackTwo = Sword.getAttack();
        Sword.setDexterity(25);
        weaponDexterityTwo = Sword.getDexterity();
        //System.out.println(Axe.attack);

        Weapon Bow = new Weapon("Bow");
        Bow.setAttack(15);
        weaponAttackThree = Bow.getAttack();
        Bow.setDexterity(85);
        weaponDexterityThree = Bow.getDexterity();
        //System.out.println(Axe.attack);

    }

    private static void createWindow() {


        JFrame frame = new JFrame("Battle exercise");

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Actions");
        JMenuItem size00 = new JMenuItem("Reset Battle");
        JMenuItem size01 = new JMenuItem("Reset Equipment");

        size00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.setText("");
            }
        });

        size01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                humanAttackOne = baseHAOne;
                humanAttackTwo = baseHATwo;
            }
        });

        menu.add(size00);
        menu.add(size01);
        menubar.add(menu);
        frame.setJMenuBar(menubar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(600, 560);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {
        String weaponList[] = {"Axe", "Sword", "Bow"};

        JTabbedPane tabbedPane = new JTabbedPane();

        // first panel
        JPanel panel1 = new JPanel(false);

        filler = new JLabel(nameOne);
        filler5 = new JLabel(nameTwo);
        //JLabel filler6 = new JLabel("...");
        filler.setHorizontalAlignment(JLabel.CENTER);
        filler5.setHorizontalAlignment(JLabel.CENTER);

        JButton button0 = new JButton("Battle");

        console = new JTextArea(10, 25);
        console2 = new JScrollPane(console);
        //console2.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel1.setLayout(new BorderLayout());
        panel1.add(filler, BorderLayout.LINE_START);
        panel1.add(filler5, BorderLayout.LINE_END);

        panel1.add(button0, BorderLayout.SOUTH);
        panel1.add(console2, BorderLayout.CENTER);
        //console2.setPreferredSize(new Dimension(20,20));
        tabbedPane.addTab("Battle", null, panel1, "Tab 1 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        button0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                systemPrint();
                //filler.setText(humanNameOne + " Fought");
                //filler5.setText(humanNameTwo + " Fought");
                // determineAttack(humanAttackOne);
                // determineDefense(humanDefenseTwo);
                Actions.Battle();
            }
        });


        // second panel
        JPanel panel2 = new JPanel(false);
        filler2 = new JLabel("Batman");
        filler3 = new JLabel("Spiderman");
        console001 = new JTextArea(10, 25);
        console002 = new JTextArea(10, 25);

        weaponCombo01 = new JComboBox(weaponList);
        weaponCombo02 = new JComboBox(weaponList);

        JButton button1 = new JButton("Save equipment Player One");
        JButton button2 = new JButton("Save equipment Player Two");
        filler2.setHorizontalAlignment(JLabel.CENTER);
        filler3.setHorizontalAlignment(JLabel.CENTER);
        console001.setAlignmentX((float)0.5);
        console002.setAlignmentX((float)0.5);
        panel2.setLayout(new GridLayout(2, 1, 10, 10));
        panel2.add(filler2);
        panel2.add(filler3);

        panel2.add(weaponCombo01);
        panel2.add(weaponCombo02);

        panel2.add(console001);
        panel2.add(console002);

        panel2.add(button1);
        panel2.add(button2);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                systemPrint();
                String weaponOfChoice;
                weaponOfChoice = (String)weaponCombo01.getItemAt(weaponCombo01.getSelectedIndex());
                if(weaponOfChoice == "Axe")
                {weaponAttributeOne = weaponAttackOne;
                console001.setText(weaponOfChoice + " " + weaponAttributeOne);
                baseHAOne = humanAttackOne;
                humanAttackOne = humanAttackOne + weaponAttributeOne;}
                if(weaponOfChoice == "Sword")
                {weaponAttributeTwo = weaponAttackTwo;
                console001.setText(weaponOfChoice + " " + weaponAttributeTwo);
                baseHAOne = humanAttackOne;
                humanAttackOne = humanAttackOne + weaponAttributeTwo;}
                if(weaponOfChoice == "Bow")
                {weaponAttributeThree = weaponAttackThree;
                console001.setText(weaponOfChoice + " " + weaponAttributeThree);
                baseHAOne = humanAttackOne;
                humanAttackOne = humanAttackOne + weaponAttributeThree;}
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                systemPrint();
                String weaponOfChoice;
                weaponOfChoice = (String)weaponCombo02.getItemAt(weaponCombo02.getSelectedIndex());
                if(weaponOfChoice == "Axe")
                {weaponAttributeOne = weaponAttackOne;
                console002.setText(weaponOfChoice + " " + weaponAttributeOne);
                baseHATwo = humanAttackTwo;
                humanAttackTwo = humanAttackTwo + weaponAttributeOne;}
                if(weaponOfChoice == "Sword")
                {weaponAttributeTwo = weaponAttackTwo;
                console002.setText(weaponOfChoice + " " + weaponAttributeTwo);
                baseHATwo = humanAttackTwo;
                humanAttackTwo = humanAttackTwo + weaponAttributeTwo;}
                if(weaponOfChoice == "Bow")
                {weaponAttributeThree = weaponAttackThree;
                console002.setText(weaponOfChoice + " " + weaponAttributeThree);
                baseHATwo = humanAttackTwo;
                humanAttackTwo = humanAttackTwo + weaponAttributeThree;}
            }
        });


        tabbedPane.addTab("Check status", null, panel2, "Tab 2 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public static void systemPrint() {
        System.out.println("Hello game");
    }

//    public static int determineAttack(int humanAttackLevel) {
//        Random random = new Random();
//        int randomInteger = random.nextInt(100);
//        int attackHuman = humanAttackLevel + (randomInteger / 10);
//        //console.append(humanNameOne + " attacked for " + attackHuman + "\n");
//        return attackHuman;
//
//    }    ;
//
//    public static int determineDefense(int humanDefenseLevel) {
//        Random random = new Random();
//        int randomInteger = random.nextInt(100);
//        int defenseHuman = (humanDefenseLevel + randomInteger / 10);
//        //console.append(humanNameTwo + " blocked for " + defenseHuman + "\n");
//        return defenseHuman;
//
//    }
//
//    public static String Battle() {
//        int playerOneLife = humanHealthOne;
//        int playerTwoLife = humanHealthTwo;
//        System.out.println(playerOneLife);
//        System.out.println(playerTwoLife);
//
//        // define starting player
//        Random random00 = new Random();
//        int randomOneOrTwo = random00.nextInt(1,3);
//        // console.append(String.valueOf(randomOneOrTwo));
//
//        while (playerOneLife >= 0 && playerTwoLife >= 0 ) {
//            int AttackByOne;
//            AttackByOne = determineAttack(humanAttackOne) -determineDefense(humanDefenseTwo) ;
//            if (AttackByOne <=0){
//                AttackByOne = 0;
//            }
//            playerTwoLife = playerTwoLife - AttackByOne;
//            if (playerTwoLife <= 0){
//                console.append(humanNameOne + " attacked for " + AttackByOne + ". " + "\n" + humanNameTwo + " lost the battle.");
//                filler.setText(humanNameOne + " Won");
//                filler5.setText(humanNameTwo + " Lost");
//                break;
//            }else {
//                console.append(humanNameOne + " attacked for " + AttackByOne + ". " + humanNameTwo + " has " + playerTwoLife + " health left." + "\n");
//            }
//
//            int AttackByTwo;
//            AttackByTwo = determineAttack(humanAttackTwo) - determineDefense(humanDefenseOne);
//            if (AttackByTwo <=0){
//                AttackByTwo = 0;
//            }
//            playerOneLife = playerOneLife - AttackByTwo;
//            if (playerOneLife <= 0){
//                console.append(humanNameTwo + " attacked for " + AttackByTwo + ". " + "\n" + humanNameOne + " lost the battle.");
//                filler.setText(humanNameOne + " Lost");
//                filler5.setText(humanNameTwo + " Won");
//                break;
//
//            }else {
//                console.append(humanNameTwo + " attacked for " + AttackByTwo + ". " + humanNameOne + " has " + playerOneLife + " health left." + "\n");
//            }
//            }
//
//            return "Battled";
//
//        }


    }














