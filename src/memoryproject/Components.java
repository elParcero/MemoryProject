package memoryproject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Components extends JPanel{
    private static final int WIDTH = 500, HEIGHT = 570;
    private Font font1 = new Font("SansSerif", Font.PLAIN, 13);
    private JLabel pidLabel = new JLabel("PID #:");
    private JTextField pidInput = new JTextField();
    private JLabel memSizeLabel = new JLabel("Size:");
    private JTextField memSizeInput = new JTextField();
    
    private JLabel algoLabel = new JLabel("Algorithms:");
    private static String[] algorithms = {"1. First Fit", "2. Best Fit", "3. Worst Fit"};
    private JComboBox memoryAlgos = new JComboBox(algorithms);
    
    private String algoSelected = "1. First Fit";
    private int pid = 0;
    private int sizeOfProcess = 64;
    
    private String[] pids = {"Process 1",
                             "Process 2",
                             "Process 3",
                             "Process 4",
                             "Process 5",
                             "Process 6",
                             "Process 7",
                             "Process 8",
                             "Process 9",
                             "Process 10",
                             "Process 11"};
    private JComboBox pidList = new JComboBox(pids);
    
    private Color honeyDew = new Color(240, 255, 240);
    private Color cherryBlossom = new Color(255, 221, 228);
    
    private boolean processAdded = false;
    private int processSize = 7;
    
    JButton test = new JButton("test");
    
    
    public Components(){
        setLayout(null);
        setSize(WIDTH,HEIGHT);
        setBackground(cherryBlossom);
        
        addPIDLabel();
        //addPIDTextBox();
        addPIDList();
        
        addMemSizeLabel();
        addMemSizeInput();
        
        addAlgorithmLabel();
        addMemoryAlgorithms();
        
        
        
        MemoryContainer containsMemory = new MemoryContainer();
        add(containsMemory);
        
        addTestButton();
        
        setVisible(true);
        repaint();
    }
    
    public void addTestButton(){
        test.setBounds(10, 300, 50, 25);
        test.setVisible(true);
        add(test);
        test.addActionListener(new TestClicked());
    }
    
    public class TestClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("test")){
                processAdded = true;
                add(new MemoryContainer());
            }
        }
    
    }
    
    public void addAlgorithmLabel(){
        algoLabel.setBounds(15, 20, 90, 30);
        algoLabel.setFont(font1);
        algoLabel.setVisible(true);
        add(algoLabel);
    }
    
    public void addMemoryAlgorithms(){
        memoryAlgos.setEditable(false);
        memoryAlgos.setBounds(90, 20, 125, 30);
        memoryAlgos.setVisible(true);
        add(memoryAlgos);
    }
    
    public void addPIDLabel(){
        pidLabel.setBounds(52, 100, 70, 30);
        pidLabel.setFont(font1);
        pidLabel.setVisible(true);
        add(pidLabel);
    }
    
    public void addPIDList(){
        pidList.setBounds(90, 100, 150, 30);
        pidList.setFont(font1);
        pidList.setVisible(true);
        add(pidList);
    }
    
    public void addPIDTextBox(){
        pidInput.setBounds(90,100, 70,30);
        pidInput.setFont(font1);
        pidInput.setVisible(true);
        add(pidInput);
    }
    
    public void addMemSizeLabel(){
        memSizeLabel.setBounds(57, 150, 70, 30);
        memSizeLabel.setFont(font1);
        memSizeLabel.setVisible(true);
        add(memSizeLabel);
    }
    
    public void addMemSizeInput(){
        memSizeInput.setBounds(90, 150, 70, 30);
        memSizeInput.setFont(font1);
        memSizeInput.setVisible(true);
        add(memSizeInput);
    }
    
    
    public class MemoryContainer extends Canvas {
        private int x = 50, y = 50;
        private int numOfProcessesInContainer = 0;
        
        private int heightOfContainer = 400;
        private int widthOfContainer = 182;
        
        private int heightOfBlock = 0;
        private int widthOfBlock = 182;
        
        private int previousHeight;
        
        public MemoryContainer(){
            super();
            this.setBounds(250, 0, 250, 570);
            this.setBackground(honeyDew);
        }
        
        @Override
        public void paint(Graphics g){
            drawMemoryContainer(g);
            drawMinimumSize(g);
            if(processAdded){
                drawMemoryBlock(g);
            }
        }
        
        public void drawMemoryContainer(Graphics g){
            g.drawRect(x, y, widthOfContainer, heightOfContainer);
        }
        
        public void drawMinimumSize(Graphics g){
            g.drawString("0KB", 20, 57);
        }  
        
        public void drawMemoryBlock(Graphics g){
                heightOfBlock = heightOfContainer / processSize;
                this.previousHeight = y + heightOfBlock;
                g.drawRect(x, y, widthOfBlock, heightOfBlock);
                numOfProcessesInContainer++;    
        }
    }
}