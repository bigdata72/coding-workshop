/**
 * Credit : https://refactoring.guru/design-patterns/flyweight/java/example
 *
 * Quoting from the author's website:
 *
 * In this example, we’re going to render a forest (1.000.000 trees)!
 * Each tree will be represented by its own object that has some state (coordinates, texture and so on).
 * Although the program does its primary job, naturally, it consumes a lot of RAM.
 *
 * The reason is simple: too many tree objects contain duplicate data (name, texture, color).
 * That’s why we can apply the Flyweight pattern and store these values inside separate flyweight objects (the TreeType class).
 * Now, instead of storing the same data in thousands of Tree objects, we’re going to reference one of the flyweight objects with a particular set of values.
 *
 * The client code isn’t going to notice anything since the complexity of reusing flyweight objects is buried inside a flyweight factory.
 *
 * TreeType.java: Contains state shared by several trees
 */

package org.code.workshop.dp.flyweight.trees;

import java.awt.*;

public class TreeType {
	private String name;
	private Color color;
	private String otherTreeData;
	
	public TreeType(String name, Color color, String otherTreeData) {
		this.name = name;
		this.color = color;
		this.otherTreeData = otherTreeData;
	}
	
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x - 1, y, 3, 5);
		g.setColor(color);
		g.fillOval(x - 5, y - 10, 10, 10);
	}
}
