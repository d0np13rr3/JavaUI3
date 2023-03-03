package Game;

import Game.CheckData.CasingMethods;
import Game.CheckData.ExportCharacterList;
import Game.ClassesCollection.Army;
import Game.ClassesCollection.Character;
import Game.ClassesCollection.StringToConstructorSwitch;
import Game.StoryCollection.StoryContinue;
import Game.StoryCollection.StorySnippets;
import Game.enum_collection.CharacterClasses;
import Game.enum_collection.CharacterSubClasses;
import Game.enum_collection.WeaponEnum;
import Game.import_export_data.ExportData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Game.CheckData.InputName.inputName;
import static Game.StoryCollection.StoryContinue.StoryContinues;
import static Game.StoryCollection.StoryContinue.readFromStoryFile;
import static Game.enum_collection.RealEstate.*;
import static Game.import_export_data.ExperienceActions.levelCalculator;
import static Game.import_export_data.ExportNameAndClass.exportCharacterStats;
import static Game.import_export_data.ExportNameAndClass.exportWeaponStats;
import static Game.import_export_data.MoneyActions.importMoneyStatsSubtract;



public abstract class Main {
    //Army variables
    public static Army armyOne;
    public static Army armyTwo;
    public static JComboBox comboBox1, comboBox9999, comboBox8888,comboBox2, comboBox3, comboBox4, comboBox5, comboBox6, comboBox7,comboBox8, comboBox9, comboBox10,comboBox11, comboBox12, comboBox13, comboBox14, comboBox15, comboBox16, comboBox17, comboBox18, comboBox19, comboBox20, comboBox21, comboBox22, comboBox23, comboBox24, comboBox25, comboBox26, comboBox27, comboBox28, comboBox29, comboBox30, comboBox31, comboBox32, comboBox33, comboBox34, comboBox35, comboBox36, comboBox37, comboBox38, comboBox39, comboBox40, comboBox41, comboBox42, comboBox43, comboBox44, comboBox45, comboBox46, comboBox47, comboBox48, comboBox49, comboBox50, comboBox51, comboBox52, comboBox53, comboBox54, comboBox55, comboBox56, comboBox57, comboBox58, comboBox59, comboBox60;
    public static JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9, textField10, textField11, textField12;
    public static JButton button1007, button2007;
    //constants
    static final String CVS = "CharacterSaveCode";
    static final String WVS = "WeaponSaveCode";
    static final String RVS = "RealEstateSaveCode";
    //variables
    public static JTextArea console, console60, console01, console001, console002;
    public static JScrollPane console2, console62, console0;
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
    public static void infoWarBox(String infoMessage, String titleBar)
    {
                // JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
        //JDialog.PROPERTIES(f,"War",true);
    }

