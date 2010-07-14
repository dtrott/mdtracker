package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("moduleRangeHome")
public class ModuleRangeHome extends EntityHome<ModuleRange> {

	@In(create = true)
	ModuleHome moduleHome;
	@In(create = true)
	VersionStringHome versionStringHome;

	public void setModuleRangeModuleRangeId(Integer id) {
		setId(id);
	}

	public Integer getModuleRangeModuleRangeId() {
		return (Integer) getId();
	}

	@Override
	protected ModuleRange createInstance() {
		ModuleRange moduleRange = new ModuleRange();
		return moduleRange;
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
		VersionString versionStringByEndVersionId = versionStringHome
				.getDefinedInstance();
		if (versionStringByEndVersionId != null) {
			getInstance().setVersionStringByEndVersionId(
					versionStringByEndVersionId);
		}
		VersionString versionStringByLatestReleaseVersionId = versionStringHome
				.getDefinedInstance();
		if (versionStringByLatestReleaseVersionId != null) {
			getInstance().setVersionStringByLatestReleaseVersionId(
					versionStringByLatestReleaseVersionId);
		}
		VersionString versionStringByStartVersionId = versionStringHome
				.getDefinedInstance();
		if (versionStringByStartVersionId != null) {
			getInstance().setVersionStringByStartVersionId(
					versionStringByStartVersionId);
		}
	}

	public boolean isWired() {
		if (getInstance().getModule() == null)
			return false;
		if (getInstance().getVersionStringByEndVersionId() == null)
			return false;
		if (getInstance().getVersionStringByStartVersionId() == null)
			return false;
		return true;
	}

	public ModuleRange getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Dependency> getDependencies() {
		return getInstance() == null ? null : new ArrayList<Dependency>(
				getInstance().getDependencies());
	}

}
