package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.WorkOn.model.Candidato;
import br.com.WorkOn.model.LoginCandidato;
import br.com.WorkOn.model.RedesSociais;

public class CandidatoDAO extends Repository {
	
	/**
	 * Nesse método é possível recuperar o código do candidato,através do email e da senha do candidato
	 * @param email
	 * @param senha
	 * @return codigo do candidato
	 */
	public int codigoCandidato(LoginCandidato c)  {
		String sql = "SELECT CD_CANDIDATO FROM T_SWO_CANDIDATO WHERE DS_EMAIL = ? and DS_SENHA = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int codCand = 0;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getSenha());

			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					codCand = rs.getInt("CD_CANDIDATO");
				}
				return codCand;

			}
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
		return codCand;
	}
	
	/**
	 *  Nesse método é possível inserir as informações no currículo do candidato.
	 * @param c - Classe candidato(com os atributos nome,telefone e genero)
	 * @param nascimento - data de nascimento do candidato
	 * @param rs - Classe RedesSociais(com os atributos linkGitHub e linkLinkedin)
	 * @param email - email do candidato
	 * @param senha - senha do email do candidato
	 */
	public void inserirCurriculo(Candidato c,String dataNascimento,RedesSociais rs,int codigoCandidato ) {

		String comando = "UPDATE T_SWO_CANDIDATO SET NM_CANDIDATO=?,DT_NASCIMENTO = TO_DATE(?,'yyyy/mm/dd'), NR_TELEFONE=?,DS_GENERO=?,DS_GITHUB=?,DS_LINKEDIN=?WHERE CD_CANDIDATO=? ";

		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(comando);
			ps.setString(1, c.getNome());
			ps.setString(2, dataNascimento);
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getGenero());
			ps.setString(5, rs.getLinkGithub());
			ps.setString(6, rs.getLinkLinkedin());
			ps.setInt(7, codigoCandidato);
			

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
