package model;

public class Board {

    // Fake prototypes for cards
    private Train_Car_Deck tc;
    private Destination_Ticket_Deck dtd;
    private Train_Car_Discard tcd;
    private Train_Car_Faceup tcf;
    private Longest_Path lp;
    private class Train_Car_Deck {
        private void Shuffle() {}
    }
    private class Destination_Ticket_Deck {
        private void Shuffle() {}
    }
    private class Train_Car_Discard {
    }
    private class Train_Car_Faceup {
    }
    private class Longest_Path {
    }


    // List of all strings
    String routes[] = new String[] {"Vancouver","Calgary","Winnipeg","Seattle","Portland","Helena","Salt Lake City",
            "Denver","San Francisco","Las Vegas","Santa Fe","Los Angeles","Phoenix","El Paso","Oklahoma City",
            "Duluth","Omaha","Kansas City","Dallas","Houston","Chicago","Saint Louis","Little Rock","New Orleans",
            "Nashville","Toronto","Pittsburgh","Atlanta","Miami","Charleston","Washington","Raleigh","New York",
            "Boston","Montreal","Sault Ste. Marie"};

    Board() {
        Init_Train_Cards();
        Init_Destination_Cards();
        Init_Discard_Cards();
        Init_Face_Up_Cards();
        Init_Longest_Path_Card();
    }
    private void Init_Train_Cards() {
        this.tc = new Train_Car_Deck();
        tc.Shuffle();
    }
    private void Init_Destination_Cards() {
        this.dtd = new Destination_Ticket_Deck();
        dtd.Shuffle();
    }
    private void Init_Discard_Cards() {
        this.tcd = new Train_Car_Discard();
    }
    private void Init_Face_Up_Cards() {
        // 5 cards
        this.tcf = new Train_Car_Faceup();
    }
    private void Init_Longest_Path_Card() {
        // 1 card
        this.lp = new Longest_Path();
    }

}