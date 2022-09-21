package basic.knowledge.henry.mockTest.partialMock.callRealMethod;

import org.junit.Test;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * 通过代码可以看出Jerry是一个mock对象， goHome()和doSomeThingB()是使用了实际调用技术，
 * 而doSomeThingA()被mockito执行了默认的answer行为（这里是个void方法，so，什么也不干）。
 *
 *  通过代码可以看出Jerry是一个mock对象， goHome()和doSomeThingB()是使用了实际调用技术，
 *  而doSomeThingA()被mockito执行了默认的answer行为（这里是个void方法，so，什么也不干）。
 */
public class CallMethodDemo {
    @Test
    public void callRealMethodTest() {
        Jerry jerry = mock(Jerry.class);

        //要真实调用goHome()
        doCallRealMethod().when(jerry).goHome();
        //要真实调用doSomeThingB()
        doCallRealMethod().when(jerry).doSomeThingB();

        jerry.goHome();

        verify(jerry).doSomeThingA();
        verify(jerry).doSomeThingB();
    }
}
