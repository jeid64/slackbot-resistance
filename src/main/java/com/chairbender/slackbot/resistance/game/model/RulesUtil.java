package com.chairbender.slackbot.resistance.game.model;

/**
 * Encapsulates rules logic like how many players are needed on missions, how many spies, etc...
 *
 * Created by chairbender on 11/19/2015.
 */
public abstract class RulesUtil {
    
    private static HashMap<Integer, Integer[]> teamSizes = new HashMap<Integer, Integer[]>() {{
        put(5, new Integer[]{2, 3, 2, 3, 3});
        put(6, new Integer[]{2, 3, 4, 3, 4});
        put(7, new Integer[]{2, 3, 3, 4, 4});
        put(8, new Integer[]{3, 4, 4, 5, 5});
    }};

    /**
     *
     * @param numPlayers number of players in the game. Must be from 5 to 10
     * @param round current round (1 - 5)
     * @return the number of players needed for the mission team for the indicated round.
     */
    public static int getRequiredTeamSize(int numPlayers, int round) {
       if(numPlayers < 5 || numPlayers > 10 || round < 1 || round > 5)
           return -1;
        else
            return teamSizes.get(numPlayers < 8 ? numPlayers : 8)[round];
    }

    /**
     *
     * @param playerCount number of players in the game (5 - 10)
     * @return the number of spies needed in the game.
     */
    public static int getSpiesNeeded(int playerCount) {
        if (playerCount == 5 || playerCount == 6) {
            return 2;
        } else if (playerCount == 10) {
            return 4;
        } else {
            return 3;
        }
    }
}
