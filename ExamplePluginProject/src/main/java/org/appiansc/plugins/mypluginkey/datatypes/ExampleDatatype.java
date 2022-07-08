package org.appiansc.plugins.mypluginkey.datatypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.Date;


@XmlRootElement(namespace = "urn:com:appian:types:mypluginkey", name = "ExampleDatatype")
@XmlType(
        namespace = ExampleDatatype.NAMESPACE_URI,
        name = ExampleDatatype.LOCAL_PART,
        propOrder = {
            "stringField",
            "decimalField",
            "booleanField",
            "longField",
            "dateField"
        })
//@XmlSeeAlso({ExampleDatatype.class})
//@Hidden // If you don't want it to be selectable
public class ExampleDatatype implements Serializable {
    public static final String NAMESPACE_URI = "urn:com:appian:types:mypluginkey";
    public static final String LOCAL_PART = "ExampleDatatype";
    public static final QName QNAME = new QName(NAMESPACE_URI, LOCAL_PART);
    private static final long serialVersionUID = 1L;

    private String stringField;
    private Double decimalField;
    private Boolean booleanField;
    private Long longField;
    private Date dateField;

    public ExampleDatatype(String stringField, Double decimalField, Boolean booleanField, Long longField, Date dateField) {
        this();
        setStringField(stringField);
        setDecimalField(decimalField);
        setBooleanField(booleanField);
        setLongField(longField);
        setDateField(dateField);
    }

    public ExampleDatatype() {
    } // for serialization only

    @XmlElement
    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    @XmlElement
    public Double getDecimalField() {
        return decimalField;
    }

    public void setDecimalField(Double decimalField) {
        this.decimalField = decimalField;
    }

    @XmlElement
    public Boolean getBooleanField() {
        return booleanField;
    }

    public void setBooleanField(Boolean booleanField) {
        this.booleanField = booleanField;
    }

    @XmlElement
    public Long getLongField() {
        return longField;
    }

    public void setLongField(Long longField) {
        this.longField = longField;
    }

    @XmlElement
    public Date getDateField() {
        return (Date)dateField.clone(); // don't return a reference to the mutable variable; clone it instead
    }

    public void setDateField(Date dateField) {
        this.dateField = (Date)dateField.clone(); // don't save a reference to a mutable variable; clone it instead
    }
}
