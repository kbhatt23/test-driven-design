package com.learning.springboottest.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
//runner helping us to do auto injection and auto mocking of bean to main class
@RunWith(MockitoJUnitRunner.class)
public class CaclulationMockVerificationTest {

	
	/* private CalculationService service = new CalculationService(); */
	@InjectMocks
	private CalculationService service;
	
	/* private DataProvider dataProvider = Mockito.mock(DataProvider.class); */
	@Mock
	private DataProvider dataProvider;
	
	
	@Test
	public void testVerificationBasic() {
		int sum = service.calcualateArraySum(new int[] {1,2,4});
		assertEquals(7, sum);
		//Mockito.verify(dataProvider).retrieveNumbers();
		Mockito.verify(dataProvider,Mockito.never()).retrieveNumbers();
		
	}
	
	@Test
	public void testVerificationBasic1() {
		Mockito.when(dataProvider.retrieveNumbers()).thenReturn(new int[] {1,2,4});
		int sumMagic = service.calcualateArraySum();
		assertEquals(7, sumMagic);
		
		Mockito.verify(dataProvider).retrieveNumbers();
	}
	
	@Test
	public void testVerificationVoid() {
		//void method
		//hence can not assert the result
		Mockito.when(dataProvider.retrieveNumbers()).thenReturn(new int[] {1,2,4});
		service.calculateAndStoreArraySum();
		service.calculateAndStoreArraySum();
		Mockito.verify(dataProvider, Mockito.times(2)).retrieveNumbers();
	}
	
	@Test
	public void testVerificationVoidArgumentNever() {
		Mockito.when(dataProvider.retrieveNumbers(Mockito.anyString())).thenReturn(new int[] {1,2,4});
		service.calculateAndStoreArraySumCapture();
		
		Mockito.verify(dataProvider,Mockito.never()).retrieveNumbers();
		
	}
	@Test
	public void testVerificationVoidArgument() {
		Mockito.when(dataProvider.retrieveNumbers(Mockito.anyString())).thenReturn(new int[] {1,2,4});
		service.calculateAndStoreArraySumCapture();
		
		//Mockito.verify(dataProvider,times(2)).retrieveNumbers(Mockito.anyString());
		
		Mockito.verify(dataProvider,atLeast(1)).retrieveNumbers(Mockito.anyString());
		ArgumentCaptor<String> arg1 = ArgumentCaptor.forClass(String.class);
		Mockito.verify(dataProvider,atLeast(1)).retrieveNumbers(arg1.capture());
		
		assertEquals("jai shree krishna", arg1.getAllValues().get(0));
		assertEquals("jai shree ram", arg1.getAllValues().get(1));
	}
	
	@Test
	public void testVerificationVoidDoubleArgument() {
		Mockito.when(dataProvider.retrieveNumbers(Mockito.anyString(), Mockito.anyString()
				, Mockito.anyInt()
				)).thenReturn(new int[] {1,2,4});
		service.calculateAndStoreArraySumCaptureTwice();
		
		//Mockito.verify(dataProvider,times(2)).retrieveNumbers(Mockito.anyString());
		
		Mockito.verify(dataProvider,atLeast(1)).retrieveNumbers(Mockito.anyString(), Mockito.anyString()
				, Mockito.anyInt());
		ArgumentCaptor<String> arg1 = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> arg2 = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Integer> arg3 = ArgumentCaptor.forClass(Integer.class);
		Mockito.verify(dataProvider,atLeast(1)).retrieveNumbers(arg1.capture()
				,arg2.capture(),arg3.capture()
				);
		//get value gives latest value passed in argument captor
		assertEquals("jai shree krishna says kannu", arg1.getValue());
		assertEquals("jai shree ram says kannu", arg2.getAllValues().get(1));
		assertEquals(109, arg3.getValue().intValue());
	}
	
	@Test
	public void verifyThreeArgument() {
		Mockito.when(dataProvider.retrieveNumbers(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt()))
			.thenReturn(new int[] {1,2,4})
		;
		service.calculateAndStoreArraySumCaptureTwice();
		
		Mockito.verify(dataProvider,Mockito.never()).retrieveNumbers();
		
		Mockito.verify(dataProvider,times(2)).retrieveNumbers(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt());
		
		ArgumentCaptor<String> arg1 = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> arg2 = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<Integer> arg3 = ArgumentCaptor.forClass(Integer.class);
		Mockito.verify(dataProvider,times(2)).retrieveNumbers(arg1.capture(), arg2.capture(), arg3.capture());

		assertEquals("jai shree krishna", arg1.getAllValues().get(0));
		assertEquals("jai shree krishna says kannu", arg1.getAllValues().get(1));
		assertEquals("jai shree ram", arg2.getAllValues().get(0));
		assertEquals("jai shree ram says kannu", arg2.getAllValues().get(1));
		assertEquals(108, arg3.getAllValues().get(0).intValue());
		assertEquals(109, arg3.getAllValues().get(1).intValue());
		
	}
}
