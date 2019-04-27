/**
 *
 */
package com.test.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author aubrey
 * @date  上午11:43:47
 * 
 */
public class TestListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("==========contextInitialized============");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("==========contextDestroyed============");
		
	}

}
