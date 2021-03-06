package scanerpac.entity.sys;

import java.util.ArrayList;
import java.util.List;

public class SeqsQuery {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Integer pageNo = 1;

	protected Integer startRow;

	protected Integer pageSize = 10;

	protected String fields;

	public SeqsQuery() {
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andSeqNameIsNull() {
			addCriterion("SEQ_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSeqNameIsNotNull() {
			addCriterion("SEQ_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSeqNameEqualTo(String value) {
			addCriterion("SEQ_NAME =", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameNotEqualTo(String value) {
			addCriterion("SEQ_NAME <>", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameGreaterThan(String value) {
			addCriterion("SEQ_NAME >", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameGreaterThanOrEqualTo(String value) {
			addCriterion("SEQ_NAME >=", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameLessThan(String value) {
			addCriterion("SEQ_NAME <", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameLessThanOrEqualTo(String value) {
			addCriterion("SEQ_NAME <=", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameLike(String value) {
			addCriterion("SEQ_NAME like", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameNotLike(String value) {
			addCriterion("SEQ_NAME not like", value, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameIn(List<String> values) {
			addCriterion("SEQ_NAME in", values, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameNotIn(List<String> values) {
			addCriterion("SEQ_NAME not in", values, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameBetween(String value1, String value2) {
			addCriterion("SEQ_NAME between", value1, value2, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqNameNotBetween(String value1, String value2) {
			addCriterion("SEQ_NAME not between", value1, value2, "seqName");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameIsNull() {
			addCriterion("SEQ_TABLENAME is null");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameIsNotNull() {
			addCriterion("SEQ_TABLENAME is not null");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameEqualTo(String value) {
			addCriterion("SEQ_TABLENAME =", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameNotEqualTo(String value) {
			addCriterion("SEQ_TABLENAME <>", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameGreaterThan(String value) {
			addCriterion("SEQ_TABLENAME >", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameGreaterThanOrEqualTo(String value) {
			addCriterion("SEQ_TABLENAME >=", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameLessThan(String value) {
			addCriterion("SEQ_TABLENAME <", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameLessThanOrEqualTo(String value) {
			addCriterion("SEQ_TABLENAME <=", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameLike(String value) {
			addCriterion("SEQ_TABLENAME like", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameNotLike(String value) {
			addCriterion("SEQ_TABLENAME not like", value, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameIn(List<String> values) {
			addCriterion("SEQ_TABLENAME in", values, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameNotIn(List<String> values) {
			addCriterion("SEQ_TABLENAME not in", values, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameBetween(String value1, String value2) {
			addCriterion("SEQ_TABLENAME between", value1, value2, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqTablenameNotBetween(String value1, String value2) {
			addCriterion("SEQ_TABLENAME not between", value1, value2, "seqTablename");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoIsNull() {
			addCriterion("SEQ_CURRNO is null");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoIsNotNull() {
			addCriterion("SEQ_CURRNO is not null");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoEqualTo(Integer value) {
			addCriterion("SEQ_CURRNO =", value, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoNotEqualTo(Integer value) {
			addCriterion("SEQ_CURRNO <>", value, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoGreaterThan(Integer value) {
			addCriterion("SEQ_CURRNO >", value, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEQ_CURRNO >=", value, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoLessThan(Integer value) {
			addCriterion("SEQ_CURRNO <", value, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoLessThanOrEqualTo(Integer value) {
			addCriterion("SEQ_CURRNO <=", value, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoIn(List<Integer> values) {
			addCriterion("SEQ_CURRNO in", values, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoNotIn(List<Integer> values) {
			addCriterion("SEQ_CURRNO not in", values, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_CURRNO between", value1, value2, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqCurrnoNotBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_CURRNO not between", value1, value2, "seqCurrno");
			return (Criteria) this;
		}

		public Criteria andSeqStepIsNull() {
			addCriterion("SEQ_STEP is null");
			return (Criteria) this;
		}

		public Criteria andSeqStepIsNotNull() {
			addCriterion("SEQ_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andSeqStepEqualTo(Short value) {
			addCriterion("SEQ_STEP =", value, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepNotEqualTo(Short value) {
			addCriterion("SEQ_STEP <>", value, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepGreaterThan(Short value) {
			addCriterion("SEQ_STEP >", value, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepGreaterThanOrEqualTo(Short value) {
			addCriterion("SEQ_STEP >=", value, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepLessThan(Short value) {
			addCriterion("SEQ_STEP <", value, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepLessThanOrEqualTo(Short value) {
			addCriterion("SEQ_STEP <=", value, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepIn(List<Short> values) {
			addCriterion("SEQ_STEP in", values, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepNotIn(List<Short> values) {
			addCriterion("SEQ_STEP not in", values, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepBetween(Short value1, Short value2) {
			addCriterion("SEQ_STEP between", value1, value2, "seqStep");
			return (Criteria) this;
		}

		public Criteria andSeqStepNotBetween(Short value1, Short value2) {
			addCriterion("SEQ_STEP not between", value1, value2, "seqStep");
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