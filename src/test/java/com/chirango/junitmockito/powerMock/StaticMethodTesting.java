package com.chirango.junitmockito.powerMock;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UtilityClass.class /*The class with static method to be mocked*/})
public class StaticMethodTesting {
  @Mock Dependency dependency;

  @InjectMocks SystemUnderTest systemUnderTest;

  @Test
  public void powerMockito_MockingAStaticMethodCall() {
    Mockito.when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1, 2, 3));

    PowerMockito.mockStatic(UtilityClass.class);
    Mockito.when(UtilityClass.staticMethod(Mockito.anyLong())).thenReturn(150);
    Assertions.assertEquals(150, systemUnderTest.methodCallingAStaticMethod());

    PowerMockito.verifyStatic(UtilityClass.class);
    UtilityClass.staticMethod(6L);
  }
}
