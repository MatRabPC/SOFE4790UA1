import java.io.*; 
import java.io.DataInputStream; 
import java.net.*; 
import java.util.Arrays;

class ScavServ 
{ 
    public static void main(String[] arg)throws Exception 
    { 
        ServerSocket server;
		Socket client;
		DataInputStream in;
		PrintStream w;
		DataInputStream r;
        
		ScavServ es = new ScavServ();
        es.run(7896);
	}		
		
		void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true) {
               Socket client = serverSocket.accept();
               Connection cc = new Connection(client);
            }
        } catch(Exception e) {
           System.out.println("Exception: "+e);
        }
    
		
		
    }
}
	
	
class Connection extends Thread {
    Socket client;
    PrintWriter out;
    BufferedReader in;
    

    public Connection(Socket s) { // constructor
       client = s;
       

       try {
           out = new PrintWriter(client.getOutputStream(), true);                   
           in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
       } catch (IOException e) {
           try {
             client.close();
           } catch (IOException ex) {
             System.out.println("Error while getting socket streams.."+ex);
           }
           return;
       }
        this.start(); // Thread starts here...this start() will call run()
    }
 
    public void run() {
      try {
		String [] anskey = {"mat", "deserves", "anne", "eh"};
		 
	String[] clientset = new String [anskey.length];
         String inputLine;
         while ((inputLine = in.readLine()) != null) {
		System.out.println("Received from: "+ client.getRemoteSocketAddress() + " Input: "+inputLine); 
		
			 	for (int i = 0; i < anskey.length; i++)
				{
					if (inputLine.equals(anskey[i])){
						clientset[i] = inputLine;
						out.println("yes " + Arrays.toString(clientset));
					}
					
				}
				
         }
       } catch (IOException e) {
           System.out.println("Exception caught...");
           System.out.println(e.getMessage());
       }
    }
	
}
