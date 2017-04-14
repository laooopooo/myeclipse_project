package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	// Throw exceptions to console
	public static String read(String filename) throws IOException {
		// Reading input by lines
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
		// 我是一个汉字，我变成大写会是神马情况呢？
		// 原来是不变！！
	}

	public static void main(String[] args) throws IOException {
		System.out.println(read("src/io/BufferedInputFile.java"));
	}
}
