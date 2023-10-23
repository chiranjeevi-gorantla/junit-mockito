package com.chirango.junitmockito.business;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

  @Test
  void mockListSizeMethod_ReturnTwo() {
    List listMock = Mockito.mock(List.class);
    Mockito.when(listMock.size()).thenReturn(2);

    Assertions.assertEquals(2, listMock.size());
  }

  @Test
  void mockListSizeMethod_ReturnMultipleValues() {
    List listMock = Mockito.mock(List.class);
    Mockito.when(listMock.size()).thenReturn(2).thenReturn(3);

    Assertions.assertEquals(2, listMock.size());
    Assertions.assertEquals(3, listMock.size());
  }

  @Test
  void mockListGetMethod() {
    List listMock = Mockito.mock(List.class);
    Mockito.when(listMock.get(Mockito.anyInt())).thenThrow(new RuntimeException("Something Wrong"));

    RuntimeException exception =
        Assertions.assertThrows(
            RuntimeException.class,
            () -> {
              listMock.get(3);
            });
    Assertions.assertEquals("Something Wrong", exception.getMessage());
    //        Assertions.assertEquals("test0", listMock.get(0));
    //        Assertions.assertEquals("test0", listMock.get(1));
  }
}