    private static void createWindow() throws IOException {

        JFrame frame = new JFrame("Battle Royal - Crossover");
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Battle Menu");
        JMenuItem size00 = new JMenuItem("Create Army One");
        JMenuItem size01 = new JMenuItem("Create Army Two");

        size00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //infoWarBox("War","Choose an Army");
        }});

        size01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //infoWarBox();
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
        BufferedImage myPicture = ImageIO.read(new File(("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Images\\portal.png")));
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
        button501.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(WOODEN_CABINE.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{WOODEN_CABINE.toString()});
        });
        JLabel label502 = new JLabel(HOUSE.toString()+ ": " + HOUSE.getCost()+ " coins.");
        JButton button502 = new JButton("Buy this property");
        button502.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(HOUSE.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{HOUSE.toString()});
        });
        JLabel label503 = new JLabel(VILLA.toString()+ ": " + VILLA.getCost()+ " coins.");
        JButton button503 = new JButton("Buy this property");
        button503.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(VILLA.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{VILLA.toString()});
        });
        JLabel label504 = new JLabel(APARTMENT.toString()+ ": " + APARTMENT.getCost()+ " coins.");
        JButton button504 = new JButton("Buy this property");
        button504.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(APARTMENT.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{APARTMENT.toString()});
        });
        JLabel label505 = new JLabel(MANSION.toString()+ ": " + MANSION.getCost()+ " coins.");
        JButton button505 = new JButton("Buy this property");
        button505.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(MANSION.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{MANSION.toString()});
        });
        JLabel label506 = new JLabel(CASTLE.toString()+ ": " + CASTLE.getCost()+ " coins.");
        JButton button506 = new JButton("Buy this property");
        button506.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(CASTLE.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{CASTLE.toString()});
        });
        JLabel label507 = new JLabel(PALACE.toString()+ ": " + PALACE.getCost()+ " coins.");
        JButton button507 = new JButton("Buy this property");
        button507.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(PALACE.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{PALACE.toString()});
        });
        JLabel label508 = new JLabel(WAREHOUSE.toString()+ ": " + WAREHOUSE.getCost()+ " coins.");
        JButton button508 = new JButton("Buy this property");
        button508.addActionListener(e ->{
            String[] listChar = ExportCharacterList.exportCharacterList();
            String boss = listChar[0];
            String answer = importMoneyStatsSubtract(Integer.parseInt(WAREHOUSE.getCost()), boss);
            buyIfEnoughFunds(boss, answer, new String[]{WAREHOUSE.toString()});
        });

        panel05.add(label501);
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
        JPanel panel06 = new JPanel(false);
        tabbedPane.addTab("War", null, panel06, "Tab 5 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);

        JButton button60 = new JButton("Battle");
        button60.addActionListener(e ->{
            String output = "";
            console60.append("Battle started!\n");
            String dumpArmy = armyOne.toString();
            console60.append(dumpArmy);

        });
        JLabel label5501 = new JLabel("First Army");
        JLabel label5502 = new JLabel("Second Army");

        console60 = new JTextArea(10, 25);
        console62 = new JScrollPane(console60);

        panel06.setLayout(new BorderLayout());
        panel06.add(label5501, BorderLayout.LINE_START);
        panel06.add(label5502, BorderLayout.LINE_END);

        panel06.add(button60, BorderLayout.SOUTH);
        panel06.add(console62, BorderLayout.CENTER);

        // sixth panel
        JPanel panel07 = new JPanel(false);
        tabbedPane.addTab("Army Layout", null, panel07, "Tab 5 tooltip");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
        panel07.setLayout(new GridLayout(0,6));

        button1007 = new JButton();
        button1007.setText("Save Army One");
        button1007.addActionListener(e ->{
            Character[] soldiers01 = new Character[1];
            //general 1
            Character character101 = getCharacterFromButton(comboBox1);
            //add to first Army
            soldiers01[0] = character101;
            armyOne = new Army(soldiers01);

        });

        button2007 = new JButton();
        button2007.setText("Save Army Two");
        button2007.addActionListener(e ->{
            Character[] soldiers02 = new Character[1];
            //general 2
            Character character201 = getCharacterFromButton(comboBox2);
            armyTwo = new Army(soldiers02);
        });
        //eerste lijn
        final JLabel label1 = new JLabel();
        final JLabel label222 = new JLabel();
        final JLabel label223 = new JLabel();
        final JLabel label224 = new JLabel();
        final JLabel label225 = new JLabel();
        label1.setText("1* General");
        panel07.add(label1);
        panel07.add(label222);
        panel07.add(label223);
        panel07.add(label224);
        panel07.add(label225);
        final JLabel label2 = new JLabel();
        label2.setText("2* General");
        panel07.add(label2);
        //tweede lijn
        comboBox1 = new JComboBox(ExportCharacterList.exportCharacterList());;
        panel07.add(comboBox1);
        comboBox9999  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox9999);
        final JLabel label227 = new JLabel();
        label227.setText("Army 1 Name");
        panel07.add(label227);
        final JLabel label230 = new JLabel();
        label230.setText("Army 2 Name");
        panel07.add(label230);
        comboBox8888  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox8888);
        comboBox2  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox2);
        //derde lijn
        final JLabel label3 = new JLabel();
        label3.setText("1* Team");
        panel07.add(label3);
        final JLabel label228 = new JLabel();
        panel07.add(label228);
        textField1 = new JTextField();
        panel07.add(textField1);
        textField2 = new JTextField();
        panel07.add(textField2 );
        final JLabel label229 = new JLabel();
        panel07.add(label229);
        final JLabel label4 = new JLabel();
        label4.setText("2* Team");
        panel07.add(label4);
        //vierde lijn
        comboBox3 = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox3);
        comboBox4  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox4);
        panel07.add(button1007 );
        panel07.add(button2007 );
        comboBox5  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox5);
        comboBox6 = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox6);
        //vijfde lijn;
        comboBox7  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox7);
        comboBox8  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox8);
        final JLabel label232 = new JLabel();
        panel07.add(label232);
        final JLabel label233 = new JLabel();
        panel07.add(label233);
        comboBox9  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox9);
        comboBox10  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox10);
        //zesde lijn
        comboBox11  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox11); 
        comboBox12  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox12);
        final JLabel label234 = new JLabel();
        panel07.add(label234);
        final JLabel label235 = new JLabel();
        panel07.add(label235);
        comboBox13  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox13); 
        comboBox14  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox14);
        //zevende lijn
        comboBox15 = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox15); 
        comboBox16  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox16);
        final JLabel label236 = new JLabel();
        panel07.add(label236);
        final JLabel label237 = new JLabel();
        panel07.add(label237);
        comboBox17  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox17 );
        comboBox18  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox18);
        //8e lijn
        comboBox19  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox19); 
        comboBox20  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox20);
        final JLabel label238 = new JLabel();
        panel07.add(label238);
        final JLabel label239 = new JLabel();
        panel07.add(label239);
        comboBox21  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox21);
        comboBox22 = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox22);
        //9e lijn
        comboBox23  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox23);
        comboBox24  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox24 );
        final JLabel label240 = new JLabel();
        panel07.add(label240);
        final JLabel label241 = new JLabel();
        panel07.add(label241);
        comboBox25 = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox25 ); 
        comboBox26  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox26 );
        //10e lijn
        comboBox27  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox27 );
        comboBox28  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox28 );
        final JLabel label242 = new JLabel();
        panel07.add(label242);
        final JLabel label243 = new JLabel();
        panel07.add(label243);
        comboBox29  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox29 );
        comboBox30 = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox30 );
        //11e lijn
        comboBox31  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox31 );
        comboBox32  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox32 );
        final JLabel label244 = new JLabel();
        panel07.add(label244);
        final JLabel label245 = new JLabel();
        panel07.add(label245);
        comboBox33  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox33 );
        comboBox34  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox34 );
        //12e lijn
        comboBox35  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox35  );
        comboBox36  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox36 );
        final JLabel label246 = new JLabel();
        panel07.add(label246);
        final JLabel label247 = new JLabel();
        panel07.add(label247);
        comboBox37 = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox37  );
        comboBox38  = new JComboBox(ExportCharacterList.exportCharacterList());
        panel07.add(comboBox38 );
        //13e lijn
        final JLabel label5 = new JLabel();
        label5.setText("1* Troops");
        panel07.add(label5 );
        final JLabel label6 = new JLabel();
        label6.setText("1* Weapons");
        panel07.add(label6 );
        final JLabel label248 = new JLabel();
        label248.setText("1* # troops");
        panel07.add(label248);
        final JLabel label249 = new JLabel();
        panel07.add(label249);
        label249.setText("2* # troops");
        final JLabel label7 = new JLabel();
        label7.setText("2* Weapons");
        panel07.add(label7 );
        final JLabel label8 = new JLabel();
        label8.setText("2* Troops");
        panel07.add(label8);
        //14e lijn
        comboBox39 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox39  );
        comboBox40  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox40  );
        textField3 = new JTextField();
        panel07.add(textField3 );
        textField4 = new JTextField();
        panel07.add(textField4);
        comboBox41  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox41  );
        comboBox42 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox42 );
        //15e lijn
        comboBox43 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox43  );
        comboBox44 = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox44  );
        textField5 = new JTextField();
        panel07.add(textField5 );
        textField6 = new JTextField();
        panel07.add(textField6 );
        comboBox45  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox45 );
        comboBox46 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox46  );
        //16e lijn
        comboBox47  = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox47  );
        comboBox48  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox48  );
        textField7 = new JTextField();
        panel07.add(textField7 );
        textField8 = new JTextField();
        panel07.add(textField8 );
        comboBox49  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox49  );
        comboBox50 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox50  );
        //17e lijn
        comboBox51 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox51 );
        comboBox52  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox52  );
        textField9 = new JTextField();
        panel07.add(textField9);
        textField10 = new JTextField();
        panel07.add(textField10 );
        comboBox53 = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox53  );
        comboBox54 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox54 );
        //18e lijn
        comboBox55 = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox55 );
        comboBox56  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox56  );
        textField11 = new JTextField();
        panel07.add(textField11  );
        textField12 = new JTextField();
        panel07.add(textField12  );
        comboBox57  = new JComboBox(WeaponEnum.values());
        panel07.add(comboBox57  );
        comboBox58  = new JComboBox(CharacterClasses.values());
        panel07.add(comboBox58  );

        // seventh panel
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

    private static Character getCharacterFromButton(JComboBox comboBox1) {
        try{
        String characterFirst  = String.valueOf(comboBox1.getItemAt(comboBox1.getSelectedIndex()));
        String upperCaseCharacter = (String)exportCharacterStats(characterFirst)[1];
        String constructorClassCharacter = CasingMethods.toTitleCaseOneWord(upperCaseCharacter);
        //maak constructor aan met behulp van de 2 geselecteerde namen
        Character characterOne = StringToConstructorSwitch.constructorClass(constructorClassCharacter, characterFirst);
        return characterOne;
        }catch (Exception e){
            return null;
        }
    }

    private static void buyIfEnoughFunds(String boss, String answer, String[] strings) {
        if (answer.equals("Positive")){
            ExportData.storeData(strings, boss, RVS);
            JOptionPane.showMessageDialog(null, "You have bought this property");
        } else {
            JOptionPane.showMessageDialog(null, "You don't have enough money");
        }
    }

    public static void systemPrint() {
        System.out.println("Hello game");
    }

}
