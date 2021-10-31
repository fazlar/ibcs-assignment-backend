package com.emp.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Gender {

	MALE(101L, "MALE"), FEMALE(102L, "FEMALE"), OTHER(103L, "OTHER");

	private final Long genderNo;
	private final String genderName;

	private Gender(Long genderNo, String genderName) {
		this.genderNo = genderNo;
		this.genderName = genderName;
	}

	public Long getGenderNo() {
		return genderNo;
	}

	public String getGenderName() {
		return genderName;
	}

	public static List<Map<String, Object>> getGenderList() {

		List<Map<String, Object>> genderList = new ArrayList<Map<String, Object>>();

		for (Gender gender : Gender.values()) {

			Map<String, Object> genderMap = new HashMap<String, Object>();
			genderMap.put("genderNo", gender.genderNo);
			genderMap.put("genderName", gender.genderName);

			genderList.add(genderMap);
		}
		return genderList;
	}

	public static String getGenderByNo(Long genderNo) {

		for (Gender gender : Gender.values()) {
			if (gender.getGenderNo().longValue() == genderNo.longValue())
				return gender.getGenderName();
		}
		return "unknown";
	}
}
