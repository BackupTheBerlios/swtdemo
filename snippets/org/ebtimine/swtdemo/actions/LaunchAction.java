/*
 * Created on Jan 4, 2004
 * $Id: LaunchAction.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */
 
package org.ebtimine.swtdemo.actions;

import org.ebtimine.swtdemo.SwtDemo;
import org.eclipse.jface.action.Action;

/**
 * @author mojo_jojo
 *
 * Manages the launch of a demo from the menu of SwtDemo.
 */
public class LaunchAction extends Action
{
	/**
	 * Reference to the SwtDemo that created us.
	 */
	private SwtDemo demo;
	
	private StringBuffer toLaunch;
	
	public LaunchAction(SwtDemo swtDemo)
	{
		toLaunch=new StringBuffer("Not implemented yet");
		demo = swtDemo;
		setText("&Launch@Ctrl+L");
		// TODO: Automatically put the name of the action that will be launched as tooltip. 
		setToolTipText("Launch the "+toLaunch.toString() +" demo");
	}
	
	public void run()
	{
		// demo.runDemo(toLaunch.toString());
		demo.runDemo();
	}
}
