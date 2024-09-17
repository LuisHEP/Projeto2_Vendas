/**
 * @author João Paulo
 */

package main.java.br.com.luishep.services;

import main.java.br.com.luishep.DAO.IClientDAO;
import main.java.br.com.luishep.domain.Client;
import main.java.br.com.luishep.domain.IPersister;

public class ClientService implements IClientService{

    private IClientDAO clientDAO;

    public ClientService(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public boolean save(Client client) {
        return clientDAO.save(client);
    }

    @Override
    public IPersister researchByCpf(Long cpf) {
        return clientDAO.research(cpf);
    }

    @Override
    public void delete(Long cpf) {
        clientDAO.deleteClient(cpf);
    }

    @Override
    public void edit(Client client) {
        clientDAO.edit(client);
    }
}
