package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


import br.com.WorkOn.model.Requisitos;
import br.com.WorkOn.model.Vaga;

public class RequisitosDAO extends Repository {

	
	/**
	 * Método para que o recrutador insira os conhecimentos e os níveis necessários para a vaga
	 * @param cd_vaga
	 * @param lista com os requisitos
	 */
	public void inserirRequisitos(int cd_vaga, Set<Integer> requisitos) {

		for (Integer req : requisitos) {
			int Requi = req;

			String comando = "INSERT INTO t_swo_requisitos_vaga (cd_vaga, cd_requisitos) VALUES (?,?)";
			PreparedStatement ps = null;
			try {
				ps = this.getConnection().prepareStatement(comando);
				ps.setInt(1, cd_vaga);
				ps.setInt(2, Requi);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro na execuçãso do SQL" + e.getMessage());
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
	}

	/**
	 * Método para o candidato inserir os conhecimentos e seus respectivos niveis
	 * @param codCandidato
	 * @param lista de conhecimentos
	 */
	public void inserirConhecimentosCand(int codCandidato, Set<Integer> conhecimentos) {

		for (Integer opcao : conhecimentos) {
			int Conhecimento = opcao;

			String comando = "INSERT INTO t_swo_checklist_requisitos (cd_candidato, cd_requisitos) VALUES (?,?)";
			PreparedStatement ps = null;
			try {
				ps = this.getConnection().prepareStatement(comando);
				ps.setInt(1, codCandidato);
				ps.setInt(2, Conhecimento);
				ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro na execuçãso do SQL" + e.getMessage());
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
	}
	
	/**
	 * Método para resgatar o código de uma vaga através do nome da mesma,esse método é importante para a realização do match
	 * @param nomeVaga
	 * @return código da vaga
	 */
	public static int codVaga(String nm_vaga) {
		String sql = "SELECT CD_VAGA FROM T_SWO_VAGA WHERE NM_VAGA = ?";
		ResultSet rs = null;
		PreparedStatement ps = null;
		Integer cd_vaga = 0;
		try {

			ps = getConnection().prepareStatement(sql);
			ps.setString(1, nm_vaga);
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					cd_vaga = rs.getInt("CD_VAGA");
				}
				return cd_vaga;

			}
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
			if (Repository.connection != null)
				Repository.closeConnection();
		}
		return cd_vaga;

	}

	/**
	 * Método para resgatar todos os requisitos que pertecem a uma vaga em específico
	 * @param codigoVaga
	 * @return lista com os requisitos da vaga 
	 */
	public List<Integer> listaConheVaga(int codigoVaga) {
		String comando = "SELECT CD_REQUISITOS FROM T_SWO_REQUISITOS_VAGA WHERE CD_VAGA =? ";
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Integer> lista = new LinkedList<>();

		try {

			ps = this.getConnection().prepareStatement(comando);
			ps.setInt(1, codigoVaga);
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					lista.add(rs.getInt("CD_REQUISITOS"));
				}

				return lista;
			}
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
		return lista;

	}

	/**
	 * Método para resgatar a lista de conhecimentos do candidato
	 * @param codCand
	 * @return lista de conhecimentos do candidato
	 */
	public List<Integer> listaConheCand(int codCand) {
		String comando = "SELECT CD_REQUISITOS FROM T_SWO_CHECKLIST_REQUISITOS WHERE CD_CANDIDATO =? ";
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Integer> lista = new LinkedList<>();

		try {

			ps = this.getConnection().prepareStatement(comando);
			ps.setInt(1, codCand);
			rs = ps.executeQuery();
			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					lista.add(rs.getInt("CD_REQUISITOS"));
				}

				return lista;
			}
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
		return lista;
	}

}