package test.wyj.util;

import junit.framework.TestCase;

import org.junit.Test;

import com.wyj.util.*;
public class TestPage extends TestCase{

	@Test
	public void test() {
		Page pg=new Page(10,102,11,8,70,true,true);
		assertEquals(PageUtil.creatPage(10, 102, 8).getBeginIndex(),
				pg.getBeginIndex());
		assertEquals(PageUtil.creatPage(10, 102, 8).getCurrentPage(),
				pg.getCurrentPage());
		assertEquals(PageUtil.creatPage(10, 102, 8).getEveryPage(),
				pg.getEveryPage());
		assertEquals(PageUtil.creatPage(10, 102, 8).getTotalCount(),
				pg.getTotalCount());
		assertEquals(PageUtil.creatPage(10, 102, 8).getTotalPage(),
				pg.getTotalPage());	
		assertEquals(PageUtil.creatPage(10, 102, 8).isHasNextPage(),
				pg.isHasNextPage());	
		assertEquals(PageUtil.creatPage(10, 102, 8).isHasPrePage(),
				pg.isHasPrePage());	
	}
	
}
