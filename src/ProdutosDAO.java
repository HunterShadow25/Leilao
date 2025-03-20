/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
   

    public void cadastrarProduto(ProdutosDTO produto) {

        //conn = new conectaDAO().connectDB();
        conn = new conectaDAO().connectDB();

        String sql = "insert into produtos(nome, valor, status) values" + "(?,?,?)";

        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.execute();
            JOptionPane.showMessageDialog(null, "Dados cadastrados com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "erro no cadastro confime se os dados inseridos são validos\n caso o erro persistir reinicie o programa");
        }

    }

    public List<ProdutosDTO> listarProdutos() {
        conn = new conectaDAO().connectDB();

        String sql = "Select * from produtos";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            List<ProdutosDTO> lista = new ArrayList();
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setStatus(rs.getString("status"));
                produto.setValor(rs.getInt("valor"));
                lista.add(produto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

}
