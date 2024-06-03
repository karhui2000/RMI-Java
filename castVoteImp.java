import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;

public class castVoteImp extends UnicastRemoteObject implements castVote
{
    public int voteCount1;
    public int voteCount2;
    public int voteCount3;
    public int invalidVoteCount;
    public int maxParticipants;
    public ArrayList<Integer> unique;
    public HashMap<Integer,Boolean> validTickets;
    

    public castVoteImp() throws RemoteException{
        this.voteCount1 =0;
        this.voteCount2 =0;
        this.voteCount3=0;
        this.invalidVoteCount =0;
        this.unique = new ArrayList<>();
        this.validTickets = new HashMap<>();
        
    }
    public int requestTicket()throws RemoteException{
        int ticket = generateUniqueID(20);
        validTickets.put(ticket, true);
        return ticket;
    }
    public void vote(int choice,int ticket){
        if(!validTickets.containsKey(ticket)){
            System.out.println("Invalid ticket");
            return;
        }
        if (choice ==1){
            voteCount1++;
        }else if (choice==2){
            voteCount2++;
        }else if (choice ==3){
            voteCount3++;
        }else{
            invalidVoteCount++;
            System.out.println("Invalid vote");
        }
    }
    public String getVoteResults()throws RemoteException{
        return "Option 1: " + voteCount1 + ", Option 2: " + voteCount2 + ", Option 3: " + voteCount3 + ", Invalid vote:"+invalidVoteCount;
    }
    public void setMaxparticipants(int maxParticipants) throws RemoteException{
        this.maxParticipants = maxParticipants;
    }
    public int getMaxparticipants()throws RemoteException{
        return maxParticipants;
    }
    public int generateUniqueID(int max){
        if (unique.isEmpty()){
            for(int i =1;i<max;i++){
                unique.add(i);
            }
            Collections.shuffle(unique);
        }
        return unique.remove(0);
    }
}   