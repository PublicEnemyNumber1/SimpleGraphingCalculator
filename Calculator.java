import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 * Write a description of class Graph here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculator
{
    private int diff;
    private double newVals[][];
    private JFrame frame;
    private JLabel label;
    private JPanel panel, panelCP;
    private JButton g1, g2, g3, g4, g5, zIn, zOut;
    private TextField t1, t2, t3, t4, t5;
    private double range = 40.0;
    private BufferedImage graph;
    private XYPoints q1, q2, q3, q4, q5;
    private JLabel graphC;
    private boolean graph1, graph2, graph3, graph4, graph5;
    /**
     * Constructor for objects of class Graph
     */
    public Calculator()
    {
        
        frame = new JFrame();
        createCalculator(range);
        createCP(range);
        frame.setVisible(true);
        frame.setSize(1200,1000);
        

    }
    
    public static void main(String[] args) {
    	Calculator newCalc = new Calculator();
    newCalc.createCalculator(100);
    }
    
    public void createCalculator(double range){
        t1 = new TextField();
        t1.setPreferredSize(new Dimension(200,24));
        t1.setText("Ex: x^3 + 0");
        t2 = new TextField();
        t2.setPreferredSize(new Dimension(200,24));
        t3 = new TextField();
        t2.setText("x^4 + 5x^3 + 10x^2 + 4x + 3");
        t3.setPreferredSize(new Dimension(200,24));
        t4 = new TextField();
        t4.setText("Ignore any errors, they don't mean anything");
        t4.setPreferredSize(new Dimension(200,24));
        t5 = new TextField();
        t5.setPreferredSize(new Dimension(200,24));
        t5.setText("Please clear these before trying");
        label = new JLabel();
        label.setText("Note: if you're gonna graph something like x^3 with no addition or subtraction signs, just slap on a little + 0 at the end, makes life a lot easier");
        g1 = new JButton("Graph");
        g1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) { createG1(t1.getText()); }
            });
        g2 = new JButton("Graph");
        g2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) { createG2(t2.getText()); }
            });
        g3 = new JButton("Graph");
        g3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) { createG3(t3.getText()); }
            });
        g4 = new JButton("Graph");
        g4.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) { createG4(t4.getText()); }
            });
        g5 = new JButton("Graph");
        g5.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) { createG5(t5.getText()); }
            });
            
        zIn = new JButton("Zoom In");
        zIn.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {zoomIn();}
            });
        
        zOut = new JButton("Zoom Out");
        zOut.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) {zoomOut();}
            });
        
        panel = new JPanel(new GridBagLayout());
        
        
        
        
        
        GridBagConstraints p = new GridBagConstraints();
        p.gridx = 40;
        p.gridy = -1;
        p.insets = new Insets(20,20,20,20);
        panel.add(zIn, p);
        
        p.gridx = 50;
        p.gridy = -1;
        p.insets = new Insets(20,20,20,20);
        panel.add(zOut,p);
        
        p.gridx = 50;
        p.gridy = 1;
        p.insets = new Insets(20,20,20,20);
        panel.add(g1,p);
        
        
        p.gridx = 50;
        p.gridy = 2;
        p.insets = new Insets(20,20,20,20);
        panel.add(g2, p);
        
        p.gridx = 50;
        p.gridy = 3;
        p.insets = new Insets(20,20,20,20);
        panel.add(g3,p);
                
        p.gridx = 50;
        p.gridy = 4;
        p.insets = new Insets(20,20,20,20);
        panel.add(g4,p);
        
          
        p.gridx = 50;
        p.gridy = 5;
        p.insets = new Insets(20,20,20,20);
        panel.add(g5,p);
        
        
        p.gridx = 0;
        p.gridy = 1;
        p.insets = new Insets(20,20,20,20);
        panel.add(t1,p);
        
        
        p.gridx = 0;
        p.gridy = 2;
        p.insets = new Insets(20,20,20,20);
        panel.add(t2, p);
        
        p.gridx = 0;
        p.gridy = 3;
        p.insets = new Insets(20,20,20,20);
        panel.add(t3,p);
                
        p.gridx = 0;
        p.gridy = 4;
        p.insets = new Insets(20,20,20,20);
        panel.add(t4,p);
        
          
        p.gridx = 0;
        p.gridy = 5;
        p.insets = new Insets(20,20,20,20);
        panel.add(t5,p);
        
      

        
        frame.add(panel, BorderLayout.EAST);
        //////////////////////////////////////////////////////////////////////////////////////////////
        
        

    }
    
    public void createCP(double range){
        graph = new BufferedImage(801,801,BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < 801; i++){
            for(int j = 0; j < 801; j++){
                Color c = Color.WHITE;
                int color = c.getRGB();
                graph.setRGB(i,j,color);
            }
            
        }
        
        int num1 = 400;
        
        

        
        int[] lineCoords = new int[(int) range*2];
        diff = (int) 800/(((int)range) * 2);
        for(int i = 1; i < ((int) range) * 2; i++){
            lineCoords[i - 1] = diff * i;
        }
        //sets range number of intervals
        for(int j = 0; j < lineCoords.length; j++){
            for(int i = 0; i < 800; i++){
                Color c = Color.lightGray;
                int color = c.getRGB();
                graph.setRGB(i, lineCoords[j], color);
                graph.setRGB(lineCoords[j], i, color);
            }
        }
        
        //sets the x,y axes
        for(int i = 0; i < 800; i++){
            Color c = Color.BLACK;
            int color = c.getRGB();
            graph.setRGB(i, num1, color);

            graph.setRGB(num1, i, color);

        }
        graphC = new JLabel(new ImageIcon(graph));
        
        panelCP = new JPanel();
        
        
        panelCP.add(graphC);
        
        
        frame.add(panelCP);
        
        frame.setVisible(true);
        
    }
    

    public void updateGraph(XYPoints xy){
        
        newVals = xy.getPoints();
        for(int i = 0; i < newVals.length; i++){
            newVals[i][0] = Math.round(newVals[i][0] * diff + 400);
            newVals[i][1] = Math.round(400 - newVals[i][1] * diff);
        }

        
        
        for(int i = 0; i < newVals.length; i++){
            if(newVals[i][1] > 800 || newVals[i][1] < 0){
                continue;
            }
            Color c = Color.black;
            int color = c.getRGB();
            graph.setRGB((int) newVals[i][0], (int) newVals[i][1], color);
        }
        graphC = new JLabel(new ImageIcon(graph));
         panelCP = new JPanel();
        panelCP.add(graphC);
        
        
        frame.add(panelCP);
        frame.setVisible(true);
        
    }
    
    //make it so that if there is no text in the boxes, nothing happens
    public void createG1(String eq){
        graph1 = false;
        Equation e1 = new Equation(eq);
        q1 = new XYPoints(e1, range);
        createCP(range);
        executeGraphs();
        updateGraph(q1);
        graph1 = true;
    }
    public void createG2(String eq){
        graph2 = false;
        Equation e2 = new Equation(eq);
        q2 = new XYPoints(e2, range);
        createCP(range);
        executeGraphs();
        updateGraph(q2);
        graph2 = true;
    }
    public void createG3(String eq){
        graph3 = false;
        Equation e3 = new Equation(eq);
        q3 = new XYPoints(e3, range);
        createCP(range);
        executeGraphs();
        updateGraph(q3);
        graph3 = true;
    }
    public void createG4(String eq){
        graph4 = false;
        Equation e4 = new Equation(eq);
        q4 = new XYPoints(e4, range);
        createCP(range);
        executeGraphs();
        updateGraph(q4);
        graph4 = true;
    }
    public void createG5(String eq){
        graph5 = false;
        Equation e5 = new Equation(eq);
        q5 = new XYPoints(e5, range);
        createCP(range);
        executeGraphs();
        updateGraph(q5);
        graph5 = true;
    }
    
    public double getRange(){
        
        return range;
        
    }
    
    public void zoomIn(){
        if(range >= 2){
                range = range / 2;
        }
        createCP(range);
        executeGraphs();
        
    }
    
    public void zoomOut(){
        if(range <= 100){
            range = range * 2;
        }
        createCP(range);
        executeGraphs();
    }
    
    public void executeGraphs(){
        if(graph1 == true){
            createG1(t1.getText());
        }
        if(graph2 == true){
            createG2(t2.getText());
        }
        if(graph3 == true){
            createG3(t3.getText());
        }
        if(graph4 == true){
            createG4(t4.getText());
        }
        if(graph5 == true){
            createG5(t5.getText());
        } 
        
        
        
        
    }
}
