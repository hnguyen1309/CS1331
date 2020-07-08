import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Driver class to demonstrate a Clinic treating various patients
 */
public class Clinic {
    private File patientFile;
    private int day;
    public Clinic(String fileName) throws FileNotFoundException{
        this(new File (fileName));
    }
    public Clinic(File file){
        patientFile = file;
        this.day = 1;
    }
    public String addTime(String timeIn, int treatmentTime){
        int hours = Integer.parseInt(timeIn) / 100;
        int minutes = Integer.parseInt(timeIn) % 100;
        if (treatmentTime + minutes >= 60){
            hours = hours + (treatmentTime + minutes) / 60;
            minutes = minutes + (treatmentTime + minutes) % 60;
        } else {
            minutes = minutes + treatmentTime;
        }
        int timeOut = hours * 100 + minutes;
        if (hours < 10) {
            return String.format("0%s",timeOut);
        } else {
            return String.format("%s",timeOut);
        }
    }
    public String nextDay(File file) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        Scanner fileScan = new Scanner(file);
        String name = "";
        String type = "";
        double rate = 0;
        int miceRate = 0;
        String timeIn = "";
        String timeOut = "";
        String line = null;
        Pet pet = null;
        String [] tokens = null;
		double health = 0;
        int painLevel = 0;
        String info = null;
        day = day + 1;
        while (fileScan.hasNextLine()){
            line = fileScan.nextLine();
            tokens = line.split(",");
            name = tokens[0];
            type = tokens[1];
            rate = Double.parseDouble(tokens[2]);
            timeIn = tokens[3];
            boolean healthValid = false;
            if(type.equals("Dog") || type.equals("Cat")) {
                while (!healthValid){
                    try {
                        System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", name, type, timeIn, name);
                        health = input.nextDouble();
                        healthValid = true;
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Please enter a decimal number");
                    }
                }
            
                boolean painLevelValid = false;
                while (!painLevelValid){
                    try {
                        System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);           
                        painLevel = input.nextInt();
                        painLevelValid = true;
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Please enter an integer number");
                    }
                }
                if(type.equals("Dog")){
                    pet = new Dog(name,health,painLevel,rate);
                } else if (type.equals("Cat")) {
                    pet = new Cat(name,health,painLevel,miceRate);
                }
                pet.speak();
                System.out.println();
                health = pet.getHealth();
                painLevel = pet.getPainLevel();
                pet.treat();
                timeOut = addTime(timeIn,pet.treat());
                //[Name],[Species],[DroolRate/MiceCaught],[Day],[EntryTime],[ExitTime],[InitialHealth],[InitialPainLevel]
                info += String.format("%s,%s,%.1f,%d,%s,%s,%.1f,%d",name, type, rate, day, timeIn, timeOut, health, painLevel);
                
            } else {
                throw new InvalidPetException();
            }       
        }
        fileScan.close();
        input.close();
        return info;
    }

    String nextDay(String fileName) throws FileNotFoundException{
        return this.nextDay(new File(fileName));
    }

    public boolean addToFile(String patientInfo){
        PrintWriter writeFile;
        Scanner fileScan = null;
        String [] tokens = patientInfo.split(",");
        String name = tokens [0];
        String detailAdded = String.format(",%s,%s,%s,%s,%s", tokens[3], tokens[4], tokens[5], tokens[6], tokens[7]);
        String [] patientList = null;
        String Appointment = "";



        try {
            fileScan = new Scanner(patientFile);
            String line = null;



            while(fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                Appointment = Appointment + line + "\n";



            }
            patientList = Appointment.split("\n");
            fileScan.close();

            
        } catch(FileNotFoundException e){
            return false;
        }

        try {
            writeFile = new PrintWriter(patientFile);
            boolean oldPatient = false;
            for (String patient : patientList) {
                if (patient.contains(name)) {
                    writeFile.println(patient + detailAdded + "\n");
                    oldPatient = true;
                } else {
                    writeFile.println(patient + "\n");
                }
            }
            if(!oldPatient){
                writeFile.println(patientInfo);
            }
            writeFile.close();
            return true;


            
        } catch (Exception e) {
            return false;
        }
    }
}




    