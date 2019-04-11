package com.kaoruk;

import com.kaoruk.data.Pizza;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.nio.file.Files;

public class Test2 {
    public static void main(String[] args) throws Exception {
        byte[] messageBytes = Files.readAllBytes(new File("pizzas-3.avro").toPath());

        BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(messageBytes, null);
        DatumReader<Pizza> reader = new SpecificDatumReader<>(Pizza.class);
        Pizza record = reader.read(null, decoder);
        System.out.println(record);
    }
}
