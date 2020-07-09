//
public class Dog extends Pet {
    private int minutes;
    private double droolRate;
    public String type = "dog";
    /**
     * Dog constructor takes
     * @param name
     * @param health
     * @param painLevel
     * chain with the second constructor
     */
    public Dog(String name, double health, int painLevel){
        this(name, health, painLevel, 5.0);
    }
    /**
     * Dog secon contructor takes
     * @param name represent the name
     * @param health represent the health
     * @param painLevel represent the pain level
     * @param droolRate represent the drool rate
     */
    public Dog(String name, double health, int painLevel, double droolRate){
        super(name, health, painLevel);
        
        this.droolRate = droolRate;
    }
    /**
     * getter for drool rate
     * @return
     */
    public double getDroolRate(){
        return droolRate;
    }
    @Override
    /**
     * mehtos override parent's treat method
     */
    public int treat() {
        // TODO Auto-generated method stub
        super.heal();
        
        if (droolRate < 3.5) {
            minutes = (int) (Math.ceil(super.getPainLevel() * 2)/super.getHealth());
        } else if (droolRate >= 3.5 && droolRate <= 7.5){
            minutes = (int) (Math.ceil(super.getPainLevel()/super.getHealth()));
        } else {
            minutes = (int) (Math.ceil(super.getPainLevel()/(super.getHealth()*2)));
        }
        return minutes;
    }
    public void speak(){
        super.speak();
        for (int i = 0; i < super.getPainLevel(); i++){
            if (getPainLevel() > 5){
                System.out.print("BARK ");  
            } else {
                System.out.print("bark ");
            }
        }
    }
    public boolean equals(Object o){
        if(!(o instanceof Dog)) {
            return false;
        }
        Dog d = (Dog) o;
        return super.equals(d) && (d.droolRate == droolRate);
    }
}