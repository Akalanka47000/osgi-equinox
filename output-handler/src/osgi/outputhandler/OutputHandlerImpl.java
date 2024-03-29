package osgi.outputhandler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import  osgi.strings.*;

public class OutputHandlerImpl implements OutputHandlerService{
	
	private StringManipulatorImpl stringManipulator;
	
	public OutputHandlerImpl(BundleContext context) throws Exception {
		ServiceTracker<?, ?> tracker;
		tracker = new ServiceTracker<StringManipulatorService, StringManipulatorService>(context, context.createFilter("(&(objectClass=" + StringManipulatorService.class.getName() + "))"), null);
		tracker.open();
		
		try {
			stringManipulator = (StringManipulatorImpl) tracker.getService();
		} catch (Exception e) {
			System.out.println("Error");
			System.out.println(e.getMessage());
		} 
	}
	
	public void start(BundleContext bundleContext) throws Exception {
    }

    public void stop(BundleContext bundleContext) throws Exception {
    }

	@Override
	public void printToConsole(String Input) {		
		Input = Input.trim();
		System.out.println(Input);
				
	}

	@Override
	public void formatAndPrint(String Input) {
		Input = Input.trim();
		String OutputToPrint = stringManipulator.formatParagraph(Input);
		System.out.println(OutputToPrint);
		
	}

	@Override
	public void printWithBorder(String Input) {
		Input = Input.trim();
		String OutputToPrint = stringManipulator.formatParagraph(Input);
		OutputToPrint = stringManipulator.addBorder(OutputToPrint);
		System.out.println(OutputToPrint);
	}

	@Override
	public void printList(String[] Input) {
		String OutputToPrint = stringManipulator.combineAll(Input);
		System.out.println(OutputToPrint);
		
	}

}
