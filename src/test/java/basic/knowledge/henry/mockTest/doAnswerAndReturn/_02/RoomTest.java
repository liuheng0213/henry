package basic.knowledge.henry.mockTest.doAnswerAndReturn._02;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNull;

public class RoomTest {

    @Test
    public void test_Room() {

        RoomService roomService = mock(RoomService.class);
        final Map<String, Room> roomMap = new HashMap<String, Room>();

        // mock for method persist
        doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                if (arguments != null && arguments.length > 0 && arguments[0] != null) {
                    Room room = (Room) arguments[0];
                    roomMap.put(room.getName(), room);
                }
                return null;
            }
        }).when(roomService).persist(any(Room.class));

        // mock for method findByName
        when(roomService.findByName(anyString())).thenAnswer(new Answer<Room>() {
            @Override
            public Room answer(InvocationOnMock invocation) throws Throwable {
                Object[] arguments = invocation.getArguments();
                if (arguments != null && arguments.length > 0 && arguments[0] != null) {
                    String key = (String) arguments[0];
                    if (roomMap.containsKey(key)) {
                        return roomMap.get(key);
                    }
                }
                return null;
            }
        });



        String name = "room";
        Room room = new Room(name);
        roomService.persist(room);
        assertThat(roomService.findByName(name), equalTo(room));
        assertNull(roomService.findByName("none"));

    }
}
