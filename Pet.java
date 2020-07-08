public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;
    public Pet(String name, double health, int painLevel){
        this.name = name;
        this.health = health;
        this.painLevel = painLevel;
        if (health < 0.0){
            health = 0.0;
        } else if (health > 1.0){
            health = 1.0;
        }
        if (painLevel < 0){
            painLevel = 0;
        } else if (painLevel > 10){
            painLevel = 10;
        }
    } 
    public String getName(){
        return name;
    }
    public double getHealth(){
        return health;
    }
    public void setHealth(double param){
        if (param >= 0.0 && param <= 1.0){
            health = param;
        }
    }
    public int getPainLevel(){
        return painLevel;
    }
    public void setPainLevel(int param){
        if (param >= 0 && param <= 10){
            painLevel = param;
        }
    }
    public abstract int treat();
    public void speak(){
        if (painLevel > 5){
            System.out.printf("HELLO MY NAME IS %s\n", name.toUpperCase());
        } else {
            System.out.printf("Hello my name is %s\n", name);
        }
    }
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Pet pet = (Pet) o;
        return (pet.getName() == name);
    }
    protected void heal(){
        setHealth(1.0);
        setPainLevel(1);
    }
}
