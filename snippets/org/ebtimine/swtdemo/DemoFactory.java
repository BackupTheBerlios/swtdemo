/*
 * Created on Dec 29, 2003
 * $Id: DemoFactory.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */
 
package org.ebtimine.swtdemo;

import org.ebtimine.swtdemo.swt.CTabFolderDemo;

/**
 * @author mojo_jojo
 *
 * This Demo factory returns demo objects that will actually run the examples.
 */
public class DemoFactory
{
	/**
	 * Reference to the DemoFactory singleton.
	 */
	static DemoFactory factory;
	
	/**
	 * Names of the different available demos are stored here.
	 */
	String[] summary = { "CTabFolder"};
	
	private DemoFactory()
	{
		factory = this;
	}
	
	public static DemoFactory getDemoFactory()
	{
		if( factory == null) {
			return new DemoFactory();
		} else {
			return factory;
		}
	}
	
	public String[] getDemoSummary()
	{
		return summary;
	}
	
	public void runDemo(String demoName)
	{
		if(demoName.equalsIgnoreCase("CTabFolder")) {
			Demo demo = CTabFolderDemo.getDemo();
			new Thread(demo).run();
		}
	}
}