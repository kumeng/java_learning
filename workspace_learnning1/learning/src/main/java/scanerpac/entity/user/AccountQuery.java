package scanerpac.entity.user;

import java.util.ArrayList;
import java.util.List;

public class AccountQuery {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Integer pageNo = 1;

	protected Integer startRow;

	protected Integer pageSize = 10;

	protected String fields;

	public AccountQuery() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo - 1) * this.pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo - 1) * this.pageSize;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getFields() {
		return fields;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andLoginnameIsNull() {
			addCriterion("LOGINNAME is null");
			return (Criteria) this;
		}

		public Criteria andLoginnameIsNotNull() {
			addCriterion("LOGINNAME is not null");
			return (Criteria) this;
		}

		public Criteria andLoginnameEqualTo(String value) {
			addCriterion("LOGINNAME =", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotEqualTo(String value) {
			addCriterion("LOGINNAME <>", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameGreaterThan(String value) {
			addCriterion("LOGINNAME >", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameGreaterThanOrEqualTo(String value) {
			addCriterion("LOGINNAME >=", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameLessThan(String value) {
			addCriterion("LOGINNAME <", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameLessThanOrEqualTo(String value) {
			addCriterion("LOGINNAME <=", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameLike(String value) {
			addCriterion("LOGINNAME like", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotLike(String value) {
			addCriterion("LOGINNAME not like", value, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameIn(List<String> values) {
			addCriterion("LOGINNAME in", values, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotIn(List<String> values) {
			addCriterion("LOGINNAME not in", values, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameBetween(String value1, String value2) {
			addCriterion("LOGINNAME between", value1, value2, "loginname");
			return (Criteria) this;
		}

		public Criteria andLoginnameNotBetween(String value1, String value2) {
			addCriterion("LOGINNAME not between", value1, value2, "loginname");
			return (Criteria) this;
		}

		public Criteria andPwdIsNull() {
			addCriterion("PWD is null");
			return (Criteria) this;
		}

		public Criteria andPwdIsNotNull() {
			addCriterion("PWD is not null");
			return (Criteria) this;
		}

		public Criteria andPwdEqualTo(String value) {
			addCriterion("PWD =", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotEqualTo(String value) {
			addCriterion("PWD <>", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdGreaterThan(String value) {
			addCriterion("PWD >", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdGreaterThanOrEqualTo(String value) {
			addCriterion("PWD >=", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdLessThan(String value) {
			addCriterion("PWD <", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdLessThanOrEqualTo(String value) {
			addCriterion("PWD <=", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdLike(String value) {
			addCriterion("PWD like", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotLike(String value) {
			addCriterion("PWD not like", value, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdIn(List<String> values) {
			addCriterion("PWD in", values, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotIn(List<String> values) {
			addCriterion("PWD not in", values, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdBetween(String value1, String value2) {
			addCriterion("PWD between", value1, value2, "pwd");
			return (Criteria) this;
		}

		public Criteria andPwdNotBetween(String value1, String value2) {
			addCriterion("PWD not between", value1, value2, "pwd");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}