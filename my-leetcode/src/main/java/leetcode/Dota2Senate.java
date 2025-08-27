package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dota2Senate {
	private class Senate {
		char letter;
		boolean isPowerUsed;
		Senate(char letter)	{
			this.letter = letter;
			isPowerUsed = false;
		}
	}
	
	public static Logger logger = Logger.getLogger(Dota2Senate.class.getName());
	public static void main(String args[])	{
		Dota2Senate s = new Dota2Senate();
		//logger.log(Level.INFO, s.predictPartyVictory("DRDRDRDRRDRD"));
		//logger.log(Level.INFO, s.predictPartyVictory("DRDRDRDRRDRD"));
		//logger.log(Level.INFO, s.predictPartyVictory("DRDRR"));
		logger.log(Level.INFO, s.predictPartyVictory("DRRDRDRDRDDRDRDR"));
	}
	
    public String predictPartyVictory(String senate) {
        int totalSenators = senate.length();
        Deque<Integer> radiantQueue = new ArrayDeque<>();
        Deque<Integer> direQueue = new ArrayDeque<>();

        // Populate queues with the indices of 'R' and 'D' senators
        for (int i = 0; i < totalSenators; ++i) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
      
        // Process the queues until one of them is empty
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.peek();
            int direIndex = direQueue.peek();
          
            // The senator with the lower index bans the opposing senator
            if (radiantIndex < direIndex) {
                // The radiant senator bans a dire senator and gets back in line
                radiantQueue.offer(radiantIndex + totalSenators);
            } else {
                // The dire senator bans a radiant senator and gets back in line
                direQueue.offer(direIndex + totalSenators);
            }

            // Remove the senators that have already made a ban
            radiantQueue.poll();
            direQueue.poll();
        }

        // Declare the winner depending on which queue is not empty
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }


    String predictPartyVictory1(String senate) {
    	Queue<Senate> dqueueD = new LinkedTransferQueue<Senate>(), dqueueR = new LinkedTransferQueue<Senate>();
    	for (char c : senate.toCharArray())	{
    		if (c == 'R')	{
    			checkAndPush(new Senate('R'), dqueueR, dqueueD);
    		}	else	{
    			checkAndPush(new Senate('D'), dqueueD, dqueueR);
    		}
    	}
    	if (dqueueR.isEmpty())	{
    		return "D";
    	}	else if (dqueueD.isEmpty())	{
        	return "R";
    	}	else	{
    		//count number of senators with powers used and another count of senators with powers not used
    		int cntD = 0, cntDUsed = 0, cntR = 0, cntRUsed = 0;
    		for (Senate s : dqueueD)	{
    			if (s.isPowerUsed)	{
    				++cntDUsed;
    			}	else	{
    				++cntD;
    			}
    		}
    		for (Senate s : dqueueR)	{
    			if (s.isPowerUsed)	{
    				++cntRUsed;
    			}	else	{
    				++cntR;
    			}
    		}
    		if (cntD > cntR)	{
    			return "D";
    		}	else if (cntR > cntD)	{
    			return "R";
    		}	else	{
    			if (cntDUsed > cntRUsed)	{
    				return "D";
    			}	else if (cntRUsed > cntDUsed) {
    				return "R";
    			}
    			return senate.substring(0, 1);
    		}
    	}
    }
    
    private void checkAndPush(Senate s, Queue<Senate> sameTeam, Queue<Senate> opponent)	{
    	if (opponent.isEmpty())	{
    		sameTeam.add(s);
    	}	else	{
    		Senate sOther = opponent.poll();
			if (!sOther.isPowerUsed)	{
				//if power has not been used then use it for this R senator and push D senator back with updated powers
				sOther.isPowerUsed = true;
				opponent.add(sOther);
			}	else	{
				//ignore D senator whose power has been used and add R senator to queue
				s.isPowerUsed = true;
				sameTeam.add(s);
			}
    	}
    }
}
