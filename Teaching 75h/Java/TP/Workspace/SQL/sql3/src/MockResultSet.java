package com.mockobjects.sql;

import com.mockobjects.ExpectationCounter;
import com.mockobjects.MockObject;
import com.mockobjects.ReturnValue;
import com.mockobjects.util.AssertMo;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

/**
 * This is the base implementation of a mock result set.
 * It manages converting objects from the current row into a other types.
 * Entries can be found by either column index or column name.
 * For basic java types (e.g. int, boolean), insert an instance of
 * the appropriate object (e.g. Integer, Boolean)
 * It also counts close() and next() calls
 * To force throwing a SQLException on a getter,
 * set the corresponding value to be of type SQLException.
 */
abstract class MockResultSet extends MockObject implements ResultSet {

    private final ExpectationCounter myCloseCalls;
    protected final ExpectationCounter myNextCalls;
    protected final String name;

    private final ReturnValue myMetaData = new ReturnValue("meta data");
    private final ReturnValue myStatement = new ReturnValue("statement");

    public MockResultSet() {
        this(MockResultSet.class.getName());
    }

    /**
     * @param name Label used to identify mock when it errors
     */
    public MockResultSet(String name) {
        this.name = name;
        myCloseCalls = new ExpectationCounter(name + ".close");
        myNextCalls = new ExpectationCounter(name + ".next");
    }

    public void setExpectedCloseCalls(int calls) {
        myCloseCalls.setExpected(calls);
    }

    public void setExpectedNextCalls(int calls) {
        myNextCalls.setExpected(calls);
    }

// --------------------------------------------------------------------- setup

    public void setupMetaData(ResultSetMetaData metaData) {
        myMetaData.setValue(metaData);
    }

    public void setupStatement(Statement statement) {
        myStatement.setValue(statement);
    }

// ------------------------------------------------------------------ abstract

    /**
     * Used as the base implementation for getting all types of object,
     * based on 1-based column index
     * @see java.sql.ResultSet#getObject(int)
     */
    abstract public Object getObject(int columnIndex) throws SQLException;

    /**
     * Used as the base implementation for getting all types of object,
     * based on columnName
     * @see java.sql.ResultSet#getObject(int)
     */
    abstract public Object getObject(String columnName) throws SQLException;

    abstract public boolean next() throws SQLException;

    abstract public int getRow() throws SQLException;

// --------------------------------------------------------------- implemented

    public void close() throws SQLException {
        myCloseCalls.inc();
    }

    public Array getArray(int i) throws SQLException {
        return (Array) getObject(i);
    }

    public Array getArray(String colName) throws SQLException {
        return (Array) getObject(colName);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return (InputStream) getObject(columnIndex);
    }

    public InputStream getAsciiStream(String columnName) throws SQLException {
        return (InputStream) getObject(columnName);
    }

