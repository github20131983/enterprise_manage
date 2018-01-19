package test.wyj.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.TestCase;

import org.junit.Test;

import com.wyj.util.*;

public class TestSqlConnect extends TestCase{

	@Test
	public void test()  {
		 Connection conn=DBconnection.getConnection();//静态对象是属于类的
		 PreparedStatement pstmt = null;	//声明预处理对象
		 ResultSet rs=null;
		try {
		    pstmt = conn.prepareStatement("select count(*) from tb_employee");
		    rs=pstmt.executeQuery();
		    rs.next();
		    assertEquals(1,rs.getInt(1));
		    } catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	
		finally{
			DBconnection.close(rs);
			DBconnection.close(pstmt);
			DBconnection.close(conn);
		}
	}

}
