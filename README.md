Antena New Relic Monitoring Plugin
==================================

Prerequisites
-------------

1. A New Relic account. Signup for a free account at http://newrelic.com
2. A configured Java Developer Kit (JDK) - version 1.6 or better
3. The Ant build tool - version 1.8 or better
4. Git
	
Installing the Antena New Relic Monitoring Plugin Agent
-------------------------------------------------------

1. Download the latest release tag from the https://github.com/Antena/monitoringPlugin/
2. Extract the archive to the location where you want to develop the plugin.

Building the Antena New Relic Monitoring Plugin 
-----------------------------------------------

1. From your shell run: `ant` to build the Anten New Relic Monitoring Plugin
2. A tar archive will be placed in the `dist` folder with the pattern `antena-monitoring-X.Y.Z.tar.gz`. The tar file will include a waveform jar and several configuration files. This is an example of a distributable file for a plugin.
3. Extract the tar file to a location where you want to run the plugin agent from.

Starting the Antena New Relic Monitoring Plugin 
-----------------------------------------------

1. Copy `config/template_newrelic.properties` to `config/newrelic.properties`
2. Edit `config/newrelic.properties` and replace `YOUR_LICENSE_KEY_HERE` with your New Relic license key
3. Edit `config/co.antena.newrelic.plugins.monitoring.json`. Follow the example and add all servers to monitor. 
4. From your shell run: `java -jar antena-monitoring-*.jar`
5. Look for error-free startup messages on stdout, such as "com.newrelic.metrics.publish.Runner setupAndRun" and "INFO: New Relic monitor started."
6. Wait a few minutes for New Relic to start processing the data sent from your agent.
7. Sign in to your New Relic account.
8. From the New Relic menu bar, look for the Monitorting plugin.
9. To view your plugin's summary page, click the plugin's name ("Monitoring").

Source Code
-----------

This plugin can be found at https://github.com/Antena/monitoringPlugin

