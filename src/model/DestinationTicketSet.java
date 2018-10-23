package model;
import java.util.LinkedList;

public class DestinationTicketSet{
    private LinkedList<DestinationCard> Set;

    public DestinationTicketSet() {
        Set = new LinkedList<DestinationCard>();
    }

    public void Shuffle(){

    }
    public void Draw(){

    }
    public void RemoveCard(){

    }
    public DestinationCard getDestCard(){
        return Set.peek();
    }
}