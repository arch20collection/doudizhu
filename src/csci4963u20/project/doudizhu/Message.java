package csci4963u20.project.doudizhu;

import java.io.*;

public class Message implements Serializable {

    public int from;
    public int to;
    public String msgType;
    public Object content;

    /**
     * Default constructor of message
     * @param from message sender
     * @param to message receiver
     * @param type message type
     * @param content message content
     */
    public Message(int from, int to, String type, Object content) {
        this.from = from;
        this.to = to;
        this.msgType = type;
        this.content = content;
    }
}
