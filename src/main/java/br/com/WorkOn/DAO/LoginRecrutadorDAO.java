package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.WorkOn.model.LoginRecrutador;

public class LoginRecrutadorDAO extends Repository {

	public LoginRecrutadorDAO() {

	}

	/**
	 * Método para realizar login no perfil do recrutador
	 * 
	 * @param Classe LoginRecrutador(com os atributos codigoDeVerificação e senha)
	 * @return true,caso as informações do recrutador sejam encontradas no banco de
	 *         dados,liberando o acesso do mesmo para o nosso sistema,ou retorna
	 *         false caso as informações não sejam encontradas
	 */
	public boolean loginRec(LoginRecrutador rec) {
		String comandoLogin = "SELECT * FROM T_SWO_RECRUTADOR WHERE CD_RECRUTADOR = ? AND DS_SENHA=?";
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			ps = this.getConnection().prepareStatement(comandoLogin);
			ps.setInt(1, rec.getCodigo());
			ps.setString(2, rec.getSenha());
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