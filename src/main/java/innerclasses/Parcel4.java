package innerclasses;

public class Parcel4 {
    private class pContents implements Contents{
        private int i =11;
        public int value() {return i;}
    }
    protected class pDestination implements Destination{
        private String label;
        private pDestination(String whereTo){
            label = whereTo;
        }
        public String readLabel(){
            return label;
        }
    }
    public Destination destination(String s){
        return new pDestination(s);
    }
    public Contents contents(){
        return new pContents();
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
    }
}
