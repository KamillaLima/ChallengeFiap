package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.WorkOn.model.LoginCandidato;

public class LoginCandidatoDAO extends Repository {

	/**
	 * No momento de cadastro,para evitar mais de uma conta cadastrada com o mesmo
	 * e-mail,é verificado se não existe alguma conta já linkada com o e-mail
	 * informado.
	 * 
	 * @param email
	 * @return true caso o email já esteja cadastrado,ou retorna false caso o email
	 *         não esteja cadastrado
	 */
	public boolean vefEmailCadastro(String ds_email) {
		String sqlVefEmail = "SELECT DS_EMAIL FROM T_SWO_CANDIDATO WHERE DS_EMAIL = ?";
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			ps = this.getConnection().prepareStatement(sqlVefEmail);
			ps.setString(1, ds_email);
			rs = ps.executeQuery();

			return rs.isBeforeFirst();
		} catch (SQLException e) {
			System.out.println("Erro na execuçao do SQL: " + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println("Erro ao tentar fechar o Statement ou o ResultSet" + e.getMessage());
			}
			if (this.connection != null)
				this.closeConnection();
		}
		return false;

	}

	/**
	 * Método para salvar um novo usuário
	 * 
	 * @param Classe LoginCandidato(com os atributos email e senha)
	 */
	public void salvarCadastro(LoginCandidato candidato) {

		String comando = "INSERT into T_SWO_CANDIDATO (DS_EMAIL, DS_SENHA) values (?,?)";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(comando);
			ps.setString(1, candidato.getEmail());
			ps.setString(2, candidato.getSenha());
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

	/**
	 * Método para um candidato realizar login em sua conta
	 * 
	 * @param Classe LoginCandidato (os atributos dessa classe são: email e senha)
	 * @return true caso o cadastro do usuário seja encontrado,false caso o cadastro
	 *         do usuário não seja encotrado no banco de dados
	 */
	public boolean loginCand(LoginCandidato candidato) {
		String comandoLogin = "SELECT * FROM T_SWO_CANDIDATO WHERE DS_EMAIL = ? AND DS_SENHA=?";
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = this.getConnection().prepareStatement(comandoLogin);
			ps.setString(1, candidato.getEmail());
			ps.setString(2, candidato.getSenha());
			rs = ps.executeQuery();
			return rs.isBeforeFirst();
		} catch (SQLException e) {
			System.out.println("Erro na execuçao do SQL: " + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println("Erro ao tentar fechar o Statement ou o ResultSet" + e.getMessage());
			}
			if (this.connection != null)
				this.closeConnection();
		}
		return false;
	}

}