public class Cat extends Pet {
    private int miceCaught;
    private int minutes;
    public String type = "cat";
    public Cat(String name, double health, int painLevel){
        this(name, health, painLevel, 0);
    }
    /**
     * methos
     * @param name
     * @param health
     * @param painLevel
     * @param miceCaught
     */
    public Cat(String name, double health, int painLevel, int miceCaught){
        super(name, health, painLevel);
        this.miceCaught = miceCaught;
        if (miceCaught < 0){
            miceCaught = 0;
        }
    }
    public int getMiceCaught(){
        return miceCaught;
    }
    @Override
    public int treat() {
        super.heal();
        if(miceCaught < 4){
            minutes = (int)(Math.ceil((super.getPainLevel() * 2)/ super.getHealth()));
        } else if (miceCaught >= 4 && miceCaught <= 7){
            minutes = (int) (Math.ceil(super.getPainLevel() / super.getHealth()));
        } else {
            minutes = (int) (Math.ceil(super.getPainLevel() / (super.getHealth() * 2)));
        }
        // TODO Auto-generated method stub
        return minutes;
    }
    public void speak(){
        super.speak();
        for (int i = 0; i < super.getPainLevel(); i++){
            if (super.getPainLevel() > 5){
                System.out.print("MEOW "); 
            } else {
                System.out.print("meow ");
            }
        }
    }
    public boolean equals(Object o){
        if(!(o instanceof Cat)) {
            return false;
        }
        Cat c = (Cat) o;
        return super.equals(c) && (c.miceCaught == miceCaught);
    }
}