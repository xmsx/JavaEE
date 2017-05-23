package edu.cugb.xg.javaee.dao;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cugb.xg.javaee.utils.JDBCUtils;



public class baseDAO {
	public ArrayList findObjs(String sql,Object[] params,Class clazz){
		//��������
		Connection conn = null;
		//���������ݿⷢ��sql��statement����
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList objs = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			//���������ݿⷢ��Ԥ����sql��PrepareSatement����
			ps = conn.prepareStatement(sql);
			if(params != null){//�����ѯ����ҳ�Ķ�����¼���趨��ҳ����
				//��ȡԤ�����prepareStatement��������Ҫ��������ļ�
				ParameterMetaData pm = ps.getParameterMetaData();
				//�Ӵ���Ĳ�����������
				for(int i=1;i<=pm.getParameterCount();i++){
					ps.setObject(i, params[i-1]);
				}	
			}
			//��ִ��Ԥ�����sql���
			rs = ps.executeQuery();
			while(rs.next()){
				//����ȡ�����ݼ�ת����ʵ������
				Object obj = mappingObj(rs,clazz);
				objs.add(obj);
			}
			JDBCUtils.free(rs, ps, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
		//���ض���
		return objs;
	}
	/**
	 * ÿ��ʵ��һ�����ݶ���
	 * @param rs ���ݼ��ĵ�������
	 * @param clazz ʵ���Ķ���bean
	 * @return ����
	 */
	private Object mappingObj(ResultSet rs,Class clazz) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//ʵ����ӳ�����
		Object obj = clazz.newInstance();
		//��ȡӳ�����ķ�����
		Method[] methods = clazz.getMethods();
		//��ȡ�������Ԫ������Ϣ
		ResultSetMetaData meta = rs.getMetaData();
		// ���ֶ���Ŀѭ��������м�¼�����ж���ӳ�䣬ת����ʵ�����󷵻�
		for(int i=1;i<=meta.getColumnCount();i++){
			// ���쵱ǰ�е�set��������
			String colname = meta.getColumnLabel(i);
			String methodname = "set" + colname;
			//ѭ������ͬ����������ͨ��������ø÷�������������ֵ
			for(Method method:methods){
				if(method.getName().equals(methodname)){
					method.invoke(obj, rs.getObject(i));
					break;
				}
			}
		}
		return obj;
	}
	/**
	 * 
	 * @param sql ��ѯ���
	 * @param params ������
	 * @param clazz 
	 * @return
	 */
	public Object findObj(String sql,Object[] params,Class clazz){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			//���
			ParameterMetaData pm = ps.getParameterMetaData();
			for(int i=1;i<=pm.getParameterCount();i++){
				ps.setObject(i, params[i-1]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				obj = mappingObj(rs,clazz);
			}
			JDBCUtils.free(rs, ps, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
		return obj;
	}
	/**
	 * �޸ģ�����ɾ�������룩
	 * @param strsql
	 * @param params
	 * @return
	 */
	public int modifyObj(String strsql,Object[] params){
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(strsql);
			ParameterMetaData pm = ps.getParameterMetaData();
			if(params.length > 0){
				for(int i=1;i<=pm.getParameterCount();i++){
					ps.setObject(i, params[i-1]);
				}	
			}
			int i = ps.executeUpdate();
			JDBCUtils.free(rs, ps, conn);
			return i;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/**
	 * ȡ�ü�¼��
	 * @param sql ��ѯ��䣬���磬"select count(*) from dish"
	 * @return
	 */
	public int getTotalRecords(String sql){
		int count = 0;
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//��ȡ�������ĵ�һ��������������Ϊint�͵ģ�
				count = rs.getInt(1);
			}
			JDBCUtils.free(rs, ps, conn);
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return count;
	}
}
