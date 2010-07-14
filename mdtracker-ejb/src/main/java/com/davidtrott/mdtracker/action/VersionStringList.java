package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("versionStringList")
public class VersionStringList extends EntityQuery<VersionString> {

	private static final String EJBQL = "select versionString from VersionString versionString";

	private static final String[] RESTRICTIONS = {"lower(versionString.custom) like lower(concat(#{versionStringList.versionString.custom},'%'))",};

	private VersionString versionString = new VersionString();

	public VersionStringList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public VersionString getVersionString() {
		return versionString;
	}
}
