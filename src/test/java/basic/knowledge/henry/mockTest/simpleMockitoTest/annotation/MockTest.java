package basic.knowledge.henry.mockTest.simpleMockitoTest.annotation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * https://blog.csdn.net/xiang__liu/article/details/81147933
 */
public class MockTest {
    @Mock
    private List mockList;

    @Before
    public void mockTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shorthand(){
        System.out.println("-------------");
        mockList.add(1);
        verify(mockList).add(1);
    }
}
