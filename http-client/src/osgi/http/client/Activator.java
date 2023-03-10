package osgi.http.client;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        context.registerService(
            HttpClient.class.getName(), new HttpClientImpl(), props);
		System.out.println("Http client service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
    	System.out.println("Http client service unregistered successfully");	
    }
}