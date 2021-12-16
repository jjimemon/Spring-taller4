package com.nttdata.eclipse_spring_taller4_JJM.services;

import java.util.List;
import java.util.Optional;

import com.nttdata.eclipse_spring_taller4_JJM.persistence.NttdataClient;

public interface NttdataClientManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newClient
	 */
	public void insertNewClient(final NttdataClient newClient);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedClient
	 */
	public void deleteClient(final NttdataClient deletedClient);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param IDClient
	 */
	public Optional<NttdataClient> findByIdClient(final Integer IDClient);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<NttdataClient>
	 */
	public List<NttdataClient> findAll();

	/*
	 * Obtiene todos los clientes con un nombre y apellido específico.
	 */
	public List<NttdataClient> findByNameAndLastName(String name, String lastname);

	/*
	 * Obtiene todos los clientes con un nombre específico.
	 */
	public List<NttdataClient> findByName(String name);

}
