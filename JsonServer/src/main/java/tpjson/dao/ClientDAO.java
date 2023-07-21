package tpjson.dao;

import java.util.HashMap;
import java.util.Map;

import Model.Client;

public class ClientDAO {

	HashMap<Integer, Client> mesclients = new HashMap<>();

	public Client getId(int cle) {

		return mesclients.get(cle);

	}

	public HashMap<Integer, Client> populate(int n) {

		for (int i = 0; i <= n; i++) {
			Client client = new Client();// création d'un nouveau client à chaque itération

			String nom = "nom" + i;
			String prenom = "prenom" + i;

			
			client.setNom(nom);
			client.setPrenom(prenom);

			mesclients.put(i, client);

//		    for (int i = 0; i <= n; i++) {
//		        String nom = "nom" + i;
//		        String prenom = "prenom" + i;
//		        mesclients.put(i, new Client(nom, prenom));

		}
		return mesclients;

	}

}
