package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("dependencyList")
public class DependencyList extends EntityQuery<Dependency> {

	private static final String EJBQL = "select dependency from Dependency dependency";

	private static final String[] RESTRICTIONS = {};

	private Dependency dependency;

	public DependencyList() {
		dependency = new Dependency();
		dependency.setId(new DependencyId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Dependency getDependency() {
		return dependency;
	}
}
