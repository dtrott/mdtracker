package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("dependencyHome")
public class DependencyHome extends EntityHome<Dependency> {

	@In(create = true)
	ModuleRangeHome moduleRangeHome;
	@In(create = true)
	ModuleVersionHome moduleVersionHome;

	public void setDependencyId(DependencyId id) {
		setId(id);
	}

	public DependencyId getDependencyId() {
		return (DependencyId) getId();
	}

	public DependencyHome() {
		setDependencyId(new DependencyId());
	}

	@Override
	public boolean isIdDefined() {
		if (getDependencyId().getModuleRangeId() == 0)
			return false;
		if (getDependencyId().getModuleVersionId() == 0)
			return false;
		return true;
	}

	@Override
	protected Dependency createInstance() {
		Dependency dependency = new Dependency();
		dependency.setId(new DependencyId());
		return dependency;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		ModuleRange moduleRange = moduleRangeHome.getDefinedInstance();
		if (moduleRange != null) {
			getInstance().setModuleRange(moduleRange);
		}
		ModuleVersion moduleVersion = moduleVersionHome.getDefinedInstance();
		if (moduleVersion != null) {
			getInstance().setModuleVersion(moduleVersion);
		}
	}

	public boolean isWired() {
		if (getInstance().getModuleRange() == null)
			return false;
		if (getInstance().getModuleVersion() == null)
			return false;
		return true;
	}

	public Dependency getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
