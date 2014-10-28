/**
 * This class is generated by jOOQ
 */
package us.fok.lenzenslijper.models.jooq.routines;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.0" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Addgeometrycolumn3 extends org.jooq.impl.AbstractRoutine<java.lang.String> {

	private static final long serialVersionUID = 6763868;

	/**
	 * The parameter <code>public.addgeometrycolumn.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.CLOB);

	/**
	 * The parameter <code>public.addgeometrycolumn.table_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> TABLE_NAME = createParameter("table_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.addgeometrycolumn.column_name</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> COLUMN_NAME = createParameter("column_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.addgeometrycolumn.new_srid</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> NEW_SRID = createParameter("new_srid", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * The parameter <code>public.addgeometrycolumn.new_type</code>.
	 */
	public static final org.jooq.Parameter<java.lang.String> NEW_TYPE = createParameter("new_type", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * The parameter <code>public.addgeometrycolumn.new_dim</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> NEW_DIM = createParameter("new_dim", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * The parameter <code>public.addgeometrycolumn.use_typmod</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> USE_TYPMOD = createParameter("use_typmod", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * Create a new routine call instance
	 */
	public Addgeometrycolumn3() {
		super("addgeometrycolumn", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.CLOB);

		setReturnParameter(RETURN_VALUE);
		addInParameter(TABLE_NAME);
		addInParameter(COLUMN_NAME);
		addInParameter(NEW_SRID);
		addInParameter(NEW_TYPE);
		addInParameter(NEW_DIM);
		addInParameter(USE_TYPMOD);
		setOverloaded(true);
	}

	/**
	 * Set the <code>table_name</code> parameter IN value to the routine
	 */
	public void setTableName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Addgeometrycolumn3.TABLE_NAME, value);
	}

	/**
	 * Set the <code>table_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setTableName(org.jooq.Field<java.lang.String> field) {
		setField(TABLE_NAME, field);
	}

	/**
	 * Set the <code>column_name</code> parameter IN value to the routine
	 */
	public void setColumnName(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Addgeometrycolumn3.COLUMN_NAME, value);
	}

	/**
	 * Set the <code>column_name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setColumnName(org.jooq.Field<java.lang.String> field) {
		setField(COLUMN_NAME, field);
	}

	/**
	 * Set the <code>new_srid</code> parameter IN value to the routine
	 */
	public void setNewSrid(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Addgeometrycolumn3.NEW_SRID, value);
	}

	/**
	 * Set the <code>new_srid</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNewSrid(org.jooq.Field<java.lang.Integer> field) {
		setField(NEW_SRID, field);
	}

	/**
	 * Set the <code>new_type</code> parameter IN value to the routine
	 */
	public void setNewType(java.lang.String value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Addgeometrycolumn3.NEW_TYPE, value);
	}

	/**
	 * Set the <code>new_type</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNewType(org.jooq.Field<java.lang.String> field) {
		setField(NEW_TYPE, field);
	}

	/**
	 * Set the <code>new_dim</code> parameter IN value to the routine
	 */
	public void setNewDim(java.lang.Integer value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Addgeometrycolumn3.NEW_DIM, value);
	}

	/**
	 * Set the <code>new_dim</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNewDim(org.jooq.Field<java.lang.Integer> field) {
		setField(NEW_DIM, field);
	}

	/**
	 * Set the <code>use_typmod</code> parameter IN value to the routine
	 */
	public void setUseTypmod(java.lang.Boolean value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.Addgeometrycolumn3.USE_TYPMOD, value);
	}

	/**
	 * Set the <code>use_typmod</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setUseTypmod(org.jooq.Field<java.lang.Boolean> field) {
		setField(USE_TYPMOD, field);
	}
}