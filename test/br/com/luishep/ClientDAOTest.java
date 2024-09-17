/**
 * @author João Paulo
 */

package br.com.luishep;

import br.com.luishep.DAO.ClientDAOMock;
import main.java.br.com.luishep.DAO.IClientDAO;
import main.java.br.com.luishep.domain.Client;
import main.java.br.com.luishep.exceptions.TypeKeyNotFound;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ClientDAOTest {

    private IClientDAO clientDao;

    private Client client;

    public ClientDAOTest() {
        clientDao = new ClientDAOMock();
    }

    @Before
    public void init() {
        client = new Client();
        client.setCpf(12345678912l);
        client.setName("Luis Henrique");
        client.setCity("RJ");
        client.setAndress("Rua x");
        client.setState("Rio de Janeiro");
        client.setPhone(123l);
        client.setNumber(1);

        clientDao.save(client);
    }

    @Test
    public void clientResearch() {
        Client clientConsulted = (Client) clientDao.research(client.getCpf());

        Assert.assertNotNull(clientConsulted);
    }

    @Test
    public void saveClient() throws TypeKeyNotFound {
        Boolean returns = clientDao.registerClient(client);

        Assert.assertTrue(returns);
    }

    @Test
    public void deleteClient() {
        clientDao.deleteClient(client.getCpf());
    }

    @Test
    public void editClient() throws TypeKeyNotFound {
        client.setName("José Santos");
        clientDao.editClient(client);

        Assert.assertEquals("José Santos", client.getName());
    }


    @Test
    public void researchAllTest() {
        List<Client> allClient = (List<Client>) clientDao.researchAll();

        Assert.assertNotNull(allClient);
    }
}
