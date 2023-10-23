package com.chirango.junitmockito.powerMock;

import java.util.Arrays;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class PrivateMethodTest {

  @Mock private Dependency dependency;

  @InjectMocks private SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_CallingPrivateMethod() throws Exception {
    Mockito.when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));
    long value = (Long) Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
    Assertions.assertEquals(6, value);
  }
}
