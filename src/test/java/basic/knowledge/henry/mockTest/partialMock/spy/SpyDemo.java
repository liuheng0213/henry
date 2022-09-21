package basic.knowledge.henry.mockTest.partialMock.spy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;


/**
 * Spy类就可以满足我们的要求。
 * 如果一个方法定制了返回值或者异常，那么就会按照定制的方式被调用执行；如果一个方法没被定制，那么调用的就是真实类的方法
 *
 * Mockito.reset(spyObject);
 */
public class SpyDemo {
    @Test
    public void spy_Simple_demo(){
        List<String> list = new LinkedList<String>();
        List<String> spy = spy(list);

        //stubbing
        when(spy.size()).thenReturn(100);


        //not stubbing
        spy.add("one");
        spy.add("two");

/*        spy的原理是，如果不打桩默认都会执行真实的方法，如果打桩则返回桩实现。
        可以看出spy.size()通过桩实现返回了值100，而spy.get(0)则返回了实际值*/
        assertEquals(spy.get(0), "one");
        assertEquals(100, spy.size());
    }

    @Test
    public void spy_Procession_Demo() {
        Jack spyJack = spy(new Jack());
        //使用spy的桩实现实际还是会调用stub的方法，只是返回了stub的值, it will print I say go go go!!
        when(spyJack.go()).thenReturn(false);
        assertFalse(spyJack.go());

        //没有打桩 ,不会调用stub的方法  it will not print I say go go go!!
        doReturn(false).when(spyJack).go();
        assertFalse(spyJack.go());
    }


    /**
     * 当使用when-thenReturn时，Spy Mockito将调用真实方法，然后将您的答案存根。
     * 如果您不想像下面的示例那样调用真实方法，则可能会导致问题：
     */
    @Test
    public void testList(){
        List list = new LinkedList();
        List spy = spy(list);
// Will throw java.lang.IndexOutOfBoundsException: Index: 0, Size: 0,
        // thenReturn 调用真实的get(0) 方法
        when(spy.get(0)).thenReturn("java");
        assertEquals("java", spy.get(0));
    }


    /**
     * 使用doAnswer，我们可以安全地将其存根。
     */
    @Test
    public void testList2(){
        List list = new LinkedList();
        List spy = spy(list);
        //不会真的调用 get方法
        doAnswer(invocation ->"java").when(spy).get(0);
        assertEquals("java", spy.get(0));
    }


    @Test
    public void testList3(){
        List list = new LinkedList();
        List spy = spy(list);
        doReturn("java").when(spy).get(0);
        assertEquals("java", spy.get(0));
    }

}
