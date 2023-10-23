package com.chirango.junitmockito.powerMock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SystemUnderTest.class /*To be able to mock the Constructor,
we need to add in the Class that creates the new object*/})
public class MockingConstructorTest {

  @Mock Dependency dependencyMock;

  @InjectMocks SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_MockingAConstructor() throws Exception {
    ArrayList<String> listMock = Mockito.mock(ArrayList.class);

    Mockito.when(listMock.size()).thenReturn(100);

    PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(listMock);
    int size = systemUnderTest.methodUsingAnArrayListConstructor();
    Assertions.assertEquals(100, size);
  }
}
