package edu.sdccd.cisc191.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TicTacToeServer {

    private static int xWins;
    private static int oWins;
    private static int ties;

    /**
     * Creates the server socket, listens, and calls handleRequest when a client connects.
     * @param args array of arguments.
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(2222)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted connection");
                handleRequest(socket);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Updates the proper variable depending on the String received from the client.
     * Writes out the all-time score as a String using those variables.
     * @param client a socket that represents the connected client
     */
    private static void handleRequest(Socket client) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String input;
            while ((input = in.readLine()) != null) {
                if (input.startsWith("RESULT")) {
                    if (input.equals("RESULT X_WIN")) {
                        xWins++;
                    } else if (input.equals("RESULT O_WIN")) {
                        oWins++;
                    } else if (input.equals("RESULT TIE")) {
                        ties++;
                    }
                }
                else if (input.equals("GET_SCORE")) {
                    out.println("SCORES X:" + xWins + " O:" + oWins + " TIES:" + ties);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}
