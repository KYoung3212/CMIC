import React from 'react';
import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayTable from '@clayui/table';
import NumberFormat from 'react-number-format';

const AccountList = (props) => {
  const spriteMap = Liferay.ThemeDisplay.getPathThemeImages() + '/cmic/icons.svg';

  if (props.isLoading) {
    return (<ClayLoadingIndicator />);
  }
  else {
    return (
      <ClayTable>
        <ClayTable.Head>
          <ClayTable.Row>
            <ClayTable.Cell expanded headingCell>
              {Liferay.Language.get('name')}
              <a href="javascript:;" className="text-muted">
                <ClayIcon symbol={"sort"} spritemap={spriteMap} />
              </a>
            </ClayTable.Cell>

            <ClayTable.Cell expanded headingCell align="center" className="table-cell-expand-smallest">
              {Liferay.Language.get('in-force-policies')}
              <a href="javascript:;" className="text-muted">
                <ClayIcon symbol={"sort"} spritemap={spriteMap} />
              </a>
            </ClayTable.Cell>

            <ClayTable.Cell headingCell align="right" className="table-cell-ws-nowrap">
              {Liferay.Language.get('amount-billed')}
              <a href="javascript:;" className="text-muted">
                <ClayIcon symbol={"sort"} spritemap={spriteMap} />
              </a>
            </ClayTable.Cell>

          </ClayTable.Row>
        </ClayTable.Head>
        <ClayTable.Body>
          {props.accountsList.map((account, index) => (
            <ClayTable.Row key={index}>
              <ClayTable.Cell>
                <h5 className="font-weight-bold mb-0">{account.accountName}</h5>
                <small className="text-muted">#{account.accountNumber}</small>
              </ClayTable.Cell>
              <ClayTable.Cell align="center">{account.policies}</ClayTable.Cell>
              <ClayTable.Cell align="right" className="h3 font-weight-bold">
                <NumberFormat value={account.amountBilled} displayType={'text'} thousandSeparator={true} prefix={'$'} />
              </ClayTable.Cell>
            </ClayTable.Row>
          ))}
        </ClayTable.Body>
        <tfoot>
          <ClayTable.Row>
            <ClayTable.Cell colSpan="3">
              <a href="#" className="link-action">{Liferay.Language.get('see-all-accounts')}</a>
            </ClayTable.Cell>
          </ClayTable.Row>
        </tfoot>
      </ClayTable>
    );
  }
};

export default AccountList;