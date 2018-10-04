import java.io.*; 
import java.io.DataInputStream; 
import java.net.*; 

class ScavClient
 
{ 
    public static void main(String arg[])throws Exception 
    { 
        try{
        Socket client=new Socket("127.0.0.1",7896); 
        DataInputStream r=new DataInputStream(client.getInputStream()); 
        PrintStream w=new PrintStream(client.getOutputStream()); 
        DataInputStream in=new DataInputStream(System.in); 
		
		String userInput;
            while ((userInput = in.readLine()) != null) {
                w.println(userInput);
			
				System.out.println("Current thing is " + r.readLine());
		}
	    
		
		}catch (UnknownHostException e){
			System.out.println("Sock:"+e.getMessage()); 
		}catch (EOFException e){
			System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){
			System.out.println("IO:"+e.getMessage());
		}
    } 
}
