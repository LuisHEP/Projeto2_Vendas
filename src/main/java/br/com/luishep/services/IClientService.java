package main.java.br.com.luishep.services;

import main.java.br.com.luishep.domain.Client;
import main.java.br.com.luishep.domain.IPersister;

public interface IClientService {

    boolean save(Client client);

    IPersister researchByCpf(Long cpf);

    void delete(Long cpf);

    void edit(Client client);
}
