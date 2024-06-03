import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class client {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){ 
            Registry registry = LocateRegistry.getRegistry("localhost");
            castVote votingSystem =(castVote)registry.lookup("Votingsystem");

            int maxParticipants = votingSystem.getMaxparticipants();
            int ticket = votingSystem.requestTicket();
            System.out.println("your id is:"+ticket);

           
            if(ticket > 0 && ticket <= maxParticipants){
                System.out.println("Enter your choice: ");
                int choice =scanner.nextInt();
                votingSystem.vote(choice,ticket);
                if (choice <1 || choice>3){
                    System.out.println("Invalid vote");
                    System.out.println("Your vote is not casted");
                }
                else{
                String results = votingSystem.getVoteResults();
                System.out.println("Voting Results:\n" + results);
                }
            }else{
                System.out.println("Invalid ID");
            }
           
        }
        catch(Exception e){
            System.err.println("Client exception: " + e.toString());
        }
        
    }

}

