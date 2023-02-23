package Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Random;

import Game.CheckData.InputName;
import Game.enum_collection.CharacterClasses;
import Game.enum_collection.CharacterSubClasses;
import Game.import_export_data.*;
import Game.CheckData.InputName.*;

import static Game.CheckData.InputName.inputName;

public abstract class Main {
    //constants
    static final String CVS = "CharacterSaveCode";
    //variables
    public static String nameOne = "Spiderman";
    public static String nameTwo = "Batman";
    public static String humanNameOne, humanNameTwo;
    public static int humanAttackOne;
    public static int humanDefenseOne;
    public static int humanMagicOne;
    public static int humanManaOne;
    public static int humanHealthOne;
    public static int humanDexterityOne;
    public static int humanAttackTwo, humanDefenseTwo, humanMagicTwo, humanManaTwo, humanHealthTwo, humanDexterityTwo;
    public static int weaponAttackOne, weaponAttackTwo, weaponAttackThree;
    public static int weaponDexterityOne, weaponDexterityTwo, weaponDexterityThree;
    public static int weaponAttributeOne, weaponAttributeTwo, weaponAttributeThree;
    public static int baseHAOne, baseHATwo;
    public static JTextArea console;
    public static JScrollPane console2;
    public static JScrollPane console0;
    public static JTextArea console01;
    public static JTextArea console001;
    public static JTextArea console002;
    public static JLabel filler;
    public static JLabel filler5;
    public static JLabel filler2;
    public static JLabel filler3;
    public static JLabel filler4;
    public static JComboBox weaponCombo01;
    public static JComboBox weaponCombo02;
    public static JComboBox ItemList;
    public static JComboBox ClassList = new JComboBox(CharacterClasses.values());
    public static JComboBox SubClassesList= new JComboBox(CharacterSubClasses.values());
    public static JComboBox WeaponList;

    public static void main(String[] args) {
        // Makes window
        createWindow();
        //Creates first player
        Actions action01 = new Actions();
        Human Batman = new Human("Batman", action01);
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
        Human Spiderman = new Human("Spiderman", action01);
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
                Actions.Battle();
            }
        });

        // second panel
        JPanel panel2 = new JPanel(false);
        tabbedPane.addTab("Check status", null, panel2, "Tab 2 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

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

        // third panel
        Container contentPane = new JPanel(false);
        tabbedPane.addTab("Create player", null, contentPane, "Tab 3 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JLabel label = new JLabel("Name: ");
        JTextField textField = new JTextField("Your name here", 10);
        contentPane.add(label);
        contentPane.add(textField);

        JLabel label01 = new JLabel("Class: ");
        contentPane.add(ClassList);
//        JTextField textField01 = new JTextField("My Text Field 01", 10);
        contentPane.add(label01);
//        contentPane.add(textField01);

        JLabel label02 = new JLabel("SubClass: ");
        contentPane.add(SubClassesList);
//        JTextField textField02 = new JTextField("My Text Field 02", 10);
        contentPane.add(label02);
//        contentPane.add(textField02);

        JLabel label03 = new JLabel("A story unfolds ");

        contentPane.add(label03);

        JButton button11 = new JButton("Save character");

        contentPane.add(button11);

        //deze lijnen geven de positie aan tegenover het paneel
        //eerste 3 velden
        layout.putConstraint(SpringLayout.WEST, label,6,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label,10,SpringLayout.NORTH, contentPane);
        //deze lijnen dat het van links naar rechts en naar boven gaat
        layout.putConstraint(SpringLayout.WEST, textField,6,SpringLayout.EAST, label);
        layout.putConstraint(SpringLayout.NORTH, textField,6,SpringLayout.NORTH, contentPane);
        //deze lijn bepaalt dat de contentpane links naar rechts uitbreidt
        layout.putConstraint(SpringLayout.WEST, contentPane,6,SpringLayout.EAST, textField);
        //deze lijn bepaalt dat de contentpane naar boven uitbreidt
        layout.putConstraint(SpringLayout.NORTH, contentPane,6,SpringLayout.NORTH, textField);

        //tweede 3 velden
        layout.putConstraint(SpringLayout.WEST, label01,10,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label01,26,SpringLayout.NORTH, label);
        //verticale calibratie van label veld
        layout.putConstraint(SpringLayout.SOUTH, label01,0,SpringLayout.NORTH, label02);
        //andere velden
        layout.putConstraint(SpringLayout.WEST, ClassList,21,SpringLayout.EAST, label01);
        layout.putConstraint(SpringLayout.NORTH, ClassList,6,SpringLayout.NORTH, label01);
        layout.putConstraint(SpringLayout.WEST, contentPane,6,SpringLayout.EAST, ClassList);
        layout.putConstraint(SpringLayout.NORTH, contentPane,6,SpringLayout.NORTH, ClassList);

        //derde 3 velden
        layout.putConstraint(SpringLayout.WEST, label02,4,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label02,30,SpringLayout.NORTH, label01);
        //verticale calibratie van label veld
        layout.putConstraint(SpringLayout.SOUTH, label02,0,SpringLayout.NORTH, label03);
        //andere velden
        layout.putConstraint(SpringLayout.WEST, SubClassesList,6,SpringLayout.EAST, label02);
        layout.putConstraint(SpringLayout.NORTH, SubClassesList,6,SpringLayout.NORTH, label02);
        layout.putConstraint(SpringLayout.WEST, contentPane,6,SpringLayout.EAST, SubClassesList);
        layout.putConstraint(SpringLayout.NORTH, contentPane,6,SpringLayout.NORTH, SubClassesList);

        //vierde veld
        layout.putConstraint(SpringLayout.WEST, label03,14,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label03,36,SpringLayout.NORTH, label02);

        //vijfde veld
        layout.putConstraint(SpringLayout.WEST, button11,14,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, button11,36,SpringLayout.NORTH, label03);

        button11.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //get and check and add name
                String name = textField.getText();
                inputName(name);
                //get and check class
                String chosenClass = String.valueOf(ClassList.getItemAt(ClassList.getSelectedIndex()));
                String classOfChoice = chosenClass;
                String chosenSubClass = String.valueOf(SubClassesList.getItemAt(SubClassesList.getSelectedIndex()));
                String subClassOfChoice = chosenSubClass;
                //add character file
                String arrayOfData[] = {name, classOfChoice, subClassOfChoice};
                ExportData.storeData(arrayOfData,name, CVS);
            }
        });

        frame.pack();
        frame.setVisible(true);

        // fourth panel
        JPanel panel04 = new JPanel(false);
        tabbedPane.addTab("Information", null, panel04, "Tab 3 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

        filler4 = new JLabel("          What can we learn?", SwingConstants.CENTER);
        console01 = new JTextArea(10, 25);
        console0 = new JScrollPane(console01);
        JButton button00 = new JButton("Get Information");
        ItemList = new JComboBox();

        panel04.setLayout(new BorderLayout());
        panel04.add(ItemList, BorderLayout.NORTH);
        panel04.add(filler4, BorderLayout.LINE_START);
        panel04.add(button00, BorderLayout.SOUTH);
        panel04.add(console0, BorderLayout.LINE_END);

    }

    public static void systemPrint() {
        System.out.println("Hello game");
    }

}
