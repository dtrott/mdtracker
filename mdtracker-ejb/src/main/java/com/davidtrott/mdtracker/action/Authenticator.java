package com.davidtrott.mdtracker.action;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
