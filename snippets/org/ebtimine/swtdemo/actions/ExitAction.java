/*
 * Created on Jan 4, 2004
 * $Id: ExitAction.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */
 
package org.ebtimine.swtdemo.actions;

import org.ebtimine.swtdemo.SwtDemo;
import org.eclipse.jface.action.Action;

/**
 * @author mojo_jojo
 *
 * Handles the click on File > Exit.
 */
public class ExitAction extends Action
{
	private SwtDemo swtDemo;
	
	public ExitAction(SwtDemo demo)
	{
		swtDemo = demo;
		setText("E&xit@Ctrl+Q");
		setToolTipText("Exit from SwtDemo");
	}
	
	public void run()
	{
		swtDemo.close();
	}
}
