package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("moduleVersionList")
public class ModuleVersionList extends EntityQuery<ModuleVersion> {

	private static final String EJBQL = "select moduleVersion from ModuleVersion moduleVersion";

	private static final String[] RESTRICTIONS = {};

	private ModuleVersion moduleVersion = new ModuleVersion();

	public ModuleVersionList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ModuleVersion getModuleVersion() {
		return moduleVersion;
	}
}
