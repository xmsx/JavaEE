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
		//创建连接
		Connection conn = null;
		//创建向数据库发送sql的statement对象
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList objs = new ArrayList();
		try {
			conn = JDBCUtils.getConnection();
			//创建向数据库发送预编译sql的PrepareSatement对象
			ps = conn.prepareStatement(sql);
			if(params != null){//如果查询带分页的多条记录，设定分页参数
				//获取预编译的prepareStatement对象中需要填入参数的集
				ParameterMetaData pm = ps.getParameterMetaData();
				//从传入的参数对象填入
				for(int i=1;i<=pm.getParameterCount();i++){
					ps.setObject(i, params[i-1]);
				}	
			}
			//空执行预存入的sql语句
			rs = ps.executeQuery();
			while(rs.next()){
				//将获取的数据集转化成实例对象
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
		//返回对象集
		return objs;
	}
	/**
	 * 每次实例一个数据对象
	 * @param rs 数据集的单条数据
	 * @param clazz 实例的对象bean
	 * @return 对象
	 */
	private Object mappingObj(ResultSet rs,Class clazz) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//实例化映射对象
		Object obj = clazz.newInstance();
		//获取映射对象的方法集
		Method[] methods = clazz.getMethods();
		//获取结果集中元数据信息
		ResultSetMetaData meta = rs.getMetaData();
		// 按字段数目循环结果集中记录，进行对象映射，转化成实例对象返回
		for(int i=1;i<=meta.getColumnCount();i++){
			// 构造当前列的set方法名称
			String colname = meta.getColumnLabel(i);
			String methodname = "set" + colname;
			//循环查找同名方法，并通过反射调用该方法，设置属性值
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
	 * @param sql 查询语句
	 * @param params 参数集
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
			//填充
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
	 * 修改（包括删除、插入）
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
	 * 取得记录数
	 * @param sql 查询语句，例如，"select count(*) from dish"
	 * @return
	 */
	public int getTotalRecords(String sql){
		int count = 0;
		try {
			Connection conn = JDBCUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//获取参数集的第一个参数（本例中为int型的）
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
