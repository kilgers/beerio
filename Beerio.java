package beerio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Beerio {

    public static void main( String[] args ) throws Exception {
    	
    	String SQL_QUERY = "SELECT * FROM beerio.users;";
    	List<Player> players = null;
    	try(Connection con = DataSource.getConnection();
    	        PreparedStatement pst = con.prepareStatement( SQL_QUERY );
    	        ResultSet rs = pst.executeQuery();) {
            while ( rs.next() ) {
            	players = new ArrayList<>();
                Player player = new Player();
                player.setPlayerId( rs.getInt( "UserId" ) );
                player.setfName( rs.getString( "FirstName" ) );
                player.setlName( rs.getString( "LastName" ) );
                player.setWeight( rs.getInt( "Weight" ) );
                player.setGender( rs.getString( "Gender" ).toUpperCase() );
                players.add( player);//player.getPlayerId(),
                
                BufferedWriter writer = new BufferedWriter(new FileWriter("testlog.txt", true));
        		writer.append(System.lineSeparator());
        		writer.append(player.toString());
        		writer.append(System.lineSeparator());
        		writer.append(player.toJson());
        		writer.append(System.lineSeparator());
        		writer.close();
            }

    	}
    	
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handleClient(client);
                }
                catch(Exception e) {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("errorlog.txt", true));
                	writer.append(System.lineSeparator());
                	writer.append(e.getStackTrace().toString());
                	writer.append(System.lineSeparator());
                	writer.close();
                	continue;
                }
            }
        }
    }

    private static void handleClient(Socket client) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        StringBuilder requestBuilder = new StringBuilder();
        String line;
        while (!(line = br.readLine()).isBlank()) {
           	BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
        	writer.append(System.lineSeparator());
        	writer.append(line.toString());
        	writer.close();
            requestBuilder.append(line + "\r\n");
        }

        String request = requestBuilder.toString();
        String[] requestsLines = request.split("\r\n");
        String[] requestLine = requestsLines[0].split(" ");
        String method = requestLine[0];
        String path = requestLine[1];
        String version = requestLine[2];
        String host = requestsLines[1].split(" ")[1];

        List<String> headers = new ArrayList<>();
        for (int h = 2; h < requestsLines.length; h++) {
            String header = requestsLines[h];
            headers.add(header);
        }
        if(method.equals("POST")) {
//        	String[] parameters = new String[headers.size()];
        	String parameters;
//        	br.readLine();
        	parameters = br.readLine();
        	String[] temp = parameters.split("&");
        	String[][] params = new String[temp.length][2];
        	for(int i=0; i<temp.length; i++) {
        		params[i][0] = temp[i].substring(0,temp[i].indexOf("="));
        		params[i][1] = temp[i].substring(temp[i].indexOf("=")+1);
        		BufferedWriter writer = new BufferedWriter(new FileWriter("postlog.txt", true));
            	writer.append(System.lineSeparator());
        		writer.append(params[i][0]);
            	writer.append(System.lineSeparator());
            	writer.append(params[i][1]);
            	writer.append(System.lineSeparator());
            	writer.close();
        	}
 //       	String parameters = (headers.get(headers.size()-1)).toString();
 //       	BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
 //       	writer.append(parameters.toString());
//        	for(int i =0; i< parameters.length; i++) {
//        	writer.append(System.lineSeparator());
  //      	writer.append(parameters);
        	//        	writer.append(parameters.toString());
    //    	writer.close();
        	//last entry in header array will be parameters. Must.Parse.Them.
        }

        String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s, headers %s",
                client.toString(), method, path, version, host, headers.toString());
        //write log to file
//        BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
//        writer.append(System.lineSeparator());
//        writer.append(accessLog);
//        writer.append(System.lineSeparator());
//        writer.append(getFilePath(path).toString());
//        writer.append(System.lineSeparator());
//        writer.append(method);
//        writer.append(System.lineSeparator());
//        writer.close();
//        System.out.println(accessLog);


        Path filePath = getFilePath(path);
        if (method.equals("GET")) {	
        	if (Files.exists(filePath)) {
        		// file exist
        		String contentType = guessContentType(filePath);
        		sendResponse(client, "200 OK", contentType, Files.readAllBytes(filePath));
        	} else {
        		// 404
        		byte[] notFoundContent = "<h1>Not found :(</h1>".getBytes();
        		sendResponse(client, "404 Not Found", "text/html", notFoundContent);
        	}
        } else if(method.equals("POST")){
        	sendPost(client, "200 OK", "text/html");
        	//direct to functions here with case statement
        }

    }

    private static void sendPost (Socket client, String status, String contentType) throws IOException{
    	OutputStream clientOutput = client.getOutputStream();
        clientOutput.write(("HTTP/1.1 \r\n" + status).getBytes());
        clientOutput.write(("ContentType: " + contentType + "\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        //clientOutput.write(content);
	    clientOutput.write("POST failed succesfully".getBytes());
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }
    private static void sendResponse(Socket client, String status, String contentType, byte[] content) throws IOException {
        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write(("HTTP/1.1 \r\n" + status).getBytes());
        clientOutput.write(("ContentType: " + contentType + "\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write(content);
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }

    private static Path getFilePath(String path) {
        if ("/".equals(path)) {
            path = "\\index.html";
        }

        return Paths.get("C:\\Users\\shawn\\beerio\\beerio\\tmp\\www", path);
    }

    private static String guessContentType(Path filePath) throws IOException {
        return Files.probeContentType(filePath);
    }

}