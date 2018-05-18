package com.chairbender.slackbot.resistance.game.model;

/**
 * Encapsulates rules logic like how many players are needed on missions, how many spies, etc...
 *
 * Created by chairbender on 11/19/2015.
 */
public abstract class RulesUtil {

    /**
     *
     * @param numPlayers number of players in the game. Must be from 5 to 10
     * @param round current round (1 - 5)
     * @return the number of players needed for the mission team for the indicated round.
     */
    public static int getRequiredTeamSize(int numPlayers, int round) {
        return (numPlayers / 8) + 2 + (round < 3 ? round - 1 : numPlayers < 7 ? numPlayers == 5 ? round / 4 : round % 2 + 1 : (round / 4) + 1);
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
