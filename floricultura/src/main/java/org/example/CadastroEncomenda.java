package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroEncomenda {
    public static void cadastrarEncomenda(Encomenda encomenda) {
        String sqlVerificarCliente = "SELECT COUNT(*) FROM clientes WHERE id_cliente = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmtVerificar = conn.prepareStatement(sqlVerificarCliente)) {

            stmtVerificar.setInt(1, encomenda.getCliente().getIdCliente());
            ResultSet rs = stmtVerificar.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                String sql = "INSERT INTO encomendas (id_cliente, local_entrega) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, encomenda.getCliente().getIdCliente());
                    System.out.println("ID do cliente: " + encomenda.getCliente().getIdCliente());
                    stmt.setString(2, encomenda.getLocalEntrega());
                    stmt.executeUpdate();
                    System.out.println("Encomenda cadastrada com sucesso!");
                }
            } else {
                System.out.println("Cliente não encontrado! Não é possível cadastrar a encomenda.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
