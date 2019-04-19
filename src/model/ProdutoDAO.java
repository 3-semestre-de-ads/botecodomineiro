package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.BD;

public class ProdutoDAO {
			public boolean cadastrar(Produto produto) {
			boolean retorno = false;
			if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "INSERT INTO produto(nome, unidade, descricao, preco, tipo, idfornecedor)" 
			+ "VALUES ('" + produto.getNome() + "','"+ produto.getUnidade() + "','" + produto.getDescricao() + "','" + produto.getPreco()
			+ "','" + produto.getTipo() + "'," + "(SELECT idfornecedor FROM fornecedor where nomefantasia = '" + produto.getFornecedor() + "'))";

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do produto", "Falha no cadastro", 0);
				}

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inserção do produto no banco", 0);
			}

		}
		return retorno;
}
			public static ResultSet consultarForn() {
			ResultSet resultado = null;
			String sql = "SELECT nomefantasia FROM fornecedor ORDER BY nomefantasia";
			if (BD.conexao) {
				try {
					BD.st = BD.con.prepareStatement(sql);
					BD.rs = BD.st.executeQuery();
					resultado = BD.rs;
				}catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Erro ao realizar a consulta de fornecedores", 0);
				}
			}
			return resultado;
}
}
