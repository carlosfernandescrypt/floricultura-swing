package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListarProdutos {
    public static List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("tipo"),
                        rs.getDouble("preco"));
                produto.setIdProduto(rs.getInt("id_produto"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
