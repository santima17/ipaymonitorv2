package com.iwtg.ipaymonitor.datalayer.implementations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.iwtg.ipaymonitor.datalayer.context.DBHibernateUtil;
import com.iwtg.ipaymonitor.datalayer.interfaces.IPayMonitorMySQLDAO;
import com.iwtg.ipaymonitor.datalayer.model.BatchClosure;
import com.iwtg.ipaymonitor.generic.datatypes.DataSearchTransactionParameter;
import com.iwtg.ipaymonitor.generic.datatypes.DataTransactionSearchResult;

public class IPayMonitorMySQLDAOImplementation implements IPayMonitorMySQLDAO {

	public <T> Integer save(final T o) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		Transaction tx = dbSession.getTransaction();
		Object id = "";
		try {
			tx.begin();
			id = dbSession.save(o);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			return null;
		}
		if (id instanceof Integer) {
			return (Integer) id;
		} else {
			return 0;
		}
	}

	public boolean delete(final Object object) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		Transaction tx = dbSession.getTransaction();
		try {
			tx.begin();
			dbSession.delete(object);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			return false;
		}
	}

	public <T> T get(final Class<T> type, final Integer id) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		return dbSession.get(type, id);
	}

	public <T> T merge(final T o) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		return (T) dbSession.merge(o);
	}

	public <T> T refresh(final T o) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		dbSession.refresh(o);
		return o;
	}

	public <T> boolean saveOrUpdate(final T o) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		Transaction tx = dbSession.getTransaction();
		try {
			tx.begin();
			dbSession.update(o);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			return false;
		}
		return true;
	}

	public <T> List<T> getAll(final Class<T> type) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		final Criteria crit = dbSession.createCriteria(type);
		return crit.list();
	}

	public <T> List<T> getAllByExample(final Class<T> type, final T objectQuery) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		Example objectExample = Example.create(objectQuery);
		final Criteria crit = dbSession.createCriteria(type).add(objectExample);
		return crit.list();
	}

	public List<DataTransactionSearchResult> searchTransactions(DataSearchTransactionParameter searchParameter) {
		if (StringUtils.isNotEmpty(searchParameter.getTransactionID())) {
			List<DataTransactionSearchResult> result = new ArrayList<DataTransactionSearchResult>();
			com.iwtg.ipaymonitor.datalayer.model.Transaction transaction = getTransaction(
					searchParameter.getTransactionID());
			if (transaction != null) {
				BatchClosure cierre = getCierre(transaction.getReservationNumber());
				result.add(convertResult(transaction, cierre));
			}
			return result;
		} else {
			Session dbSession = DBHibernateUtil.getSessionFactoryMain();
			Query query = dbSession.createSQLQuery(makeSearchQuery(searchParameter));
			List<Object[]> resultList = query.list();
			return convertResult(resultList);
		}
	}

	private List<DataTransactionSearchResult> convertResult(List<Object[]> resultList) {
		List<DataTransactionSearchResult> resultDataList = new ArrayList<DataTransactionSearchResult>();
		if (CollectionUtils.isNotEmpty(resultList)) {
			for (Object[] row : resultList) {
				DataTransactionSearchResult dataResult = new DataTransactionSearchResult();
				dataResult.setCodigoRes((String) row[0]);
				dataResult.setCanal((String) row[1]);
				dataResult.setPais((String) row[2]);
				dataResult.setMedioPago((String) row[3]);
				dataResult.setMoneda((String) row[4]);
				dataResult.setEstado((String) row[5]);
				dataResult.setFecha((Date) row[6]);
				dataResult.setNombre((String) row[7]);
				dataResult.setApellido((String) row[8]);
				dataResult.setMail((String) row[9]);
				dataResult.setDocumento((String) row[10]);
				dataResult.setMonto((String) row[11]);
				dataResult.setCodCard((String) row[12]);
				dataResult.setTarjeta((String) row[15]);
				dataResult.setAutorizacion((String) row[16]);
				dataResult.setCodcomercio((String) row[17]);
				resultDataList.add(dataResult);
			}
		}
		return resultDataList;
	}

	private DataTransactionSearchResult convertResult(com.iwtg.ipaymonitor.datalayer.model.Transaction transaction,
			BatchClosure cierre) {
		DataTransactionSearchResult dataResult = new DataTransactionSearchResult();
		dataResult.setApellido(transaction.getLastName());
		dataResult.setAutorizacion(cierre.getTransactionAuthCode());
		dataResult.setCanal(transaction.getChannel());
		// dataResult.setCodCard(transaction.getCodCard());
		dataResult.setCodcomercio(cierre.getCommerceId());
		dataResult.setCodigoRes(transaction.getReservationNumber());
		dataResult.setDocumento(transaction.getCustomerId());
		dataResult.setEstado(transaction.getTransactionStatusCode());
		dataResult.setFecha(transaction.getDate());
		dataResult.setMail(transaction.getEmail());
		dataResult.setMedioPago(transaction.getCreditCardBrand());
		dataResult.setMoneda(transaction.getCurrency());
		dataResult.setMonto(transaction.getAmount());
		dataResult.setNombre(transaction.getName());
		dataResult.setPais(transaction.getCountry());
		dataResult.setTarjeta(cierre.getCreditCardNumber());
		return dataResult;
	}

	private String makeSearchQuery(DataSearchTransactionParameter searchParameter) {
		SimpleDateFormat formatterFrom = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat formatterTo = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		String query = "SELECT t.*, b.* FROM transaction t JOIN batch_closure b ON t.reservationNumber = b.reservationNumber ";

		String where = "where ";
		int cont = 0;
		if (StringUtils.isNotEmpty(searchParameter.getTransactionID())) {
			where = where + "t.reservationNumber like '%" + searchParameter.getTransactionID() + "%'";
			cont = 1;
		} else {
			if (StringUtils.isNotEmpty(searchParameter.getCreditCardNumber())) {
				if (cont == 1) {
					where = where + " and creditCardNumber = '" + searchParameter.getCreditCardNumber() + "'";
				} else {
					where = where + "creditCardNumber = '" + searchParameter.getCreditCardNumber() + "'";
				}
				cont = 1;
			}
			if (!searchParameter.getStatus().equals("Todos")) {
				if (cont == 1) {
					if (searchParameter.getStatus().equals("Autorizado")) {
						where = where + " and transactionStatusCode like '%000%'";
					} else if (searchParameter.getStatus().equals("Cancelado")) {
						where = where + " and transactionStatusCode = '112'";
					} else if (searchParameter.getStatus().equals("Devuelto")) {
						where = where + " and transactionStatusCode = 'D'";
					} else if (searchParameter.getStatus().equals("Check. Manual")) {
						where = where + " and transactionStatusCode = 'CHK'";
					} else {
						where = where
								+ " and (transactionStatusCode like '%001%' OR transactionStatusCode like '%010%' OR transactionStatusCode like '%011%' OR transactionStatusCode like '%100%' OR transactionStatusCode like '%110%' OR transactionStatusCode like '%111%' OR transactionStatusCode like '%114%')";
					}
				} else if (searchParameter.getStatus().equals("Autorizado")) {
					where = where + " transactionStatusCode like '%000%'";
				} else if (searchParameter.getStatus().equals("Cancelado")) {
					where = where + "transactionStatusCode = '112'";
				} else if (searchParameter.getStatus().equals("Devuelto")) {
					where = where + "transactionStatusCode = 'D'";
				} else if (searchParameter.getStatus().equals("Check. Manual")) {
					where = where + "transactionStatusCode = 'CHK'";
				} else {
					where = where
							+ " (transactionStatusCode like '%001%' OR transactionStatusCode like '%010%' OR transactionStatusCode like '%011%' OR transactionStatusCode like '%100%' OR transactionStatusCode like '%110%' OR transactionStatusCode like '%111%' OR transactionStatusCode like '%114%')";
				}

				cont = 1;
			}

			if (!searchParameter.getAdquirer().equals("Todos")) {
				if (cont == 1) {
					where = where + " and acquirerID = '" + searchParameter.getAdquirer() + "'";
				} else {
					where = where + " acquirerID = '" + searchParameter.getAdquirer() + "'";
				}
				cont = 1;
			}

			if (!searchParameter.getCountry().equals("Todos")) {
				if (cont == 1) {
					where = where + " and country = '" + searchParameter.getCountry() + "'";
				} else {
					where = where + " country = '" + searchParameter.getCountry() + "'";
				}
				cont = 1;
			}
			if (!searchParameter.getChannel().equals("Todos")) {
				if (cont == 1) {
					where = where + " and channel  = '" + searchParameter.getChannel() + "'";
				} else {
					where = where + " channel  = '" + searchParameter.getChannel() + "'";
				}
				cont = 1;
			}
			if (!searchParameter.getCurrency().equals("Todas")) {
				if (cont == 1) {
					where = where + " and currency = '" + searchParameter.getCurrency() + "'";
				} else {
					where = where + " currency = '" + searchParameter.getCurrency() + "'";
				}
				cont = 1;
			}
			if (!searchParameter.getCardBrand().equals("Todos")) {
				if (cont == 1) {
					where = where + " and creditCardBrand = '" + searchParameter.getCardBrand() + "'";
				} else {
					where = where + "creditCardBrand = '" + searchParameter.getCardBrand() + "'";
				}
				cont = 1;
			}

			if (cont == 1) {
				where = where + " and (t.fecha >= '" + formatterFrom.format(searchParameter.getDateFrom())
						+ "' and t.fecha <= '" + formatterTo.format(searchParameter.getDateTo()) + "')";
			} else {
				where = where + "(t.fecha >= '" + formatterFrom.format(searchParameter.getDateFrom())
						+ "' and t.fecha <= '" + formatterTo.format(searchParameter.getDateTo()) + "')";
			}

			where = where + " and transactionStatusCode NOT like '%PPP%'  and transactionStatusCode <> '' ";
		}

		System.out.println("QUERY" + query + where);
		return query + where;

	}

	public com.iwtg.ipaymonitor.datalayer.model.Transaction getTransaction(String transactionID) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		com.iwtg.ipaymonitor.datalayer.model.Transaction transaction = (com.iwtg.ipaymonitor.datalayer.model.Transaction) dbSession
				.createQuery("select T from Transaction T where T.reservationNumber = :reservationNumber")
				.setString("reservationNumber", transactionID).uniqueResult();
		return transaction;
	}

	public BatchClosure getCierre(String transactionIDLongNumber) {
		Session dbSession = DBHibernateUtil.getSessionFactoryMain();
		BatchClosure cierre = (BatchClosure) dbSession
				.createQuery("select C from BatchClosure C where C.reservationNumber = :reservationNumber")
				.setString("reservationNumber", transactionIDLongNumber).uniqueResult();
		return cierre;
	}

}
