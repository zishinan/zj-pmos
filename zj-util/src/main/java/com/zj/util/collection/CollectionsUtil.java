package com.zj.util.collection;

import com.alibaba.fastjson.JSON;
import com.zj.util.collection.sort.Sort;
import com.zj.util.collection.sort.SortKey;
import com.zj.util.excel.ExcelUtil;
import com.zj.util.file.LogUtil;

import java.util.*;

/**
 * 集合工具类
 */
public class CollectionsUtil {
	public static void main(String[] args) {
		List<Map<String, Object>> result = ExcelUtil.getExcel2Maps("C:\\Users\\Administrator\\Desktop\\a.xlsx",0);
		List<SortKey> sortKeys = new ArrayList<>(  );
		sortKeys.add(new SortKey("type", Sort.ASC));
		sortKeys.add(new SortKey("age", Sort.DESC));
		sortMaps( result,sortKeys );
		for (int i = 0; i < result.size(); i++) {
			System.out.println(JSON.toJSONString(result.get(i)));
		}
	}
	/**
	 * 打印集合元素到控制台
	 * @param collection
	 */
	public static void printSimpleCollection2Console(Collection<?> collection) {
		Iterator<?> iterator = collection.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * 根据map中多个key排序List<Map>
	 * @param result
	 * @param sortKeys
	 */
	public static void sortMaps(final List<Map<String, Object>> result, final List<SortKey> sortKeys){
		Collections.sort(result, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				for(SortKey key : sortKeys){
					Double number1 = Double.parseDouble(o1.get( key.getName())+"");
					Double number2 = Double.parseDouble(o2.get( key.getName())+"");
					double diff = number1 - number2;
					if(0 == diff){
						continue;
					}
					if(0 < diff){
						switch (key.getSort()){
							case ASC:
								return 1;
							case DESC:
								return -1;
						}
					}
					if(0 > diff){
						switch (key.getSort()){
							case ASC:
								return -1;
							case DESC:
								return 1;
						}
					}
				}
				return 0;
			}
		});
	}

	/**
	 * 判断一个集合是否有数据
	 * @param list
	 * @return 非空并且长度大于0返回true
	 */
	public static boolean isNotEmpty(Collection list){
		if(null != list && list.size() > 0){
			return true;
		}
		return false;
	}
}
