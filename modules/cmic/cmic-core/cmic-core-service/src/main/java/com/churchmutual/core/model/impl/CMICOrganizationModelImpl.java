/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.churchmutual.core.model.impl;

import com.churchmutual.core.model.CMICOrganization;
import com.churchmutual.core.model.CMICOrganizationModel;
import com.churchmutual.core.model.CMICOrganizationSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CMICOrganization service. Represents a row in the &quot;cmic_CMICOrganization&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CMICOrganizationModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CMICOrganizationImpl}.
 * </p>
 *
 * @author Kayleen Lim
 * @see CMICOrganizationImpl
 * @generated
 */
@JSON(strict = true)
public class CMICOrganizationModelImpl
	extends BaseModelImpl<CMICOrganization> implements CMICOrganizationModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cmic organization model instance should use the <code>CMICOrganization</code> interface instead.
	 */
	public static final String TABLE_NAME = "cmic_CMICOrganization";

	public static final Object[][] TABLE_COLUMNS = {
		{"cmicOrganizationId", Types.BIGINT}, {"organizationId", Types.BIGINT},
		{"agent", Types.VARCHAR}, {"division", Types.VARCHAR},
		{"producerId", Types.BIGINT}, {"producerType", Types.INTEGER},
		{"active_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("cmicOrganizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("organizationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("agent", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("division", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("producerId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("producerType", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cmic_CMICOrganization (cmicOrganizationId LONG not null primary key,organizationId LONG,agent VARCHAR(75) null,division VARCHAR(75) null,producerId LONG,producerType INTEGER,active_ BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table cmic_CMICOrganization";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cmicOrganization.cmicOrganizationId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cmic_CMICOrganization.cmicOrganizationId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long PRODUCERID_COLUMN_BITMASK = 1L;

	public static final long CMICORGANIZATIONID_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CMICOrganization toModel(CMICOrganizationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CMICOrganization model = new CMICOrganizationImpl();

		model.setCmicOrganizationId(soapModel.getCmicOrganizationId());
		model.setOrganizationId(soapModel.getOrganizationId());
		model.setAgent(soapModel.getAgent());
		model.setDivision(soapModel.getDivision());
		model.setProducerId(soapModel.getProducerId());
		model.setProducerType(soapModel.getProducerType());
		model.setActive(soapModel.isActive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CMICOrganization> toModels(
		CMICOrganizationSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CMICOrganization> models = new ArrayList<CMICOrganization>(
			soapModels.length);

		for (CMICOrganizationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CMICOrganizationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _cmicOrganizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCmicOrganizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cmicOrganizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CMICOrganization.class;
	}

	@Override
	public String getModelClassName() {
		return CMICOrganization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CMICOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CMICOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CMICOrganization, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CMICOrganization)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CMICOrganization, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CMICOrganization, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CMICOrganization)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CMICOrganization, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CMICOrganization, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CMICOrganization>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CMICOrganization.class.getClassLoader(), CMICOrganization.class,
			ModelWrapper.class);

		try {
			Constructor<CMICOrganization> constructor =
				(Constructor<CMICOrganization>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CMICOrganization, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CMICOrganization, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CMICOrganization, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CMICOrganization, Object>>();
		Map<String, BiConsumer<CMICOrganization, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CMICOrganization, ?>>();

		attributeGetterFunctions.put(
			"cmicOrganizationId", CMICOrganization::getCmicOrganizationId);
		attributeSetterBiConsumers.put(
			"cmicOrganizationId",
			(BiConsumer<CMICOrganization, Long>)
				CMICOrganization::setCmicOrganizationId);
		attributeGetterFunctions.put(
			"organizationId", CMICOrganization::getOrganizationId);
		attributeSetterBiConsumers.put(
			"organizationId",
			(BiConsumer<CMICOrganization, Long>)
				CMICOrganization::setOrganizationId);
		attributeGetterFunctions.put("agent", CMICOrganization::getAgent);
		attributeSetterBiConsumers.put(
			"agent",
			(BiConsumer<CMICOrganization, String>)CMICOrganization::setAgent);
		attributeGetterFunctions.put("division", CMICOrganization::getDivision);
		attributeSetterBiConsumers.put(
			"division",
			(BiConsumer<CMICOrganization, String>)
				CMICOrganization::setDivision);
		attributeGetterFunctions.put(
			"producerId", CMICOrganization::getProducerId);
		attributeSetterBiConsumers.put(
			"producerId",
			(BiConsumer<CMICOrganization, Long>)
				CMICOrganization::setProducerId);
		attributeGetterFunctions.put(
			"producerType", CMICOrganization::getProducerType);
		attributeSetterBiConsumers.put(
			"producerType",
			(BiConsumer<CMICOrganization, Integer>)
				CMICOrganization::setProducerType);
		attributeGetterFunctions.put("active", CMICOrganization::getActive);
		attributeSetterBiConsumers.put(
			"active",
			(BiConsumer<CMICOrganization, Boolean>)CMICOrganization::setActive);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCmicOrganizationId() {
		return _cmicOrganizationId;
	}

	@Override
	public void setCmicOrganizationId(long cmicOrganizationId) {
		_cmicOrganizationId = cmicOrganizationId;
	}

	@JSON
	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	@JSON
	@Override
	public String getAgent() {
		if (_agent == null) {
			return "";
		}
		else {
			return _agent;
		}
	}

	@Override
	public void setAgent(String agent) {
		_agent = agent;
	}

	@JSON
	@Override
	public String getDivision() {
		if (_division == null) {
			return "";
		}
		else {
			return _division;
		}
	}

	@Override
	public void setDivision(String division) {
		_division = division;
	}

	@JSON
	@Override
	public long getProducerId() {
		return _producerId;
	}

	@Override
	public void setProducerId(long producerId) {
		_columnBitmask |= PRODUCERID_COLUMN_BITMASK;

		if (!_setOriginalProducerId) {
			_setOriginalProducerId = true;

			_originalProducerId = _producerId;
		}

		_producerId = producerId;
	}

	public long getOriginalProducerId() {
		return _originalProducerId;
	}

	@JSON
	@Override
	public int getProducerType() {
		return _producerType;
	}

	@Override
	public void setProducerType(int producerType) {
		_producerType = producerType;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CMICOrganization.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CMICOrganization toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CMICOrganization>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CMICOrganizationImpl cmicOrganizationImpl = new CMICOrganizationImpl();

		cmicOrganizationImpl.setCmicOrganizationId(getCmicOrganizationId());
		cmicOrganizationImpl.setOrganizationId(getOrganizationId());
		cmicOrganizationImpl.setAgent(getAgent());
		cmicOrganizationImpl.setDivision(getDivision());
		cmicOrganizationImpl.setProducerId(getProducerId());
		cmicOrganizationImpl.setProducerType(getProducerType());
		cmicOrganizationImpl.setActive(isActive());

		cmicOrganizationImpl.resetOriginalValues();

		return cmicOrganizationImpl;
	}

	@Override
	public int compareTo(CMICOrganization cmicOrganization) {
		long primaryKey = cmicOrganization.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CMICOrganization)) {
			return false;
		}

		CMICOrganization cmicOrganization = (CMICOrganization)obj;

		long primaryKey = cmicOrganization.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CMICOrganizationModelImpl cmicOrganizationModelImpl = this;

		cmicOrganizationModelImpl._originalProducerId =
			cmicOrganizationModelImpl._producerId;

		cmicOrganizationModelImpl._setOriginalProducerId = false;

		cmicOrganizationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CMICOrganization> toCacheModel() {
		CMICOrganizationCacheModel cmicOrganizationCacheModel =
			new CMICOrganizationCacheModel();

		cmicOrganizationCacheModel.cmicOrganizationId = getCmicOrganizationId();

		cmicOrganizationCacheModel.organizationId = getOrganizationId();

		cmicOrganizationCacheModel.agent = getAgent();

		String agent = cmicOrganizationCacheModel.agent;

		if ((agent != null) && (agent.length() == 0)) {
			cmicOrganizationCacheModel.agent = null;
		}

		cmicOrganizationCacheModel.division = getDivision();

		String division = cmicOrganizationCacheModel.division;

		if ((division != null) && (division.length() == 0)) {
			cmicOrganizationCacheModel.division = null;
		}

		cmicOrganizationCacheModel.producerId = getProducerId();

		cmicOrganizationCacheModel.producerType = getProducerType();

		cmicOrganizationCacheModel.active = isActive();

		return cmicOrganizationCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CMICOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CMICOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CMICOrganization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CMICOrganization)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CMICOrganization, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CMICOrganization, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CMICOrganization, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CMICOrganization)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CMICOrganization>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _cmicOrganizationId;
	private long _organizationId;
	private String _agent;
	private String _division;
	private long _producerId;
	private long _originalProducerId;
	private boolean _setOriginalProducerId;
	private int _producerType;
	private boolean _active;
	private long _columnBitmask;
	private CMICOrganization _escapedModel;

}