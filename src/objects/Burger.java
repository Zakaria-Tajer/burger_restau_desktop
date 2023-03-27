package objects;

public class Burger {
    public String userBurger;
    public String userSize;
    public String userBun;
    public Boolean userKetchup;
    public Boolean userMustard;
    public Boolean userMayonaise;
    public Integer userQuantity;
    public Integer cost;
    
    public Burger(String userBurger, String userSize, String userBun, Boolean userKetchup, Boolean userMustard, Boolean userMayonaise, Integer userQuantity, Integer cost) {
	this.userBurger = userBurger;
        this.userSize  = userSize;
	this.userBun = userBun;
	this.userKetchup = userKetchup;
	this.userMustard = userMustard;
	this.userMayonaise = userMayonaise;
        this.userQuantity = userQuantity;
        this.cost = cost;
    }
@Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        //sb.append(this.userSize).append(" ").append(this.userBurger).append(" x").append(this.userQuantity).append("\n");
       // System.out.println(sb);
        //return sb.toString();
        return String.format(this.userSize + " " + this.userBurger + " x" + this.userQuantity);
    }
}
