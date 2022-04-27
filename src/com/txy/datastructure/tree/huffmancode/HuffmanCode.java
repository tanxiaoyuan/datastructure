package com.txy.datastructure.tree.huffmancode;

import java.io.*;
import java.util.*;

public class HuffmanCode {

    private Map<Byte, String> codes = new HashMap<>();

    public byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node tree = createHuffmanTree(nodes);
        this.getCodes(tree);
        return zip(bytes);
    }

    public Map<Byte, String> getCodes(){
        return this.codes;
    }

    public byte[] huffmanDecode(byte[] bytes, Map<Byte, String> codes){
        Map<String, Byte> decodeCodes = new HashMap<>();
        for(Byte key : codes.keySet()){
            decodeCodes.put(codes.get(key), key);
        }
        String message = bytesToString(bytes);
        List<Byte> newBytesList = new ArrayList<>();
        for(int i = 0; i < message.length();){
            int count = 1;
            boolean flag = true;
            while (flag){
                Byte data = decodeCodes.get(message.substring(i, i + count));
                if(data == null){
                    count++;
                }else{
                    flag = false;
                    newBytesList.add(data);
                }
            }
            i = i + count;
        }
        byte[] newBytes = new byte[newBytesList.size()];
        for(int i = 0; i < newBytesList.size(); i++){
            newBytes[i] = newBytesList.get(i);
        }
        return  newBytes;
    }

    public void zipFile(String src, String dst) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        byte[] data = new byte[fis.available()];
        fis.read(data);
        fis.close();
        byte[] newBytes = this.huffmanZip(data);
        FileOutputStream fos = new FileOutputStream(dst);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(newBytes);
        oos.writeObject(this.codes);
        oos.close();
        fos.close();
    }

    public void unzipFile(String src, String dst) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(src);
        ObjectInputStream ois = new ObjectInputStream(fis);
        byte[] data = (byte[])ois.readObject();
        Map<Byte, String> codes = (Map<Byte, String>)ois.readObject();
        ois.close();
        fis.close();
        byte[] unzipData = this.huffmanDecode(data, codes);
        FileOutputStream ops = new FileOutputStream(dst);
        ops.write(unzipData);
        ops.close();
    }

    private String bytesToString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length; i++){
            if(i != bytes.length - 1){
                String binaryString = Integer.toBinaryString(256 | bytes[i]);
                sb.append(binaryString.substring(binaryString.length() - 8));
            } else {
                sb.append(Integer.toBinaryString(bytes[i]));
            }
        }
        return sb.toString();
    }

    private byte[] zip(byte[] data){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < data.length; i++){
            sb.append(this.codes.get(data[i]));
        }
        byte[] bytes = new byte[sb.length() % 8 == 0 ? sb.length() / 8 : sb.length() / 8 + 1];
        int index = 0 ;
        for(int i = 0; i < sb.length(); i = i + 8){
            if(i + 8 > sb.length()){
                bytes[index] = (byte) Integer.parseInt(sb.substring(i), 2);
            } else{
                bytes[index] = (byte) Integer.parseInt(sb.substring(i, i + 8), 2);
            }
            index++;
        }
        return bytes;
    }

    private void getCodes(Node tree){
        if(tree == null){
            return;
        }
        StringBuilder sb = new StringBuilder();
        getCodes(tree.getLeftNode(), "0", sb);
        getCodes(tree.getRightNode(), "1", sb);
    }

    private void getCodes(Node node, String code, StringBuilder sb){
        StringBuilder sb1 = new StringBuilder(sb);
        sb1.append(code);
        if(node.getData() == null){
            getCodes(node.getLeftNode(), "0", sb1);
            getCodes(node.getRightNode(), "1", sb1);
        } else {
            this.codes.put(node.getData(), sb1.toString());
        }
    }

    private Node createHuffmanTree(List<Node> nodes){
        while(nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node node = new Node(null, leftNode.getWeight() + rightNode.getWeight());
            node.setLeftNode(leftNode);
            node.setRightNode(rightNode);
            nodes.add(node);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }

    private List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for(byte b: bytes){
            Integer count = counts.get(b);
            if(count != null){
               counts.put(b, count + 1);
            } else{
                counts.put(b, 1);
            }
        }
        for(byte b: counts.keySet()){
            Node node = new Node(b, counts.get(b));
            nodes.add(node);
        }
        return nodes;
    }
}
