package com.founder.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author yxm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MapUtil 
{
	/**
	 * return mapA is sameWith mapB at the keys in compareList
	 * @param mapA
	 * @param mapB
	 * @param compareList
	 * @return
	 */
	public static boolean sameWith(Map mapA, Map mapB, List compareList)
	{
		boolean result = false;
		if (mapA == null && mapB == null)
		{
			result = true;
		} else if (mapA != null && mapB != null)
		{
			if (compareList == null || compareList.size() < 1)
			{
				result = mapA.equals(mapB);
			} else {
				result = true;
				Iterator it = compareList.iterator();
				while (it.hasNext())
				{
					String key = (String) it.next();
					Object a = mapA.get(key);
					Object b = mapB.get(key);
					if (!compareTo(a, b))
					{
						result = false;
						System.out.println("not equal key=" + key + ",val1=" + a + ",val2=" + b);
						break;
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param mapA
	 * @param mapB
	 * @param compareList
	 * @return
	 */
	public static List getNotSameList(Map mapA, Map mapB, List compareList)
	{
		List result = new ArrayList();
		if (mapA != null && mapB != null)
		{
			Iterator it = compareList.iterator();
			while (it.hasNext())
			{
				String key = (String) it.next();
				Object a = mapA.get(key);
				Object b = mapB.get(key);
				if (!compareTo(a, b))
				{
					result.add(key);
				}
			}
		}
		return result;
	}
	
	private static boolean compareTo(Object a, Object b)
	{
		boolean result = false;
		
		if ((a == null || "".equals(a)) && (b == null || "".equals(b)))
		{
			result = true;
		} else if (a != null && b != null)
		{
			result = a.equals(b);
		}
//		if (!result)
//		{
//			System.out.println("val a=" + a + ", val b=" + b);
//		}
		return result;
	}
}

