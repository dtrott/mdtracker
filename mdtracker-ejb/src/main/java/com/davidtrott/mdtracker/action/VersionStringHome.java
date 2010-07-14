package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("versionStringHome")
public class VersionStringHome extends EntityHome<VersionString> {

	public void setVersionStringVersionId(Integer id) {
		setId(id);
	}

	public Integer getVersionStringVersionId() {
		return (Integer) getId();
	}

	@Override
	protected VersionString createInstance() {
		VersionString versionString = new VersionString();
		return versionString;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public VersionString getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ModuleRange> getModuleRangesForEndVersionId() {
		return getInstance() == null ? null : new ArrayList<ModuleRange>(
				getInstance().getModuleRangesForEndVersionId());
	}
	public List<ModuleRange> getModuleRangesForLatestReleaseVersionId() {
		return getInstance() == null ? null : new ArrayList<ModuleRange>(
				getInstance().getModuleRangesForLatestReleaseVersionId());
	}
	public List<ModuleRange> getModuleRangesForStartVersionId() {
		return getInstance() == null ? null : new ArrayList<ModuleRange>(
				getInstance().getModuleRangesForStartVersionId());
	}
	public List<ModuleVersion> getModuleVersions() {
		return getInstance() == null ? null : new ArrayList<ModuleVersion>(
				getInstance().getModuleVersions());
	}

}
