/*
 * Created on Dec 30, 2003
 * $Id: CTabFolderDemo.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */
 
package org.ebtimine.swtdemo.swt;

import org.ebtimine.swtdemo.Demo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolderAdapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author mojo_jojo
 *
 * Demo of the CTabFolder capabilities.
 */
public class CTabFolderDemo extends Demo
{
	/**
	 * Demo shell used to present the CTabFolder.
	 */
	private Shell demoShell;
	
	/**
	 * Shell used to prompt the source of the CTabFolder demo.
	 */
	private Shell srcShell;
	
	private CTabFolderDemo()
	{
		demo = this;
	}
	
	/**
	 * Returns a Demo object that will run the demo of CTabFolder capabilities. 
	 * @see org.ebtimine.swtdemo.Demo#getDemo()
	 */
	public static Demo getDemo()
	{
		if(demo == null) {
			return  (Demo) new CTabFolderDemo();
		} else {
			return demo;
		}
	}

	/**
	 * Return filename of the screenshot
	 * of the component this Demo reprensents. 
	 * The file is supposed to be stored in the images folder.
	 * @see org.ebtimine.swtdemo.Demo#getImage()
	 */
	public String getImage()
	{
		return new StringBuffer("CTabFolder.png").toString();
	}

	/**
	 * Return the name of the current Demo.
	 * This name will be prompted in the demo tree.
	 * @see org.ebtimine.swtdemo.Demo#getName()
	 */
	public String getName()
	{
		return new StringBuffer("CTabFolder").toString();
	}

	/**
	 * Return the name of the source used for the current Demo. 
	 * Pretty much the text of the run method.
	 * The file is supposed to be stored in the src folder.
	 * @see org.ebtimine.swtdemo.Demo#getSource()
	 */
	public String getSource()
	{
		return new StringBuffer("CTabFolder.txt").toString();
	}

	/**
	 * Returns the text that needs to be prompted for this demo.
	 * This text will be prompted on top of the screenshot.
	 * @see org.ebtimine.swtdemo.Demo#getText()
	 */
	public String getText()
	{
		return new StringBuffer("Displays tabs like in the eclipse ide.").toString();
	}

	/**
	 * Runs the demo associated with CTabFolder. 
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		if(demoShell == null || demoShell.isDisposed()) {
			Display display = Display.getCurrent();
			demoShell = new Shell(display);
			demoShell.setText("-- CTabFolder --");
			demoShell.setLayout(new FillLayout());
			CTabFolder folder = new CTabFolder(demoShell, SWT.NONE);
			for (int i = 0; i < 4; i++) {
				CTabItem item = new CTabItem(folder, SWT.NONE);
				item.setText("Item "+i);
				Text text = new Text(folder, SWT.BORDER | SWT.MULTI);
				text.setText("Content for Item "+i);
				item.setControl(text);
			}
        
			final CTabItem specialItem = new CTabItem(folder, SWT.NONE);
			specialItem.setText("Don't Close Me");
			Text text = new Text(folder, SWT.BORDER | SWT.MULTI);
			text.setText("This tab can never be closed");
			specialItem.setControl(text);
                
			folder.addCTabFolderListener(new CTabFolderAdapter() {
				public void itemClosed(CTabFolderEvent event) {
					if (event.item.equals(specialItem)) {
						event.doit = false;
					}
				}
			});
			demoShell.setSize(400, 400);
			demoShell.open();
		} else {
			demoShell.setFocus();
		}
	}
}
