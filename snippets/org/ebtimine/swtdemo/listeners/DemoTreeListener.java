/*
 * Created on Jan 4, 2004
 * $Id: DemoTreeListener.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */
 
package org.ebtimine.swtdemo.listeners;

import org.ebtimine.swtdemo.SwtDemo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

/**
 * @author mojo_jojo
 *
 * Listens to the tree, and updates the description group accordingly.
 */
public class DemoTreeListener implements SelectionListener
{
	private SwtDemo swtDemo;
	
	public DemoTreeListener(SwtDemo demo)
	{
		swtDemo = demo;
	}
	
	/**
	 * We just the update the description group to indicate the information relative to the 
	 * selected item.
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent selectionEvent)
	{
		// TODO : implement widgetSelected.
	}

	/**
	 * Not only updates the description groupd to indicate the information relative to 
	 * the selected item, but it launches the demo as well.
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent selectionEvent)
	{
		// TODO : implement widgetDefaultSelected.
	}

}
