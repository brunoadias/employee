/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.employee.model;

import java.io.Serializable;
import java.text.Collator;

/**
 * An employee.
 * 
 * @author Inácio Nery
 */
public class Employee implements Serializable, Comparable<Employee> {

	private static final long serialVersionUID = 1L;

	private String name;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return this.getName().length() * 7;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Employee)) {
			return false;
		}

		String firstFullName = this.name.replace(" ", "");
		String anotherFullName = ((Employee) obj).getName().replace(" ", "");

		if (firstFullName.equalsIgnoreCase(anotherFullName)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Employee{name='" + name + "}";
	}

	@Override
	public int compareTo(Employee o) {
		return Collator.getInstance().compare(this.name, o.getName());
	}
}
