package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.WorkOn.model.Endereco;

public class EnderecoDAO extends Repository {

	public void inserirEndereco(int codigoCandidato,Endereco endereco) {
		String sql = "INSERT INTO T_SWO_ENDERECO ( cd_candidato,\r\n"
				+ "    ds_logradouro,\r\n"
				+ "    ds_numero,\r\n"
				+ "    ds_bairro,\r\n"
				+ "    sg_uf,\r\n"
				+ "    ds_cidade) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setInt(1, codigoCandidato);
			ps.setString(2, endereco.getLogradouro());
			ps.setInt(3, endereco.getNumero());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getSiglaEstado());
			ps.setString(6, endereco.getCidade());
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
