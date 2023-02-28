package Game;

import Game.CheckData.CasingMethods;
import Game.CheckData.ExportCharacterList;
import Game.ClassesCollection.Character;
import Game.ClassesCollection.God;
import Game.ClassesCollection.Human;
import Game.ClassesCollection.StringToConstructorSwitch;
import Game.StoryCollection.StoryContinue;
import Game.StoryCollection.StorySnippets;
import Game.enum_collection.CharacterClasses;
import Game.enum_collection.CharacterSubClasses;
import Game.enum_collection.RealEstate;
import Game.enum_collection.WeaponEnum;
import Game.import_export_data.ExportData;
import Game.StoryCollection.StorySnippets.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import static Game.CheckData.CasingMethods.toTitleCaseOneWord;
import static Game.CheckData.InputName.inputName;
import static Game.StoryCollection.StoryContinue.StoryContinues;
import static Game.StoryCollection.StoryContinue.readFromStoryFile;
import static Game.enum_collection.RealEstate.*;
import static Game.import_export_data.ExperienceActions.levelCalculator;
import static Game.import_export_data.ExportData.resetWeapon;
import static Game.import_export_data.ExportNameAndClass.exportCharacterStats;
import static Game.import_export_data.ExportNameAndClass.exportWeaponStats;


public abstract class Main {
    //constants
    static final String CVS = "CharacterSaveCode";
    static final String WVS = "WeaponSaveCode";
    //variables
    public static JTextArea console;
    public static JScrollPane console2;
    public static JScrollPane console0;
    public static JTextArea console01;
    public static JTextArea console001;
    public static JTextArea console002;
    public static JLabel filler4;
    public static JComboBox weaponCombo01 = new JComboBox(WeaponEnum.values());;
    public static JComboBox weaponCombo02 = new JComboBox(WeaponEnum.values());;
    public static JComboBox ItemList;
    public static JComboBox ClassList = new JComboBox(CharacterClasses.values());
    public static JComboBox SubClassesList= new JComboBox(CharacterSubClasses.values());

    //creates Character list
    ExportCharacterList exportCharacterList = new ExportCharacterList();
    public static JComboBox CharacterOne = new JComboBox(ExportCharacterList.exportCharacterList());
    public static JComboBox CharacterTwo = new JComboBox(ExportCharacterList.exportReverseCharacterList());
    public static JComboBox CharacterOnePage2 = new JComboBox(ExportCharacterList.exportCharacterList());
    public static JComboBox CharacterTwoPage2 = new JComboBox(ExportCharacterList.exportReverseCharacterList());
    public static JComboBox CharacterInformationPage = new JComboBox(ExportCharacterList.exportCharacterList());


    public static void main(String[] args) throws IOException {
        // Makes window
        createWindow();
    }

