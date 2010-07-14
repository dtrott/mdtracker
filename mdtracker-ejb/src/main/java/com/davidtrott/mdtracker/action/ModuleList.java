package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("moduleList")
public class ModuleList extends EntityQuery<Module> {

	private static final String EJBQL = "select module from Module module";

	private static final String[] RESTRICTIONS = {
			"lower(module.artifactId) like lower(concat(#{moduleList.module.artifactId},'%'))",
			"lower(module.groupId) like lower(concat(#{moduleList.module.groupId},'%'))",};

	private Module module = new Module();

	public ModuleList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Module getModule() {
		return module;
	}
}
