package br.com.luishep;

import main.java.br.com.luishep.DAO.IClientDAO;
import main.java.br.com.luishep.domain.Client;
import br.com.luishep.DAO.ClientDAOMock;
import main.java.br.com.luishep.services.ClientService;
import main.java.br.com.luishep.services.IClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientServiceTest {

    private IClientService clientService;

    private Client client;

    public ClientServiceTest() {
        IClientDAO dao = new ClientDAOMock();
        clientService = new ClientService(dao);
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
    }

    @Test
    public void clientResearch() {
        Client clientConsulted = (Client) clientService.researchByCpf(client.getCpf());

        Assert.assertNotNull(clientConsulted);
    }

    @Test
    public void saveClient() {
        Boolean returns = clientService.save(client);

        Assert.assertTrue(returns);
    }

    @Test
    public void deleteClient() {
        clientService.delete(client.getCpf());
    }

    @Test
    public void editClient() {
        client.setName("José Santos");
        clientService.edit(client);

        Assert.assertEquals("José Santos", client.getName());
    }
}