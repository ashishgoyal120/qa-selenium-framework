package org.selenium.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer{

	@Override
	@SuppressWarnings("rawtypes")
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryFailedTests.class);
		// Usage of other parameters
		/*
		 * // 🚫 Example 1: Skip all tests inside "PaymentTests" class
		 * if (testClass != null && testClass.getSimpleName().equals("PaymentTests")) {
		 * annotation.setEnabled(false);
		 * }
		 * 
		 * // 🚫 Example 2: Skip specific method "testLogin" (regardless of class)
		 * if (testMethod != null && testMethod.getName().equals("testLogin")) {
		 * annotation.setEnabled(false);
		 * }
		 * 
		 * // ✅ Example 3: Retry only for "testCheckout" method
		 * if (testMethod != null && testMethod.getName().equals("testCheckout")) {
		 * annotation.setRetryAnalyzer(RetryFailedTests.class);
		 * }
		 */
	}

}
