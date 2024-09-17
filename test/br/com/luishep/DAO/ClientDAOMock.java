/**
 * @author
 */

package br.com.luishep.DAO;

import main.java.br.com.luishep.DAO.IClientDAO;
import main.java.br.com.luishep.domain.Client;
import main.java.br.com.luishep.domain.IPersister;
import main.java.br.com.luishep.exceptions.TypeKeyNotFound;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ClientDAOMock implements IClientDAO {
    @Override
    public Boolean registerClient(IPersister entity) throws TypeKeyNotFound {
        return true;
    }

    @Override
    public void deleteClient(Serializable value) {

    }

    @Override
    public void editClient(IPersister entity) throws TypeKeyNotFound {

    }

    @Override
    public IPersister research(Long value) {
        Client client = new Client();
        client.setCpf(value);
        return client;
    }

    @Override
    public Collection researchAll() {
        return List.of();
    }

    @Override
    public Boolean save(Client client) {
        return true;
    }

    @Override
    public void edit(Client client) {

    }
}
