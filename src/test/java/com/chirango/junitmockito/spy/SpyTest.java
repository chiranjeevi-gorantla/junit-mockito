package com.chirango.junitmockito.spy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyTest {

  @Test
  void mockTest() {
    List arrayListMock = Mockito.mock(ArrayList.class);
    Assertions.assertEquals(0, arrayListMock.size());

    // mocks return default values
    Mockito.when(arrayListMock.size()).thenReturn(5);
    arrayListMock.add("Dummy");
    Assertions.assertEquals(5, arrayListMock.size());
  }

  @Test
  void spyTest() {
    List arrayListSpy = Mockito.spy(ArrayList.class);
    Assertions.assertEquals(0, arrayListSpy.size());

    arrayListSpy.add("Dummy");
    Assertions.assertEquals(1, arrayListSpy.size());

    arrayListSpy.remove("Dummy");
    Assertions.assertEquals(0, arrayListSpy.size());

    Mockito.when(arrayListSpy.size()).thenReturn(6);
    Assertions.assertEquals(6, arrayListSpy.size());
    
    arrayListSpy.add("Dummy");
    Mockito.verify(arrayListSpy, Mockito.times(2)).add("Dummy");
    Mockito.verify(arrayListSpy, Mockito.never()).clear();
  }
}
