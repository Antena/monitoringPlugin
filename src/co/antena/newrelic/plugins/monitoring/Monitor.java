package co.antena.newrelic.plugins.monitoring;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import com.newrelic.metrics.publish.Agent;
import com.newrelic.metrics.publish.binding.Context;

public class Monitor extends Agent {

	private String name = "Default";
	private String url = "http://www.google.com/";
	private String method = "GET";
	private int connectiontimeout = 1000;
	private int readtimeout = 10000;
	
    public Monitor(String name, String url, String method, int connectiontimeout, int readtimeout ) {
    	super("co.antena.newrelic.plugins.monitoring", "1.0.1");

    	this.name = (name != null && !name.isEmpty()) ? name:this.name;
    	this.url = (url != null && !url.isEmpty()) ? url:this.url;
    	this.method = (method != null && !method.isEmpty()) ? method:this.method;
    	this.connectiontimeout = (connectiontimeout == 0) ? connectiontimeout: this.connectiontimeout;
    	this.readtimeout = (readtimeout == 0) ? readtimeout: this.readtimeout;
    	    	
    }
    
	@Override
	public String getComponentHumanLabel() {
		return name;
	}
	
	@Override
	public void pollCycle() {
		reportMetric("Monitor/Alive", "value", isAlive());
	}

	private Integer isAlive() {
	
		try {
		
			HttpURLConnection connection = (HttpURLConnection) new URL(this.url).openConnection();
			connection.setReadTimeout(this.readtimeout);
			connection.setConnectTimeout(this.connectiontimeout);
			connection.setRequestMethod(this.method);
			int responseCode = connection.getResponseCode();
			return (200 <= responseCode && responseCode <= 399) ? 1 : 0;
					
		} catch (MalformedURLException e) {
			Context.getLogger().log(Level.SEVERE,"Malformed url while checking service : " + this.url, e);
			return 0;
		} catch (IOException e) {
			Context.getLogger().log(Level.WARNING,"IO Exception while checking service : " + this.url, e);
			return 0;
		}		

	}
	

	
}

