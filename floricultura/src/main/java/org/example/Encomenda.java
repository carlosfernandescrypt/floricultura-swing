package org.example;

public class Encomenda {
    private int idEncomenda;
    private Cliente cliente;
    private String localEntrega;

    public Encomenda(Cliente cliente, String localEntrega) {
        this.cliente = cliente;
        this.localEntrega = localEntrega;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }
}
