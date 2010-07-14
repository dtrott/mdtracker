package com.davidtrott.mdtracker.action;

import com.davidtrott.mdtracker.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("moduleHome")
public class ModuleHome extends EntityHome<Module> {

	public void setModuleModuleId(Integer id) {
		setId(id);
	}

	public Integer getModuleModuleId() {
		return (Integer) getId();
	}

	@Override
	protected Module createInstance() {
		Module module = new Module();
		return module;
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

	public Module getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ModuleRange> getModuleRanges() {
		return getInstance() == null ? null : new ArrayList<ModuleRange>(
				getInstance().getModuleRanges());
	}
	public List<ModuleVersion> getModuleVersions() {
		return getInstance() == null ? null : new ArrayList<ModuleVersion>(
				getInstance().getModuleVersions());
	}

}
