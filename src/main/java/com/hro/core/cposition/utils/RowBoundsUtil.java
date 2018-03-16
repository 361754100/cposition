package com.hro.core.cposition.utils;

import org.apache.ibatis.session.RowBounds;

/**
 * mybatis 翻页工具
 * @author Mojianzhang
 */
public class RowBoundsUtil {
	private RowBoundsUtil() {
		
	}

	public static RowBounds of(int pageNum, int pageSize) {
		return new RowBounds((pageNum - 1) * pageSize, pageSize);
	}

}
