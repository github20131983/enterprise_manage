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
		 Connection conn=DBconnection.getConnection();//��̬�������������
		 PreparedStatement pstmt = null;	//����Ԥ�������
		 ResultSet rs=null;
		try {
		    pstmt = conn.prepareStatement("select count(*) from tb_employee");
		    rs=pstmt.executeQuery();
		    rs.next();
		    assertEquals(1,rs.getInt(1));
		    } catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}	
		finally{
			DBconnection.close(rs);
			DBconnection.close(pstmt);
			DBconnection.close(conn);
		}
	}

}
