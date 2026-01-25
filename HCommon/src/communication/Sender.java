/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Nikola
 */
public class Sender {
    private final Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void send(Object obj) throws Exception {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(obj);
            out.flush();
        } catch (IOException ex) {
            throw new Exception("Error while sending object: " + obj);
        }

    }
}
