import acm.program.*;
import java.awt.event.*;
import acm.graphics.*;
import javax.swing.*;
import java.util.*;
import javax.swing.*;


class BoxDiagram extends GraphicsProgram {
    private HashMap<String, GObject> objectMap = new HashMap<String, GObject>();
    private JTextField nameField;
    private JButton addButton = new JButton("Add");
    private JButton removeButton = new JButton("Remove");
    private JButton clearButton = new JButton("Clear");
    private GObject currentObj;
    private GPoint last;
    
    private static final int MAX_WORDS = 20;
    private static final double BOX_WIDTH = 120;
    private static final double BOX_HEIGHT = 50;
    
    public void init() {
    	addSwingComponents();
    	
    	
    }
    
    public void run() {
    	
    }
    
    private void addSwingComponents() {
    	nameField = new JTextField(MAX_WORDS);
    	add(new JLabel("Name"), SOUTH);
    	add(nameField, SOUTH);
    	nameField.addActionListener(this);
    	add(addButton, SOUTH);
    	add(removeButton, SOUTH);
    	add(clearButton, SOUTH);
    }
	
}
