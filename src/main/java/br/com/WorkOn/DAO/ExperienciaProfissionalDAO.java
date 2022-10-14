package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.WorkOn.model.ExperienciaProfissional;

public class ExperienciaProfissionalDAO extends Repository {

	/**
	 * Nesse método é possível a inserção da experiência profissional de um
	 * candidato
	 * 
	 * @param cd_cand
	 * @param descricao
	 * @param nomeEmpresa
	 * @param inicio
	 * @param termino
	 */
	public void inserirExpProf(int cd_cand, ExperienciaProfissional EP, String dataInicio, String dataTermino) {
		if (dataTermino != null) {
			String sql = "INSERT INTO t_swo_experiencia_profissional (cd_candidato,ds_cargo,nm_empresa,dt_inicio,dt_termino) VALUES (?,?,?, TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'))";
			PreparedStatement ps = null;
			try {
				ps = getConnection().prepareStatement(sql);
				ps.setInt(1, cd_cand);
				ps.setString(2, EP.getCargo());
				ps.setString(3, EP.getNomeEmpresa());
				ps.setString(4, dataInicio);
				ps.setString(5, dataTermino);
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
		} else {
			String sql = "INSERT INTO t_swo_experiencia_profissional (cd_candidato,ds_cargo,nm_empresa,dt_inicio) VALUES (?,?,?,TO_DATE(?,'DD/MM/YYYY'))";
			PreparedStatement ps = null;
			try {
				ps = getConnection().prepareStatement(sql);
				ps.setInt(1, cd_cand);
				ps.setString(2, EP.getCargo());
				ps.setString(3, EP.getNomeEmpresa());
				ps.setString(4, dataInicio);
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
	}
}