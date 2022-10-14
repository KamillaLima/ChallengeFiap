package br.com.WorkOn.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


import br.com.WorkOn.model.Vaga;

public class VagaDAO extends Repository {

	/**
	 * Método para o recrutador inserir uma vaga
	 * 
	 * @param cd_recrutador
	 * @param Classe        Vaga(com os atributos
	 *                      salario,nomeVaga,cargo,descVaga,beneficios,matchMinino,tipoVaga,disponivel
	 */
	public static void InserirVaga(int cd_recrutador, Vaga v) {
		System.out.println(v);
		String sql = "INSERT INTO t_swo_vaga (cd_recrutador,nm_vaga,ds_vaga,ds_cargo,vl_salario,vl_match_min,ds_tipo_vaga,st_disponivel) VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {

			ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cd_recrutador);
			ps.setString(2, v.getNome());
			ps.setString(3, v.getDescricao());
			ps.setString(4, v.getCargo());
			ps.setDouble(5, v.getSalario());
			ps.setInt(6, v.getMatchMinimo());
			ps.setString(7, v.getTipoVaga());
			ps.executeUpdate();
		}

		 catch (SQLException e) {
			System.out.println("Erro na execução do SQL" + e.getMessage());
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("Erro ao tentar fechar o Statement " + e.getMessage());
			}
			if (Repository.connection != null) {
				Repository.closeConnection();
			}
		}
		
	}
		
	

	/**
	 * Método para o recrutador recuperar o código da vaga para inserir a lista de
	 * benefícios e requisitos
	 * 
	 * @param cd_recrutador
	 * @param Classe Vaga(em que serão puxados apenas 3 atributos,nomeVaga,descVaga e salario
	 * @return o código daquela vaga em específico
	 */
	public int ResgatarCodVaga(int cd_recrutador, Vaga v) {
		String sql = "SELECT CD_Vaga FROM T_SWO_VAGA WHERE CD_RECRUTADOR = ? and NM_VAGA = ? AND DS_VAGA = ? AND VL_SALARIO =? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int codVaga = 0;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setInt(1, cd_recrutador);
			ps.setString(2, v.getNome());
			ps.setString(3, v.getDescricao());
			ps.setDouble(4, v.getSalario());
			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					codVaga = rs.getInt("CD_VAGA");
				}
				return codVaga;

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
		return codVaga;
	}

	/**
	 * Método para inserir beneficios para uma determinada vaga
	 * 
	 * @param cd_vaga
	 * @param listaBeneficios
	 */
	public void inserirBeneficios(int cd_vaga, HashSet<Integer> listaBeneficios) {
		for (Integer bene : listaBeneficios) {
			int Bene = bene;
			String comando = "INSERT INTO t_swo_beneficios_vaga (cd_vaga,\n" + "    cd_beneficio\n" + ") VALUES (?,?)";
			
			
			PreparedStatement ps = null;
			try {
				ps = Repository.getConnection().prepareStatement(comando);
				ps.setInt(1, cd_vaga);
				ps.setInt(2, Bene);

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

	/**
	 * Método para listar todas as vagas publicadas por um determinado recrutador
	 * 
	 * @param cd_recrutador
	 * @return uma lista com todas as vagas publicadas por ele
	 */
	public List<Vaga> listarVagas(int cd_recrutador) {

		List<Vaga> listVaga = new ArrayList<>();
		String sql = "SELECT nm_vaga,ds_vaga,ds_cargo,ds_tipo_vaga, vl_salario FROM t_swo_vaga WHERE CD_RECRUTADOR = ?";

		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			ps = this.getConnection().prepareStatement(sql);
			ps.setInt(1, cd_recrutador);
			rs = ps.executeQuery();
//			while (rs.next()) {
//				listVaga.add(new Vaga(rs.getString("NM_VAGA"), rs.getString("DS_VAGA"), rs.getString("DS_CARGO"),
//						rs.getString("DS_TIPO_VAGA"), rs.getDouble("VL_SALARIO")));
//			}

			return listVaga;

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

		return listVaga;
	}

	/**
	 * Método para listar todas as vagas existentes para o candidato visualizar
	 * 
	 * @return lista com todas as vagas publicadas
	 */
	public static List<Vaga> listarTodasVagas() {

		List<Vaga> listVaga = new ArrayList<>();
		String sql = "SELECT nm_vaga, ds_vaga, ds_cargo, ds_tipo_vaga, vl_salario, vl_match_min FROM t_swo_vaga";
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {

			ps = getConnection().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Double salario = rs.getDouble("VL_SALARIO");
				String nomeVaga = rs.getString("NM_VAGA");
				String cargo = rs.getString("DS_CARGO");
				String vaga = rs.getString("DS_VAGA");
				Integer matchMinimo = rs.getInt("VL_MATCH_MIN");
				String tipoVaga = rs.getString("DS_TIPO_VAGA");
				
				
				
				
				listVaga.add(new Vaga(salario, nomeVaga, cargo, vaga, matchMinimo, tipoVaga));
			}

			return listVaga;

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

		return listVaga;
	}

	/**
	 * Método para o recrutador buscar o código da vaga que o mesmo deseja deletar
	 * 
	 * @param nm_vaga
	 * @return o código da vaga que o mesmo deseja deletar
	 */

	public int returnCodigo(String nome) {
		String sql = "SELECT CD_Vaga FROM T_SWO_VAGA WHERE NM_VAGA = ?  ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int codVaga = 0;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					codVaga = rs.getInt("CD_VAGA");
				}
				return codVaga;

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
		return codVaga;

	}

	@SuppressWarnings("resource")
	/**
	 * Deleta uma vaga e tudo que se associe a mesma,como benefícios,requisitos e afins
	 * @param codVaga
	 */
	public void DeletarVaga(int codVaga) {
		String comando = "DELETE FROM T_SWO_PROVA_CONHECIMENTO WHERE CD_VAGA = ?";
		String comando2 = "DELETE FROM T_SWO_BENEFICIOS_VAGA WHERE CD_VAGA =?";
		String comando3 = "DELETE FROM T_SWO_REQUISITOS_VAGA WHERE CD_VAGA = ?";
		String comando4 = "DELETE FROM T_SWO_INSCRICAO_VAGA WHERE CD_VAGA=?";
		String comando5 = "DELETE FROM T_SWO_VAGA WHERE CD_VAGA = ?";

		PreparedStatement ps = null;

		try {
			ps = getConnection().prepareStatement(comando);
			ps.setInt(1, codVaga);
			ps.executeUpdate();

			ps = getConnection().prepareStatement(comando2);
			ps.setInt(1, codVaga);
			ps.executeUpdate();

			ps = getConnection().prepareStatement(comando3);
			ps.setInt(1, codVaga);
			ps.executeUpdate();

			ps = getConnection().prepareStatement(comando4);
			ps.setInt(1, codVaga);
			ps.executeUpdate();

			ps = getConnection().prepareStatement(comando5);
			ps.setInt(1, codVaga);
			ps.executeUpdate();
			System.out.println("Vaga deletada ");
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
	 * Método para inserir todos os incritos no banco de dados
	 * @param codigoVaga
	 * @param codigoCandidato
	 * @param match
	 */
	public void inscritosVaga(int codigoVaga, int codigoCandidato, int match) {
		String comando = "INSERT INTO T_SWO_INSCRICAO_VAGA (CD_VAGA,CD_CANDIDATO,VL_MATCH) VALUES (?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = this.getConnection().prepareStatement(comando);
			ps.setInt(1, codigoVaga);
			ps.setInt(2, codigoCandidato);
			ps.setInt(3, match);
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
	 * Busca o valor mínimo de match pedido em uma específica vaga
	 * @param codigoVaga
	 * @return valor mínimo de match
	 */
	public int matchMinVaga(int codigoVaga) {
		String sql = "SELECT  VL_MATCH_MIN  FROM T_SWO_VAGA WHERE CD_VAGA = ?  ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int valMatch = 0;
		try {
			ps = getConnection().prepareStatement(sql);
			ps.setInt(1, codigoVaga);
			rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {

				while (rs.next()) {
					valMatch = rs.getInt("VL_MATCH_MIN");
				}
				return valMatch;

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
		return valMatch;

	}
}