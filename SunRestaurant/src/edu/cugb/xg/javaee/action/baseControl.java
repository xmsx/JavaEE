package edu.cugb.xg.javaee.action;

import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;

public abstract class baseControl extends HttpServlet {
	/**
	 * ��־����
	 */
	protected Logger logger = Logger.getLogger(getClass());
}
