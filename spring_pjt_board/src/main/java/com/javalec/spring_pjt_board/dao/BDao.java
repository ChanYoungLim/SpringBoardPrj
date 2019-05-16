package com.javalec.spring_pjt_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.javalec.spring_pjt_board.dto.BDto;
import com.javalec_spring_pjt_board.util.Constant;

public class BDao {
	
	private DataSource dataSource;
	
	JdbcTemplate template = null;
	
	public BDao() {
			//Context context = new InitialContext();
			//dataSource = (DataSource) context.lookup("java:comp/env/jdbc/");
		
		template = Constant.template;
	}
	
	public void reply(final String bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
		
		String query = "insert into mvc_board (bName, bTitle, bContent, bGroup, bStep, bIndent) values (?, ?, ?, ?, ?, ?)";
		
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,  bName);
				ps.setString(2,  bTitle);
				ps.setString(3,  bContent);
				ps.setInt(4,  Integer.parseInt(bGroup));
				ps.setInt(5,  Integer.parseInt(bStep)+1);
				ps.setInt(6,  Integer.parseInt(bIndent)+1);
			}
		});
		
//		replyShape(bGroup, bStep);
//		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "insert into mvc_board (bName, bTitle, bContent, bGroup, bStep, bIndent) values (?, ?, ?, ?, ?, ?)";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1,  bName);
//			preparedStatement.setString(2,  bTitle);
//			preparedStatement.setString(3,  bContent);
//			preparedStatement.setInt(4,  Integer.parseInt(bGroup));
//			preparedStatement.setInt(5,  Integer.parseInt(bStep)+1);
//			preparedStatement.setInt(6,  Integer.parseInt(bIndent)+1);
//			
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//		}
	}
	
	public BDto reply_view(String strId) {
		
		String query = "select * from mvc_board where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
//		BDto dto = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select * from mvc_board where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1,  Integer.parseInt(strId));
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			}
//			
//			//int rn = preparedStatement.executeUpdate();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//			
//		}
//		
//		return null;
	}
	
	public void delete(final String strId) {
		String query = "delete from mvc_board where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, strId);
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "delete from mvc_board where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1,  Integer.parseInt(strId));
//			
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//			
//		}
	}
	
	public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
		
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2,  bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1,  bName);
//			preparedStatement.setString(2,  bTitle);
//			preparedStatement.setString(3,  bContent);
//			preparedStatement.setInt(4,  Integer.parseInt(bId));
//			
//			int rn = preparedStatement.executeUpdate();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//			
//		}
	}
	
	public BDto contentView(String strId) {
		
		upHit(strId);
		
		String query = "select * from mvc_board where bId = " + strId;
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		BDto dto = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select * from mvc_board where dId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1,  Integer.parseInt(strId));
//			int rn = preparedStatement.executeUpdate();
//			
//			if(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//			
//		}
//		
//		return null;
	}
	
	public void write(final String bName, final String bTitle, final String bContent) {
		
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
				String query = "insert into mvc_board (bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (?, ?, ?, 0, 0, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				return pstmt;
			}
		});
		
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "insert into mvc_board (bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (?, ?, ?, 0, 0, 0, 0)";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1,  bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			
//			int rn = preparedStatement.executeUpdate();
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				e2.printStackTrace();
//			}
//			
//		}
	}

	public ArrayList<BDto> list() {
		String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		
//		ArrayList<BDto> dtos = new ArrayList<BDto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				int bHit = resultSet.getInt("bHit");
//				int bGroup = resultSet.getInt("bGroup");
//				int bStep = resultSet.getInt("bStep");
//				int bIndent = resultSet.getInt("bIndent");
//				
//				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
//				dtos.add(dto);
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e2) {
//				
//			}
//			
//		}
		
		//return dtos;
		
	}
	
	private void upHit( final String bId) {
		// TODO Auto-generated method stub
		String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, Integer.parseInt(bId));
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, bId);
//			
//			int rn = preparedStatement.executeUpdate();
//					
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
	}
	
	private void replyShape( final String strGroup, final String strStep) {
		// TODO Auto-generated method stub
		String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException{
				ps.setInt(1, Integer.parseInt(strGroup));
				ps.setInt(2, Integer.parseInt(strStep));
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Integer.parseInt(strGroup));
//			preparedStatement.setInt(2, Integer.parseInt(strStep));
//			
//			int rn = preparedStatement.executeUpdate();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			try {
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//		}
	}
}
