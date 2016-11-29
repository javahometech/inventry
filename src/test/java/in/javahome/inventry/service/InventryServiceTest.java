package in.javahome.inventry.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import in.javahome.inventry.repository.InventryRepository;
import in.javahome.inventry.response.BaseResponse;

public class InventryServiceTest {
	static private InventryService invService = new InventryService();
	static InventryRepository invRepoMock;
	@BeforeClass
	public static void setUP() {
		invRepoMock = mock(InventryRepository.class);
		invService.inventRepo = invRepoMock;
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testDeleteItem() {
		stubVoid(invRepoMock).toReturn().on().delete(111);
		BaseResponse response = invService.deleteItem(111);
		assertEquals(HttpStatus.OK.value(), response.getCode());
		assertEquals("Success", response.getStatus());
	}

}
