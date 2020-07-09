public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;
    /**
     * Pet class takes in
     * @param name represent the name
     * @param health represent the health
     * @param painLevel represent the pain level
     */
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
    /**
     * getter for pet's name
     * @return the pet's name
     */
    public String getName(){
        return name;
    }
    /**
     * getter for pet's health
     * @return the pet's health
     */
    public double getHealth(){
        return health;
    }
    /**
     * Setter for pet's health
     * @param param
     */
    public void setHealth(double param){
        if (param >= 0.0 && param <= 1.0){
            health = param;
        }
    }
    /**
     * getter for pet's pain level
     * @return pain level
     */
    public int getPainLevel(){
        return painLevel;
    }
    /**
     * setter to pet's pain level
     * @param param
     */
    public void setPainLevel(int param){
        if (param >= 0 && param <= 10){
            painLevel = param;
        }
    }
    /**
     * method for treat pet
     * @return boolean
     */
    public abstract int treat();
    public void speak(){
        if (painLevel > 5){
            System.out.printf("HELLO MY NAME IS %s\n", name.toUpperCase());
        } else {
            System.out.printf("Hello my name is %s\n", name);
        }
    }
    /**
     * boolean method takes in 
     * @param o representing the pet object
     */
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
    /**
     * method to heal pet
     */
    protected void heal(){
        setHealth(1.0);
        setPainLevel(1);
    }
}
