package hbf;

import javax.ejb.Remote;

@Remote
public interface BankBeanRemote {
	public String motd();
}
