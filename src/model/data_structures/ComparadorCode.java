package model.data_structures;

import java.util.Comparator;

import model.vo.VOMovingViolations;

public class ComparadorCode implements Comparator<VOMovingViolations>{

	@Override
	public int compare(VOMovingViolations o1, VOMovingViolations o2) {
		// TODO Auto-generated method stub
		return o1.darViolationCode().compareToIgnoreCase(o2.darViolationCode());
	}

}
