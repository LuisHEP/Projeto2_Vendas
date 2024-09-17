/**
 * @author
 */

package main.java.br.com.luishep.domain;


import java.util.Objects;

public class Client implements IPersister {

    private String name;
    private Long cpf;
    private Long phone;
    private String andress;
    private Integer number;
    private String city;
    private String state;

    public Client() {
    }

    public Client(String name, Long cpf, Long phone, String andress, Integer number, String city, String state) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.andress = andress;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAndress() {
        return andress;
    }

    public void setAndress(String andress) {
        this.andress = andress;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
   public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Client cliente = (Client) obj;

        return Objects.equals(cpf, cliente.cpf);
   }

   @Override
   public int hashCode() {
        return Objects.hash(cpf);
   }

    @Override
    public String toString() {
        return "Cliente{ " +
                "NOME = '" + name + '\'' +
                ", CPF = " + cpf + " " +
                '}';
    }
}
