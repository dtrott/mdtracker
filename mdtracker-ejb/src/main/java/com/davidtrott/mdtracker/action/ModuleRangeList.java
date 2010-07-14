package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("moduleRangeList")
public class ModuleRangeList extends EntityQuery<ModuleRange> {

	private static final String EJBQL = "select moduleRange from ModuleRange moduleRange";

	private static final String[] RESTRICTIONS = {};

	private ModuleRange moduleRange = new ModuleRange();

	public ModuleRangeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ModuleRange getModuleRange() {
		return moduleRange;
	}
}
