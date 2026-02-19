/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import threads.ServerThread;

/**
 *
 * @author Nikola
 */
public class Main {
    
    public static void main(String[] args) {
        ServerThread server=new ServerThread();
        server.startServer();
    }
    
}
