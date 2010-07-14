package com.davidtrott.mdtracker.model;
// Generated May 11, 2010 12:22:15 AM by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import org.hibernate.validator.NotNull;

/**
 * ModuleVersion generated by hbm2java
 */
@Entity
@Table(name = "module_version", uniqueConstraints = @UniqueConstraint(columnNames = {
		"module_id", "version_id"}))
public class ModuleVersion implements java.io.Serializable {

	private int moduleVersionId;
	private int version;
	private Module module;
	private VersionString versionString;
	private Set<Dependency> dependencies = new HashSet<Dependency>(0);

	public ModuleVersion() {
	}

	public ModuleVersion(int moduleVersionId, Module module,
			VersionString versionString) {
		this.moduleVersionId = moduleVersionId;
		this.module = module;
		this.versionString = versionString;
	}
	public ModuleVersion(int moduleVersionId, Module module,
			VersionString versionString, Set<Dependency> dependencies) {
		this.moduleVersionId = moduleVersionId;
		this.module = module;
		this.versionString = versionString;
		this.dependencies = dependencies;
	}

	@Id
	@GeneratedValue
	@Column(name = "module_version_id", unique = true, nullable = false)
	public int getModuleVersionId() {
		return this.moduleVersionId;
	}

	public void setModuleVersionId(int moduleVersionId) {
		this.moduleVersionId = moduleVersionId;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id", nullable = false)
	@NotNull
	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "version_id", nullable = false)
	@NotNull
	public VersionString getVersionString() {
		return this.versionString;
	}

	public void setVersionString(VersionString versionString) {
		this.versionString = versionString;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "moduleVersion")
	public Set<Dependency> getDependencies() {
		return this.dependencies;
	}

	public void setDependencies(Set<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

}
