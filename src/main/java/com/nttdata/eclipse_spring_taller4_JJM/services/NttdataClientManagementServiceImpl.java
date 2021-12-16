package com.nttdata.eclipse_spring_taller4_JJM.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.eclipse_spring_taller4_JJM.persistence.NttdataClient;
import com.nttdata.eclipse_spring_taller4_JJM.persistence.NttdataClientRepositoryI;

@Service
public class NttdataClientManagementServiceImpl implements NttdataClientManagementServiceI {

	@Autowired
	private NttdataClientRepositoryI daoClient;

	@Override
	public void insertNewClient(NttdataClient newClient) {
		// Verificación de nulidad e inexistencia.
		if (newClient != null && newClient.getIdClient() == null) {

			// Insercción de una nueva persona.
			daoClient.save(newClient);
		}

	}

	@Override
	public void deleteClient(NttdataClient deletedClient) {
		// Verificación de nulidad e inexistencia.
		if (deletedClient != null && deletedClient.getIdClient() != null) {

			// borrado de una nueva persona.
			daoClient.delete(deletedClient);
		}
	}

	@Override
	public Optional<NttdataClient> findByIdClient(Integer IDClient) {

		// Resultado.
		Optional<NttdataClient> client = null;

		// Verificación de nulidad.
		if (IDClient != null) {

			// Obtención del cliente por ID.
			client = daoClient.findById(IDClient);
		}

		return client;
	}

	@Override
	public List<NttdataClient> findAll() {

		// Resultado.
		List<NttdataClient> clientList = new ArrayList<NttdataClient>();

		// Obtención del cliente.
		clientList = daoClient.findAll();

		return clientList;
	}

	@Override
	public List<NttdataClient> findByNameAndLastName(String name, String lastname) {

		// Resultado.
		List<NttdataClient> clientList = new ArrayList<NttdataClient>();

		// Obtención del cliente
		clientList = daoClient.findByNameAndLastName(name, lastname);

		return clientList;
	}

	@Override
	public List<NttdataClient> findByName(String name) {
		// Resultado.
		List<NttdataClient> clientList = new ArrayList<NttdataClient>();

		// Obtención del cliente
		clientList = daoClient.findByName(name);

		return clientList;
	}

}
