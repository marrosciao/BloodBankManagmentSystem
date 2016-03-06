package registeration;

/**
 *
 * @author student
 */
public class Main {

    public static void main(String[] args) {
        RegistrationForm  rf = new RegistrationForm();
        rf.main(args);
        
        System.out.println(rf.uname+","+rf.name+","+rf.pass+","+rf.email+","+rf.address+","+rf.dob);
        
    }

}
