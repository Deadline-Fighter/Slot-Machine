package core.service;

import core.components.AbstractSlot;
import core.components.slot.Bar;
import core.components.slot.Heart;
import core.components.slot.Seven;
//import org.junit.Before;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

//@RunWith(MockitoJUnitRunner.class)
public class PatternCheckerTest {

    private PatternChecker checker;

//    @Before
//    public void before() {
//        checker = new PatternChecker();
//    }

    @Test
    public void testIsHorizontallySame() {
        AbstractSlot left_1 = Mockito.mock(Bar.class);
        AbstractSlot left_2 = Mockito.mock(Heart.class);
        AbstractSlot left_3 = Mockito.mock(Seven.class);

        AbstractSlot center_1 = Mockito.mock(Bar.class);
        AbstractSlot center_2 = Mockito.mock(Heart.class);
        AbstractSlot center_3 = Mockito.mock(Seven.class);

        AbstractSlot right_1 = Mockito.mock(Bar.class);
        AbstractSlot right_2 = Mockito.mock(Heart.class);
        AbstractSlot right_3 = Mockito.mock(Seven.class);

        ArrayList leftColumn = Mockito.mock(ArrayList.class);
        Mockito.when(leftColumn.get(0)).thenReturn(left_1);
        Mockito.when(leftColumn.get(1)).thenReturn(left_2);
        Mockito.when(leftColumn.get(2)).thenReturn(left_3);

        ArrayList centerColumn = Mockito.mock(ArrayList.class);
        Mockito.when(centerColumn.get(0)).thenReturn(center_1);
        Mockito.when(centerColumn.get(1)).thenReturn(center_2);
        Mockito.when(centerColumn.get(2)).thenReturn(center_3);

        ArrayList rightColumn = Mockito.mock(ArrayList.class);

    }

    private AbstractSlot getMockedObject(Object obj, String name, int odds) {
        AbstractSlot slot = (AbstractSlot) Mockito.mock(obj.getClass());
        Mockito.when(slot.getName()).thenReturn(name);
        Mockito.when(slot.getOdd()).thenReturn(odds);
        return slot;
    }

}
