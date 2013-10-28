package co.antena.newrelic.plugins.monitoring;

import java.util.Map;
import java.util.logging.Level;

import com.newrelic.metrics.publish.Agent;
import com.newrelic.metrics.publish.AgentFactory;
import com.newrelic.metrics.publish.binding.Context;

public class MonitorFactory extends AgentFactory {

	public MonitorFactory() {
		super("co.antena.newrelic.plugins.monitoring.json");
	}
	
	@Override
	public Agent createConfiguredAgent(Map<String, Object> properties) {
		String name = (String) properties.get("name");
		String url = (String) properties.get("url");
		String method = ( (String) properties.get("method") ).toUpperCase();
		int connectiontimeout = ((Long) properties.get("connectiontimeout")).intValue();
		int readtimeout = ((Long) properties.get("readtimeout")).intValue();
	
		Context.getLogger().log(Level.INFO,"== Agent created == ");
		Context.getLogger().log(Level.INFO,"  name : " +  name);
		Context.getLogger().log(Level.INFO,"  url : " +  url);
		Context.getLogger().log(Level.INFO,"  method : " +  method);
		Context.getLogger().log(Level.INFO,"  connectiontimeout : " +  connectiontimeout);
		Context.getLogger().log(Level.INFO,"  readtimeout : " +  readtimeout);
		
		
		
		return new Monitor(name, url, method, connectiontimeout, readtimeout);
	}
}
