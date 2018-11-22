package memoryproject;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    
    private Color honeyDew = new Color(240, 255, 240);
    private Color cherryBlossom = new Color(255, 221, 228);
    
    public Components(){
        setLayout(null);
        setSize(WIDTH,HEIGHT);
        setBackground(cherryBlossom);
        
        addPIDLabel();
        addPIDTextBox();
        
        addMemSizeLabel();
        addMemSizeInput();
        
        addAlgorithmLabel();
        addMemoryAlgorithms();
        
        add(new MemoryContainer());
        setVisible(true);
        repaint();
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
        private int heightOfContainer = 350;
        public MemoryContainer(){
            super();
            this.setBounds(250, 0, 250, 570);
            this.setBackground(honeyDew);
        }
        
        @Override
        public void paint(Graphics g){
            drawContainer(g);
            drawMinimumSize(g);
        }
        
        public void drawContainer(Graphics g){
            g.drawRect(50, 50, 182, 400);
        }
        
        public void drawMinimumSize(Graphics g){
            g.drawString("0KB", 20, 57);
        }
    }
}