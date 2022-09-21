package basic.knowledge.henry.mockTest.doAnswerAndReturn._01;


import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;


public class MyUnitTest {

    static class ExampleService {

        public int add(int a, int b) {
            return a + b;
        }

        public int deduct(int a, int b) {
            return a - b;
        }

    }

    @Mock
    private ExampleService exampleService;

    @Test
    public void test() {

        MockitoAnnotations.initMocks(this);

        when(exampleService.add(anyInt(), anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                // 获取参数
                Integer a = (Integer) args[0];
                Integer b = (Integer) args[1];

                // 根据第1个参数，返回不同的值
                if (a == 1) {
                    return 9;
                }
                if (a == 2) {
                    return 99;
                }
                if (a == 3) {
                    throw new RuntimeException("异常");
                }
                return 999;
            }
        });

        assertEquals(9, exampleService.add(1, 100));
        assertEquals(99, exampleService.add(2, 100));
        assertEquals(999, exampleService.add(4, 100));

        try {
            exampleService.add(3, 100);
            Assert.fail();
        } catch (RuntimeException ex) {
            assertEquals("异常", ex.getMessage());
        }
    }


    @Test
    public void test_return() throws Exception {
        Dummy dummy = mock(Dummy.class);
        int returnValue = 5;

        // choose your preferred way
        when(dummy.stringLength("dummy")).thenReturn(returnValue);
        doReturn(returnValue).when(dummy).stringLength("dummy");
    }

    @Test
    public void test_answer() throws Exception {
        Dummy dummy = mock(Dummy.class);
        Answer<Integer> answer = new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                Object argument = invocation.getArgument(0);
                // 获取参数
                String string = (String) argument;

                return string.length() * 2;
            }
        };

        // choose your preferred way
        when(dummy.stringLength("dummy")).thenAnswer(answer);

        assertEquals(10, dummy.stringLength("dummy"));

        doAnswer(answer).when(dummy).stringLength("c");
    }


    /**
     * doAnswer和thenReturn在以下情况下执行相同的操作：
     */
    @Test
    public void test_answer2() {
        BookService service = mock(BookService.class);
        when(service.getAuthor()).thenReturn("Joshua");
// or..
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return "Joshua";
            }
        }).when(service).getAuthor();


    }


    /**
     * 当您想"存根" void方法时。
     */
    @Test
    public void test_answer3(){
        BookService service = mock(BookService.class);
        BookServiceCallback callback = new BookServiceCallback() {
            @Override
            public void onSuccess(String bookTitle) {
                assertEquals("Effective Java", bookTitle);
            }
        };
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                BookServiceCallback callback = (BookServiceCallback) invocation.getArguments()[0];
                callback.onSuccess("Effective Java");
                // return null because queryBookTitle is void
                return null;
            }
        }).when(service).queryBookTitle(callback);
        service.queryBookTitle(callback);


    }


}