    public BigDecimal getBigDecimal(String columnName, int scale) throws SQLException {
        return getBigDecimal(columnName);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return (BigDecimal) getObject(columnIndex);
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return (BigDecimal) getObject(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnName) throws SQLException {
        return (BigDecimal) getObject(columnName);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return (InputStream) getObject(columnIndex);
    }

    public InputStream getBinaryStream(String columnName) throws SQLException {
        return (InputStream) getObject(columnName);
    }

    public Blob getBlob(int i) throws SQLException {
        return (Blob) getObject(i);
    }

    public Blob getBlob(String colName) throws SQLException {
        return (Blob) getObject(colName);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return ((Boolean) getObject(columnIndex)).booleanValue();
    }

    public boolean getBoolean(String columnName) throws SQLException {
        return ((Boolean) getObject(columnName)).booleanValue();
    }

    public byte getByte(int columnIndex) throws SQLException {
        return ((Byte) getObject(columnIndex)).byteValue();
    }

    public byte getByte(String columnName) throws SQLException {
        return ((Byte) getObject(columnName)).byteValue();
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return (byte[]) getObject(columnIndex);
    }

    public byte[] getBytes(String columnName) throws SQLException {
        return (byte[]) getObject(columnName);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return (Reader) getObject(columnIndex);
    }

    public Reader getCharacterStream(String columnName) throws SQLException {
        return (Reader) getObject(columnName);
    }

    public Clob getClob(int i) throws SQLException {
        return (Clob) getObject(i);
    }

    public Clob getClob(String colName) throws SQLException {
        return (Clob) getObject(colName);
    }

    public Date getDate(int columnIndex) throws SQLException {
        return (Date) getObject(columnIndex);
    }

    public Date getDate(String columnName) throws SQLException {
        return (Date) getObject(columnName);
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return getDate(columnIndex);
    }

    public Date getDate(String columnName, Calendar cal) throws SQLException {
        return getDate(columnName);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return ((Double) getObject(columnIndex)).doubleValue();
    }

    public double getDouble(String columnName) throws SQLException {
        return ((Double) getObject(columnName)).doubleValue();
    }

    public float getFloat(int columnIndex) throws SQLException {
        return ((Float) getObject(columnIndex)).floatValue();
    }

    public float getFloat(String columnName) throws SQLException {
        return ((Float) getObject(columnName)).floatValue();
    }

    public int getInt(int columnIndex) throws SQLException {
        return ((Integer) getObject(columnIndex)).intValue();
    }

    public int getInt(String columnName) throws SQLException {
        return ((Integer) getObject(columnName)).intValue();
    }

    public long getLong(int columnIndex) throws SQLException {
        return ((Long) getObject(columnIndex)).longValue();
    }

    public long getLong(String columnName) throws SQLException {
        return ((Long) getObject(columnName)).longValue();
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return (ResultSetMetaData) myMetaData.getValue();
    }

    public Ref getRef(int i) throws SQLException {
        return (Ref) getObject(i);
    }

    public Ref getRef(String colName) throws SQLException {
        return (Ref) getObject(colName);
    }

    public short getShort(String columnName) throws SQLException {
        return ((Short) getObject(columnName)).shortValue();
    }

    public short getShort(int columnIndex) throws SQLException {
        return ((Short) getObject(columnIndex)).shortValue();
    }

    public Statement getStatement() throws SQLException {
        return (Statement) myStatement.getValue();
    }

    public String getString(int columnIndex) throws SQLException {
        final Object object = getObject(columnIndex);
        if (object != null) {
            AssertMo.assertTrue("Column " + columnIndex + " in " + name + " is a " +
                object.getClass().getName() + " not a String", object instanceof String);

            return (String) object;
        } else {
            return null;
        }
    }

    public String getString(String columnName) throws SQLException {
        return (String) getObject(columnName);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return (Time) getObject(columnIndex);
    }

    public Time getTime(String columnName) throws SQLException {
        return (Time) getObject(columnName);
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return getTime(columnIndex);
    }

    public Time getTime(String columnName, Calendar cal) throws SQLException {
        return getTime(columnName);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return (Timestamp) getObject(columnIndex);
    }

    public Timestamp getTimestamp(String columnName) throws SQLException {
        return (Timestamp) getObject(columnName);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal)
        throws SQLException {
        return getTimestamp(columnIndex);
    }

    public Timestamp getTimestamp(String columnName, Calendar cal)
        throws SQLException {
        return getTimestamp(columnName);
    }

    public InputStream getUnicodeStream(int columnIndex)
        throws SQLException {
        return (InputStream) getObject(columnIndex);
    }

    public InputStream getUnicodeStream(String columnName)
        throws SQLException {
        return (InputStream) getObject(columnName);
    }

// ------------------------------------------------------------ notImplemented

    public String getCursorName() throws SQLException {
        notImplemented();
        return null;
    }

    public int getConcurrency() throws SQLException {
        notImplemented();
        return 0;
    }

    /**
     * Calls notImplemented. Returns 0.
     */
    public int getFetchDirection() throws SQLException {
        notImplemented();
        return 0;
    }

    /**
     * Calls notImplemented. Returns 0.
     */
    public int getFetchSize() throws SQLException {
        notImplemented();
        return 0;
    }

    /**
     * Calls notImplemented. Returns null.
     */
    public Object getObject(int i, Map map) throws SQLException {
        notImplemented();
        return null;
    }

    /**
     * Calls notImplemented. Returns null.
     */
    public Object getObject(String colName, Map map) throws SQLException {
        notImplemented();
        return null;
    }

    /**
     * Calls notImplemented. Returns 0.
     */
    public int getType() throws SQLException {
        notImplemented();
        return 0;
    }

    /**
     * Calls notImplemented. Returns null.
     */
    public SQLWarning getWarnings() throws SQLException {
        notImplemented();
        return null;
    }

    /**
     * Calls notImplemented.
     */
    public void clearWarnings() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented. Returns 0.
     */
    public int findColumn(String columnName) throws SQLException {
        notImplemented();
        return 0;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean isBeforeFirst() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean isAfterLast() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean isFirst() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean isLast() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented.
     */
    public void beforeFirst() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void afterLast() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean first() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean last() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean absolute(int row) throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean relative(int rows) throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean previous() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented.
     */
    public void setFetchDirection(int direction) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void setFetchSize(int rows) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean rowUpdated() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean rowInserted() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented. Returns false.
     */
    public boolean rowDeleted() throws SQLException {
        notImplemented();
        return false;
    }

    /**
     * Calls notImplemented.
     */
    public void updateNull(int columnIndex) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBoolean(int columnIndex, boolean x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateByte(int columnIndex, byte x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateShort(int columnIndex, short x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateInt(int columnIndex, int x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateLong(int columnIndex, long x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateFloat(int columnIndex, float x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateDouble(int columnIndex, double x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBigDecimal(int columnIndex, BigDecimal x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateString(int columnIndex, String x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBytes(int columnIndex, byte x[]) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateDate(int columnIndex, Date x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateTime(int columnIndex, Time x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateTimestamp(int columnIndex, Timestamp x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateAsciiStream(int columnIndex,
        InputStream x,
        int length) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBinaryStream(int columnIndex,
        InputStream x,
        int length) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateCharacterStream(int columnIndex,
        Reader x,
        int length) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateObject(int columnIndex, Object x, int scale)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateObject(int columnIndex, Object x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateNull(String columnName) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBoolean(String columnName, boolean x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateByte(String columnName, byte x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateShort(String columnName, short x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateInt(String columnName, int x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateLong(String columnName, long x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateFloat(String columnName, float x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateDouble(String columnName, double x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBigDecimal(String columnName, BigDecimal x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateString(String columnName, String x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBytes(String columnName, byte x[]) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateDate(String columnName, Date x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateTime(String columnName, Time x) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateTimestamp(String columnName, Timestamp x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateAsciiStream(String columnName,
        InputStream x,
        int length) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateBinaryStream(String columnName,
        InputStream x,
        int length) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateCharacterStream(String columnName,
        Reader reader,
        int length) throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateObject(String columnName, Object x, int scale)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateObject(String columnName, Object x)
        throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void insertRow() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void updateRow() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void deleteRow() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void refreshRow() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void cancelRowUpdates() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void moveToInsertRow() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public void moveToCurrentRow() throws SQLException {
        notImplemented();
    }

    /**
     * Calls notImplemented.
     */
    public boolean wasNull() throws SQLException {
        notImplemented();
        return false;
    }

} // end MockResultSet
