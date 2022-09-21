package basic.knowledge.henry.mockTest.partialMock.spy;

import org.mockito.Mockito;

import static org.mockito.Mockito.when;


/**
 *
 *
 *
 output:
 0
 0
 RealTest1()!!! - 1
 RealTest2()!!! - 2
 RealTest1()!!! - 100
 RealTest1()!!! - 1
 RealTest2()!!! - 2
 RealTest1()!!! - 104
 *
 *
 *
 */
public class TestMockObject {
    public static void main(String[] args) {

        TestMockObject mock = Mockito.mock(TestMockObject.class);
        System.out.println(mock.test1());
        System.out.println(mock.test2());

        TestMockObject spy = Mockito.spy(new TestMockObject());
        System.out.println(spy.test1());
        System.out.println(spy.test2());

        when(spy.test1()).thenReturn(100);
        System.out.println(spy.test1());

        Mockito.reset(spy);
        System.out.println(spy.test1());
        System.out.println(spy.test2());

        when(spy.test1()).thenReturn(104);
        System.out.println(spy.test1());
    }

    public int test1() {
        System.out.print("RealTest1()!!! - ");
        return 1;
    }

    public int test2() {
        System.out.print("RealTest2()!!! - ");
        return 2;
    }
}
