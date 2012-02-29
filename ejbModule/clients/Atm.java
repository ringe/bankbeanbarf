package clients;

import hbf.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Atm {

	/**
	 * @param args
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
		Context context = new InitialContext(props);
		BankBeanRemote bank = (BankBeanRemote)context.lookup("aa/BankBeanRemote");
		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(bank.motd());

		System.out.println("Insert your card number (pretend you inserted your card: ");
        String card = r.readLine();
        System.out.println("Enter your PIN: ");
        String pin = r.readLine();

        if (verify(card, pin)) {
            boolean noMatch = true;
            do {
            	System.out.println(bank.motd());
            	noMatch= false;
            } while (noMatch);
        }

    }
    
    // Dummy verification method.
    static boolean verify(String card, String pin) {
    	// check for a "valid" card number - no real check here
    	if (card.length() != 16)
    		return false;
    	
        // this only checks if your pin is 0000
        return pin.toString() == "0000";
    }

    // Dummy change method.
    static void change(String login, char[] password) {
        // modify this method to change
        // password according to your rules.
    }

}
