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
public class PopulateGeometryColumns2 extends org.jooq.impl.AbstractRoutine<java.lang.Integer> {

	private static final long serialVersionUID = -1328198323;

	/**
	 * The parameter <code>public.populate_geometry_columns.RETURN_VALUE</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Integer> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * The parameter <code>public.populate_geometry_columns.tbl_oid</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Long> TBL_OID = createParameter("tbl_oid", org.jooq.impl.SQLDataType.BIGINT);

	/**
	 * The parameter <code>public.populate_geometry_columns.use_typmod</code>.
	 */
	public static final org.jooq.Parameter<java.lang.Boolean> USE_TYPMOD = createParameter("use_typmod", org.jooq.impl.SQLDataType.BOOLEAN);

	/**
	 * Create a new routine call instance
	 */
	public PopulateGeometryColumns2() {
		super("populate_geometry_columns", us.fok.lenzenslijper.models.jooq.Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER);

		setReturnParameter(RETURN_VALUE);
		addInParameter(TBL_OID);
		addInParameter(USE_TYPMOD);
		setOverloaded(true);
	}

	/**
	 * Set the <code>tbl_oid</code> parameter IN value to the routine
	 */
	public void setTblOid(java.lang.Long value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PopulateGeometryColumns2.TBL_OID, value);
	}

	/**
	 * Set the <code>tbl_oid</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setTblOid(org.jooq.Field<java.lang.Long> field) {
		setField(TBL_OID, field);
	}

	/**
	 * Set the <code>use_typmod</code> parameter IN value to the routine
	 */
	public void setUseTypmod(java.lang.Boolean value) {
		setValue(us.fok.lenzenslijper.models.jooq.routines.PopulateGeometryColumns2.USE_TYPMOD, value);
	}

	/**
	 * Set the <code>use_typmod</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setUseTypmod(org.jooq.Field<java.lang.Boolean> field) {
		setField(USE_TYPMOD, field);
	}
}
