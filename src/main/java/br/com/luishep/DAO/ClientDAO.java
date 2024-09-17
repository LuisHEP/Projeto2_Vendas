/**
 * @author
 */

package main.java.br.com.luishep.DAO;

import main.java.br.com.luishep.domain.Client;
import main.java.br.com.luishep.DAO.generics.GenericsDAO;
import main.java.br.com.luishep.domain.IPersister;

public abstract class ClientDAO extends GenericsDAO<Client, IPersister> implements IClientDAO{

    public ClientDAO() {
        super();
    }

    @Override
    public Class<Client> getTypeClass() {
        return Client.class;
    }

    @Override
    public void updateData(IPersister entity, IPersister entityRegistered) {

    }
}
