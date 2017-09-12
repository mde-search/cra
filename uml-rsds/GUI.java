import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.*;
import java.util.StringTokenizer;

public class GUI extends JFrame implements ActionListener
{ JPanel panel = new JPanel();
  JPanel tPanel = new JPanel();
  JPanel cPanel = new JPanel();
  Controller cont = Controller.inst();
  JButton loadModelButton = new JButton("loadModel");
  JButton saveModelButton = new JButton("saveModel");
  JButton loadCSVButton = new JButton("loadCSVs");
  JButton saveCSVButton = new JButton("saveCSVs");
  JButton createClassesButton = new JButton("createClasses");
  JButton refactorButton = new JButton("refactor");
  JButton cleanupButton = new JButton("cleanup");
  JButton measuresButton = new JButton("measures");
  JButton preprocessButton = new JButton("preprocess");
  JButton evolveButton = new JButton("evolve");
  JButton nextgenerationButton = new JButton("nextgeneration");
  JButton initialiseButton = new JButton("initialise");
  JButton postprocessButton = new JButton("postprocess");
  JButton gaButton = new JButton("ga");
  JButton createClasses1Button = new JButton("createClasses1");

 public GUI()
  { super("Select use case to execute");
    panel.setLayout(new BorderLayout());
    panel.add(tPanel, BorderLayout.NORTH);
    panel.add(cPanel, BorderLayout.CENTER);
    setContentPane(panel);
    addWindowListener(new WindowAdapter() 
    { public void windowClosing(WindowEvent e)
      { System.exit(0); } });
  tPanel.add(loadModelButton);
  loadModelButton.addActionListener(this);
  tPanel.add(saveModelButton);
  saveModelButton.addActionListener(this);
  tPanel.add(loadCSVButton);
  loadCSVButton.addActionListener(this);
  tPanel.add(saveCSVButton);
  saveCSVButton.addActionListener(this);
  cPanel.add(createClassesButton);
  createClassesButton.addActionListener(this);
  cPanel.add(refactorButton);
  refactorButton.addActionListener(this);
  cPanel.add(cleanupButton);
  cleanupButton.addActionListener(this);
  cPanel.add(measuresButton);
  measuresButton.addActionListener(this);
  cPanel.add(preprocessButton);
  preprocessButton.addActionListener(this);
  cPanel.add(evolveButton);
  evolveButton.addActionListener(this);
  cPanel.add(nextgenerationButton);
  nextgenerationButton.addActionListener(this);
  cPanel.add(initialiseButton);
  initialiseButton.addActionListener(this);
  cPanel.add(postprocessButton);
  postprocessButton.addActionListener(this);
  cPanel.add(gaButton);
  gaButton.addActionListener(this);
  cPanel.add(createClasses1Button);
  createClasses1Button.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e)
  { if (e == null) { return; }
    String cmd = e.getActionCommand();
    if ("loadModel".equals(cmd))
    { Controller.loadModel("in.txt");
      cont.checkCompleteness();
      System.err.println("Model loaded");
      return; } 
    if ("saveModel".equals(cmd))
    { cont.saveModel("out.txt");  
      cont.saveXSI("xsi.txt"); 
      return; } 
    if ("loadCSVs".equals(cmd))
    { Controller.loadCSVModel();
      System.err.println("Model loaded");
      return; } 
    if ("saveCSVs".equals(cmd))
    { cont.saveCSVModel();  
      return; } 
    if ("createClasses".equals(cmd))
    {  cont.createClasses() ;  return; } 
    if ("refactor".equals(cmd))
    {  cont.refactor() ;  return; } 
    if ("cleanup".equals(cmd))
    {  cont.cleanup() ;  return; } 
    if ("measures".equals(cmd))
    {  cont.measures() ;  return; } 
    if ("preprocess".equals(cmd))
    {  cont.preprocess() ;  return; } 
    if ("evolve".equals(cmd))
    {  cont.evolve() ;  return; } 
    if ("nextgeneration".equals(cmd))
    {  cont.nextgeneration() ;  return; } 
    if ("initialise".equals(cmd))
    {  cont.initialise() ;  return; } 
    if ("postprocess".equals(cmd))
    {  cont.postprocess() ;  return; } 
    if ("ga".equals(cmd))
    { String _vals = JOptionPane.showInputDialog("Enter parameters iter :");
    Vector _values = new Vector();
    StringTokenizer _st = new StringTokenizer(_vals);
    while (_st.hasMoreTokens())
    { String _se = _st.nextToken().trim();
      _values.add(_se); 
    }

    int iter = Integer.parseInt((String) _values.get(0));
 cont.ga(iter) ;  return; } 
    if ("createClasses1".equals(cmd))
    {  cont.createClasses1() ;  return; } 
  }

  public static void main(String[] args)
  {  GUI gui = new GUI();
    gui.setSize(400,400);
    gui.setVisible(true);
  }
 }
