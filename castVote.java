import java.rmi.*;



public interface castVote extends Remote
{
    public void vote(int choice, int ticket)throws RemoteException;
    public String getVoteResults()throws RemoteException;
    public int generateUniqueID(int max) throws RemoteException;
    public void setMaxparticipants(int maxParticipants) throws RemoteException;
    public int getMaxparticipants ()throws RemoteException;
    public int requestTicket() throws RemoteException;
} 