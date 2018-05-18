package art.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.geom.Ellipse2D;

import java.util.Hashtable;

import javax.swing.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import art.controller.*;

public class artPanel extends JPanel
{
	private final int MINIMUM_EDGE = 5;
	private final int MAXIMUM_EDGE = 20;
	private final int MINIMUM_SCALE = 20;
	private final int MAXIMUM_SCALE = 100;
	
	private SpringLayout appLayout;
	
	private ShapeCanvas canvas;
	
	private JPanel buttonPanel;
	private JPanel sliderPanel;
	
	private JSlider scaleSlider;
	private JSlider edgeSlider;
	
	private JButton triangleButton;
	private JButton rectangleButton;
	private JButton ellipseButton;
	private JButton polygonButton;
	private JButton clearButton;
	private JButton saveButton;
	private JButton colorButton;
	
	private int currentEdgeCount;
	private int currentScale;
	
	private artController app;
	
	public artPanel(artController app) 
	{
		super();
		this.app = app;
		appLayout = new SpringLayout();
		
		currentScale = MINIMUM_SCALE;
		currentEdgeCount = MINIMUM_EDGE;
		scaleSlider = new JSlider(MINIMUM_SCALE, MAXIMUM_SCALE);
		edgeSlider = new JSlider(MINIMUM_EDGE,MAXIMUM_EDGE);
		
		canvas = new ShapeCanvas(app);
		sliderPanel = new JPanel();
		buttonPanel = new JPanel(new GridLayout(0,1));
		
		triangleButton = new JButton("Add Triangle");
		rectangleButton = new JButton("Add rectangle");
		ellipseButton = new JButton("Add ellipse");
		polygonButton = new JButton("Add polygon");
		clearButton = new JButton("Clear image");
		saveButton = new JButton("Save image");
		colorButton = new JButton("Change color");
		
		setupSlider();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupSlider() 
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		Hashtable<Integer, JLabel> edgeLabels = new Hashtable<Integer, JLabel>();
		
		scaleLabels.put(MINIMUM_SCALE, new JLabel("<HTML>Small<BR>Shape</HTML>"));
		scaleLabels.put((MAXIMUM_SCALE + MINIMUM_SCALE)/2, new JLabel("<HTML>MEDIUM<BR>SHAPE</HTML>"));
		scaleLabels.put(MAXIMUM_SCALE, new JLabel("<HTML>Large<BR>Shape</HTML>"));
		edgeLabels.put(MINIMUM_EDGE, new JLabel("EDges: " + MINIMUM_EDGE));
		edgeLabels.put(MAXIMUM_EDGE, new JLabel("Edges: " + MAXIMUM_EDGE));
		
		scaleSlider.setLabelTable(scaleLabels);
		scaleSlider.setOrientation(JSlider.VERTICAL);
		scaleSlider.setSnapToTicks(true);
		scaleSlider.setMajorTickSpacing(10);
		scaleSlider.setPaintTicks(true);
		scaleSlider.setPaintLabels(true);
		
		edgeSlider.setLabelTable(edgeLabels);
		edgeSlider.setOrientation(JSlider.VERTICAL);
		edgeSlider.setSnapToTicks(true);
		edgeSlider.setMajorTickSpacing(3);
		edgeSlider.setMinorTickSpacing(1);
		edgeSlider.setPaintTicks(true);
		edgeSlider.setPaintLabels(true);
		
	}
	private void setupPanel() 
	{
		this.setLayout(appLayout);
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(1024, 768));
		this.add(canvas);
		
		buttonPanel.setPreferredSize(new Dimension(200, 450));
		buttonPanel.add(triangleButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(ellipseButton);
		buttonPanel.add(polygonButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(colorButton);
		
		sliderPanel.setPreferredSize(new Dimension(250, 450));
		sliderPanel.add(scaleSlider);
		sliderPanel.add(edgeSlider);
		
		this.add(buttonPanel);
		this.add(sliderPanel);
	}
	private void setupLayout() 
	{
		
	}
	private void setupListeners()
	{
		
	}
	private boolean coinFlip() {
		return (int)(Math.random() * 2) == 0;
	}
	private Polygon createPolygon(int sides) {
		Polygon currentShape = new Polygon();
		int originX = (int)(Math.random() * 600);
		int originY = (int)(Math.random() * 600);
		for(int index = 0; index < sides; index++) {
			int minus = coinFlip() ? - 1 : 1;
			int shiftX = (int) (Math.random() * currentScale) * minus;
			minus = coinFlip() ? - 1 : 1;
			int shiftY = (int) (Math.random() * currentScale) * minus;
			currentShape.addPoint(originX+shiftX,originY + shiftY);
		}
		return currentShape;
	}
	private Rectangle createRectangle() 
	{
		Rectangle currentShape = new Rectangle();
		return currentShape;
	}
}

}
