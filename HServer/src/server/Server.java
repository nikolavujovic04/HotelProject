/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import communication.Operation;
import communication.Request;
import communication.Response;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import controller.Controller;

/**
 *
 * @author Nikola
 */
public class Server {
    
    private Controller controller;

    public Server() {
        this.controller = new Controller();
    }

    public void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Waiting for connection...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected!");
            //kriraj ulazni tok za citanje podataka
            ObjectInputStream inSoket
                    = new ObjectInputStream(clientSocket.getInputStream());
            //kreiraj izlazni tok za upisanje podataka, slanje odgovora
            ObjectOutputStream outSocket
                    = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                Response response = new Response();

                try {
                    //procitaj zahtev klijenta
                    Request request = (Request) inSoket.readObject();
                    //obradi zahtev
                    Operation operation = request.getOperation();

                    switch (operation) {

                        default:
                            throw new AssertionError();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    response.setException(new Exception("Erron on server!"));
                }
                outSocket.writeObject(response);
                outSocket.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
