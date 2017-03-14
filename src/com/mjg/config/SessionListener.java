package com.mjg.config;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener {

	private final static Logger logger = Logger.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent event) {

		event.getSession().setMaxInactiveInterval(5 * 60);
		logger.info("Session created at " + new Date() + " for Session: " + event.getSession().getId());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("Session " + event.getSession().getId() + " destroyed at " + new Date());
	}
}
