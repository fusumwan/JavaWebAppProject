package com.app.ordertableweb.domain.services;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.sql.Date;

import com.app.ordertableweb.domain.models.*;
import com.app.ordertableweb.domain.utils.web.WebRequestUtil;
public interface TimeperiodService {
	public List<Timeperiod> getTimeperiods();
	public Timeperiod saveTimeperiod(Timeperiod timeperiod);
	public Timeperiod getTimeperiod(String timeperiod_id);
	public void deleteTimeperiod(String timeperiod_id);
	public List<Timeperiod> findByTimeperiodId(String timeperiod_id);
	public List<Timeperiod> findByRestaurantId(String restaurant_id);
	public List<Timeperiod> findByAccountId(String account_id);
	public List<Timeperiod> findByStartPeriod(Date start_period);
	public List<Timeperiod> findByEndPeriod(Date end_period);
	public List<Timeperiod> filterTimeperiod(WebRequestUtil.FilterRequestData requestData);
	public List<Timeperiod> getByTimeperiodAccountIdStartPeriodEndPeriod(String account_id_03,Date start_period_01,Date end_period_02);
}
