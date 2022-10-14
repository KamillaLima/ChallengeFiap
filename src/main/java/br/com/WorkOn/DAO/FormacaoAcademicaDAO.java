package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class FormacaoAcademicaDAO extends Repository{

	
	/**
	 * Nesse método é possível inserir uma formação academica ligada a um candidato
	 * @param cd_candidato
	 * @param inicio
	 * @param termino
	 * @param nomeCurso
	 * @param instituicao
	 */
	public  void inserirFormacaoAcademica(int cd_candidato,String inicio,String termino,String nomeCurso,String instituicao) {
			String sql = "INSERT INTO t_swo_formacao_academica (cd_candidato,dt_inicio,dt_termino,nm_curso, nm_instituicao_ensino) VALUES (?,TO_DATE(?,'MM/YYYY'),TO_DATE(?,'MM/YYYY'),?,?)";
			PreparedStatement ps = null;
			try {
				ps = getConnection().prepareStatement(sql);
				ps.setInt(1, cd_candidato);
				ps.setString(2, inicio);
				ps.setString(3, termino);
				ps.setString(4, nomeCurso);
				ps.setString(5, instituicao);
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