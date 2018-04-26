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

public class DrawingCanvas {

}












private SpringLayout appLayout;
private ShapeCanvas canvas;
private JPanel buttonPanel;
private JPanel sliderPanel;
private JSlider scaleSlider;
private  JSlider edgeSlider;
private JButton triangleButton;
private JButton rectangleButton;
private JButton ellipseButton;










super();
this.app = app;
appLayout = new SpringLayout();

currentScale = MINIMUM_SCALE
currentEdgeCount = MINIMUM_EDGE;
scaleSlider = new JSlider(MINIMUM_SCALE, MAXIMUM_SCALE);
edgeSlider = new JSlider(MINIMUM_EDGE, MAXIMUM_EDGE);

canvas = new ShapeCanvas



triangleButton = new JButton("add triangle");
rectangleButton = new JButton("add rectangle");
ellipseButton = new JButton("add ellipse");
polygonButon = new JButton("add polygon");
clearButton = new JButton("clear image");
saveButton = new JButton("save button");
