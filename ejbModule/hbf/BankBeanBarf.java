package hbf;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BankBean
 */
@Stateless
@LocalBean
public class BankBeanBarf implements BankBeanRemote {

    private String motd;

	/**
     * Default constructor. 
     */
    public BankBeanBarf() {
        motd = "Welcome to HBF!";
    }

    public String motd() { return motd; }
}
