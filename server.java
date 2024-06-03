import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class server {
    public static void main(String[] args) {
        try{
            System.out.println("Voting server is starting...");

            castVoteImp voting = new castVoteImp();
            voting.setMaxparticipants(10);

            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Votingsystem", voting);

            System.out.println("Voting server is running...");

        }catch(Exception e){
            System.out.println("Server error"+e.getMessage());
        }
    }
}
