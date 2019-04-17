package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.BD;

public class ProdutoDAO {
			public boolean cadastrar(Produto produto) {
			boolean retorno = false;
			if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "INSERT INTO produto(nome, unidade, descricao, preco, tipo)" 
			+ "VALUES ('" + produto.getNome() + "','"+ produto.getUnidade() + "','" + produto.getDescricao() + "','" + produto.getPreco() + "','" + produto.getTipo() + "')";

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
}
