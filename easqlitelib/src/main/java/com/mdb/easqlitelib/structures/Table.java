package com.mdb.easqlitelib.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andy on 10/8/16
 *
 * An abstraction of a SQLite Table
 */

public class Table {
    // The name of the Table
    private String tableName;

    // The types of columns in order
    private List<String> schema;

    // The Entry Rows of the Table
    private Map<Integer, Entry> entries;

    // A mapping from column names to the actual column
    private Map<String, Column> columns;

    public Table(String tableName) {
        this.tableName = tableName;
        this.schema = new ArrayList<>();
        this.columns = new HashMap<>();
        this.entries = new HashMap<>();
    }

    /**
     * This method takes in a specified column and adds it into the Table.
     * It updates the schema and all the entries already part of the Table.
     * @param column the column to be added.
     */
    public void addColumn(Column column) {
        columns.put(column.name, column);
        schema.add(column.type);

        for (Entry entry : entries) {
            entry.addField(null);
        }
    }

    /**
     * This method takes in an entry to add into the table. It first verifies
     * that the entry is valid in that its types match the schema.
     * @param entry the entry to be added to the table.
     */
    public void addEntry(Entry entry) {
        if (entry.verifyFields()) {
            entries.put(entry.id, entry);
        } else {
            throw new InvalidTypeException("Entry insertion is invalid");
        }
    }

    /**
     * This method removes a specified entry from the table.
     * @param entry the entry to be removed from the table.
     */
    public void removeEntry(Entry entry) {
        entries.remove(entry.id);
    }

    public List<String> getSchema() {
        return schema;
    }
}
