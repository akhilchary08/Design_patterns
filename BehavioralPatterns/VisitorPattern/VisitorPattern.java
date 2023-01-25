

interface Visitor {
    public int visit(Necessity necessityItem);

    public int visit(Luxury luxuryItem);
}


class TaxVisitor implements Visitor{
    public TaxVisitor(){
    }
    public int visit(Necessity necessityItem)
    {
        return 20+necessityItem.getPrice();
    }
    public int visit(Luxury luxuryItem){
        return 100+luxuryItem.getPrice();
    }
}


interface Visitable{
    public int accept(Visitor visitor);
}

class Necessity implements Visitable{
    private int price;
    Necessity(int cost){
        price=cost;
    }
    public int accept(Visitor visitor)
    {
        return visitor.visit(this);
    }
    public int getPrice(){
        return price;
    }

}

class Luxury implements Visitable{
    private int price;
    Luxury(int cost){
        price=cost;
    }
    public int accept(Visitor visitor){
        return visitor.visit(this);
    }
    public int getPrice()
    {
        return price;
    }
    
}


public class VisitorPattern {
    public static void main(String[] args){
        TaxVisitor tc=new TaxVisitor();

        Necessity rice=new Necessity(20);
        Luxury gold = new Luxury(200);
        
        System.out.println(rice.accept(tc));
        System.out.println(gold.accept(tc));
    }
    
}









