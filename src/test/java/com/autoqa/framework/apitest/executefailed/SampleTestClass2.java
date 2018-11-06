package com.autoqa.framework.apitest.executefailed;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestClass2 {

	@Test
	public void sampleTest3() {
		System.out.println("Sample Test Code 3");
		Assert.assertEquals(true, false);
	}

	@Test
	public void sampleTest4() {
		System.out.println("Sample Test Code 4");
	}

}
