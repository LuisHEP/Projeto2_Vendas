package main.java.br.com.luishep.DAO.generics;

import main.java.br.com.luishep.domain.Client;
import main.java.br.com.luishep.domain.IPersister;
import main.java.br.com.luishep.exceptions.TypeKeyNotFound;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericsDAO<T extends IPersister, E extends Serializable>{
    public Boolean registerClient(T entity) throws TypeKeyNotFound;

    public void deleteClient(Serializable value);

    public void editClient(IPersister entity) throws TypeKeyNotFound;

    public IPersister research(Long cpf);

    public Collection researchAll();

    public Boolean save(Client client);

    public void edit(Client client);
}
