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
    
    private JLabel memSizeLabel = new JLabel("Size:");
    private JTextField memSizeInput = new JTextField();
    
    private JLabel algoLabel = new JLabel("Algorithms:");
    private static String[] algorithms = {"1. First Fit", "2. Best Fit", "3. Worst Fit"};
    private JComboBox memoryAlgos = new JComboBox(algorithms);
    
    private String algoSelected = "1. First Fit";
    
    private int sizeOfProcess = 64;
    private int processSize = 7;
    
    private JLabel pidLabel = new JLabel("PID #:");
    private int pid = 0;
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
    
    private JButton test = new JButton("test");
    private JButton addMemoryBlock = new JButton("Add Memory Block");
    private JButton removeMemoryBlock = new JButton("Remove Memory Block");
    
    private JButton compactMemory = new JButton("Compact Memory");
    
    public Components(){
        setLayout(null);
        setSize(WIDTH,HEIGHT);
        setBackground(cherryBlossom);
        
        addPIDLabel();
        addPIDList();
        
        addMemSizeLabel();
        addMemSizeInput();
        
        addAlgorithmLabel();
        addMemoryAlgorithmsList();
        
        
        MemoryContainer containsMemory = new MemoryContainer();
        add(containsMemory);
        
        addTestButton();
        addMemoryAddButton();
        addMemoryRemoveButton();
        addCompactMemoryButton();
        
        setVisible(true);
        repaint();
    }
    
    public void addMemoryAddButton(){
        addMemoryBlock.setBounds(60, 300, 170, 35);
        addMemoryBlock.setFont(font1);
        addMemoryBlock.setVisible(true);
        add(addMemoryBlock);
    }
    
    public void addMemoryRemoveButton(){
        removeMemoryBlock.setBounds(60, 350, 170, 35);
        removeMemoryBlock.setFont(font1);
        removeMemoryBlock.setVisible(true);
        add(removeMemoryBlock);
    }
    
    public void addCompactMemoryButton(){
        compactMemory.setBounds(60, 400, 170, 35);
        compactMemory.setFont(font1);
        compactMemory.setVisible(true);
        add(compactMemory);
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
        algoLabel.setBounds(5, 20, 90, 30);
        algoLabel.setFont(font1);
        algoLabel.setVisible(true);
        add(algoLabel);
    }
    
    public void addMemoryAlgorithmsList(){
        memoryAlgos.setEditable(false);
        memoryAlgos.setFont(font1);
        memoryAlgos.setBounds(80, 20, 125, 30);
        memoryAlgos.setVisible(true);
        add(memoryAlgos);
    }
    
    public void addPIDLabel(){
        pidLabel.setBounds(42, 100, 70, 30);
        pidLabel.setFont(font1);
        pidLabel.setVisible(true);
        add(pidLabel);
    }
    
    public void addPIDList(){
        pidList.setEditable(false);
        pidList.setBounds(80, 100, 125, 30);
        pidList.setFont(font1);
        pidList.setVisible(true);
        add(pidList);
    }
    
    public void addMemSizeLabel(){
        memSizeLabel.setBounds(47, 150, 70, 30);
        memSizeLabel.setFont(font1);
        memSizeLabel.setVisible(true);
        add(memSizeLabel);
    }
    
    public void addMemSizeInput(){
        memSizeInput.setBounds(80, 150, 70, 30);
        memSizeInput.setFont(font1);
        memSizeInput.setVisible(true);
        add(memSizeInput);
    }
    
    public class MemoryContainer extends Canvas {
        private int x = 60, y = 50;
        private int numOfProcessesInContainer = 0;
        
        private int heightOfContainer = 400;
        private int widthOfContainer = 182;
        
        private int heightOfBlock = 0;
        private int widthOfBlock = 182;
        
        private int previousHeight;
        
        public MemoryContainer(){
            super();
            this.setBounds(240, 0, 260, 570);
            this.setBackground(honeyDew);
        }
        
        @Override
        public void paint(Graphics g){
            drawMemoryContainer(g);
            drawMinimumSize(g);
            drawMaximumSize(g);
            if(processAdded){
                drawMemoryBlock(g);
            }
        }
        
        public void drawMemoryContainer(Graphics g){
            // x = 60 | y = 50 | width = 182 | height = 400
            g.drawRect(x, y, widthOfContainer, heightOfContainer);
        }
        
        public void drawMinimumSize(Graphics g){
            g.drawString("0KB", 20, 57);
        }  
        
        public void drawMaximumSize(Graphics g){
            g.drawString("8192KB",5, 455);
        }
        
        public void drawMemoryBlock(Graphics g){
                heightOfBlock = heightOfContainer / processSize;
                this.previousHeight = y + heightOfBlock;
                g.fillRect(x, y, widthOfBlock, heightOfBlock);
                numOfProcessesInContainer++;    
                System.out.println(numOfProcessesInContainer);
        }
    }
}