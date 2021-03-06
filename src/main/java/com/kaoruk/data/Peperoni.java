/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.kaoruk.data;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Peperoni extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1632007391815893836L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Peperoni\",\"namespace\":\"com.kaoruk\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"bam\",\"type\":{\"type\":\"enum\",\"name\":\"Bam\",\"symbols\":[\"Apple\",\"Bar\",\"Foo\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Peperoni> ENCODER =
      new BinaryMessageEncoder<Peperoni>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Peperoni> DECODER =
      new BinaryMessageDecoder<Peperoni>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Peperoni> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Peperoni> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Peperoni>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Peperoni to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Peperoni from a ByteBuffer. */
  public static Peperoni fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence name;
  @Deprecated public Bam bam;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Peperoni() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param bam The new value for bam
   */
  public Peperoni(java.lang.CharSequence name, Bam bam) {
    this.name = name;
    this.bam = bam;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return bam;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: bam = (Bam)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'bam' field.
   * @return The value of the 'bam' field.
   */
  public Bam getBam() {
    return bam;
  }

  /**
   * Sets the value of the 'bam' field.
   * @param value the value to set.
   */
  public void setBam(Bam value) {
    this.bam = value;
  }

  /**
   * Creates a new Peperoni RecordBuilder.
   * @return A new Peperoni RecordBuilder
   */
  public static Peperoni.Builder newBuilder() {
    return new Peperoni.Builder();
  }

  /**
   * Creates a new Peperoni RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Peperoni RecordBuilder
   */
  public static Peperoni.Builder newBuilder(Peperoni.Builder other) {
    return new Peperoni.Builder(other);
  }

  /**
   * Creates a new Peperoni RecordBuilder by copying an existing Peperoni instance.
   * @param other The existing instance to copy.
   * @return A new Peperoni RecordBuilder
   */
  public static Peperoni.Builder newBuilder(Peperoni other) {
    return new Peperoni.Builder(other);
  }

  /**
   * RecordBuilder for Peperoni instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Peperoni>
    implements org.apache.avro.data.RecordBuilder<Peperoni> {

    private java.lang.CharSequence name;
    private Bam bam;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Peperoni.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.bam)) {
        this.bam = data().deepCopy(fields()[1].schema(), other.bam);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Peperoni instance
     * @param other The existing instance to copy.
     */
    private Builder(Peperoni other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.bam)) {
        this.bam = data().deepCopy(fields()[1].schema(), other.bam);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public Peperoni.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public Peperoni.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'bam' field.
      * @return The value.
      */
    public Bam getBam() {
      return bam;
    }

    /**
      * Sets the value of the 'bam' field.
      * @param value The value of 'bam'.
      * @return This builder.
      */
    public Peperoni.Builder setBam(Bam value) {
      validate(fields()[1], value);
      this.bam = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'bam' field has been set.
      * @return True if the 'bam' field has been set, false otherwise.
      */
    public boolean hasBam() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'bam' field.
      * @return This builder.
      */
    public Peperoni.Builder clearBam() {
      bam = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Peperoni build() {
      try {
        Peperoni record = new Peperoni();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.bam = fieldSetFlags()[1] ? this.bam : (Bam) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Peperoni>
    WRITER$ = (org.apache.avro.io.DatumWriter<Peperoni>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Peperoni>
    READER$ = (org.apache.avro.io.DatumReader<Peperoni>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
