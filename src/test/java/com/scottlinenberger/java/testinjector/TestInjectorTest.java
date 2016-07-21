package com.scottlinenberger.java.testinjector;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestInjectorTest {
	
	private SampleClass testObject;
	private String injectedStringValue = "Hello, world!";
	
	
	@Before
	public void init() {
		
		//create a new instance of the class to be injected
		testObject = new SampleClass();
		
		//create a new test injector
		TestInjector<SampleClass> testInjector = new TestInjector<SampleClass>(testObject);
		
		//See javadoc for more details
		testInjector.set("someAutowiredValue", injectedStringValue);
		
	}
	
	@Test
	public void testInjectorTest_injectedValueShouldBeSetOnTargetObject() {
		assertEquals(injectedStringValue, testObject.getSomeAutowiredValue());
	}

	private class SampleClass {
		
		private String someAutowiredValue;
		
		public String getSomeAutowiredValue(){
			return someAutowiredValue;
		}
		
	}
	
}
 