    private static void createWindow() throws IOException {

        JFrame frame = new JFrame("Battle Royal - Crossover");
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Battle Menu");
        JMenuItem size00 = new JMenuItem("Reset Battle - on first page");
        JMenuItem size01 = new JMenuItem("Reset Equipment - on first page");

        size00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                console.setText("");
            }
        });

        size01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String characterFirst  = String.valueOf(CharacterOne.getItemAt(CharacterOne.getSelectedIndex()));
                String characterSecond  = String.valueOf(CharacterTwo.getItemAt(CharacterTwo.getSelectedIndex()));
                resetWeapon(characterFirst);
                resetWeapon(characterSecond);
                console001.setText("");
                console002.setText("");
            }
        });

        menu.add(size00);
        menu.add(size01);
        menubar.add(menu);
        frame.setJMenuBar(menubar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(600, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) throws IOException {
        //creating file if first try
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\Storytracker.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                StoryContinue.writeToStoryFile(0);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int trackTheStory = StoryContinue.readFromStoryFile();

        JTabbedPane tabbedPane = new JTabbedPane();
        // 0panel
        JPanel panel0 = new JPanel(false);
        panel0.setBackground(Color.BLACK);
        tabbedPane.addTab("Front", null, panel0, "Tab 0 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
        panel0.setLayout(new FlowLayout());
        BufferedImage myPicture = ImageIO.read(new File(("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\portal.png")));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        JLabel label0001 = new JLabel("NEXUS", SwingConstants.CENTER );
        label0001.setFont(new Font("Serif", Font.BOLD, 60));
        label0001.setForeground(Color.WHITE);
        panel0.add(label0001);
        panel0.add(picLabel);
        //storypanel

        JPanel panelStory = new JPanel(false);
        tabbedPane.addTab("Story", null, panelStory, "Tab 00 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_0);
        panelStory.setLayout(new BorderLayout());
        JButton buttonStory01 = new JButton("Continue");
        String[] arrayOfSTory;
        arrayOfSTory = StorySnippets.storySnippets();
        JTextArea labelStory00 = new JTextArea( arrayOfSTory[trackTheStory]);
        labelStory00.setLineWrap(true);
        labelStory00.setLineWrap(true);
        labelStory00.setWrapStyleWord(true);
        labelStory00.setOpaque(false);
        labelStory00.setEditable(false);
        panelStory.add(buttonStory01, BorderLayout.LINE_END);
        panelStory.add(labelStory00);
          buttonStory01.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                 StoryContinues();
                 int trackStory = readFromStoryFile();
                 String[] arrayOfSTory;
                 arrayOfSTory = StorySnippets.storySnippets();
                 labelStory00.setText(arrayOfSTory[trackStory]);
                }
          });



        // first panel
        JPanel panel1 = new JPanel(false);
        tabbedPane.addTab("Battle", null, panel1, "Tab 1 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JButton button0 = new JButton("Battle");

        console = new JTextArea(10, 25);
        console2 = new JScrollPane(console);

        panel1.setLayout(new BorderLayout());
        panel1.add(CharacterOne, BorderLayout.LINE_START);
        panel1.add(CharacterTwo, BorderLayout.LINE_END);

        panel1.add(button0, BorderLayout.SOUTH);
        panel1.add(console2, BorderLayout.CENTER);

        button0.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //get character and class
                String characterFirst  = String.valueOf(CharacterOne.getItemAt(CharacterOne.getSelectedIndex()));
                String upperCaseCharacter = (String)exportCharacterStats(characterFirst)[1];
                String constructorClassCharacter = CasingMethods.toTitleCaseOneWord(upperCaseCharacter);

                String characterSecond  = String.valueOf(CharacterTwo.getItemAt(CharacterTwo.getSelectedIndex()));
                String upperCaseCharacter00 = (String)exportCharacterStats(characterSecond)[1];
                String constructorClassCharacter00 = CasingMethods.toTitleCaseOneWord(upperCaseCharacter00);

                //maak constructor aan met behulp van de 2 geselecteerde namen
                Character characterOne = StringToConstructorSwitch.constructorClass(constructorClassCharacter, characterFirst);
                Character characterTwo = StringToConstructorSwitch.constructorClass(constructorClassCharacter00, characterSecond);
                System.out.println(characterOne.toString());
                System.out.println(characterTwo.toString());
                //haal attack en defense op van de 2 geselecteerde namen
                int humanAttack1 = characterOne.getAttack();
                int humanDefense1 = characterOne.getDefense();
                int humanAttack2 = characterTwo.getAttack();
                int humanDefense2 = characterTwo.getDefense();
                int humanHealth1 = characterOne.getHealth();
                int humanHealth2 = characterTwo.getHealth();
                String humanName1 = characterFirst;
                String humanName2= characterSecond;
                //haal wapenschade op van de 2 geselecteerde namen
                int weaponDamage1 = 0;
                int weaponDamage2 = 0;
                try {
                    weaponDamage1 = Integer.parseInt(exportWeaponStats(characterFirst)[1]);
                    weaponDamage2 = Integer.parseInt(exportWeaponStats(characterSecond)[1]);
                } catch (Exception ex) {
                    System.out.println("No weapons selected");
                }
                //steek ze in Battle
                Actions.Battle((humanAttack1+weaponDamage1), humanDefense1, (humanAttack2+weaponDamage2), humanDefense2, humanHealth1, humanHealth2, humanName1, humanName2);
            }
        });

        // second panel
        JPanel panel2 = new JPanel(false);
        tabbedPane.addTab("Add equipment", null, panel2, "Tab 2 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        console001 = new JTextArea(10, 25);
        console002 = new JTextArea(10, 25);

        JButton button1 = new JButton("Save equipment Player One");
        JButton button2 = new JButton("Save equipment Player Two");

        console001.setAlignmentX((float)0.5);
        console002.setAlignmentX((float)0.5);
        panel2.setLayout(new GridLayout(2, 1, 10, 10));
        panel2.add(CharacterOnePage2);
        panel2.add(CharacterTwoPage2);

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

                WeaponEnum weaponEnum = WeaponEnum.valueOf(weaponCombo01.getSelectedItem().toString());
                console001.setText(weaponEnum.getName() + " " + weaponEnum.getAttack());
                String[] weaponStats = {weaponEnum.getName(), String.valueOf(weaponEnum.getAttack())};
                String characterSecond  = String.valueOf(CharacterOnePage2.getItemAt(CharacterOnePage2.getSelectedIndex()));
                ExportData.storeData(weaponStats, characterSecond, WVS);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                WeaponEnum weaponEnum = WeaponEnum.valueOf(weaponCombo02.getSelectedItem().toString());
                console002.setText(weaponEnum.getName() + " " + weaponEnum.getAttack());
                String[] weaponStats = {weaponEnum.getName(), String.valueOf(weaponEnum.getAttack())};
                String characterSecond  = String.valueOf(CharacterTwoPage2.getItemAt(CharacterTwoPage2.getSelectedIndex()));
                ExportData.storeData(weaponStats, characterSecond, WVS);

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
        contentPane.add(label01);

        JLabel label02 = new JLabel("SubClass: ");
        contentPane.add(SubClassesList);
        contentPane.add(label02);

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
        JPanel panel05 = new JPanel(false);
        tabbedPane.addTab("Real Estate", null, panel05, "Tab 4 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);


        panel05.setLayout(new GridLayout(8, 2, 10, 10));
        JLabel label501 = new JLabel(WOODEN_CABINE.toString()+ ": " + WOODEN_CABINE.getCost() + " coins.");
        JButton button501 = new JButton("Buy this property");
        JLabel label502 = new JLabel(HOUSE.toString()+ ": " + HOUSE.getCost()+ " coins.");
        JButton button502 = new JButton("Buy this property");
        JLabel label503 = new JLabel(VILLA.toString()+ ": " + VILLA.getCost()+ " coins.");
        JButton button503 = new JButton("Buy this property");
        JLabel label504 = new JLabel(APARTMENT.toString()+ ": " + APARTMENT.getCost()+ " coins.");
        JButton button504 = new JButton("Buy this property");
        JLabel label505 = new JLabel(MANSION.toString()+ ": " + MANSION.getCost()+ " coins.");
        JButton button505 = new JButton("Buy this property");
        JLabel label506 = new JLabel(CASTLE.toString()+ ": " + CASTLE.getCost()+ " coins.");
        JButton button506 = new JButton("Buy this property");
        JLabel label507 = new JLabel(PALACE.toString()+ ": " + PALACE.getCost()+ " coins.");
        JButton button507 = new JButton("Buy this property");
        JLabel label508 = new JLabel(WAREHOUSE.toString()+ ": " + WAREHOUSE.getCost()+ " coins.");
        JButton button508 = new JButton("Buy this property");

        panel05.add(label501 );
        panel05.add(button501);
        panel05.add(label502);
        panel05.add(button502);
        panel05.add(label503);
        panel05.add(button503);
        panel05.add(label504);
        panel05.add(button504);
        panel05.add(label505);
        panel05.add(button505);
        panel05.add(label506);
        panel05.add(button506);
        panel05.add(label507);
        panel05.add(button507);
        panel05.add(label508);
        panel05.add(button508);


        // fifth panel
        JPanel panel04 = new JPanel(false);
        tabbedPane.addTab("Information", null, panel04, "Tab 5 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

        filler4 = new JLabel("          What can we learn?", SwingConstants.CENTER);
        console01 = new JTextArea(10, 25);
        console0 = new JScrollPane(console01);
        JButton button0099 = new JButton("Get Information");
        ItemList = new JComboBox(CharacterInformationPage.getModel());

        panel04.setLayout(new BorderLayout());
        panel04.add(ItemList, BorderLayout.NORTH);
        panel04.add(filler4, BorderLayout.LINE_START);
        panel04.add(button0099, BorderLayout.SOUTH);
        panel04.add(console0, BorderLayout.LINE_END);
        button0099.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            console01.setText("");
            //get and check and add name
            String characterInformation  = String.valueOf(ItemList.getItemAt(ItemList.getSelectedIndex()));
            //set console
            //console01.setText(characterInformation + "\n");
            String[] characterStats = exportCharacterStats(characterInformation);
            for (String s: characterStats){
                console01.append(s + "\n");
            }
            try {
                String[] weaponStats = exportWeaponStats(characterInformation);
                for (String s : weaponStats) {
                    console01.append(s+ "\n");
                }
            }catch (Exception ee) {
                console01.append("No weapons there.\n");
            }

            int returnedExperience = Integer.parseInt(characterStats[3].substring(0,4).replaceFirst("^0+(?!$)", ""));
            console01.append(levelCalculator(returnedExperience) + " is current level.");
        }
    });



    }

    public static void systemPrint() {
        System.out.println("Hello game");
    }

}
