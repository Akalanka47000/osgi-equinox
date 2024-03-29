package osgi.logger;

import org.osgi.framework.BundleContext;

public interface LoggerService {
	public void logInit(String message);
	public void logError(String errorMessage);
	public void logSuccess(String message);
	public void logPerformanceMetrics();
	public void logRequestData(String requestData);
	public void logResponseData(String responseData);
}
