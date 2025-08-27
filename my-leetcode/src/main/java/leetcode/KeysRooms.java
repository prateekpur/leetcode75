package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Problem 841
public class KeysRooms {

	static Set<Integer> keys = new HashSet<Integer>();
	static boolean[] roomsVisited;
	
	public static void main(String args[])	{
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		
		rooms.add(new ArrayList<>(List.of()));
		rooms.add(new ArrayList<>(List.of()));
		rooms.add(new ArrayList<>(List.of(1)));
		rooms.add(new ArrayList<>(List.of(2,3)));
		System.out.println(canVisitAllRooms(rooms));
	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	roomsVisited = new boolean[rooms.size()];
    	List<Integer> firstRoom = rooms.get(0);
    	if(firstRoom.isEmpty())	{
    		return false;
    	}
    	keys.addAll(firstRoom);
    	roomsVisited[0] = true;
    	while(!keys.isEmpty())	{
    		int room = visitRoom();
    		if (room != -1)	{
        		keys.addAll(rooms.get(room));
    		}
    		if (allRoomsVisited(roomsVisited))	{
    			return true;
    		}
    	}
    	return allRoomsVisited(roomsVisited);
    }
    
    static int visitRoom()	{
    	Iterator<Integer> keyIter = keys.iterator();
    	while(keyIter.hasNext())	{
    		int key = keyIter.next();
    		keyIter.remove();
    		if (roomsVisited[key])	{
    			
    			continue;
    		}
        	roomsVisited[key] = true;
        	return key;
    	}
    	return -1;
    }
    
    static boolean allRoomsVisited(boolean rooms[])	{
    	for (boolean room : rooms)	{
    		if (!room)	{
    			return false;
    		}
    	}
    	return true;
    }
}
