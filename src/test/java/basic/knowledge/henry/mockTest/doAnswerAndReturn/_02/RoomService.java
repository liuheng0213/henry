package basic.knowledge.henry.mockTest.doAnswerAndReturn._02;

import java.util.HashMap;
import java.util.Map;

public class RoomService {
    final Map<String, Room> roomMap = new HashMap<String, Room>();
    public Room findByName(String roomName) {
        return roomMap.get(roomName);
    }
    public void persist(Room room) {
        roomMap.put(room.getName(), room);
    }
}
