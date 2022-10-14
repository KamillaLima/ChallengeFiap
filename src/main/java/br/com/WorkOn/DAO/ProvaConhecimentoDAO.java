package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import br.com.WorkOn.model.ProvaConhecimento;

public class ProvaConhecimentoDAO extends Repository {

	
	/**
	 * Método para inserir uma prova de conhecimento para uma vaga
	 * @param cd_vaga
	 * @param tema
	 */
	public void inserirProva(int cd_vaga, String tema) {
		String sql = "INSERT INTO t_swo_prova_conhecimento (cd_vaga, ds_assunto) VALUES (?,?)";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cd_vaga);
			ps.setString(2, tema);
		
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro na execução do SQL" + e.getMessage());
		} finally {
			try {
				if (ps != null) 
					ps.close();
			} catch (SQLException e) {
				System.out.println("Erro ao tentar fechar o Statement " + e.getMessage());
			}
			if (this.connection != null) {
				this.closeConnection();
			}
		}
	}
	
	public Map<Integer,ProvaConhecimento> puxarProva(String assuntoTeste) {
		
		
		Map<Integer,ProvaConhecimento> q = new HashMap<>();
		
		ResultSet rs = null;
		PreparedStatement ps = null;

		
		String sql = "SELECT tx_questoes,ds_alternativa_a,ds_alternativa_b,ds_alternativa_c,ds_alternativa_d,ds_alternativa_correta,cd_questoes "
				+ "FROM t_swo_banco_questoes where ds_assunto = ?";
		try {

			ps = this.getConnection().prepareStatement(sql);
			ps.setString(1, assuntoTeste);
			rs = ps.executeQuery();
			
			while (rs.next()) {
					q.put(rs.getInt("CD_QUESTOES"), new ProvaConhecimento(rs.getString("TX_QUESTOES"),rs.getString("DS_ALTERNATIVA_A"),
							rs.getString("DS_ALTERNATIVA_B"),rs.getString("DS_ALTERNATIVA_C"),rs.getString("DS_ALTERNATIVA_D"),rs.getString("DS_ALTERNATIVA_CORRETA")));
	
			
			}
			return q;
		} catch (SQLException e) {
			System.out.println("Erro na execu��o do SQL: " + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println("Erro ao tentar fechar o Statment ou o ResultSet");
			}
			if (this.connection != null)
				this.closeConnection();
		}

	
	
		return q;
		
	
	
	}
}