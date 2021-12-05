package services;

import java.util.List;


import models.Commandes;
import models.CommandesDAO;
import models.CommandesDAOImp;


public class CommandesServicesImp implements CommandesService {
	CommandesDAO cmds = new CommandesDAOImp(); 
	@Override
	public int add(Commandes e) {
		return cmds.add(e);
	}

	@Override
	public List<Commandes> findCommandByUser(String client) {
		return cmds.findCommandByUser(client);
	}

}
