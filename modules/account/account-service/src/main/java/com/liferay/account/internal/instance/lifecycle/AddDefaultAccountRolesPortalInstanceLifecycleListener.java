package com.liferay.account.internal.instance.lifecycle;

import com.liferay.account.constants.AccountActionKeys;
import com.liferay.account.constants.AccountConstants;
import com.liferay.account.model.AccountEntry;
import com.liferay.account.model.AccountRole;
import com.liferay.account.service.AccountRoleLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleThreadLocal;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class AddDefaultAccountRolesPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		User defaultUser = company.getDefaultUser();

		if (!_exists(BusinessRole.ACCOUNT_USER.getRoleName())) {
			AccountRole accountRole = _addAccountRole(
				defaultUser.getUserId(),
				BusinessRole.ACCOUNT_USER.getRoleName());

			_addResourcePermissions(
				accountRole.getRoleId(), _accountUserResourceActionsMap);
		}

		if (!_exists(
				BusinessRole.ACCOUNT_POWER_USER.getRoleName())) {

			AccountRole accountRole = _addAccountRole(
				defaultUser.getUserId(),
				BusinessRole.ACCOUNT_POWER_USER.getRoleName());

			_addResourcePermissions(
				accountRole.getRoleId(), _accountUserResourceActionsMap);
			_addResourcePermissions(
				accountRole.getRoleId(), _accountPowerUserResourceActionsMap);
		}

		if (!_exists(BusinessRole.ACCOUNT_OWNER.getRoleName())) {
			AccountRole accountRole = _addAccountRole(
				defaultUser.getUserId(),
				BusinessRole.ACCOUNT_OWNER.getRoleName());

			_addResourcePermissions(
				accountRole.getRoleId(), _accountAdministratorResourceActionsMap);
		}

		if (!_exists(BusinessRole.ACCOUNT_ADMINISTRATOR.getRoleName())) {

			AccountRole accountRole = _addAccountRole(
				defaultUser.getUserId(),
				BusinessRole.ACCOUNT_ADMINISTRATOR.getRoleName());

			_addResourcePermissions(
				accountRole.getRoleId(), _accountAdministratorResourceActionsMap);
		}
	}

	private AccountRole _addAccountRole(long userId, String roleName)
		throws PortalException {

		AccountRole accountRole = _accountRoleLocalService.createAccountRole(
			_counterLocalService.increment());

		Role role = _roleLocalService.addRole(
			userId, AccountRole.class.getName(), accountRole.getAccountRoleId(),
			roleName,
			HashMapBuilder.put(
				LocaleThreadLocal.getDefaultLocale(), roleName
			).build(),
			null, 6, null, null);

		accountRole.setCompanyId(role.getCompanyId());
		accountRole.setAccountEntryId(
			AccountConstants.ACCOUNT_ENTRY_ID_DEFAULT);
		accountRole.setRoleId(role.getRoleId());

		return _accountRoleLocalService.addAccountRole(accountRole);
	}

	private void _addResourcePermissions(
			long roleId, Map<String, String[]> resourceActionsMap)
		throws PortalException {

		for (Map.Entry<String, String[]> entry :
				resourceActionsMap.entrySet()) {

			for (String resourceAction : entry.getValue()) {
				String resourceName = entry.getKey();

				_resourcePermissionLocalService.addResourcePermission(
					CompanyThreadLocal.getCompanyId(), resourceName,
					ResourceConstants.SCOPE_GROUP_TEMPLATE, "0", roleId,
					resourceAction);
			}
		}
	}

	private Role _addRole(long userId, String roleName) throws PortalException {
		return _roleLocalService.addRole(
			userId, null, 0, roleName,
			HashMapBuilder.put(
				LocaleThreadLocal.getDefaultLocale(), roleName
			).build(),
			null, RoleConstants.TYPE_REGULAR, null, null);
	}

	private boolean _exists(String roleName) {
		Role role = _roleLocalService.fetchRole(
			CompanyThreadLocal.getCompanyId(), roleName);

		if (role != null) {
			return true;
		}

		return false;
	}

	private static final Map<String, String[]>
		_accountAdministratorResourceActionsMap = HashMapBuilder.put(
			AccountEntry.class.getName(),
			new String[] {AccountActionKeys.CREATE_ACCOUNT_ENTRY_USER}
		).build();
	private static final Map<String, String[]>
		_accountPowerUserResourceActionsMap = HashMapBuilder.put(
			AccountConstants.RESOURCE_NAME,
			new String[] {AccountActionKeys.ADD_ACCOUNT_ENTRY}
		).put(
			AccountEntry.class.getName(),
			new String[] {ActionKeys.UPDATE, ActionKeys.MANAGE_USERS}
		).build();
	private static final Map<String, String[]> _accountUserResourceActionsMap =
		HashMapBuilder.put(
			AccountEntry.class.getName(), new String[] {ActionKeys.VIEW}
		).build();

	@Reference
	private AccountRoleLocalService _accountRoleLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private ResourcePermissionLocalService _resourcePermissionLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

}