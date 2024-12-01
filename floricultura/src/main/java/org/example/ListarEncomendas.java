package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListarEncomendas {
    public static List<Encomenda> listarEncomendas() {
        List<Encomenda> encomendas = new ArrayList<>();
        String sql = "SELECT e.id_encomenda, e.local_entrega, c.nome AS cliente_nome FROM encomendas e JOIN clientes c ON e.id_cliente = c.id_cliente";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString("cliente_nome"), "", "");
                Encomenda encomenda = new Encomenda(cliente, rs.getString("local_entrega"));
                encomenda.setIdEncomenda(rs.getInt("id_encomenda"));
                encomendas.add(encomenda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return encomendas;
    }
}
