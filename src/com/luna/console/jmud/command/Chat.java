package com.luna.console.jmud.command;

//import java.util.Iterator;

import java.nio.channels.SocketChannel;

import com.luna.console.jmud.Player;
import com.luna.console.jmud.PlayerChannel;
import com.luna.console.jmud.Room;

/*
 * Chat.java
 *
 * Created on March 28 2003 12:26 PM
 */

/**
 * Executable command Chat
 * <p/>
 * Provides the functionality for chatting to all players in a room.
 * 
 * @author Chris maguire
 * @version 0.1
 */

public class Chat extends Command {

    private final PlayerChannel playerChannel;

    private final Player player;

    private final SocketChannel sc;

    private final Room room;

    private final String msg;

    /**
     * Constructs an instance of Chat where: <br>
     * &nbsp;&nbsp; The Player from the PlayerChannel is sending the chat <br>
     * &nbsp;&nbsp; The Room is "where" the chat will be displayed <br>
     * &nbsp;&nbsp; The String is the chat message to display
     * 
     * @param pc
     *            The player and socket channel of the player sending the chat
     * @param r
     *            The room where the message will be displayed (should be where
     *            the player is)
     * @param msg
     *            The chat message to display
     */
    public Chat(PlayerChannel pc, Room r, String msg) {

        this.playerChannel = pc;
        this.player = pc.getPlayer();
        this.sc = pc.getSocketChannel();
        this.room = r;
        this.msg = msg;
    }

    /**
     * Displays a message to all players in the room specified in the
     * constructor
     * 
     * @return true to signify that this command is complete.
     */
    @Override
    public boolean exec() {

        try {
            // the player prompt will be handled by sendMessageToAllButOne
            room.sendMessageToAllButOne(CRLF + player.getName() + ": " + msg + CRLF, playerChannel);
            playerChannel.sendMessage(CRLF + player.getPrompt());
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

}