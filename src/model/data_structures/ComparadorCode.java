package model.data_structures;

import java.util.Comparator;

import model.vo.VOMovingViolations;

public class ComparadorCode implements Comparator<VOMovingViolations>{

	@Override
	public int compare(VOMovingViolations o1, VOMovingViolations o2) {
		// TODO Auto-generated method stub
		String p=o1.darViolationCode();
		String subP=p.substring(1, p.length());
		int num1=Integer.parseInt(subP);
		String s=o2.darViolationCode();
		String subD=p.substring(1, s.length());
		int num2=Integer.parseInt(subD);
		if(num1<num2)
		{
			return -1;
		}
		else if(num1>num2)
		{
			return 1;
		}
		else
			return 0;



	}

}
