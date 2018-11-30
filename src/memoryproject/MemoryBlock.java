package memoryproject;

import java.awt.Color;
import java.awt.Graphics;

public class MemoryBlock {
    private Color honeyDew = new Color(240, 255, 240);
    private int x = 0, y = 0, widthOfBlock = 0, heightOfBlock = 0, processSize = 0;
    private int heightOfLatestProcess = 0;
    
    public MemoryBlock(int x, int y, int widthOfBlock, int heightOfBlock, int processSize){
        this.x = x;
        this.y = y;
        this.widthOfBlock = widthOfBlock;
        this.heightOfBlock = heightOfBlock;
        this.processSize = processSize;
    }
    
    public int getY(){
        return y;
    }
    public int getHeightOfBlock(){
        return heightOfBlock;
    }
    
    public void drawFirstFit(Graphics g){
        heightOfLatestProcess = heightOfLatestProcess + heightOfBlock;
        System.out.println("draw first fit" + heightOfLatestProcess);
        System.out.println();
        
        g.setColor(honeyDew);
        g.fillRect(x+1, y+1, widthOfBlock-2, heightOfBlock);
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, widthOfBlock, heightOfBlock);
        
        g.drawString(String.valueOf(processSize) + "kb", x-50, y + heightOfBlock);  
    }
}
