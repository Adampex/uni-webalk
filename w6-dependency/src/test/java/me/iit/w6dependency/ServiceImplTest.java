package me.iit.w6dependency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServiceImplTest {

    @Mock Dependency dependency;

    @InjectMocks ServiceImpl service;


    @Test
    void calculateTest() {
        // GIVEN

        // WHEN
        service.calculate();

        // THEN
        verify(dependency, times(1)).helpNoParameterNoReturnValue();
    }

    @Test
    void return5Test() {
        // GIVEN
        final int FIVE = 5;

        // WHEN
        int result = service.returnFive();

        // THEN
        assertEquals(FIVE, result);
    }

    @Test
    // Is the service calls the dependency?
    // Is the return value of dependency method used?
    void dependencyReturnValueIsUsedTest() {
        // GIVEN
        final int FIVE = 5;
        when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);

        // WHEN
        int result = service.callHelpAndUseReturnValue();

        //THEN
        verify(dependency, times(1)).helpNoParameterReturnValue();
        assertEquals(FIVE, result);
    }

    @Test
    // Is the service calls the dependency?
    // Is the parameter of dependency method appropriate?
    void callHelpAndPassParameter5Test() {
        // GIVEN
        final int FIVE = 5;

        // WHEN
        service.callHelpAndPassParameter5();

        // THEN
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        verify(dependency, times(1)).helpWithParameterNoReturnValue(captor.capture());
        assertEquals(FIVE, captor.getValue());
    }

    @Test
    void getImportantAbstactTest() {
        // GIVEN
        String testText = "Something random";
        String expected = "<b>abc...</b>";
        String goal = service.getFirst3Char(testText);
        when(dependency.important(goal)).thenReturn("<b>abc...</b>");

        // WHEN
        String result = service.getImportantAbstract(testText);

        // THEN
        verify(dependency, times(1)).important(goal);
        assertEquals(expected, result);
    }
}

