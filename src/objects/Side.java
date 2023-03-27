package objects;

public class Side {
    public String userSide;
    public String userSize;
    public Integer userQuantity;
    public Integer cost;
    
    public Side(String userSide, String userSize, Integer userQuantity, Integer cost){
        this.userSide = userSide;
        this.userSize = userSize;
        this.userQuantity = userQuantity;
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        //sb.append(this.userSize).append(" ").append(this.userSide).append(" x").append(this.userQuantity).append("\n");
        //System.out.println(sb);  
        //return sb.toString();
        return String.format(this.userSize + " " + this.userSide + " x" + this.userQuantity);
    }
}
