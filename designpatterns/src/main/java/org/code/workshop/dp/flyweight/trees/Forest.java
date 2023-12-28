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
 * Forest.java: Forest, which we draw
 */

package org.code.workshop.dp.flyweight.trees;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
	private List<Tree> trees = new ArrayList<>();
	
	public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
		TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
		Tree tree = new Tree(x, y, type);
		trees.add(tree);
	}
	
	@Override
	public void paint(Graphics graphics) {
		for (Tree tree : trees) {
			tree.draw(graphics);
		}
	}
}
