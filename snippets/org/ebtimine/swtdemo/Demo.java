/*
 * Created on Dec 30, 2003
 * $Id: Demo.java,v 1.1 2004/01/18 13:12:18 mojo_jojo Exp $
 */
 
package org.ebtimine.swtdemo;

/**
 * @author mojo_jojo
 *
 * Demo framework : this interface sumarizes the methods that an swt demo has 
 * to possess. 
 */
public abstract class Demo implements Runnable
{
	protected static Demo demo;
	
	public static Demo getDemo()
	{
		return demo;
	}
	
	public abstract String getName();
	
	public abstract String getImage();
	
	public abstract String getText();
	
	public abstract String getSource();
}
