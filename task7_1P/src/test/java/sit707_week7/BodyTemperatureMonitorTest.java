package sit707_week7;

import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BodyTemperatureMonitorTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "223495239";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Hashini";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
	@Test
	public void testReadTemperatureNegative() {
        TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(-1.0);

        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        double temperature = monitor.readTemperature();

        Assert.assertTrue("Temperature should negative", temperature < 0);
	}
	
	@Test
	public void testReadTemperatureZero() {
		TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(0.0);

        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        double temperature = monitor.readTemperature();

        Assert.assertEquals("Temperature should be zero", 0.0, temperature, 0.01);
	}
	
	@Test
	public void testReadTemperatureNormal() {
		 TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
	        when(temperatureSensor.readTemperatureValue()).thenReturn(36.5);

	        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
	        double temperature = monitor.readTemperature();

	        Assert.assertTrue("Temperature should be normal", temperature >= 35 && temperature <= 37);
	}
	
	@Test
	public void testReadTemperatureAbnormallyHigh() {
		TemperatureSensor temperatureSensor = Mockito.mock(TemperatureSensor.class);
        when(temperatureSensor.readTemperatureValue()).thenReturn(40.0);

        BodyTemperatureMonitor monitor = new BodyTemperatureMonitor(temperatureSensor, null, null);
        double temperature = monitor.readTemperature();

        Assert.assertTrue("Temperature should be abnormally high", temperature > 37);
    }

	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testReportTemperatureReadingToCloud() {
//		// Mock reportTemperatureReadingToCloud() calls cloudService.sendTemperatureToCloud()
//		
//		Assert.assertTrue("Not tested", false);
//	}
	
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testInquireBodyStatusNormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
	
	/*
	 * CREDIT or above level students, Remove comments. 
	 */
//	@Test
//	public void testInquireBodyStatusAbnormalNotification() {
//		Assert.assertTrue("Not tested", false);
//	}
}
