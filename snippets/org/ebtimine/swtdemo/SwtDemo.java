/*
 * Created on Dec 29, 2003
 * $Id: SwtDemo.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */

package org.ebtimine.swtdemo;

import org.ebtimine.swtdemo.actions.ExitAction;
import org.ebtimine.swtdemo.actions.LaunchAction;
import org.ebtimine.swtdemo.listeners.DemoTreeListener;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


/**
 * @author mojo_jojo
 *
 * Demo of SWT capabilities.
 */

public class SwtDemo extends ApplicationWindow
{
	
	private DemoFactory factory;
	
	private Tree demoTree;
	
	private Label demoDescription;
	
	private MenuManager rootMenu;
	
	public SwtDemo()
	{
		super(null);
		addMenuBar();
		addStatusLine();
		
		// Creates the demo factory.
		factory = DemoFactory.getDemoFactory();
		
	}

	public Control createContents(Composite father)
	{
		getShell().setText("SwtDemo --- A eye candy of swt");
		
		SashForm mainControl = new SashForm(father, SWT.HORIZONTAL);
		
		String[] demos = factory.getDemoSummary();
		
		Group treeGroup = new Group(mainControl, SWT.NONE);
		treeGroup.setText("Demo tree");
		
		demoTree = new Tree(treeGroup, SWT.BORDER);
		demoTree.setSize(360, 460);
		
		for(int i=0; i < demos.length; i++) {
			TreeItem item = new TreeItem(demoTree, 0);
			item.setText(demos[i]);
		}
		
		demoTree.addSelectionListener(new DemoTreeListener(this));
		demoTree.deselectAll();
		
		Group descriptionGroup = new Group(mainControl, SWT.NONE);
		descriptionGroup.setSize(400, 600);
		descriptionGroup.setText("Description");
		
		demoDescription = new Label(descriptionGroup, SWT.NONE);
		
		getShell().setSize(800, 600);
		
		return mainControl;
	}
	
	public MenuManager createMenuManager()
	{
		rootMenu = new MenuManager("");
		
		MenuManager fileMenu = new MenuManager("&File");
		fileMenu.add(new LaunchAction(this));
		fileMenu.add(new ExitAction(this));
		rootMenu.add(fileMenu);
		
		return rootMenu;
	}
	
	public void runDemo()
	{
		if(demoTree.getSelectionCount() > 1)
		{
			getStatusLineManager().setErrorMessage("You can launch only one demo at a time");
		} else {
			factory.runDemo(demoTree.getSelection()[0].getText());
		}
	}
	
	public void runDemo(String demo)
	{
		factory.runDemo(demo);
	}

	public static void main(String[] args) 
	{
		SwtDemo demo = new SwtDemo();
		demo.setBlockOnOpen(true);
		demo.open();
	}
}