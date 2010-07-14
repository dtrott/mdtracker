package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("moduleVersionHome")
public class ModuleVersionHome extends EntityHome<ModuleVersion> {

	@In(create = true)
	ModuleHome moduleHome;
	@In(create = true)
	VersionStringHome versionStringHome;

	public void setModuleVersionModuleVersionId(Integer id) {
		setId(id);
	}

	public Integer getModuleVersionModuleVersionId() {
		return (Integer) getId();
	}

	@Override
	protected ModuleVersion createInstance() {
		ModuleVersion moduleVersion = new ModuleVersion();
		return moduleVersion;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Module module = moduleHome.getDefinedInstance();
		if (module != null) {
			getInstance().setModule(module);
		}
		VersionString versionString = versionStringHome.getDefinedInstance();
		if (versionString != null) {
			getInstance().setVersionString(versionString);
		}
	}

	public boolean isWired() {
		if (getInstance().getModule() == null)
			return false;
		if (getInstance().getVersionString() == null)
			return false;
		return true;
	}

	public ModuleVersion getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Dependency> getDependencies() {
		return getInstance() == null ? null : new ArrayList<Dependency>(
				getInstance().getDependencies());
	}

}
