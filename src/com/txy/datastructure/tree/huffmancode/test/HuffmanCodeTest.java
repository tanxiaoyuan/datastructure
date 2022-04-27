package com.txy.datastructure.tree.huffmancode.test;

import com.txy.datastructure.tree.huffmancode.HuffmanCode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class HuffmanCodeTest {

    private HuffmanCode huffmanCode;

    @Before
    public void init() {
        this.huffmanCode = new HuffmanCode();
    }

    @Test
    public void testHuffmanZip(){
        String message = "can you can a can as a can cer can can ";
        byte[] bytes = message.getBytes();
        byte[] zipBytes =  this.huffmanCode.huffmanZip(bytes);
        for(int i = 0; i < zipBytes.length; i++){
            System.out.print(zipBytes[i] + " ");
        }
    }

    @Test
    public void testHuffmanDecode(){
        String message = "can you can a can as a can cer can can ";
        byte[] bytes = message.getBytes();
        byte[] zipBytes =  this.huffmanCode.huffmanZip(bytes);
        byte[] decodeBytes = this.huffmanCode.huffmanDecode(zipBytes, this.huffmanCode.getCodes());
        Assert.assertEquals(true, new String(decodeBytes).equals(message));
    }

    @Test
    public void testZipFile(){
        String src = "test.PNG";
        String dst = "test.zip";
        try {
            this.huffmanCode.zipFile(src, dst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUnzipFile(){
        String src = "test.zip";
        String dst = "test1.jpg";
        try {
            this.huffmanCode.unzipFile(src, dst);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}