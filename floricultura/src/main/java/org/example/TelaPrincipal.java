package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Loja de Floricultura");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        JButton btnCadastrarProduto = new JButton("Cadastrar Produto");
        JButton btnCadastrarEncomenda = new JButton("Cadastrar Encomenda");
        JButton btnListar = new JButton("Listar Produtos, Encomendas e Clientes");
        add(btnCadastrarCliente);
        add(btnCadastrarProduto);
        add(btnCadastrarEncomenda);
        add(btnListar);
        btnCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente:");
                String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
                Cliente cliente = new Cliente(nome, endereco, telefone);
                CadastroCliente.cadastrarCliente(cliente);
            }
        });

        btnCadastrarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipo = JOptionPane.showInputDialog("Digite o tipo do produto:");
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
                Produto produto = new Produto(tipo, preco);
                CadastroProduto.cadastrarProduto(produto);
            }
        });

        btnCadastrarEncomenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                String localEntrega = JOptionPane.showInputDialog("Digite o local de entrega:");
                Cliente cliente = new Cliente(nomeCliente, "", ""); // Simplificado para exemplo
                Encomenda encomenda = new Encomenda(cliente, localEntrega);
                CadastroEncomenda.cadastrarEncomenda(encomenda);
            }
        });
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog listagemDialog = new JDialog(TelaPrincipal.this, "Listagem de Clientes, Produtos e Encomendas", true);
                listagemDialog.setLayout(new GridLayout(3, 1));
                listagemDialog.setSize(600, 400);
                List<Cliente> clientes = ListarClientes.listarClientes();
                String[] clienteColumns = {"ID", "Nome", "Endereço", "Telefone"};
                DefaultTableModel clienteModel = new DefaultTableModel(clienteColumns, 0);
                for (Cliente cliente : clientes) {
                    clienteModel.addRow(new Object[]{cliente.getIdCliente(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone()});
                }
                JTable clienteTable = new JTable(clienteModel);
                listagemDialog.add(new JScrollPane(clienteTable));
                List<Produto> produtos = ListarProdutos.listarProdutos();
                String[] produtoColumns = {"ID", "Tipo", "Preço"};
                DefaultTableModel produtoModel = new DefaultTableModel(produtoColumns, 0);
                for (Produto produto : produtos) {
                    produtoModel.addRow(new Object[]{produto.getIdProduto(), produto.getTipo(), produto.getPreco()});
                }
                JTable produtoTable = new JTable(produtoModel);
                listagemDialog.add(new JScrollPane(produtoTable));
                List<Encomenda> encomendas = ListarEncomendas.listarEncomendas();
                String[] encomendaColumns = {"ID", "Cliente", "Local de Entrega"};
                DefaultTableModel encomendaModel = new DefaultTableModel(encomendaColumns, 0);
                for (Encomenda encomenda : encomendas) {
                    encomendaModel.addRow(new Object[]{encomenda.getIdEncomenda(), encomenda.getCliente().getNome(), encomenda.getLocalEntrega()});
                }
                JTable encomendaTable = new JTable(encomendaModel);
                listagemDialog.add(new JScrollPane(encomendaTable));

                listagemDialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
